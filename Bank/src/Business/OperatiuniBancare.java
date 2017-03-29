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
    ProcessData pd=new ProcessData();
    EmployeeData ed=new EmployeeData();
    public ArrayList<ProcessOp> readOperatiuni(int ID_Employee,String dindata,String panadata) throws SQLException, ParseException
    {
        ArrayList<StringBuilder> r1=new ArrayList<StringBuilder>();
        ArrayList<StringBuilder> r2=new ArrayList<StringBuilder>();
        ArrayList<ProcessOp> rez=new ArrayList<ProcessOp>();
        ProcessOp po=new ProcessOp();
        r1=pd.readProcess(ID_Employee, dindata, panadata);
        r2=ed.printActions(ID_Employee, dindata, panadata);
        StringBuilder bulider1=new StringBuilder();
        String[] str=null;
        for(StringBuilder s : r1){
            str=r1.toString().split(",");
            po.setIdEmployee(Integer.parseInt(str[0]));
            po.setAmmountOfMoney(0.0f);
            po.setDataOperation(str[3]);
            po.setIdNumberAcc(null);
            po.setOp(str[4]);
            rez.add(po);
        }
        for(StringBuilder s : r2){
            str=r2.toString().split(",");
            po.setIdEmployee(Integer.parseInt(str[3]));
            po.setAmmountOfMoney(0.0f);
            po.setDataOperation(str[2]);
            po.setIdNumberAcc(null);
            po.setOp(str[1]);
            rez.add(po);
        }
        return rez;
    }
}
