package demo2.view.listeners;

import demo2.view.EditorFrame;

import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseListener extends MouseAdapter {
    private EditorFrame editorFrame;

    public MyMouseListener() {
        editorFrame=EditorFrame.getInstance();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mods = e.getModifiers();
        //
        if ((mods & InputEvent.BUTTON3_MASK) != 0) {
            editorFrame.getPopMenu().show(e.getComponent(), e.getX(), e.getY());
        }
    }

}
