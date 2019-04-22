package demo1.view.listeners;

import demo1.view.EditorFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * listen the keyboaed event
 */
public class MyKeyBoardListener extends KeyAdapter {
    private EditorFrame editorFrame;

    public MyKeyBoardListener() {
        editorFrame= EditorFrame.getInstance();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Returns the position of the text insertion caret for the text component.
        int pos=editorFrame.getTextArea().getCaretPosition();
        System.out.println(pos);
        if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE){
            if(pos != 0) {
                //TODO DELETE
            }
        }
        else{
            char c=e.getKeyChar();
            System.out.println(c);

            //TODO INSERT
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Returns the position of the text insertion caret for the text component.
        int pos=editorFrame.getTextArea().getCaretPosition();

    }
}
