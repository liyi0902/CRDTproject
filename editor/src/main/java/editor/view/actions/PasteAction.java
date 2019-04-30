package editor.view.actions;

import editor.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * paste selected content
 */
public class PasteAction extends AbstractAction {
    private EditorFrame editorFrame;

    public PasteAction() {
        super("Paste");
        editorFrame= EditorFrame.getInstance();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        editorFrame.getTextArea().paste();

    }
}
