package demo2.view.actions;

import demo2.utils.FileUtil;
import demo2.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;


/**
 * save the file as the new path
 */
public class SaveFileAsAction extends AbstractAction {
    private EditorFrame editorFrame;

    public SaveFileAsAction() {
        super("save as ");
        editorFrame=EditorFrame.getInstance();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        FileUtil.saveFileAs(editorFrame);

    }
}
