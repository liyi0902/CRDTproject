package demo1.view.actions;

import demo1.utils.FileUtil;
import demo1.view.EditorFrame;

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
