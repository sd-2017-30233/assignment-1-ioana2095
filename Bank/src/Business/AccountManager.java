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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ioana
 */
public class AccountManager {
    AccountValidator av=new AccountValidator();
    AccountMapper am=new AccountMapper ();
    EmpClientModule ecm=new EmpClientModule();
    public boolean addAccount(float ammountOfMoney,String dataCreation,String cnp,int idType,int ID_Employee)
    {
        String IdNumberAcc="RO"+(1 + (int)(Math.random() * 1000000000))+"BT";
        if(av.validare(IdNumberAcc, ammountOfMoney, dataCreation, cnp))
        {
                Account a=new Account(IdNumberAcc,ammountOfMoney,dataCreation,cnp,idType);
                am.insert(a,IdNumberAcc);
                ecm.Insert(cnp,ID_Employee,"insert");
                return true;
        }
        return false;
    }
    public boolean updateAccount(String vechiIdNrAccount,String idNrAccount,float ammountOfMoney,String dataCreation,String cnp,int idType,int ID_Employee) 
    {
        
        if(av.validare(idNrAccount))
        {
            try {
                Account a=new Account(idNrAccount,ammountOfMoney,dataCreation,cnp,idType);
                am.Update(a,vechiIdNrAccount);
                ecm.Insert(cnp,ID_Employee,"update");
                 return true;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }
        public boolean deleteAccount(String idNrAccount)
    {
        Account a=new Account();
        if(av.validare(idNrAccount))
        {
            try {
                
                am.Delete(idNrAccount); 
                return true;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }
        public boolean tranzactie(String nrAccount1,String nrAccount2,float suma,int ID_Employee)
        {
            if(av.validare(nrAccount1) && av.validare(nrAccount2) )
        {
            Account rs1=am.readAccount(nrAccount1);
            Account rs2=am.readAccount(nrAccount2);
            Account a1=new Account(nrAccount1,rs1.getAmmountOfMoney(),rs1.getDataCreation(),rs1.getCnp(),rs1.getIdType());
            Account a2=new Account(nrAccount2,rs2.getAmmountOfMoney(),rs2.getDataCreation(),rs2.getCnp(),rs2.getIdType());
            
            a1.setAmmountOfMoney(a1.getAmmountOfMoney()-suma);
            a2.setAmmountOfMoney(a2.getAmmountOfMoney()+suma);
            try{
            am.Update(a1,nrAccount1);
            am.Update(a2,nrAccount2);
            } 
            catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date today = Calendar.getInstance().getTime();        
            String reportDate = df.format(today);
            
            ProcessModule p=new ProcessModule();
        try {
            p.Insert(ID_Employee,nrAccount1,suma,reportDate,"Tranzactie");
            p.Insert(ID_Employee,nrAccount2,suma,reportDate,"Tranzactie");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
          return false; 
            
        }
        public boolean payUtilities(String nrAccount,float suma,String utility,int ID_Employee,int type,String cnp) throws SQLException
        {
             if(av.validare(nrAccount) )
             {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date today = Calendar.getInstance().getTime();        
            String reportDate = df.format(today);
            Account rs1=am.readAccount(nrAccount);
            Account a1=new Account(nrAccount,rs1.getAmmountOfMoney(),rs1.getDataCreation(),rs1.getCnp(),rs1.getIdType());
            ProcessModule p=new ProcessModule();
            if(a1.getAmmountOfMoney()-suma>10){
                a1.setAmmountOfMoney(a1.getAmmountOfMoney()-suma);
            try{
            am.Update(a1,nrAccount);
            } 
            catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            if(utility.equals("Apa")){
            p.Insert(ID_Employee,nrAccount,suma,reportDate,"Apa");
            return true;
            }
            if(utility.equals("Gaz")){
            p.Insert(ID_Employee,nrAccount,suma,reportDate,"Gaz");
            return true;
            }
            if(utility.equals("Electricitate")){
            p.Insert(ID_Employee,nrAccount,suma,reportDate,"Electricitate");
            return true;
            }
            }
        }
        return false;
            
            
        }
        public ArrayList<ArrayList<String>> printAccount(String CNP)
        {
        List<Account> c=am.readAccounts(CNP); 
        ArrayList<String> str=new ArrayList<String>();
        ArrayList<ArrayList<String>> s=new ArrayList<ArrayList<String>>();
        for(Account account:c)
        {
            str.add(String.valueOf(account.getAmmountOfMoney()));
            str.add(account.getDataCreation());
            str.add(account.getCnp());
            str.add(String.valueOf(account.getIdType()));
            s.add(str);
        }
            return s;
        }
}
