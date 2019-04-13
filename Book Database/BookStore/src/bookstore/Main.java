/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Grim
 */
public class Main {
    Connection connection;
    String databaseName = "books.accdb";
    
    public static Connection connect() {
        try{
        String msAccDB = "..//books.accdb"; // db name , located a dir above the folder containing this file
        String dbURL = "jdbc:ucanaccess://" + msAccDB; 
        Connection connection = DriverManager.getConnection(dbURL,"",""); //db link user + pass are blank
        return connection;
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        return null;
        }
        
       
    }
    
}
