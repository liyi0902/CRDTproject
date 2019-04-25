package demo1;

import demo1.view.EditorFrame;

import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 该类的main方法，需要成为成为本程序的主入口。
 * 现阶段测试，点对点单播需要手动修改port端口，防冲突，ip设置成localhost就行。
 * 若想测试全网段广播，默认参数不用改，但需要多台设备在一个局域网下，一台电脑无法完成，因为端口永远是冲突的。
 *
 * 如果用当前默认参数启动一个客户端，该客户端能收到自己的广播信息。用户在控制台上输入的内容会被广播出去，然后自己接收到，再显示到控制台上。
 */
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


            Text.initialList();
            //启动发送和接收线程
            send_thread.start();
            rece_thread.start();
//            //启动文本编辑器
//            EditorFrame.getInstance();

        } catch (Exception e) {
            System.out.println("Exception!");
            e.printStackTrace();
        }

    }

}