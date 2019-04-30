package editor.view.actions;

import editor.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Help
 */
public class HelpAction extends AbstractAction {
    private EditorFrame editorFrame;

    public HelpAction() {
        super("Help");
        editorFrame= EditorFrame.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(editorFrame,"Get help on https://github.com/JingeOnline/CRDT_Project",
                "help",JOptionPane. INFORMATION_MESSAGE);


    }
}
