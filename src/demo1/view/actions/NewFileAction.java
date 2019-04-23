package demo1.view.actions;

import demo1.utils.FileUtil;
import demo1.view.EditorFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * empty the current text area to create a nwe file
 */
public class NewFileAction extends AbstractAction {
    private EditorFrame editorFrame;

    public NewFileAction() {
        super("new");
        editorFrame= EditorFrame.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if the current content not equals to the temp content, means you need to save it
        if(!editorFrame.getTextArea().getText().equals(editorFrame.getTempContent())) {
            int result = JOptionPane.showConfirmDialog(null,
                    "Do you want to save the file before open a new file ?", "warning", JOptionPane.YES_NO_CANCEL_OPTION);

            // you do nothing if tou choose cancel
            if(result==JOptionPane.YES_OPTION){
                if (editorFrame.getFilename() != null) {
                    FileUtil.saveFile(editorFrame);
                }else {
                    FileUtil.saveFileAs(editorFrame);
                }
                clear();

            }else if(result==JOptionPane.NO_OPTION){
                clear();
            }
        } else {
            clear();
        }


    }

    /**
     * clear all content
     */
    private void clear(){
        editorFrame.setFilename(null);
        editorFrame.setTitle("Editor");
        editorFrame.getTextArea().setText("");
        editorFrame.setTempContent("");
    }
}
