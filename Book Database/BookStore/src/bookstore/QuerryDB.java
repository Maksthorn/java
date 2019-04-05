package bookstore;

/**
 *
 * @author lejla
 * example from http://www.benchresources.net/jdbc-msaccess-database-connection-steps-in-java-8/
 */

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QuerryDB extends JFrame {
 
    // variables
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null; 
    String query = null;
  
    
    public QuerryDB(){
 
        // Step 1: Loading or registering Oracle JDBC driver class
        // Step 2: Opening database connection
        try {
            String msAccDB = "lib_sys.accdb";
            String dbURL = "jdbc:ucanaccess://" + msAccDB; 
            // Step 2.A: Create and get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL, "", "");    //1 
            // Step 2.B: Creating JDBC Statement 
            statement = connection.createStatement();
            // Step 2.C: Executing SQL &amp; retrieve data into ResultSet
            query = "SELECT * FROM book";
            resultSet = statement.executeQuery(query);
            // Step 2.D: use data from ResultSet
            displayResultSet(resultSet);
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
       
      // User Interface
      addWindowListener(new WindowAdapter() 
      { public void windowClosing(java.awt.event.WindowEvent e) 
      {  try {
           connection.close();
         }
         catch (SQLException ex) {}
         System.exit(0);
      }
      });
      // JFrame window size
      setSize(450, 150);
      //set window 
      setTitle(query);
      // show window
      setVisible(true);
    }
   
   // display the result set in a GUI table
   private void displayResultSet(ResultSet rs) throws SQLException
   {
    if (!rs.next()) {
      JOptionPane.showMessageDialog(this, "ResultSet contains no records");
      return;
    }
    ResultSetMetaData rsmd = rs.getMetaData();
    int numCols = rsmd.getColumnCount();
    // get column headers
    String[] columnHeads = new String[numCols];
    for (int i = 1; i <= numCols; i++) 
      columnHeads[i-1] = rsmd.getColumnName(i);
  
    // create table with column heads
    DefaultTableModel tableModel = new DefaultTableModel(columnHeads, 0);
    JTable table = new JTable(tableModel);

    // fill table with ResultSet contents, one row at a time
    do {
       tableModel.addRow( getRow(rs, rsmd) ); 
    } while (rs.next());
    connection.commit();
    // make scrollable table
    JScrollPane scroller = new JScrollPane(table);
    getContentPane().add(scroller, BorderLayout.CENTER);
    // lay out conainer subcomponents.
    validate();
  }  // end of displayResultSet()
  

   // return current row of resultset as an array
   private Object[] getRow(ResultSet rs, ResultSetMetaData rsmd) 
                                                      throws SQLException
   { 
     // get number of columns  
     int numCols = rsmd.getColumnCount();
     Object[] row = new Object[numCols];
     
     // get each field from the current row in the result set
     for (int i = 1; i <= numCols; i++) {
         row[i-1] = rs.getObject(i);
     }
      return row;
   }  // end of getRow()
}// end of class
