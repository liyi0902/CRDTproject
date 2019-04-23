package demo1.view.actions;

import demo1.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * cut selected content
 */
public class CutAction extends AbstractAction {
    private EditorFrame editorFrame;

    public CutAction() {
        super("cut");
        editorFrame= EditorFrame.getInstance();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        editorFrame.getTextArea().cut();

    }
}
