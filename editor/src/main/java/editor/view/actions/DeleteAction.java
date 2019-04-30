package editor.view.actions;


import editor.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * delete selected content
 */
public class DeleteAction extends AbstractAction {
    private EditorFrame editorFrame;

    public DeleteAction() {
        super("Delete");
        editorFrame= EditorFrame.getInstance();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        editorFrame.getTextArea().replaceSelection("");

    }
}
