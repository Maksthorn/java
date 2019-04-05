/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class StorageManager {
    // variables
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null; 
    String query = null;
  
    
    public StorageManager(String databaseName) throws ClassNotFoundException , SQLException{
 
        // Step 1: Loading or registering Oracle JDBC driver class
        // Step 2: Opening database connection
        try {
            //String msAccDB = "..//First_DB.accdb";
            String driver = "net.ucanaccess.jdbc.UcanaccessDriver"; 
            String dbURL = "jdbc:ucanaccess://" + databaseName;
            Class.forName(driver);
            
            // Step 2.A: Create and get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL, "", "");
           
        }
        catch(SQLException sqlex){
            System.err.println(sqlex.getMessage());
        }
        finally {
            // Step 3: Closing database connection
            try {
                if(null != connection) {
                    // cleanup resources, once after processing
                    resultSet.close();
                    statement.close();
                    // and then finally close connection
                    connection.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
    
    }
    
    //sql queries handlers 
    public ResultSet query(String SQL)throws SQLException{
        Statement stmt = connection.createStatement();
        ResultSet result =stmt.executeQuery(SQL);
        return result; 
    }
    
    public int update (String SQL)throws SQLException{
        Statement stmt = connection.createStatement();
        int done = stmt.executeUpdate(SQL);
        return done; 
    }
    
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
