package demo2.view.listeners;

import demo2.view.EditorFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * listen the keyboaed event
 */
public class MyKeyBoardListener extends KeyAdapter {
    private EditorFrame editorFrame;

    public MyKeyBoardListener() {
        editorFrame=EditorFrame.getInstance();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Returns the position of the text insertion caret for the text component.
        int pos=editorFrame.getTextArea().getCaretPosition();


//        if(e.getKeyCode()== KeyEvent.VK_C){
//
//        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Returns the position of the text insertion caret for the text component.
        int pos=editorFrame.getTextArea().getCaretPosition();

    }
}
