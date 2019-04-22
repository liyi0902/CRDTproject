package demo2.view;



import demo2.view.actions.*;
import demo2.view.listeners.MyKeyBoardListener;
import demo2.view.listeners.MyMouseListener;
import demo2.view.listeners.MyWindowListener;

import javax.swing.*;


/**
 * the frame of editor
 */
public class EditorFrame extends JFrame {
    private JTextArea textArea;
    private String filename;
    private String tempContent = "";
    private JMenuBar menu;
    private JPopupMenu popMenu;

    private volatile static EditorFrame newInstance;



    private EditorFrame() {
        menu=new JMenuBar();
        popMenu = new JPopupMenu();

        setTitle("Editor");
        textArea = new JTextArea();

        //add scroll bar
        JScrollPane scroll = new JScrollPane(textArea);
        add(scroll);

        //set size and location
        setSize(800,600);
        setLocation(300, 100);

    }

    /**
     * create menu
     */
    private void createMenu(){

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu about = new JMenu("About");

        JMenuItem newFile = new JMenuItem(new NewFileAction());
        JMenuItem open = new JMenuItem(new OpenFileAction());
        JMenuItem save = new JMenuItem(new SaveFileAction());
        JMenuItem save_as = new JMenuItem(new SaveFileAsAction());
        JMenuItem exit = new JMenuItem(new ExitAction());

        JMenuItem copy = new JMenuItem(new CopyAction());
        JMenuItem cut = new JMenuItem(new CutAction());
        JMenuItem paste = new JMenuItem(new PasteAction());
        JMenuItem delete = new JMenuItem(new DeleteAction());
        JMenuItem clear=new JMenuItem(new ClearAction());

        JMenuItem copy_pop = new JMenuItem(new CopyAction());
        JMenuItem cut_pop = new JMenuItem(new CutAction());
        JMenuItem paste_pop = new JMenuItem(new PasteAction());
        JMenuItem delete_pop = new JMenuItem(new DeleteAction());
        JMenuItem clear_pop=new JMenuItem(new ClearAction());

        JMenuItem aboutThis = new JMenuItem(new AboutAction());

        file.add(newFile);
        file.add(open);
        file.add(save);
        file.add(save_as);
        file.add(exit);

        edit.add(copy);
        edit.add(cut);
        edit.add(paste);
        edit.add(delete);
        edit.add(clear);

        popMenu.add(copy_pop);
        popMenu.add(cut_pop);
        popMenu.add(paste_pop);
        popMenu.add(delete_pop);
        popMenu.add(clear_pop);


        about.add(aboutThis);

        menu.add(file);
        menu.add(edit);
        menu.add(about);

        textArea.add(popMenu);
        setJMenuBar(menu);

    }

    /**
     * add listener for mouse,keyboard and window
     */
    private void addListener(){
        addWindowListener(new MyWindowListener());
        textArea.addMouseListener(new MyMouseListener());
        textArea.addKeyListener(new MyKeyBoardListener());
    }


    /**
     * use Singleton pattern since we only need one editor for one process
     * @return
     */
    public static EditorFrame getInstance(){
        if(newInstance==null){
            synchronized (EditorFrame.class){
                if(newInstance==null){
                    newInstance=new EditorFrame();
                    newInstance.createMenu();
                    newInstance.addListener();
                    newInstance.setVisible(true);
                }
            }
        }

        return newInstance;
    }

    /**
     * remote insert
     * @param pos
     * @param str
     */
    public synchronized void remoteInsert(int pos, String str) {
        //TODO

        textArea.insert(str,pos);

    }

    /**
     * remote delete
     * @param pos
     */
    public synchronized void remoteDelete(int pos) {
        //TODO

        textArea.remove(pos);
    }


    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getTempContent() {
        return tempContent;
    }

    public void setTempContent(String tempContent) {
        this.tempContent = tempContent;
    }

    public JMenuBar getMenu() {
        return menu;
    }

    public void setMenu(JMenuBar menu) {
        this.menu = menu;
    }

    public JPopupMenu getPopMenu() {
        return popMenu;
    }

    public void setPopMenu(JPopupMenu popMenu) {
        this.popMenu = popMenu;
    }
}

