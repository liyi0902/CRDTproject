package demo1;

import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Broadcast {
    //接收方主机端口号
    public static final int DEST_PORT = 9000;
    //本机发送端口号
    public static final int SEND_PORT = 10000;
    //本机接收端口号
    public static final int RECE_PORT = 9000;
    //广播网段
    public static final String IP = "192.168.1.255";

    public static void main(String[] args) {
        try {
            Send_Thread send_thread = null;
            Receive_Thread rece_thread = null;
            InetSocketAddress address = null;
            //创建待接收数据包的目的机的端口号和IP地址
            address = new InetSocketAddress(IP, DEST_PORT);
            //创建发送的Socket端
            DatagramSocket sendsocket = new DatagramSocket(SEND_PORT);
            //创建接收的Socket端
            DatagramSocket recesocket = new DatagramSocket(RECE_PORT);
            //发送线程建立
            send_thread = new Send_Thread(sendsocket, address);
            //接受线程的建立
            rece_thread = new Receive_Thread(recesocket);
            //启动用户输入线程
            Input_Thread input_thread=new Input_Thread();
            input_thread.start();
            //启动发送和接收线程
            send_thread.start();
            rece_thread.start();

        } catch (Exception e) {
            System.out.println("Exception!");
            e.printStackTrace();
        }

    }

}