package quiz;

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
 
    public StorageManager(String databaseName) throws ClassNotFoundException , SQLException{
 
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
     //returns the ID of an sql stmt
    public int updateReturnID(String SQL)throws SQLException{
        Statement stmt = connection.createStatement();
        int id=-1;
        stmt.executeUpdate(SQL, Statement.RETURN_GENERATED_KEYS);
        ResultSet result = stmt.getGeneratedKeys();
        if(result.next()){
            id=result.getInt(1);
        }
        return id; 
    }
    
}
