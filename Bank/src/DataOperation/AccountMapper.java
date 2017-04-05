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
import java.util.List;

/**
 *
 * @author Ioana
 */
public class AccountMapper extends AbstractMapper<String> {
    Conexiune c=new Conexiune(); 
      public  boolean Update(Account ac,String IdNumberAcc) throws SQLException
    {
        Connection con=c.getConnection();
        if(readAccount(ac.getIdNrAccount())!=null){
        String queryStr = "Update Account Set IdNumberAcc=?,AmmountOfMoney=?,DataCreation=?,CNP=?,IdType=? where IdNumberAcc=?";
        PreparedStatement pstmt =con.prepareStatement(queryStr);
        pstmt.setString(1, ac.getIdNrAccount());
        pstmt.setFloat(2, ac.getAmmountOfMoney());
        pstmt.setString(3, ac.getDataCreation());
        pstmt.setString(4, ac.getCnp());
        pstmt.setInt(5, ac.getIdType());
        pstmt.setString(6, IdNumberAcc);
        pstmt.execute();
        
        if(queryStr!=null)
            return true;
        else
            return false;
        }
        return false;
    }
  public  boolean Delete(String IdNumberAcc) throws SQLException
    {
        Connection con=c.getConnection();
        String queryStr = "delete from Account " +"WHERE IdNumberAcc=?";
        PreparedStatement pstmt =con.prepareStatement(queryStr);
        pstmt.setString(1, IdNumberAcc);
        pstmt.execute();
        if(queryStr!=null)
            return true;
        else
            return false;
    }
  public  Account readAccount(String idAccount)
  {
      return (Account) abstractFind(idAccount);
  }
   public  List<Account> readAccounts(String CNP)
  {
      return findMany(new AccountMapper.ReadAll(CNP));
  }      

    @Override
    protected String findStatement() {
       return "Select * from Account where IdNumberAcc=?" ;
    }

    @Override
    protected DomainObject doLoad(String id, ResultSet rs) throws SQLException {
        float AmmountOfMoney = rs.getFloat(2);
        String DataCreation = rs.getString(3);
        String CNP = rs.getString(4);
        int IdType = rs.getInt(5);
        return new Account(id, AmmountOfMoney, DataCreation, CNP,IdType);
    }

    @Override
    protected String insertStatement() {
        return "Insert into Account (IdNumberAcc,AmmountOfMoney,DataCreation,CNP,IdType) values (?,?,?,?,?)";
    }

    @Override
    protected void doInsert(DomainObject subject, PreparedStatement insertStatement) throws SQLException {
        Account account =(Account) subject;
        insertStatement.setFloat(2, account.getAmmountOfMoney());
        insertStatement.setString(3, account.getDataCreation());
        insertStatement.setString(4, account.getCnp());
        insertStatement.setInt(5, account.getIdType());
    }

    public class ReadAll implements StatementSource {
    private String CNP;
    public ReadAll(String CNP) {
        this.CNP = CNP;
}
    @Override
    public String sql() {
        return "Select * from Account where CNP=?";
    }

    @Override
    public Object[] parameters() {
        Object[] result = {CNP};
        return result;
    }
}

    

    
    
}
