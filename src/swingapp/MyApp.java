package swingapp;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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

public class MyApp implements ActionListener, WindowListener ,MouseListener{
    JFrame frame;
    JLabel usernameLabel, passwordLabel,welcomeLabel,showLabel,logo;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton, signupButton;
    JPanel panel;
    

    public MyApp(){

        frame=new JFrame("Login Frame");
        frame.addWindowListener(this);
        
        panel =new JPanel();
        panel.setLayout(null);

        panel.setBounds(180,84,410,320);
        panel.setBorder(BorderFactory.createLoweredBevelBorder());
        // panel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        // panel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        // panel.setBorder(BorderFactory.createTitledBorder("User Login"));
        // panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createTitledBorder("User Login")));
        // panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLineBorder(Color.RED, 2)));
        

        welcomeLabel = new JLabel("Login Page");
        welcomeLabel.setBounds(130,30,300,40);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD,30));

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(50,100,70,25);

        usernameField = new JTextField();
        usernameField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        usernameField.setBounds(120,100,200,25);
        
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50,150,90,25);
      
        passwordField = new JPasswordField();
        passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        showLabel= new JLabel("Show");
        showLabel.setBounds(330,150,40,25);
        showLabel.addMouseListener(this);


        passwordField.setBounds(120,150,200,25);
        passwordField.setEchoChar('*');

        loginButton=new JButton("Login");
        loginButton.setBounds(50,200,300,30);
        loginButton.setActionCommand("login");
        loginButton.addActionListener(this);
        loginButton.setBackground(Color.cyan);
        loginButton.setForeground(Color.black);
        loginButton.setFont(new Font("Times New Roman", Font.BOLD,20));

        signupButton=new JButton("Create New Account");
        signupButton.setBounds(130,250,150,30);
        signupButton.setActionCommand("signup");
        signupButton.addActionListener(this);
        signupButton.setBackground(Color.red);
        signupButton.setForeground(Color.black);
        // signupButton.setFont(new Font("arial", Font.BOLD,14));

       
        panel.add(welcomeLabel);
        panel.add(usernameField);
        panel.add(usernameLabel);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(showLabel);
        panel.add(loginButton);
        panel.add(signupButton);

        frame.add(panel);
        
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new MyApp();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("login"))
        {
            String username =usernameField.getText();
            String passsword= passwordField.getText();
            if(username.isEmpty()|| passsword.isEmpty()){
                JOptionPane.showMessageDialog(frame,"Username or password is missing", "Missing Credentials", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                if(new StudentDao().checkValidUser(username,passsword))
                {
                    this.frame.dispose();
                    new Home();
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"Username and password is not correct","Incorrect Credintials",JOptionPane.ERROR_MESSAGE);
                }
            }

        }
        else if(e.getActionCommand().equals("signup")){
            this.frame.dispose();
            new SignUpForm(); 
        }
    }
    @Override
    public void windowOpened(WindowEvent e) {
      
        
    }
    @Override
    public void windowClosing(WindowEvent e) {
        int option=JOptionPane.showOptionDialog(frame,"Are you sure ?"
        , "Exit", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,JOptionPane.YES_OPTION);
        if(option==0){
            System.exit(0);
        }
        else{
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
       
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        passwordField.setEchoChar((char)0);
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        passwordField.setEchoChar('*');
        
    }

}
