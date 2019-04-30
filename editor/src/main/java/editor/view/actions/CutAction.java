package editor.view.actions;


import editor.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * cut selected content
 */
public class CutAction extends AbstractAction {
    private EditorFrame editorFrame;

    public CutAction() {
        super("Cut");
        editorFrame= EditorFrame.getInstance();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        editorFrame.getTextArea().cut();

    }
}
