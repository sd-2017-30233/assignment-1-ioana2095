/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataOperation.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Ioana
 */
public class OperatiuniBancare {
    EmployeeMapper ed=new EmployeeMapper();
    ProcessModule pm=new ProcessModule();
    public ArrayList<ArrayList<String>> readOperatiuni(int ID_Employee,String dindata,String panadata) throws SQLException, ParseException
    {
        ArrayList<StringBuilder> r1=new ArrayList<StringBuilder>();
        ArrayList<StringBuilder> r2=new ArrayList<StringBuilder>();
        ArrayList<ArrayList<String>> rez=new ArrayList<ArrayList<String>>();
        ArrayList<String> po=new ArrayList<String>();
        r1=pm.readProcess(ID_Employee, dindata, panadata);
        r2=ed.printActions(ID_Employee, dindata, panadata);
        StringBuilder bulider1=new StringBuilder();
        String[] str=null;
        for(StringBuilder s : r1){
            str=r1.toString().split(",");
            po.add(str[0]);
            po.add(str[1]);
            po.add(str[2]);
            po.add(str[3]);
            po.add(str[4]);
            rez.add(po);
        }
        for(StringBuilder s : r2){
            str=r2.toString().split(",");
            po.add(str[0]);
            po.add(str[1]);
            po.add(str[2]);
            po.add(str[3]);
            po.add(str[4]);
            rez.add(po);
        }
        return rez;
    }
}
