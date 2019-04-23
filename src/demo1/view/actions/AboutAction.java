package demo1.view.actions;

import demo1.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * show about message
 */
public class AboutAction extends AbstractAction {
    private EditorFrame editorFrame;

    public AboutAction() {
        super("about");
        editorFrame= EditorFrame.getInstance();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"CRDT DOC EDITOR","about",JOptionPane. INFORMATION_MESSAGE);


    }
}
