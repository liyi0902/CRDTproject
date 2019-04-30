package editor.view.actions;


import editor.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * copy selected content
 */
public class CopyAction extends AbstractAction {

    private EditorFrame editorFrame;

    public CopyAction() {
        super("Copy");
        editorFrame= EditorFrame.getInstance();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        editorFrame.getTextArea().copy();

    }
}
