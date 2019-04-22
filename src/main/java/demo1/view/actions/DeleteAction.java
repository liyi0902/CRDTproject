package demo1.view.actions;

import demo1.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * delete selected content
 */
public class DeleteAction extends AbstractAction {
    private EditorFrame editorFrame;

    public DeleteAction() {
        super("delete");
        editorFrame= EditorFrame.getInstance();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        editorFrame.getTextArea().replaceSelection("");

    }
}
