package editor.network;

import editor.Configuration;
import editor.controller.EditorController;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * listening a port for new socket connecting in
 */
@Slf4j
public class ConnectionListener extends Thread{
	private ServerSocket serverSocket=null;
	private int port;
	private boolean flag = false;
	private volatile static ConnectionListener newInstance;

	private ConnectionListener() throws IOException{
		port = Configuration.getLocalPort();
		serverSocket = new ServerSocket(port);
		start();
	}

	public static ConnectionListener getInstance() throws IOException{
		if(newInstance==null){
			synchronized (EditorController.class){
				if(newInstance==null){
					newInstance=new ConnectionListener();
				}
			}
		}
		return newInstance;
	}


	@Override
	public void run() {
		log.info("listening for new connections on "+port);
		while(!flag){
			Socket clientSocket;
			try {
				clientSocket = serverSocket.accept();
				EditorController.getInstance().incomingConnection(clientSocket);
			} catch (IOException e) {
				log.info("received exception, shutting down");
				flag=true;
			}
		}

		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public String getSocketAdr(){
		return serverSocket.getInetAddress()+":"+serverSocket.getLocalPort();
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
