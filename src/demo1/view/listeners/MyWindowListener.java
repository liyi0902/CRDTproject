package demo1.view.listeners;

import demo1.utils.FileUtil;
import demo1.view.EditorFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowListener extends WindowAdapter {
    private EditorFrame editorFrame;

    public MyWindowListener() {
        editorFrame= EditorFrame.getInstance();
    }

    @Override
    public void windowClosing(WindowEvent evt) {

        FileUtil.exit(editorFrame);
    }


}
