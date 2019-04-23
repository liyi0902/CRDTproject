package demo2;

import demo2.view.EditorFrame;

public class Main {
    public static void main(String[] args)
    {

        EditorFrame e=EditorFrame.getInstance();
        e.getTextArea().setText("01234");
        e.getTextArea().setText("56789");
    }

}
