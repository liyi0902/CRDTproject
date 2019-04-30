package editor.view.actions;

import editor.utils.FileUtil;
import editor.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * open a file
 */
public class OpenFileAction extends AbstractAction {
    private EditorFrame editorFrame;

    public OpenFileAction() {
        super("Open");
        editorFrame= EditorFrame.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!editorFrame.getTextArea().getText().equals(editorFrame.getTempContent())) {
            int result = JOptionPane.showConfirmDialog(editorFrame,
                    "Do you want to save the file before open a new file ?", "warning", JOptionPane.YES_NO_CANCEL_OPTION);
            // you do not open another file if tou choose cancel
            if(result==JOptionPane.YES_OPTION){
                if (editorFrame.getFileTitle() != null) {
                    FileUtil.saveFile(editorFrame);
                }else {
                    FileUtil.saveFileAs(editorFrame);
                }
                FileUtil.openFile(editorFrame);
            }else if(result==JOptionPane.NO_OPTION){
                FileUtil.openFile(editorFrame);
            }
        }


    }
}
