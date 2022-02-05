package layout;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.*;

import java.awt.event.ActionListener;

public class all implements ActionListener{
    JFrame  frame;
    JLabel fullNameLabel,emailLabel,usernameLabel,PasswordLabel,welcomeLabel;
    JTextField  fullNameField,emailField,welcomeField,usernameField;
    JPasswordField passwordField;
    JButton signupButton,restButton;
    JMenuBar menuBar;
    JMenu fileMenu,editMenu,newItemMenu;
    JMenuItem  openItem, undoItem,copyItem,projectItem,classItem,packageItem;

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
        welcomeLabel = new JLabel("Sign-Up Form ");
        welcomeLabel.setBounds(100,50,300,25);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(100,100,100,25);

        emailField= new JTextField();
        emailField.setBounds(200,100,150,25);

        fullNameLabel= new JLabel("Full Name");
        fullNameLabel.setBounds(100,150,150,25);

        fullNameField= new JTextField();
        fullNameField.setBounds(200,150,150,25);

        usernameLabel=new JLabel("Username");
        usernameLabel.setBounds(100,200,150,25);

        usernameField=new JTextField();
        usernameField.setBounds(200,200,150,25);
 
        PasswordLabel=new JLabel("Password");
        PasswordLabel.setBounds(100,250,150,25);

        passwordField=new JPasswordField();
        passwordField.setBounds(200,250,150,25);

        signupButton= new JButton("Sign UP");
        signupButton.setBounds(200,300,80,25);
        signupButton.addActionListener(this);

        frame.add(welcomeLabel);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(fullNameLabel);
        frame.add(fullNameField);

        frame.add(usernameLabel);
        frame.add(usernameField);

        frame.add(PasswordLabel);
        frame.add(passwordField);
        frame.add(signupButton);

        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


public static void main(String[] args) {
    new all();
}


@Override
public void actionPerformed(ActionEvent e) {
    String username =usernameField.getText();
    String fullName=fullNameField.getText();
    String email=emailField.getText();
    String password=passwordField.getText();

    if(fullName.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()){
         JOptionPane.showMessageDialog(frame,"Please provide all the fields" ,"ncomplete detail",JOptionPane.ERROR_MESSAGE);
    }
    else{
        
        System.out.println(fullName);
        System.out.println(username);
        System.out.println(email);
        System.out.println(password);
    }
     
    
    
}

}

    

