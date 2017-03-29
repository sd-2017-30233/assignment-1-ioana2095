/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperation;

import Business.Employees;
import DataOperation.Conexiune;
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
public class EmployeeData {
    Conexiune c=new Conexiune();  
    public boolean Insert(int IdEmployee,String username,String password,String userType) throws SQLException
    {
        Connection con = c.getConnection();  
        String queryStr = "Insert into Employees (ID_Employee,UserNume,Password,UserType) values (?,?,?,?)";
        PreparedStatement pstmt =con.prepareStatement(queryStr);
        pstmt.setInt(1, IdEmployee);
        pstmt.setString(2, username);
        pstmt.setString(3, password);
        pstmt.setString(4, userType);
        pstmt.execute();
        if(queryStr!=null)
            return true;
        else
            return false;
    }
    public boolean Update(int IdEmployee,String username,String password,String userType) throws SQLException
    {
        Connection con = c.getConnection();  
        String queryStr = "UPDATE Employees SET UserNume=?,Password=?,UserType=? WHERE ID_Employee=?";
        PreparedStatement pstmt =con.prepareStatement(queryStr);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        pstmt.setString(3, userType);
        pstmt.setInt(4, IdEmployee);
        pstmt.execute();
        if(queryStr!=null)
            return true;
        else
            return false;
    }
    public boolean Delete(int ID_Employee) throws SQLException
    {
        Connection con = c.getConnection();  
        String queryStr = "delete from Employees " +"WHERE ID_Employee=?";
        PreparedStatement pstmt =con.prepareStatement(queryStr);
        pstmt.setInt(1, ID_Employee);
        pstmt.execute();
        if(queryStr!=null)
            return true;
        else
            return false;
    }
    public StringBuilder readEmployee(int ID_Employee)
    {
        Connection con = c.getConnection();  
        StringBuilder builder = new StringBuilder();
        String query="Select * from Employees";
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
                   return builder;
                }
            }
        }catch(SQLException e)
        {
             System.err.println("Caught IOException: " + e.getMessage());
        }
        return null;
    }
    public StringBuilder readEmployee(String userName)
    {
        Connection con = c.getConnection();  
        StringBuilder builder = new StringBuilder();
        String query="Select * from Employees";
        try{
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery(query);
        int columnCount = rs.getMetaData().getColumnCount();
            while ( rs.next() ) {
                if(rs.getString("UserNume").equals(userName)){
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
    public ArrayList<StringBuilder> readEmployees()
    {
        ArrayList<StringBuilder> employees=new ArrayList<StringBuilder>();
        StringBuilder builder = new StringBuilder();
        Connection con = c.getConnection();  
        String query="Select * from Employees";
        try{
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery(query);
        int columnCount = rs.getMetaData().getColumnCount();
            while ( rs.next() ) {
                for (int i = 0; i < columnCount;) {
                    builder.append(rs.getString(i + 1));
                        if (++i < columnCount) builder.append(",");
                }
                employees.add(builder);
            }
        }catch(SQLException e)
        {
             System.err.println("Caught IOException: " + e.getMessage());
        }
        return employees;
    }
     public ArrayList<StringBuilder> printActions(int ID_Employee,String dinData,String panadata) throws SQLException, ParseException
    {
        Connection con = c.getConnection();  
        String queryStr = "Select * from EmpClient";
        ArrayList<StringBuilder> actions=new ArrayList<StringBuilder>();
        StringBuilder builder = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date parsed = null;
        java.util.Date parsed1 = null;
        try {
        parsed = sdf.parse(dinData);
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
        rs = stmt.executeQuery(queryStr);
        int columnCount = rs.getMetaData().getColumnCount();
            while ( rs.next() ) {
                 java.sql.Date data2= rs.getDate("DataOp");
                if(rs.getInt("ID_Employee")==ID_Employee && rs.getDate("DataOp").after(data) && rs.getDate("DataOp").before(data1)){
                    for (int i = 0; i < columnCount;) {
                    builder.append(rs.getString(i + 1));
                        if (++i < columnCount) builder.append(",");
                }
                actions.add(builder);
                builder=new StringBuilder();
                }
            }
        }catch(SQLException e)
        {
             System.err.println("Caught IOException: " + e.getMessage());
        }
        return actions;
        
    }
}
