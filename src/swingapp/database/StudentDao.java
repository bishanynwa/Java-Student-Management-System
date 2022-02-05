package swingapp.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class StudentDao {

   Connection connection=null;
    public boolean checkValidUser(String username, String passsword) {
        
        boolean isValidUser=false;
        PreparedStatement pstmt;

        try {

            connection =new DbConnection().getDbConnection();
           pstmt=connection.prepareStatement("SELECT COUNT(1) FROM USERS WHERE USERNAME =?  AND PASSWORD =?");
            pstmt.setString(1,username);
            pstmt.setString(2, passsword);
            ResultSet rs=pstmt.executeQuery();
            int count=0;
            if(rs.next())
            {
                count=rs.getInt(1);
            }
            if(count>0){
                isValidUser=true;
                 pstmt.close();
                rs.close();
                connection.close();
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }

        return isValidUser;
    }
    public boolean registerUser(String fullName, String email, String username, String password) {
        
        boolean isregistered=false;
        PreparedStatement pstmt;
        try {
            connection= new DbConnection().getDbConnection();
            pstmt=connection.prepareStatement("insert into users(fullname,email,username,password) values(?,?,?,?)");
            pstmt.setString(1,fullName);
            pstmt.setString(2,email);
            pstmt.setString(3,username);
            pstmt.setString(4,password);
            int rows =pstmt.executeUpdate();
            if(rows>0)
            {
                isregistered=true;
            }

            pstmt.close();
            connection.close();
            
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        
        return isregistered;
    }
    


    public boolean addStudent(String firstName,String lastName,String address,String gender,String course,String finalHobbies,String phone,String remarks) {
        
        boolean isadded=false;
        PreparedStatement pstmt;
        try {
            connection= new DbConnection().getDbConnection();
            pstmt=connection.prepareStatement("insert into STUDENT(FIRSTNAME,LASTNAME,ADDRESS,GENDER,COURSE,HOBBIE,PHONE,REMARKS) values(?,?,?,?,?,?,?,?)");
            pstmt.setString(1,firstName);
            pstmt.setString(2,lastName);
            pstmt.setString(3,address);
            pstmt.setString(4,gender);
            pstmt.setString(5,course);
            pstmt.setString(6,finalHobbies);
            pstmt.setString(7,phone);
            pstmt.setString(8,remarks);
            int rows =pstmt.executeUpdate();
            if(rows>0)
            {
                isadded=true;
            }

            pstmt.close();
            connection.close();
            
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        
        return isadded;
    }
   
    
    public boolean deleteStudent(int studentId) {
        Boolean isDeleted=false;
        try {
            connection=new DbConnection().getDbConnection();
            PreparedStatement pstmt = null;
        
            pstmt=connection.prepareStatement("DELETE FROM STUDENT WHERE STUDENTID =?");
            pstmt.setInt(1,studentId);
            

            int rows=pstmt.executeUpdate();
            if(rows>0)
            {
                isDeleted=true;
            }
            
            pstmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
    public boolean updateStudent(int studentid, String firstName,String lastName,String address,String gender,String course,String finalHobbies,String phone,String remarks) {
        
        boolean isUpdated=false;
        PreparedStatement pstmt;
        try {
            System.out.println("function runned");
            connection= new DbConnection().getDbConnection();
            pstmt=connection.prepareStatement("UPDATE STUDENT SET FIRSTNAME=? ,LASTNAME=?,ADDRESS=?,GENDER=?,COURSE=?,HOBBIE=?,PHONE=?,REMARKS=?"+
            " WHERE STUDENTID=?");
            pstmt.setString(1,firstName);
            pstmt.setString(2,lastName);
            pstmt.setString(3,address);
            pstmt.setString(4,gender);
            pstmt.setString(5,course);
            pstmt.setString(6,finalHobbies);
            pstmt.setString(7,phone);
            pstmt.setString(8,remarks);
            pstmt.setInt(9,studentid);
            int rows =pstmt.executeUpdate();
            if(rows>0)
            {
                isUpdated=true;
                
            }
            
            pstmt.close();
            connection.close();
            
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        
        return isUpdated;
    }
   


}
