package demo2.view.actions;

import demo2.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * clear all content
 */
public class ClearAction extends AbstractAction {
    private EditorFrame editorFrame;

    public ClearAction() {
        super("clear");
        editorFrame=EditorFrame.getInstance();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "Do you want to clear all the contents",
                "warning", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            editorFrame.getTextArea().setText("");
            editorFrame.setTempContent("");
        }
    }
}
