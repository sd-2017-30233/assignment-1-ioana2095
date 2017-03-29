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
        EmployeeData emp=new EmployeeData();
        StringBuilder builder = new StringBuilder();
        if(emp.readEmployee(userName)!=null){
            String[] s=emp.readEmployee(userName).toString().split(",");
            if(s[2].equals(parola))
            {
                builder.append(s[0]);
                builder.append(",");
                builder.append(s[3]);
                return builder;
            }
        }
        return null;
    }
    
}
