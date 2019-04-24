package demo2.view.actions;

import demo2.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * show about message
 */
public class AboutAction extends AbstractAction {
    private EditorFrame editorFrame;

    public AboutAction() {
        super("about");
        editorFrame=EditorFrame.getInstance();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(editorFrame,"CRDT DOC EDITOR","about",JOptionPane. INFORMATION_MESSAGE);


    }
}
