package demo1;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive_Thread extends Thread {

    private static final int MAX_RECEIVE_BUFFER = 1024;
    private DatagramSocket server;
    private DatagramPacket packet;
    byte[] buffer = new byte[MAX_RECEIVE_BUFFER];

    public Receive_Thread(DatagramSocket server)
    {
        this.server = server;
        packet = new DatagramPacket(buffer, buffer.length);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try
        {
            while(true)
            {
                //接收数据包
                server.receive(packet);
                String s = new String(packet.getData(),packet.getOffset(),packet.getLength(),"UTF-8");
                //发送者的ip和port
                //System.out.println(packet.getSocketAddress()+"  Says :"+s);
                System.out.println("Received raw message: "+s);
                Message message=Message.DecodeMessage(s);
                System.out.println(message.localName+":"+message.content);
                packet.setLength(buffer.length);
            }
        }
        catch(IOException e)
        {
            System.out.println("IOException");
            e.printStackTrace();
        }
    }
}