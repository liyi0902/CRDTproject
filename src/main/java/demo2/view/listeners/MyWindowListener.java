package demo2.view.listeners;

import demo2.utils.FileUtil;
import demo2.view.EditorFrame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowListener extends WindowAdapter {
    private EditorFrame editorFrame;

    public MyWindowListener() {
        editorFrame=EditorFrame.getInstance();
    }

    @Override
    public void windowClosing(WindowEvent evt) {

        FileUtil.exit(editorFrame);
    }


}
