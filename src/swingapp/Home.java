package swingapp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import swingapp.database.DbConnection;
import swingapp.database.StudentDao;


//search feature ,sort by ,filter , resuume file location 




public class Home  implements ActionListener,WindowListener, KeyListener {
    
    JFrame frame;
    JLabel headingLabel ,firstNameLabel,lastnameLabel,addressLabel,genderLabel,courseLabel,hobbieslLabel,phoneLabel,remarksLabel;
    JTextField firstNameTextField,lastnameField,addressField,phoneField;
    JTextArea remaksArea;
    JRadioButton maleButton,femaleButton;
    JButton resumeButton,saveButton, deleteButton, updateButton;
    ButtonGroup bgGender;
    JComboBox<String> comboCourse;
    JCheckBox programmingBox,playingBox,travellingBox;

    JTable studentlisTable;
    JScrollPane scrollPane;
    DefaultTableModel model;
    String[] columns ={"STUDENTID","FIRST NAME","LAST NAME","ADDRESS", "GENDER", "COURSE", "HOBBIES", "PHONE","REMARKS"};
    JPanel panel;


    public Home() {
        frame=new JFrame("Home");
        frame.addWindowListener(this);

        panel=new JPanel();
        panel.setBorder(BorderFactory.createLoweredBevelBorder());
        // panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(),BorderFactory.createLineBorder(Color.RED, 2)));
        panel.setBounds(1000,70,470,600);



        model=new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        studentlisTable = new JTable();
        studentlisTable.setModel(model);

        
        scrollPane = new JScrollPane(studentlisTable);
        scrollPane.setBounds(50,80,900,400);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        headingLabel=new JLabel("Students Details");
        headingLabel.setBounds(50,20,500,50);
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD,50));

        firstNameLabel=new JLabel("First Name");
        firstNameLabel.setBounds(1050,100,100,30);

        firstNameTextField=new JTextField();
        firstNameTextField.setBounds(1150,100,200,30);

        lastnameLabel = new JLabel("Last Name");
        lastnameLabel.setBounds(1050,150,100,30);

        lastnameField=new JTextField();
        lastnameField.setBounds(1150,150,200,30);

        addressLabel= new JLabel("Address");
        addressLabel.setBounds(1050,200,200,30);

        addressField =new JTextField();
        addressField.setBounds(1150,200,200,30);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(1050,250,200,30);

        maleButton =new JRadioButton("Male");
        maleButton.setBounds(1150,250,80,30);

        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(1230,250,80,30);

        bgGender = new ButtonGroup();
        bgGender.add(maleButton);
        bgGender.add(femaleButton);

        courseLabel =new JLabel("Course");
        courseLabel.setBounds(1050,300,100,30);

        comboCourse= new JComboBox<>();
        comboCourse.addItem("Select Course");
        comboCourse.addItem("BCA");
        comboCourse.addItem("CSIT");
        comboCourse.addItem("BIM");
        comboCourse.addItem("BBS");
        comboCourse.setBounds(1150,300,150,30);

        hobbieslLabel =new JLabel("Hobbies");
        hobbieslLabel.setBounds(1050,350,100,30);

        programmingBox = new JCheckBox("Programming");
        playingBox = new JCheckBox("Playing Games");
        travellingBox= new JCheckBox("Travelling");
        programmingBox.setBounds(1150,350,100,30);
        playingBox.setBounds(1250,350,110,30);
        travellingBox.setBounds(1360,350,100,30);

        phoneLabel =new JLabel("Phone");
        phoneLabel.setBounds(1050,400,100,30);
        
        phoneField = new JTextField();
        phoneField.setBounds(1150,400,200,30);
        phoneField.addKeyListener(this);

        remarksLabel = new JLabel("Remarks");
        remarksLabel.setBounds(1050,450,100,30);

        remaksArea = new JTextArea();
        remaksArea.setBounds(1150,450,200,100); 

        resumeButton =new JButton("Resume");
        resumeButton.setBounds(1050,550,100,30);
        
        saveButton =new JButton("Save");
        saveButton.setBounds(1150,600,100,30);
        saveButton.setActionCommand("save");
        saveButton.addActionListener(this);

        deleteButton =new JButton("Delete");
        deleteButton.setBounds(100,500,100,50);
        deleteButton.setActionCommand("delete");
        deleteButton.addActionListener(this);

        updateButton =new JButton("Update");
        updateButton.setBounds(220,500,100,30);
        updateButton.setActionCommand("update");
        updateButton.addActionListener(this);
        
        frame.add(deleteButton);
        frame.add(updateButton);

        frame.add(scrollPane);
        frame.add(headingLabel);

        frame.add(firstNameLabel);
        frame.add(firstNameTextField);

        frame.add(lastnameLabel);
        frame.add(lastnameField);

        frame.add(addressField);
        frame.add(addressLabel);

        frame.add(genderLabel);

        frame.add(maleButton);
        frame.add(femaleButton);

        frame.add(courseLabel);
        frame.add(comboCourse);
        
        frame.add(hobbieslLabel);
        frame.add(programmingBox);
        frame.add(playingBox);
        frame.add(travellingBox);
        
        frame.add(phoneLabel);
        frame.add(phoneField);
        
        frame.add(remarksLabel);
        frame.add(remaksArea);
        
        frame.add(resumeButton);

        frame.add(saveButton);

        frame.add(panel);


        frame.setSize(1500,1000);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        getStudentlist();




    }
    
    public static void main(String[] args) {
        new Home();
    }

    public void refreshStudent() {

        firstNameTextField.setText("");
        lastnameField.setText("");
        addressField.setText("");
        remaksArea.setText("");
        phoneField.setText("");

        programmingBox.setSelected(false);
        playingBox.setSelected(false);
        travellingBox.setSelected(false);

        comboCourse.setSelectedIndex(0);;

        bgGender.clearSelection();

        getStudentlist();
    }

    public void getStudentlist() {
        if(model.getRowCount()>0)
        {
            model.setRowCount(0);
        }
       
        try {

            Connection connection= new DbConnection().getDbConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs =stmt.executeQuery("SELECT STUDENTID, FIRSTNAME, LASTNAME, ADDRESS, GENDER, COURSE, HOBBIE, PHONE, REMARKS FROM student ");
            
            while(rs.next())
            {
                model.addRow(new Object[] {rs.getInt("STUDENTID") , rs.getString("firstname") , rs.getString("lastname") , rs.getString("address"), rs.getString("gender"), rs.getString("course"), rs.getString("hobbie"), rs.getString("phone"), rs.getString("remarks")});
            }
            stmt.close();
            rs.close();
            connection.close();

        } catch (Exception e) {
           e.printStackTrace();
        } 
    }
    



    @Override
    public void actionPerformed(ActionEvent e) {
             if(e.getActionCommand().equals("save"))
            {
                String firstName = firstNameTextField.getText();
                String lastName = lastnameField.getText();
                String address = addressField.getText();
                String phone = phoneField.getText();
                String remarks =remaksArea.getText();
                String gender = maleButton.isSelected()? "Male" :"Female";
                String course = (String)comboCourse.getSelectedItem();
                List<String>  hobbyList =new ArrayList<>();
                if (travellingBox.isSelected()){
                    hobbyList.add("Travelling");
                }
                if (programmingBox.isSelected()){
                    hobbyList.add("Programming");
                }
                if (playingBox.isSelected()){
                    hobbyList.add("Playing");
                }
                StringBuilder sb =new StringBuilder();
                for (String hobby : hobbyList) {
                    sb.append(hobby);
                    sb.append(",");
                }

                String finalHobbies = sb.toString();
                if(firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || phone.isEmpty() || remarks.isEmpty())
                {
                    JOptionPane.showMessageDialog(frame,"informations are missing ","Fill all  information",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(new StudentDao().addStudent(firstName,lastName,address,gender,course,finalHobbies,phone,remarks))
                    {   
                        
                        JOptionPane.showMessageDialog(frame,"New student added successfully" ,"Student Added",JOptionPane.INFORMATION_MESSAGE);
                     
                        refreshStudent();

                    }
                    else{
                        JOptionPane.showMessageDialog(frame,"New student not added ","Something went wrong",JOptionPane.ERROR_MESSAGE);
                    }

                }


        }
            else if(e.getActionCommand().equals("delete"))
        {
                if(studentlisTable.getSelectedRowCount()<1)
                {
                    JOptionPane.showMessageDialog(frame,"Please Select the row","no Row selected",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    
                    int studentId=(int)studentlisTable.getValueAt(studentlisTable.getSelectedRow(),0);
                    if(new StudentDao().deleteStudent(studentId)){

                        JOptionPane.showMessageDialog(frame,"Student deleted successfully" ,"Delete complete",JOptionPane.INFORMATION_MESSAGE);
                        getStudentlist();
                    }
                    else{
                        JOptionPane.showMessageDialog(frame,"Student not deleted","Error occured",JOptionPane.ERROR_MESSAGE);
                    }
                
                }


            }
            else if(e.getActionCommand().equals("update"))
            {
                saveButton.setActionCommand("updateStd");
                if(studentlisTable.getSelectedRowCount()<1)
                {
                    JOptionPane.showMessageDialog(frame,"Please Select the row","no Row selected",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    
                    firstNameTextField.setText((String) studentlisTable.getValueAt(studentlisTable.getSelectedRow(),1));    
                    lastnameField.setText((String) studentlisTable.getValueAt(studentlisTable.getSelectedRow(),2));
                    addressField.setText((String) studentlisTable.getValueAt(studentlisTable.getSelectedRow(),3));
                    String gender = (String) studentlisTable.getValueAt(studentlisTable.getSelectedRow(),4);
                    if (gender.equals("male"))
                    {
                        maleButton.setSelected(true);
                        
                    }
                    else
                    {
                        femaleButton.setSelected(true);
                    }
                    comboCourse.setSelectedItem((String) studentlisTable.getValueAt(studentlisTable.getSelectedRow(),5));
                    
                    String hobbies =  (String) studentlisTable.getValueAt(studentlisTable.getSelectedRow(),6);
                    String[] hobbiesArray=hobbies.split(",");

                        programmingBox.setSelected(false);
                        playingBox.setSelected(false);
                        travellingBox.setSelected(false);

                    for(String hobby :hobbiesArray)
                    {
                        if(hobby.equals("Playing"))
                        {
                            playingBox.setSelected(true);
                        }
                        else if(hobby.equals("Travelling"))
                        {
                            travellingBox.setSelected(true);
                        }
                        if(hobby.equals("Programming"))
                        {
                            programmingBox.setSelected(true);
                        }
                        
                        
                    }

                    phoneField.setText((String) studentlisTable.getValueAt(studentlisTable.getSelectedRow(),7));
                    remaksArea.setText((String) studentlisTable.getValueAt(studentlisTable.getSelectedRow(),8));
                
                }

                
    
                    
            }


            else if(e.getActionCommand().equals("updateStd"))
                {
                    
                    String firstName = firstNameTextField.getText();
                    String lastName = lastnameField.getText();
                    String address = addressField.getText();
                    String phone = phoneField.getText();
                    String remarks =remaksArea.getText();
                    String gender = maleButton.isSelected()? "Male" :"Female";
                    String course = (String)comboCourse.getSelectedItem();
                    List<String>  hobbyList =new ArrayList<>();
                    if (travellingBox.isSelected()){
                        hobbyList.add("Travelling");
                    }
                    if (programmingBox.isSelected()){
                        hobbyList.add("Programming");
                    }
                    if (playingBox.isSelected()){
                        hobbyList.add("Playing");
                    }
                    StringBuilder sb =new StringBuilder();
                    for (String hobby : hobbyList) {
                        sb.append(hobby);
                        sb.append(",");
                    }
    
                    String finalHobbies = sb.toString();
                    int studentid=(int)studentlisTable.getValueAt(studentlisTable.getSelectedRow(),0);
                        if(new StudentDao().updateStudent(studentid,firstName,lastName,address,gender,course,finalHobbies,phone,remarks))
                        {   
                            
                            JOptionPane.showMessageDialog(frame," Student updates successfully" ,"Student Added",JOptionPane.INFORMATION_MESSAGE);
                         
                            refreshStudent();
    
                        }
                        else{
                            JOptionPane.showMessageDialog(frame,"student not upodated ","Something went wrong",JOptionPane.ERROR_MESSAGE);
                        }


        }
        else if(e.getActionCommand().equals("resume"))
        {
            
            
        }


 

        saveButton.setActionCommand("save");
        
    }
    @Override
    public void windowClosing(WindowEvent e) {
        int option=JOptionPane.showOptionDialog(frame,"Are you sure ?", "Exit",
            JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,JOptionPane.YES_OPTION);
        if(option==0){
            
            System.exit(0);
            
        }
        else{
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }
        
    @Override
    public void keyTyped(KeyEvent e)
    {
        char character = e.getKeyChar();
        if(phoneField.getText().length()<10)
        {
            if (!Character.isDigit(character)) 
            {
                java.awt.Toolkit.getDefaultToolkit().beep();
                    e.consume();
            }
        }
        else{
            e.consume();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
        
    }
    @Override
    public void windowOpened(WindowEvent e) {
         
        
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
}
