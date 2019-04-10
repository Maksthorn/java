package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Grim
 */
//class used for connecting to database similarly to the lab example
public class StorageManager {
private Connection connection;
//private static String dbURL = "books.accdb";
 
    public StorageManager(String databaseName) throws ClassNotFoundException , SQLException{
        //creates connection for db , uses UcanaccessDriver
        String driver = "net.ucanaccess.jdbc.UcanaccessDriver"; 
        Class.forName(driver);
        connection = DriverManager.getConnection("jdbc:ucanaccess://" + databaseName);
           
    }
    
    //sql queries handlers 
    public ResultSet query(String SQL)throws SQLException{
        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery(SQL);
        return result; 
    }
    
    public int update (String SQL)throws SQLException{
        Statement stmt = connection.createStatement();
        int done = stmt.executeUpdate(SQL);
        return done; 
    }
   
    
}
