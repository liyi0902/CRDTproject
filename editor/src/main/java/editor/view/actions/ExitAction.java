package editor.view.actions;



import editor.utils.FileUtil;
import editor.view.EditorFrame;

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
