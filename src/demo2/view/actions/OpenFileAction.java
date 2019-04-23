package demo2.view.actions;

import demo2.utils.FileUtil;
import demo2.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * open a file
 */
public class OpenFileAction extends AbstractAction {
    private EditorFrame editorFrame;

    public OpenFileAction() {
        super("open");
        editorFrame=EditorFrame.getInstance();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        FileUtil.openFile(editorFrame);

    }
}
