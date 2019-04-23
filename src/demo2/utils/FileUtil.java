package demo2.utils;

import demo2.view.EditorFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class FileUtil {

    /**
     * open new file
     * @param editorFrame
     */
    public static void openFile(EditorFrame editorFrame){
        try{
            //open the fileDialog
            FileDialog fileDialog = new FileDialog(editorFrame, "open file", FileDialog.LOAD);
            fileDialog.setFile("*.txt");
            fileDialog.setVisible(true);

            if (fileDialog.getFile() != null) {
                //set file name
                editorFrame.setFilename(fileDialog.getDirectory() + fileDialog.getFile());

                //read content of the file
                FileReader fileReader = new FileReader( editorFrame.getFilename());
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String content = "";
                while (bufferedReader.ready())
                {
                    int c = bufferedReader.read();
                    content = content+ (char)c;
                }

                //show the file in the text area
                editorFrame.getTextArea().setText(content);
                bufferedReader.close();
                fileReader.close();

                //set the temp content and the title
                editorFrame.setTempContent(editorFrame.getTextArea().getText());
                editorFrame.setTitle("Editor -" + editorFrame.getFilename());

            }

        }catch (Exception exception){
            exception.printStackTrace();
        }

    }


    /**
     * save file
     * @param editorFrame
     */
    public static void saveFile(EditorFrame editorFrame){
        try {
            //write the file
            File writeFile = new File(editorFrame.getFilename());
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(writeFile)));
            printWriter.print(editorFrame.getTextArea().getText());
            printWriter.flush();
            printWriter.close();

            //set the temp content
            editorFrame.setTempContent(editorFrame.getTextArea().getText());

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    /**
     * save file as ...
     * @param editorFrame
     */
    public static void saveFileAs(EditorFrame editorFrame){
        FileDialog fileDialog = new FileDialog(editorFrame, "save as", FileDialog.SAVE);
        fileDialog.setFile("*.txt");
        fileDialog.setVisible(true);
        if (fileDialog.getFile() != null) {
            try {
                //write the file
                File writeFile = new File(fileDialog.getDirectory() + fileDialog.getFile());
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(writeFile)));
                printWriter.print(editorFrame.getTextArea().getText());
                printWriter.flush();
                printWriter.close();

                //set the temp content
                editorFrame.setTempContent(editorFrame.getTextArea().getText());

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * exit
     * @param editorFrame
     */
    public static void exit(EditorFrame editorFrame){
        editorFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        //if the current content not equals to the temp content, means you need to save it
        if(!editorFrame.getTextArea().getText().equals(editorFrame.getTempContent())) {
            int result = JOptionPane.showConfirmDialog(null,
                    "Do you want to save the file before exit ?", "warning", JOptionPane.YES_NO_CANCEL_OPTION);

            // you do nothing if tou choose cancel
            if(result==JOptionPane.YES_OPTION){
                if (editorFrame.getFilename() != null) {
                    FileUtil.saveFile(editorFrame);
                }else {
                    FileUtil.saveFileAs(editorFrame);
                }
                System.exit(0);
            }else if(result==JOptionPane.NO_OPTION){
                System.exit(0);
            }
            else if(result==JOptionPane.CANCEL_OPTION){

            }
        } else {
            System.exit(0);
        }
    }


}
