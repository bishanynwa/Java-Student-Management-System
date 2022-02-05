package swingapp.database;
import java.sql.Connection;
import java.sql.DriverManager;
public class DbConnection {
    
    public Connection getDbConnection(){
        Connection  connection=null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/javabca", "root","");
            System.out.println("Connection is " +connection);

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Exception occured:- "+ e.getMessage());
        }
        return connection;
    }
}
