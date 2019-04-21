package demo1;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;


public class Send_Thread extends Thread{

    //发送的socket端
    private DatagramSocket sender = null;
    //待发送的目标地址
    private InetSocketAddress targetAddress = null;
    //从键盘输入
    Scanner scanner = new Scanner(System.in);

    public Send_Thread(DatagramSocket sender,InetSocketAddress address)
    {
        this.sender = sender;
        this.targetAddress = address;
    }

    @Override
    public void run() {
        // TODO 这里目前监听的是控制台输入，每次回车，发送一次消息。
        //  要改成，每隔一定时间自动发送一次同步的消息。
        //  因此，要再添加一个线程，该线程负责每5s同步一次用户输入的文本，另一个线程负责用户输入。
        try
        {
            while(true)
            {
                //输入待发送的内容
                String input = scanner.nextLine();
                if(input.equals("exit"))
                    break;
                Message m=new Message(input);
                String message=m.getMessage();
                byte[] data = null;
                data = message.getBytes("UTF-8");
                //创建UDP数据报
                DatagramPacket pack = new DatagramPacket(data, data.length, targetAddress);

                sender.send(pack);
            }

            System.out.println("Exit!");
            System.exit(1);

        }catch(IOException e)
        {
            System.out.println("IOException");
        }
    }


}