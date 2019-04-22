package demo2.view.actions;

import demo2.utils.FileUtil;
import demo2.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * copy selected content
 */
public class CopyAction extends AbstractAction {

    private EditorFrame editorFrame;

    public CopyAction() {
        super("copy");
        editorFrame=EditorFrame.getInstance();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        editorFrame.getTextArea().copy();

    }
}
