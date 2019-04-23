package demo2.view.actions;

import demo2.utils.FileUtil;
import demo2.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * exit the editor
 */
public class ExitAction extends AbstractAction {
    private EditorFrame editorFrame;

    public ExitAction() {
        super("exit");
        editorFrame=EditorFrame.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileUtil.exit(editorFrame);

    }

}
