package editor.view.actions;

import editor.utils.FileUtil;
import editor.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;


/**
 * save the file as the new path
 */
public class SaveFileAsAction extends AbstractAction {
    private EditorFrame editorFrame;

    public SaveFileAsAction() {
        super("Save As ");
        editorFrame= EditorFrame.getInstance();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        FileUtil.saveFileAs(editorFrame);

    }
}
