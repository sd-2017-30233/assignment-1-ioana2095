/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperation;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ioana
 */
public class ClientMapper extends AbstractMapper<String>{
    Conexiune c=new Conexiune();  
    public boolean Update(Client client,String cnp) throws SQLException
    {
        Connection con = c.getConnection();  
        String queryStr = "UPDATE Client SET CNP=?,Nume=?,IDCardNumber=?,Adress=? WHERE CNP=?";
        PreparedStatement pstmt =con.prepareStatement(queryStr);
        pstmt.setString(1, cnp);
        pstmt.setString(2, client.getNume());
        pstmt.setInt(3, client.getIdCard());
        pstmt.setString(4, client.getAdress());
        pstmt.setString(5, cnp);
        pstmt.execute();
        if(queryStr!=null)
            return true;
        else
            return false;
    }
    public Client readClient(String cnp)
    {
        return (Client) abstractFind(cnp);
    }
    public List<Client> readClients()
    {
        return findMany(new ClientMapper.ReadAll());
    }
    @Override
    protected String findStatement() {
       return "Select * from Client where CNP=?"; 
    }

    @Override
    protected DomainObject doLoad(String id, ResultSet rs) throws SQLException {
        String nume=rs.getString(2);
        int idCard=rs.getInt(3);
        String adr=rs.getString(4);
        return new Client(nume,idCard,id,adr);
    }

    @Override
    protected String insertStatement() {
        return "Insert into Client (CNP,Nume,IDCardNumber,Adress) values (?,?,?,?)";
    }
    @Override
    protected void doInsert(DomainObject subject, PreparedStatement insertStatement) throws SQLException {
        Client client = (Client) subject;
        insertStatement.setString(2, client.getNume());
        insertStatement.setInt(3, client.getIdCard());
        insertStatement.setString(4, client.getAdress());
    }

    
   public class ReadAll implements StatementSource {
    public ReadAll() {
    }
    @Override
    public String sql() {
        return "Select * from Client";
    }

    @Override
    public DomainObject[] parameters() {
        DomainObject[] result = {};
        return result;
    }
    
}
}
