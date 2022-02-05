package swingapp.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudeOperations {
    static Connection connection=null;
    static PreparedStatement pstmt = null;
    static Statement stmt=null;

    public static void main(String[] args) throws Exception {
        connection= new DbConnection().getDbConnection();
        // insertDemo();
        // updateDemo();
        // deleteDemo();
        selectDemo();
    }


    private static void selectDemo() throws Exception {
    
            stmt=connection.createStatement();
            String query="select studentid,firstname,address,remarks from student";
            ResultSet rs=stmt.executeQuery(query);  
            while(rs.next())
            {
                System.out.println(rs.getString("firstname"));
                System.out.println(rs.getInt("studentid"));
                System.out.println(rs.getString("remarks"));
                System.out.println(rs.getString("address"));
                System.out.println();
            }
            stmt.close();
            rs.close();
            connection.close();
    }


    private static void deleteDemo() {
        try {
            pstmt=connection.prepareStatement("DELETE FROM USERS WHERE USERNAME =?");
            pstmt.setString(1,"try_user");
            

            int rows=pstmt.executeUpdate();
            if(rows>0)
            {
                System.out.println(rows+" user Deleted");
            }
            else{
                System.out.println("USer not Deleted");
            }
            
            pstmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void updateDemo() {
        try {

            pstmt=connection.prepareStatement("update users set password=?,email=? where username =?");
            pstmt.setString(1,"nimesh1234");
            pstmt.setString(2,"nimeshshrestha7@gmail.com");
            pstmt.setString(3,"X.nimesh");
            int rows=pstmt.executeUpdate();
            if(rows>0)
            {
                System.out.println(rows+" user updated");
            }
            else{
                System.out.println("USer not updated");
            }
            pstmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    static void insertDemo(){
        
        try {
            String studentName="test",mail="try@gmail.com",user="try_user",pass="try";
            pstmt=connection.prepareStatement("insert into users(fullname,email,username,password) values(?,?,?,?)");
            pstmt.setString(1,studentName);
            pstmt.setString(2,mail);
            pstmt.setString(3,user);
            pstmt.setString(4,pass);
            int rows =pstmt.executeUpdate();
            if(rows>0)
            {
                System.out.println(rows+" user Added");
            }
            else{
                System.out.println("USer not added");
            }
            pstmt.close();
            connection.close();
            
        } catch (SQLException e) {
           
            e.printStackTrace();
        }

    }
}
