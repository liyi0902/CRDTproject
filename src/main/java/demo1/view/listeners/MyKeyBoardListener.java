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
        //TODO


//        if(e.getKeyCode()== KeyEvent.VK_C){
//
//        }
    }
}
