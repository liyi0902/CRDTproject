package demo1.view.actions;

import demo1.utils.FileUtil;
import demo1.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * exit the editor
 */
public class ExitAction extends AbstractAction {
    private EditorFrame editorFrame;

    public ExitAction() {
        super("Close");
        editorFrame= EditorFrame.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FileUtil.exit(editorFrame);

    }

}
