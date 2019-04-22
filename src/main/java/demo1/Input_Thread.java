package demo1;

import java.util.Scanner;

public class Input_Thread extends Thread{

    private static String Text="";

    public void run(){
        //从键盘输入
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input=scanner.next();
            if(input.equals("exit"))
                break;
            Text+=input;
        }
        System.exit(1);
    }

    public static String getText() {
        return Text;
    }
}
