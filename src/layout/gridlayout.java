package layout;

import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.JFrame;

public class gridlayout {

    JFrame frame;
    JButton  b1,b2,b3,b4,b5;

    public gridlayout(){
        frame= new JFrame("Grid LAyout");
        frame.setLayout(new GridLayout(2,2));
        
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
         new gridlayout();
    }
    
}
