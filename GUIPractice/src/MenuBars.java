import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.io.File;

public class MenuBars extends JMenuBar {
    public static void main(String[] args) {
        Frames frame = new Frames();

        JMenuBar menu = new JMenuBar();
        
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem loadItem = new JMenuItem("Open File");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem undo = new JMenuItem("Undo");
        JMenuItem redo = new JMenuItem("Redo");
        JMenuItem about = new JMenuItem("About");
        //-----------------------------------------File Chooser--------------------------------------------
        loadItem.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);//select file to open

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        });

        save.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("C:\\Users\\Ayush\\Desktop"));
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }

        });
        //-------------------------------------------------------------------------------------------------
        about.addActionListener(e -> JOptionPane.showMessageDialog(null, ("Version 10.00")));

        fileMenu.setMnemonic(KeyEvent.VK_F);//Hold Alt + F to open the file menu
        loadItem.setMnemonic(KeyEvent.VK_L);//l to load

        fileMenu.add(loadItem);
        fileMenu.add(save);
        editMenu.add(undo);
        editMenu.add(redo);
        helpMenu.add(about);
        
        menu.add(fileMenu);
        menu.add(editMenu);
        menu.add(helpMenu);

        frame.setJMenuBar(menu);
        frame.setVisible(true);
    }
}
