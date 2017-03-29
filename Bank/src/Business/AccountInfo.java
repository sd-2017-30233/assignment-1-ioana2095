/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DataOperation.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ioana
 */
public class AccountInfo {
    AccountData acc=new AccountData();
    ProcessData pro=new ProcessData();
    EmpClientData ec=new EmpClientData();
    private boolean verifyExistenceAccount(String idAccount)
    {
        if(acc.readAccount(idAccount)!=null)
            return true;
        return false;
    }
    public boolean addAccount(Account a1,int ID_Employee)
    {
       
        if(verifyExistenceAccount(a1.getIdNrAccount())==false)
        {
            try {
                acc.Insert(a1.getIdNrAccount(),a1.getAmmountOfMoney(),a1.getCnp(),a1.getIdType());
                ec.Insert(a1.getCnp(), ID_Employee, "AddAccount");
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    public boolean updateAccount(String idNrAccount,float ammountOfMoney,int ID_Employee) 
    {
        Account ac=new Account();
        AccountData a= new AccountData();
        if(verifyExistenceAccount(idNrAccount)==true)
        {
            try {
                StringBuilder rs1=a.readAccount(idNrAccount);
                String[] str=rs1.toString().split(",");
                ac.setCnp(str[3]);
                ac.setAmmountOfMoney(Float.parseFloat(str[1]));
                ac.setDataCreation(str[2]);
                ac.setIdNrAccount(str[0]);
                ac.setIdType(Integer.parseInt(str[4]));
                acc.Update(ac.getAmmountOfMoney()+ammountOfMoney, idNrAccount);
                 ec.Insert(ac.getCnp(), ID_Employee, "UpdateAccount");
                 return true;
            } catch (SQLException ex) {
                Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
        public boolean deleteAccount(String idNrAccount,String CNP)
    {
        Account a=new Account();
        if(verifyExistenceAccount(idNrAccount)!=false)
        {
            try {
                
                acc.Delete(idNrAccount,CNP); 
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
        public boolean tranzactie(String nrAccount1,String nrAccount2,float suma,int ID_Employee)
        {
            
            ProcessOp p1=new ProcessOp();
            ProcessOp p2=new ProcessOp();
            AccountData a= new AccountData();
            StringBuilder rs1=a.readAccount(nrAccount1);
            StringBuilder rs2=a.readAccount(nrAccount2);
            String[] str1=rs1.toString().split(",");
            String[] str2=rs2.toString().split(",");
            Account a1=new Account();
            Account a2=new Account();
            a1.setCnp(str1[3]);
            a1.setAmmountOfMoney(Float.parseFloat(str1[1]));
            a1.setDataCreation(str1[2]);
            a1.setIdNrAccount(str1[0]);
            a1.setIdType(Integer.parseInt(str1[4]));
            a2.setCnp(str2[3]);
            a2.setAmmountOfMoney(Float.parseFloat(str2[1]));
            a2.setDataCreation(str2[2]);
            a2.setIdNrAccount(str2[0]);
            a2.setIdType(Integer.parseInt(str2[4]));
            
            a1.setAmmountOfMoney(a1.getAmmountOfMoney()-suma);
            a2.setAmmountOfMoney(a2.getAmmountOfMoney()+suma);
            try{
            a.Update(a1.getAmmountOfMoney(), a1.getIdNrAccount());
            a.Update(a2.getAmmountOfMoney(), a2.getIdNrAccount());
            } 
            catch (SQLException ex) {
            Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
            p1.setIdEmployee(ID_Employee);
            p1.setIdNumberAcc(nrAccount1);
            p1.setAmmountOfMoney(suma);     
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date today = Calendar.getInstance().getTime();        
            String reportDate = df.format(today);
            p1.setDataOperation(reportDate);
            p1.setOp("Tranzactie");
            p2.setIdEmployee(ID_Employee);
            p2.setIdNumberAcc(nrAccount2);
            p2.setAmmountOfMoney(suma);     
            p2.setDataOperation(reportDate);
            p2.setOp("Tranzactie");
            
            ProcessData p=new ProcessData();
        try {
            p.Insert(ID_Employee,a2.getIdNrAccount(),p2.getAmmountOfMoney(),p2.getDataOperation(),p2.getOp());
            p.Insert(ID_Employee,a1.getIdNrAccount(),p1.getAmmountOfMoney(),p1.getDataOperation(),p1.getOp());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
          return false; 
            
        }
        public boolean payUtilities(String nrAccount,float suma,String utility,int ID_Employee)
        {
            Account a1=new Account();
            ProcessOp p1=new ProcessOp();
            AccountData a= new AccountData();
            StringBuilder rs1=a.readAccount(nrAccount);
            String[] str=rs1.toString().split(",");
            a1.setCnp(str[3]);
            a1.setAmmountOfMoney(Float.parseFloat(str[1]));
            a1.setDataCreation(str[2]);
            a1.setIdNrAccount(str[0]);
            a1.setIdType(Integer.parseInt(str[4]));
            if(a1.getAmmountOfMoney()-suma>10){
                a1.setAmmountOfMoney(a1.getAmmountOfMoney()-suma);
            try{
            a.Update(a1.getAmmountOfMoney(), a1.getIdNrAccount());
            } 
            catch (SQLException ex) {
            Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(utility.equals("Apa")){
            p1.setIdEmployee(ID_Employee);
            p1.setIdNumberAcc(nrAccount);
            p1.setAmmountOfMoney(suma);     
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date today = Calendar.getInstance().getTime();        
            String reportDate = df.format(today);
            p1.setDataOperation(reportDate);
            p1.setOp("apa");
            }
            if(utility.equals("Gaz")){
            p1.setIdEmployee(ID_Employee);
            p1.setIdNumberAcc(nrAccount);
            p1.setAmmountOfMoney(suma);     
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date today = Calendar.getInstance().getTime();        
            String reportDate = df.format(today);
            p1.setDataOperation(reportDate);
            p1.setOp("gaz");
            }
            if(utility.equals("Electricitate")){
            p1.setIdEmployee(ID_Employee);
            p1.setIdNumberAcc(nrAccount);
            p1.setAmmountOfMoney(suma);     
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date today = Calendar.getInstance().getTime();        
            String reportDate = df.format(today);
            p1.setDataOperation(reportDate);
            p1.setOp("electricitate");
            }
            ProcessData p=new ProcessData();
        try {
            p.Insert(ID_Employee,a1.getIdNrAccount(),p1.getAmmountOfMoney(),p1.getDataOperation(),p1.getOp());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        return false;
            
            
        }
        public ArrayList<Account> printAccount(String CNP)
        {
            ArrayList<StringBuilder> account=acc.readAccounts(CNP);
            ArrayList<Account> ac=new  ArrayList<Account>();
            Account acou=new Account();
            String[] str=null;
            if(account!=null)
            {
            for(StringBuilder s : account){
            str=s.toString().split(",");
            acou.setIdNrAccount(str[0]);
            acou.setAmmountOfMoney(Float.parseFloat(str[1]));
            acou.setDataCreation(str[2]);
            acou.setCnp(str[3]);
            acou.setIdType(Integer.parseInt(str[4]));
            ac.add(acou);
            }
            }
            return ac;
        }
}
