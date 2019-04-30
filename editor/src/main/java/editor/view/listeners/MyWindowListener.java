package editor.view.listeners;



import editor.utils.FileUtil;
import editor.view.EditorFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * listen to the event when user operate the window
 */
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
