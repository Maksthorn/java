
import java.sql.DriverManager;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 450143
 */
public class DataHandler{
// DB details
 private static String dbURL =
 "jdbc:ucanaccess://..//guiDB.accdb";
 private static java.sql.Connection con;
 private static java.sql.Statement stm;
 private static java.sql.ResultSet rs;
 private static java.sql.ResultSetMetaData rsMeta;
 private static int columnCount;

public static Vector<String> getTables() {
Vector<String> l = new Vector<String>();
l.add("Employee");
l.add("Dependant");
l.add("Department");
l.add("Project");
l.add("Workson");
return l;
}
public static void searchRecords(String table) {
 String sqlQuery = "SELECT * FROM " + table;
 try{
    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    con = DriverManager.getConnection(dbURL, "","");
    stm = con.createStatement(
    java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
    java.sql.ResultSet.CONCUR_UPDATABLE);
    rs = stm.executeQuery(sqlQuery);
    rsMeta = rs.getMetaData();
    columnCount = rsMeta.getColumnCount();
 }
    catch ( ClassNotFoundException cnfex ) {
    System.err.println("Issue with driver." );
    cnfex.printStackTrace();
    System.exit( 1 ); // terminate program
    }
    catch ( java.sql.SQLException sqlex ) {
    System.err.println( sqlex );
    sqlex.printStackTrace();
    }
    catch ( Exception ex ) {
    System.err.println( ex );
    ex.printStackTrace();
    }
}

public static Object[] getTitles(String table) {
 Object [] columnNames = new Object[columnCount];
 try{
 for(int col = columnCount; col > 0; col--)
 columnNames[col-1] =
 rsMeta.getColumnName(col);
 }
 catch( java.sql.SQLException sqlex ) {
 System.err.println( sqlex );
 sqlex.printStackTrace();
 }
 return columnNames;
}

public static Object[][] getRows(String table) {
 searchRecords(table);
 Object [][] content;
 try{
 // determine the number of rows
 rs.last();
 int number = rs.getRow();
 content = new Object[number][columnCount];
 rs.beforeFirst();

 int i =0;
 while(rs.next()) {
 // each row is an array of objects
 for(int col = 1; col <= columnCount; col++)
 content[i][col - 1] = rs.getObject(col);
 i++;
 }
 return content;
 }
 catch( java.sql.SQLException sqlex ) {
 System.err.println( sqlex );
 sqlex.printStackTrace();
 }
 return null;
 }
}