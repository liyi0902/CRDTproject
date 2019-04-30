package editor.view.listeners;


import editor.view.EditorFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * listen the  event when user click the keyboard
 */
public class MyKeyBoardListener extends KeyAdapter {
    private EditorFrame editorFrame;

    public MyKeyBoardListener() {
        editorFrame = EditorFrame.getInstance();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Returns the position of the text insertion caret for the text component.
        int pos = editorFrame.getTextArea().getCaretPosition();

        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            pos -= 1;
            System.out.println("[delete],pos=" + pos);
        } else {
            char c = e.getKeyChar();
            System.out.println("[add],pos=" + pos + ",char=" + c);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Returns the position of the text insertion caret for the text component.
        int pos = editorFrame.getTextArea().getCaretPosition();

    }
}
