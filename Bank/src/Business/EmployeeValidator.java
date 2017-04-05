/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Ioana
 */
public class EmployeeValidator {
    public boolean validare(String username,String password)
    {
        if(username!=null && password!=null)
        {
            return true;
        }
        return false;
    }
     public boolean validare(String username,String password,String userType)
    {
        if(username!=null && password!=null)
        {
            if(userType.equals("admin") || userType.equals("employee"))
            return true;
        }
        return false;
    }
}
