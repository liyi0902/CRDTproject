package demo2.view.actions;

import demo2.utils.FileUtil;
import demo2.view.EditorFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

/**
 * save file
 */
public class SaveFileAction extends AbstractAction {
    private EditorFrame editorFrame;

    public SaveFileAction() {
        super("save");
        editorFrame=EditorFrame.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (editorFrame.getFilename() != null) {
            FileUtil.saveFile(editorFrame);
        }else {
            FileUtil.saveFileAs(editorFrame);
        }

    }

}
