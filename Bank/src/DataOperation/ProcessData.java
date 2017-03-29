/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperation;

import Business.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ioana
 */
public class ProcessData {
   Conexiune c=new Conexiune();  
  public boolean Insert(int ID_Employee,String IdNrAccount,float AmmountOfMoney,String DataOperation,String op) throws SQLException
    {
        Connection con=c.getConnection();
        String queryStr = "Insert into Process (IdProcess,IdNumberAcc,AmmountOfMoney,DataOperation,Op) values (?,?,?,?,?)";
        PreparedStatement pstmt =con.prepareStatement(queryStr);
        pstmt.setInt(1, ID_Employee);
        pstmt.setString(2, IdNrAccount);
        pstmt.setFloat(3, AmmountOfMoney);
        pstmt.setString(4, DataOperation);
        pstmt.setString(5, op);
        pstmt.execute();
        if(queryStr!=null)
            return true;
        else
            return false;
    }
  public ArrayList<StringBuilder> readProcess(int ID_Employee,String dindata,String panadata)
  {
      ArrayList<StringBuilder> pros=new ArrayList<StringBuilder>();
      StringBuilder builder=new StringBuilder();
        Connection con = c.getConnection();  
        String query="Select * from Process";
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date parsed = null;
        java.util.Date parsed1 = null;
        try {
        parsed = sdf.parse(dindata);
        parsed1=sdf.parse(panadata);
        } catch (ParseException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
        }
    java.sql.Date data = new java.sql.Date(parsed.getTime());
    java.sql.Date data1 = new java.sql.Date(parsed1.getTime());
        try{
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery(query);
        int columnCount = rs.getMetaData().getColumnCount();
            while ( rs.next() ) {
                if(rs.getString("ID_Employee").equals(ID_Employee) && rs.getDate("DataOp").after(data) && rs.getDate("DataOp").before(data1)){
                   for (int i = 0; i < columnCount;) {
                    builder.append(rs.getString(i + 1));
                        if (++i < columnCount) builder.append(",");
                }
                    pros.add(builder);
                }
                
            }
        }catch(SQLException e)
        {
             System.err.println("Caught IOException: " + e.getMessage());
        }
        return pros;
  }
}
