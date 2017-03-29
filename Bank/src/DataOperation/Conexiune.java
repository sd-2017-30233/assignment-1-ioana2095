/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 *
 * @author Ioana
 */
public class Conexiune {
    private Connection con = null;  
    public Conexiune()
    {
        Conection();
    }
    public Connection getConnection()
    {
        return con;
    }
    private void Conection() 
{
     // Create a variable for the connection string.  
      String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
              "databaseName=Bank;integratedSecurity=true;"; 
      // Declare the JDBC objects.   
      try{
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
      con = DriverManager.getConnection(connectionUrl);   
      }  
  
      // Handle any errors that may have occurred.  
      catch (Exception e) {  
         e.printStackTrace();  
      }  
}
}
