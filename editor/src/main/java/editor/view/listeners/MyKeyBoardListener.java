package editor.view.listeners;


import editor.algorithm.logoot.LogootDoc;
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
//        if(notFunctionButton(e)){
            //Returns the position of the text insertion caret for the text component.
            int pos = editorController.getEditorFrame().getTextArea().getCaretPosition();

            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                pos -= 1;
                System.out.println("[delete],pos=" + pos);
                editorController.localDelete(pos);
            } else if(e.getKeyCode()!=KeyEvent.VK_LEFT&&e.getKeyCode()!=KeyEvent.VK_LEFT) {
                char c = e.getKeyChar();
                System.out.println("[add],pos=" + pos + ",char=" + c);
                editorController.localInsert(pos,c);
            }
            ((LogootDoc)editorController.getDoc()).showAtoms();

//        }

    }

    /**
     * can't unstand why type "enter" the pos will plus 2
     * @param e
     */

//    @Override
//    public void keyTyped(KeyEvent e) {
////        Returns the position of the text insertion caret for the text component.
//        System.out.println(editorController.getEditorFrame().getTextArea().getCaretPosition());
//
//
//    }





    /**
     * exclude functional button
     * @param e
     * @return
     */
    private boolean notFunctionButton(KeyEvent e) {
        return e.getKeyCode() != KeyEvent.VK_HOME && e.getKeyCode() != KeyEvent.VK_END && e.getKeyCode() != KeyEvent.VK_PAGE_DOWN
                && e.getKeyCode() != KeyEvent.VK_PAGE_UP && e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN
                && e.getKeyCode() != KeyEvent.VK_LEFT && e.getKeyCode() != KeyEvent.VK_RIGHT && e.getKeyCode() != KeyEvent.VK_ESCAPE
                && e.getKeyCode() != KeyEvent.VK_CONTROL && e.getKeyCode() != KeyEvent.VK_SHIFT && e.getKeyCode() != KeyEvent.VK_CAPS_LOCK
                && e.getKeyCode() != KeyEvent.VK_NUM_LOCK && e.getKeyCode() != KeyEvent.VK_UNDEFINED;
    }


}
