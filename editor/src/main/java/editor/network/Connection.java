package editor.network;



import editor.Configuration;
import editor.controller.EditorController;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;


@Slf4j
public class Connection extends Thread {
	private BufferedReader inreader;
	private PrintWriter outwriter;
	private boolean open = false;
	private Socket socket;
	private boolean flag = false;

	public Connection(Socket socket) throws IOException{
	    inreader = new BufferedReader( new InputStreamReader(new DataInputStream(socket.getInputStream())));
	    outwriter = new PrintWriter(new DataOutputStream(socket.getOutputStream()), true);
	    this.socket = socket;
	    open = true;
	    start();
	}


	public boolean writeMsg(String msg) {
		if(open){
			outwriter.println(msg);
			outwriter.flush();
			return true;
		}
		return false;
	}

	public void closeCon(){
		if(open){
			log.info("closing connection "+ Configuration.socketAddress(socket));

			try {
				flag=true;
				inreader.close();
				outwriter.close();
				EditorController.getInstance().setFlag(true);
			} catch (IOException e) {
				log.error("received exception closing the connection "+Configuration.socketAddress(socket)+": "+e);
			}
		}
	}


	@Override
	public void run(){
		try {
			String data;
			while(!flag && (data = inreader.readLine())!=null){
				log.debug("receive data {}",data);
			}
			log.debug("connection closed to "+Configuration.socketAddress(socket));
		} catch (IOException e) {
			log.error("connection "+Configuration.socketAddress(socket)+" closed with exception: "+e);
			EditorController.getInstance().connectionClosed(this);
		}
		open=false;
	}

	public BufferedReader getInreader() {
		return inreader;
	}

	public void setInreader(BufferedReader inreader) {
		this.inreader = inreader;
	}

	public PrintWriter getOutwriter() {
		return outwriter;
	}

	public void setOutwriter(PrintWriter outwriter) {
		this.outwriter = outwriter;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
