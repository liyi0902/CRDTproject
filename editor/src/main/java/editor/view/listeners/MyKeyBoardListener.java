package editor.view.listeners;


import editor.controller.EditorController;
import editor.view.EditorFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * listen the  event when user click the keyboard
 */
public class MyKeyBoardListener extends KeyAdapter {
    private EditorController editorController;

    public MyKeyBoardListener() {
        editorController = EditorController.getInstance();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Returns the position of the text insertion caret for the text component.
        int pos = editorController.getEditorFrame().getTextArea().getCaretPosition();

        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            pos -= 1;
            System.out.println("[delete],pos=" + pos);
            editorController.localDelete(pos);
        } else {
            char c = e.getKeyChar();
            System.out.println("[add],pos=" + pos + ",char=" + c);
            editorController.localInsert(pos,c);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Returns the position of the text insertion caret for the text component.
        int pos = editorController.getEditorFrame().getTextArea().getCaretPosition();

    }
}
