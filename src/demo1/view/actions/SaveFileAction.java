package demo1.view.actions;

import demo1.utils.FileUtil;
import demo1.view.EditorFrame;

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
