package demo1.view.actions;

import demo1.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * clear all content
 */
public class ClearAction extends AbstractAction {
    private EditorFrame editorFrame;

    public ClearAction() {
        super("Clear");
        editorFrame= EditorFrame.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(editorFrame, "Do you want to clear all the contents",
                "warning", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            editorFrame.getTextArea().setText("");
            editorFrame.setTempContent("");
        }
    }
}
