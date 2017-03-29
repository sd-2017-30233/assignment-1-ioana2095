/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataOperation.EmployeeData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ioana
 */
public class EmployeesInfo {
    private boolean verifyEmployee(int idEmployee)
    {
        Employees e=new Employees();
        EmployeeData emp=new EmployeeData();
        StringBuilder s=emp.readEmployee(idEmployee);
        if(s!=null)
            return true;
        return false;
    }
    public boolean insertEmployee(Employees e)
    {
        EmployeeData emp=new EmployeeData();
        if(verifyEmployee(e.getIdEmployee())==false)
        {
            try {
                emp.Insert(e.getIdEmployee(),e.getUsername(),e.getPassword(),e.getUserType());
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(Logare.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    public boolean updateEmployee(Employees employee)
    {
        EmployeeData emp=new EmployeeData();
        if(verifyEmployee(employee.getIdEmployee())==false)
        {
            try {
                emp.Update(employee.getIdEmployee(),employee.getUsername(),employee.getPassword(),employee.getUserType());
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(Logare.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    public boolean deleteEmployee(int idEmployee)
    {
        EmployeeData emp=new EmployeeData();
        if(verifyEmployee(idEmployee)==false)
        {
            try {
                emp.Delete(idEmployee);
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(Logare.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
}
