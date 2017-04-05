/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperation;

import java.sql.*;
import java.util.*;
import org.omg.CORBA.portable.ApplicationException;

/**
 *
 * @author Ioana
 */
public abstract class AbstractMapper<T> {
    private Conexiune c=new Conexiune();  
    Connection con=c.getConnection();
    protected Map loadedMap = new HashMap();
    abstract protected String findStatement();
    protected DomainObject abstractFind(String id) {
        DomainObject result = (DomainObject) loadedMap.get(id);
        if (result != null) return result;
        PreparedStatement findStatement = null;
        try {
        findStatement =con.prepareStatement(findStatement());
        findStatement.setString(1, id);
        ResultSet rs = findStatement.executeQuery();
        rs.next();
        result = load(rs);
        return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return null;
    }
    protected DomainObject load(ResultSet rs) throws SQLException {
    if (loadedMap.containsKey(rs.getString(1))) return (DomainObject) loadedMap.get(rs.getString(1));
            DomainObject result = doLoad((T) rs.getString(1), rs);
            loadedMap.put(rs.getString(1), result);
    return result;
    }
    abstract protected DomainObject doLoad(T id, ResultSet rs) throws SQLException;
    protected List loadAll(ResultSet rs) throws SQLException {
    List result = new ArrayList();
    while (rs.next())
    result.add(load(rs));
    return result;
    }
    public List findMany(StatementSource source) {
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
    stmt = con.prepareStatement(source.sql());
    if(source.parameters().length!=0){
    for (int i = 0; i < source.parameters().length; i++)
    stmt.setObject(i+1, source.parameters()[i]);
    }
    rs = stmt.executeQuery();
    return loadAll(rs);
    } catch (SQLException e) {
    System.out.println(e.getMessage());
    }
    return null;
    }
    public T insert(DomainObject subject,String id) 
    {
        PreparedStatement insertStatement = null;
        try {
        insertStatement = con.prepareStatement(insertStatement());
        subject.setId(id);
        insertStatement.setObject(1, subject.getId());
        doInsert(subject, insertStatement);
        insertStatement.execute();
        loadedMap.put(subject.getId(), subject);
        return (T) subject.getId();
        } catch (SQLException e) {
         System.out.println(e.getMessage());
        }
        return null;
    }
        abstract protected String insertStatement();
        abstract protected void doInsert(DomainObject subject, PreparedStatement insertStatement)throws SQLException;
    }
