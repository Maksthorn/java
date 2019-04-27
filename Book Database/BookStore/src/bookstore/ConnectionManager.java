/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Grim
 */
//class creates reusable connection for all other classes
public class ConnectionManager {
    Connection connection;
    String databaseName = "books.accdb";
    
    public static Connection connect() {
        try{
        String msAccDB = "./books.accdb"; // db name , located a dir above the folder containing this file
        String dbURL = "jdbc:ucanaccess://" + msAccDB; 
        Connection connection = DriverManager.getConnection(dbURL,"",""); //db link user + pass are blank
        return connection;
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        return null;
        }
        
       
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
