/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOperation;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ioana
 */
public interface DataMapper<T> {
    public T map(ResultSet resultSet) throws SQLException;
    
}
