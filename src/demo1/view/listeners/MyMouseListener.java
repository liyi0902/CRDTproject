package demo1.view.listeners;

import demo1.view.EditorFrame;

import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * listen the event when user click the mouse
 */
public class MyMouseListener extends MouseAdapter {
    private EditorFrame editorFrame;

    public MyMouseListener() {
        editorFrame= EditorFrame.getInstance();
    }

    @Override
    public void mousePressed(MouseEvent e) {

        //when click the right button of mouse, pop menu will be show
        if (e.getButton()==MouseEvent.BUTTON3) {
            editorFrame.getPopMenu().show(e.getComponent(), e.getX(), e.getY());
        }
    }

}
