/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Ioana
 */
public class EmpClientData {
    Conexiune c=new Conexiune();
    public synchronized boolean Insert(String cnp,int ID_Employee,String Operatia) throws SQLException
    {
        Connection con=c.getConnection();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        java.util.Date today = Calendar.getInstance().getTime();        
        String reportDate = df.format(today);
        String queryStr1 = "Insert into EmpClient (CNP,Operatia,DataOp,ID_Employee) values (?,?,?,?)";
        PreparedStatement pstmt1 =con.prepareStatement(queryStr1);
        pstmt1.setString(1, cnp);
        pstmt1.setString(2, "InsertAccount");
        pstmt1.setString(3,reportDate );
        pstmt1.setInt(4, ID_Employee);
        pstmt1.execute();
        if(queryStr1!=null)
            return true;
        else
            return false;
    }
  public synchronized  boolean Delete(String CNP) throws SQLException
    {
        Connection con=c.getConnection();
        String queryStr = "delete from EmpClient " +"WHERE CNP=?";
        PreparedStatement pstmt =con.prepareStatement(queryStr);
        pstmt.setString(1, CNP);
        pstmt.execute();
        
        if(queryStr!=null)
            return true;
        else
            return false;
    }
  public  ArrayList<StringBuilder> readOperatii(int ID_Employee)
  {
      
        Connection con = c.getConnection(); 
        ArrayList<StringBuilder> op=new ArrayList<StringBuilder>();
        StringBuilder builder=new StringBuilder();
        String query="Select * from EmpClient";
        try{
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery(query);
        int columnCount = rs.getMetaData().getColumnCount();
            while ( rs.next() ) {
                if(rs.getInt("ID_Employee")==ID_Employee){
                   for (int i = 0; i < columnCount;) {
                    builder.append(rs.getString(i + 1));
                        if (++i < columnCount) builder.append(",");
                }
                   op.add(builder);
                }
            }
        }catch(SQLException e)
        {
             System.err.println("Caught IOException: " + e.getMessage());
        }
        return op;
  }
}
