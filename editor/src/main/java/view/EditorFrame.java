package view;



import view.actions.*;
import view.listeners.*;

import javax.swing.*;


/**
 * the frame of editor
 */
public class EditorFrame extends JFrame {
    /**
     * main text area
     */
    private JTextArea textArea;
    /**
     * file title
     */
    private String fileTitle;
    /**
     * the temp content which has not been saved by the user
     */
    private String tempContent = "";
    /**
     * menu bar
     */
    private JMenuBar menu;
    /**
     * pop menu when click the right button of mouse
     */
    private JPopupMenu popMenu;
    /**
     * the scroll bar
     */
    private JScrollPane scroll;

    /**
     * The instance of this class, use singleton pattern
     */
    private volatile static EditorFrame newInstance;

    /**
     * constructor
     */
    private EditorFrame() {
        menu=new JMenuBar();
        popMenu = new JPopupMenu();
        textArea = new JTextArea();
        scroll = new JScrollPane(textArea);

        //set the component and size of the editor
        this.setTitle("Editor");
        this.add(scroll);
        this.setSize(800,600);
        this.setLocation(300, 100);

    }

    /**
     * create menu
     */
    private void createMenu(){

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu about = new JMenu("About");

        //create menu
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
        JMenuItem help = new JMenuItem(new HelpAction());

        //add menu
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

        about.add(aboutThis);
        about.add(help);

        popMenu.add(copy_pop);
        popMenu.add(cut_pop);
        popMenu.add(paste_pop);
        popMenu.add(delete_pop);
        popMenu.add(clear_pop);

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

        textArea.replaceRange("",pos,pos+1);

    }


    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
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


    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public static void main(String[] args) {
        getInstance();
    }

}

