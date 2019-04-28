package utils;


import view.EditorFrame;

import javax.swing.*;
import java.awt.*;
import java.io.*;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 * provide methods to operate the file
 */
public class FileUtil {

    /**
     * open new file
     * @param editorFrame
     */
    public static void openFile(EditorFrame editorFrame){
        try{
            //open the fileDialog
            FileDialog fileDialog = new FileDialog(editorFrame, "open file", FileDialog.LOAD);
            fileDialog.setFile("Untitled.txt");
            fileDialog.setVisible(true);

            if (fileDialog.getFile() != null) {
                //set file title
                editorFrame.setFileTitle(fileDialog.getDirectory()+fileDialog.getFile());

                //read content of the file
                BufferedReader bufferedReader =
                        new BufferedReader(new FileReader(fileDialog.getDirectory() + fileDialog.getFile()));
                StringBuilder content =new StringBuilder();
                while (bufferedReader.ready()) {
                    int character = bufferedReader.read();
                    content.append((char)character);
                }

                //show the file in the text area
                editorFrame.getTextArea().setText(content.toString());
                bufferedReader.close();

                //set the temp content and the title
                editorFrame.setTempContent(editorFrame.getTextArea().getText());
                editorFrame.setTitle(fileDialog.getFile());
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
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(new File(editorFrame.getFileTitle()))));
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
        fileDialog.setFile("Untitled.txt");
        fileDialog.setVisible(true);
        if (fileDialog.getFile() != null) {
            try {
                //write the file
                PrintWriter printWriter =
                        new PrintWriter(new BufferedWriter(new FileWriter(
                                new File(fileDialog.getDirectory() + fileDialog.getFile()))));
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
            int result = JOptionPane.showConfirmDialog(editorFrame,
                    "Do you want to save the file before exit ?", "warning", JOptionPane.YES_NO_CANCEL_OPTION);

            // you do not exit if tou choose cancel
            if(result==JOptionPane.YES_OPTION){
                if (editorFrame.getFileTitle() != null) {
                    FileUtil.saveFile(editorFrame);
                }else {
                    FileUtil.saveFileAs(editorFrame);
                }
                System.exit(0);
            }else if(result==JOptionPane.NO_OPTION){
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }


}
