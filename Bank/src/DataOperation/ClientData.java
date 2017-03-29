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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ioana
 */
public class ClientData {
    Conexiune c=new Conexiune();  
    public boolean Insert(String nume,int idCard,String cnp,String adress) throws SQLException
    {
        Connection con = c.getConnection();  
        if(readClient(cnp)==null){
        String queryStr = "Insert into Client (CNP,Nume,IDCardNumber,Adress) values (?,?,?,?)";
        PreparedStatement pstmt =con.prepareStatement(queryStr);
        pstmt.setString(1, cnp);
        pstmt.setString(2, nume);
        pstmt.setInt(3, idCard);
        pstmt.setString(4, adress);
        pstmt.execute();
        if(queryStr!=null)
            return true;
        else
            return false;
        }
        return false;
    }
    public boolean Update(String nume,int idCard,String cnp,String adress) throws SQLException
    {
        Connection con = c.getConnection();  
        String queryStr = "UPDATE Client SET Nume=?,IDCardNumber=?,Adress=? WHERE CNP=?";
        PreparedStatement pstmt =con.prepareStatement(queryStr);
        pstmt.setString(1,nume);
        pstmt.setInt(2, idCard);
        pstmt.setString(3,adress );
        pstmt.setString(4, cnp);
        pstmt.execute();
        if(queryStr!=null)
            return true;
        else
            return false;
    }
    public Client readClient(String cnp)
    {
        Connection con = c.getConnection(); 
        Client client = new Client();
        String query="Select * from Client";
        try{
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery(query);
        int columnCount = rs.getMetaData().getColumnCount();
            while ( rs.next() ) {
                if(rs.getString("CNP").equals(cnp)){
                   client.setCnp(rs.getString("CNP"));
                   client.setIdCard(rs.getInt("IDCardNumber"));
                   client.setNume(rs.getString("Nume"));
                   client.setAdress(rs.getString("Adress"));
                   return client;
                
                }
            }
        }catch(SQLException e)
        {
             System.err.println("Caught IOException: " + e.getMessage());
        }
        return null;
    }
    public ArrayList<Client> readClients()
    {
        ArrayList<Client> clients=new ArrayList<Client>();
        Client client = new Client();
        Connection con = c.getConnection();  
        String query="Select * from Client";
        try{
        Statement stmt = con.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery(query);
        int columnCount = rs.getMetaData().getColumnCount();
            while ( rs.next() ) {
                   client.setCnp(rs.getString("CNP"));
                   client.setIdCard(rs.getInt("IDCardNumber"));
                   client.setNume(rs.getString("Nume"));
                   client.setAdress(rs.getString("Adress"));
                    clients.add(client);
                }
            } catch(SQLException e)
        {
             System.err.println("Caught IOException: " + e.getMessage());
        }
        return clients;
    }
}
