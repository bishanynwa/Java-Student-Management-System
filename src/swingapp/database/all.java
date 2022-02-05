package swingapp.database;
 
import javax.swing.*;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
public class all{
    JFrame  frame;
 
    JMenuBar menuBar;
    JMenu fileMenu,editMenu,newItemMenu;
    JMenuItem  openItem, undoItem,copyItem,projectItem,classItem,packageItem;
    static Connection connection=null;
    static PreparedStatement pstmt = null;
    static Statement stmt=null;
    public all(){
        frame = new JFrame("Sign Up Form");
 
        menuBar =new JMenuBar();
        fileMenu =new JMenu("File");
        editMenu =new JMenu("Edit");
 
        newItemMenu =new JMenu("New");
 
        projectItem = new JMenuItem("Project");
        classItem =new JMenuItem("Class");
        packageItem =new JMenuItem("Package");
 
        openItem =new JMenuItem("Open File");
        undoItem =new JMenuItem("Undo");
        copyItem =new JMenuItem("Copy");
 
        fileMenu.add(newItemMenu); newItemMenu.add(projectItem); newItemMenu.add(classItem); newItemMenu.add(packageItem); fileMenu.add(openItem);
        editMenu.add(undoItem); editMenu.add(copyItem);
 
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
 
        frame.setJMenuBar(menuBar);
        
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
 
public static void main(String[] args) {
    new all();
    
    
}
}
 
    
