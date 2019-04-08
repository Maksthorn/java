package bookstore;

import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Grim
 */
public class Main {
     private static StorageManager stMan; //allows to be referable without having an instance of it
     
        public Main (String db) throws ClassNotFoundException, SQLException{
            stMan = new StorageManager(db);
        
        }

    public static StorageManager getStMan() {
        return stMan;
    }
    
}
