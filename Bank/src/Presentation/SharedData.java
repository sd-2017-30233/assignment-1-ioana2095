/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

/**
 *
 * @author Ioana
 */
public class SharedData {

    public static  String type;
    public static  int Id_Employee;
    public static int response;

    public SharedData() {
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getId_Employee() {
        return Id_Employee;
    }

    public void setId_Employee(int Id_Employee) {
        this.Id_Employee = Id_Employee;
    }
     public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }
    
    
}