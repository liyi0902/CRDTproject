package editor.view.actions;

import editor.utils.FileUtil;
import editor.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * save file
 */
public class SaveFileAction extends AbstractAction {
    private EditorFrame editorFrame;

    public SaveFileAction() {
        super("Save");
        editorFrame= EditorFrame.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (editorFrame.getFileTitle() != null) {
            FileUtil.saveFile(editorFrame);
        }else {
            FileUtil.saveFileAs(editorFrame);
        }

    }

}
