/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperation;
import Business.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Ioana
 */
public class AccountData {
  Conexiune c=new Conexiune();  
  public synchronized boolean Insert(String idNrAccount,float ammountOfMoney,String cnp,int type) throws SQLException
    {
        Connection con=c.getConnection();
        if(readAccount(idNrAccount)==null){
        String queryStr = "Insert into Account (IdNumberAcc,AmmountOfMoney,DataCreation,CNP,IdType) values (?,?,?,?,?)";
        PreparedStatement pstmt =con.prepareStatement(queryStr);
        pstmt.setString(1, idNrAccount);
        pstmt.setFloat(2, ammountOfMoney);
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        java.util.Date today = Calendar.getInstance().getTime();        
        String reportDate = df.format(today);
        pstmt.setString(3, reportDate);
        pstmt.setString(4, cnp);
        pstmt.setInt(5, type);
        pstmt.execute();
        if(queryStr!=null)
            return true;
        else
            return false;
        }
        return false;
    }
  public synchronized  boolean Update(float money,String IdNumberAcc) throws SQLException
    {
        Connection con=c.getConnection();
        String queryStr = "Update Account Set AmmountOfMoney=? where IdNumberAcc=?";
        PreparedStatement pstmt =con.prepareStatement(queryStr);
        pstmt.setFloat(1, money);
        pstmt.setString(2, IdNumberAcc);
        pstmt.execute();
        
        if(queryStr!=null)
            return true;
        else
            return false;
    }
  public  boolean Delete(String IdNumberAcc,String CNP) throws SQLException
    {
        Connection con=c.getConnection();
        String queryStr = "delete from Account " +"WHERE IdNumberAcc=? and CNP=?";
        PreparedStatement pstmt =con.prepareStatement(queryStr);
        pstmt.setString(1, IdNumberAcc);
        pstmt.setString(2, CNP);
        pstmt.execute();
        
        if(queryStr!=null)
            return true;
        else
            return false;
    }
  public  StringBuilder readAccount(String IdNumberAcc)
  {
      
        Connection con = c.getConnection();  
        StringBuilder builder=new StringBuilder();
        String query="Select * from Account";
        try{
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery(query);
        int columnCount = rs.getMetaData().getColumnCount();
            while ( rs.next() ) {
                if(rs.getString("IdNumberAcc").equals(IdNumberAcc)){
                   for (int i = 0; i < columnCount;) {
                    builder.append(rs.getString(i + 1));
                        if (++i < columnCount) builder.append(",");
                }
                   return builder;
                }
            }
        }catch(SQLException e)
        {
             System.err.println("Caught IOException: " + e.getMessage());
        }
        return null;
  }
   public  ArrayList<StringBuilder> readAccounts(String CNP)
  {
      ArrayList<StringBuilder> accs=new ArrayList<StringBuilder>();
      StringBuilder builder=new StringBuilder();
        Connection con = c.getConnection();  
        String query="Select * from Account";
        try{
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery(query);
        int columnCount = rs.getMetaData().getColumnCount();
            while ( rs.next() ) {
                if(rs.getString("CNP").equals(CNP)){
                  for (int i = 0; i < columnCount;) {
                    builder.append(rs.getString(i + 1));
                        if (++i < columnCount) builder.append(",");
                }
                  accs.add(builder);
                }
                
            }
        }catch(SQLException e)
        {
             System.err.println("Caught IOException: " + e.getMessage());
        }
        return accs;
  }
}
