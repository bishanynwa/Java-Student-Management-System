package swingapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


import java.awt.Color;
import java.awt.Font;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import swingapp.database.StudentDao;

public class SignUpForm implements ActionListener, WindowListener, MouseListener{
    JFrame  frame;
    JLabel fullNameLabel,emailLabel,usernameLabel,PasswordLabel,welcomeLabel,loginLabel;
    JTextField  fullNameField,emailField,welcomeField,usernameField;
    JPasswordField passwordField;
    JButton signupButton,restButton;
    JPanel panel;

    public SignUpForm(){
        frame = new JFrame("Sign Up Form");
        frame.addWindowListener(this);

        panel =new JPanel();
        panel.setLayout(null);
        
        panel.setBounds(70,70,410,420);
        // panel.setBorder(BorderFactory.createLoweredBevelBorder());
        panel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        // panel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        // panel.setBorder(BorderFactory.createTitledBorder("User Login"));
        // panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createTitledBorder("User Login")));
        // panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLineBorder(Color.RED, 2)));

        loginLabel =new JLabel("Already a User? Click Here :)");
        loginLabel.setBounds(150,330,250,30);
        loginLabel.addMouseListener(this);

        welcomeLabel = new JLabel("Sign-Up Form ");
        welcomeLabel.setBounds(50,30,300,40);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD,30));


        emailLabel = new JLabel("Email");
        emailLabel.setBounds(50,100,100,25);

        emailField= new JTextField();
        emailField.setBounds(120,100,250,25);

        fullNameLabel= new JLabel("Full Name");
        fullNameLabel.setBounds(50,150,150,25);

        fullNameField= new JTextField();
        fullNameField.setBounds(120,150,250,25);

        usernameLabel=new JLabel("Username");
        usernameLabel.setBounds(50,200,150,25);

        usernameField=new JTextField();
        usernameField.setBounds(120,200,250,25);
 
        PasswordLabel=new JLabel("Password");
        PasswordLabel.setBounds(50,250,150,25);

        passwordField=new JPasswordField();
        passwordField.setBounds(120,250,250,25);

        loginLabel =new JLabel("Already a User? Click Here :)");
        loginLabel.setBounds(120,350,250,30);
        loginLabel.addMouseListener(this);


        signupButton= new JButton("Sign UP");
        signupButton.setBounds(120,300,250,50);
        signupButton.addActionListener(this);

       
       
        
        panel.add(welcomeLabel);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(fullNameLabel);
        panel.add(fullNameField);

        panel.add(usernameLabel);
        panel.add(usernameField);

        panel.add(PasswordLabel);
        panel.add(passwordField);

        panel.add(signupButton);

        panel.add(loginLabel);

        frame.add(panel);

        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


public static void main(String[] args) {
    new SignUpForm();
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
        if(new StudentDao().registerUser(fullName,email,username,password))
        {   
            
            JOptionPane.showMessageDialog(frame,"New User registered successfully" ,"User Registered",JOptionPane.INFORMATION_MESSAGE);
            fullNameField.setText("");
            emailField.setText("");
            usernameField.setText("");
            passwordField.setText("");
            frame.dispose();
            new MyApp();

        }
        else{
            JOptionPane.showMessageDialog(frame,"New User not Registered" ,"Something went wrong",JOptionPane.ERROR_MESSAGE);
        }


    }
     
    
    
}


@Override
public void windowOpened(WindowEvent e) {
     
    
}


@Override
public void windowClosing(WindowEvent e) {
    
    int option= JOptionPane.showOptionDialog(frame,"Are you sure you want to exit?"
    , "Exit", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE, null,null,JOptionPane.YES_OPTION);
    
    if(option==0)
    {
        System.exit(0);
    }
    else
    {
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}


@Override
public void windowClosed(WindowEvent e) {
     
    
}


@Override
public void windowIconified(WindowEvent e) {
     
    
}


@Override
public void windowDeiconified(WindowEvent e) {
     
    
}


@Override
public void windowActivated(WindowEvent e) {
     
    
}


@Override
public void windowDeactivated(WindowEvent e) {
     
    
}


@Override
public void mouseClicked(MouseEvent e) {
    this.frame.dispose();
            new MyApp(); 
    
}


@Override
public void mousePressed(MouseEvent e) {
     
    
}


@Override
public void mouseReleased(MouseEvent e) {
     
    
}


@Override
public void mouseEntered(MouseEvent e) {
     
    
}


@Override
public void mouseExited(MouseEvent e) {
     
    
}

}
