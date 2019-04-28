package view.actions;



import utils.FileUtil;
import view.EditorFrame;

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
