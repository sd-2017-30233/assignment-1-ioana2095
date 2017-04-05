/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperation;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ioana
 */
public class EmployeeMapper extends AbstractMapper<String> {
    Conexiune c=new Conexiune();  
    public boolean Update(Employees employee) throws SQLException
    {
        Connection con = c.getConnection();  
        String queryStr = "UPDATE Employees SET UserNume=?,ID_Employees=?,Password=?,UserType=? WHERE UserNume=?";
        PreparedStatement pstmt =con.prepareStatement(queryStr);
        pstmt.setString(1, employee.getUsername());
        pstmt.setInt(2, employee.getIdEmployee());
        pstmt.setString(3, employee.getPassword());
        pstmt.setString(4, employee.getUserType());
        pstmt.setString(5, employee.getUsername());
        pstmt.execute();
        if(queryStr!=null)
            return true;
        else
            return false;
    }
    public boolean Delete(int ID_Employee) throws SQLException
    {
        Connection con = c.getConnection();  
        String queryStr = "delete from Employees " +"WHERE ID_Employees=?";
        PreparedStatement pstmt =con.prepareStatement(queryStr);
        pstmt.setInt(1, ID_Employee);
        pstmt.execute();
        if(queryStr!=null)
            return true;
        else
            return false;
    }
    public Employees readEmployee(String username)
    {
        return (Employees) abstractFind(username);
    }
    public List<Employees> readEmployees()
    {
        return findMany(new EmployeeMapper.ReadAll());
    }
     public ArrayList<StringBuilder> printActions(int ID_Employee,String dinData,String panadata) throws SQLException
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
                if(rs.getInt("ID_Employees")==ID_Employee && rs.getDate("DataOp").after(data) && rs.getDate("DataOp").before(data1)){
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

    @Override
    protected String findStatement() {
        return "Select * from Employees where UserNume=?";
     }

    @Override
    protected DomainObject doLoad(String id, ResultSet rs) throws SQLException {
        int idE=rs.getInt(2);
        String pass=rs.getString(3);
        String user=rs.getString(4);
        return new Employees(idE,id,pass,user);
    }

    @Override
    protected String insertStatement() {
        return "Insert into Employees (UserNume,ID_Employees,Password,UserType) values (?,?,?,?)";
    }

    @Override
    protected void doInsert(DomainObject subject, PreparedStatement insertStatement) throws SQLException {
        Employees employee=(Employees) subject;
        insertStatement.setInt(2, employee.getIdEmployee());
        insertStatement.setString(3, employee.getPassword());
        insertStatement.setString(4, employee.getUserType());
        
    }
public class ReadAll implements StatementSource {
    public ReadAll() {
    }
    @Override
    public String sql() {
        return "Select * from Employees";
    }

    @Override
    public DomainObject[] parameters() {
        DomainObject[] result = {null};
        return result;
    }
    
}

    
}
