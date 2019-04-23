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
        //这里每5秒钟发送一次消息
        try
        {
            while(true)
            {

                Message m=new Message(Input_Thread.getText());
                String message=m.getMessage();
                byte[] data = null;
                data = message.getBytes("UTF-8");
                //创建UDP数据报
                DatagramPacket pack = new DatagramPacket(data, data.length, targetAddress);

                sender.send(pack);
                sleep(5000);
            }

        }catch(IOException e)
        {
            System.out.println("IOException");
        }
        catch (InterruptedException e){
            System.out.println("Error in sleep()");
            e.printStackTrace();
        }
    }


}