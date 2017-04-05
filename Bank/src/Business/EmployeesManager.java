/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataOperation.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ioana
 */
public class EmployeesManager {
    EmployeeMapper em=new EmployeeMapper();
    EmployeeValidator ev=new EmployeeValidator();
    public boolean insertEmployee(int idEmployee,String username, String password,String userType)
    {
        if(ev.validare(username, password, userType))
        {
            Employees eb=new Employees(idEmployee,username,password,userType);
            em.insert(eb, username);
            return true;
        }
        return false;
    }
    public boolean updateEmployee(int idEmployee,String username, String password,String userType)
    {
        if(ev.validare(username, password, userType))
        {
            try {
                Employees eb=new Employees(idEmployee,username,password,userType);
                em.Update(eb);
                return true;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }
    public boolean deleteEmployee(int idEmployee)
    {
            try {
                em.Delete(idEmployee);
                return true;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return false;
    }
        
}
