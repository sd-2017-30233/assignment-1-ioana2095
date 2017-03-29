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
public class Employees {
    private int idEmployee;
    private String username;
    private String password;
    private String userType;
    public Employees(int idEmployee,String username,String password,String userType)
    {
        this.idEmployee=idEmployee;
        this.username=username;
        this.password=password;
        this.userType=userType;
    }
    public Employees(String username,String password)
    {
        this.idEmployee=idEmployee;
        this.username=username;
        this.password=password;
        this.userType=userType;
    }

    public Employees() {}

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
   
}
