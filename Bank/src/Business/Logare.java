/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataOperation.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ioana
 */
public class Logare {
    public StringBuilder logareEmployee(String userName,String parola)
    {
        EmployeeMapper emp=new EmployeeMapper();
        EmployeeValidator ev=new EmployeeValidator();
        Employees e=new Employees();
        StringBuilder s=new StringBuilder();
        if(ev.validare(userName, parola)){
            e=emp.readEmployee(userName);
            if(e!=null)
                if(e.getUsername().equals(userName) && e.getPassword().equals(parola)){
                    s.append(e.getIdEmployee());
                    s.append(",");
                    s.append(e.getUserType());
                    return s;
                }
        }
        return null;
    }
    
}
