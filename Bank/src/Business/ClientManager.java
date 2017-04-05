/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import DataOperation.Client;
import DataOperation.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ioana
 */
public class ClientManager {
    ClientValidator cv=new ClientValidator();
    ClientMapper cm=new ClientMapper ();
    EmpClientModule ecm=new EmpClientModule();
    public boolean addClient(String nume,int idCard,String cnp,String adress,int ID_Employee)
    {
        if(cv.validateCnp(cnp))
        {
                Client client=new Client(nume,idCard,adress);
                cm.insert(client, cnp);
                ecm.Insert(cnp,ID_Employee, "AddClient");
                return true;
        }
        return false;
    }
    public boolean updateClient(String nume,int idCard,String cnp,String adress,int ID_Employee)
    {
        if(cv.validateCnp(cnp)!=false)
        {
            try {
               Client client=new Client(nume,idCard,adress);
              cm.Update(client,cnp);
              ecm.Insert(cnp,ID_Employee, "UpdateClient");
              return true;
            } catch (SQLException ex) {
                System.out.print(ex.getMessage());
            }
        }
        return false;
    }
    public ArrayList<String> printClient(String cnp,int ID_Employee) 
    {
        Client client=new Client();
        ArrayList<String> str=new ArrayList<String>();
        if(cv.validateCnp(cnp)!=false)
        {
            client=cm.readClient(cnp);
            str.add(client.getNume());
            str.add(String.valueOf(client.getIdCard()));
            str.add(client.getAdress());
            return  str;
        }
        else
        {
            return null;
        }
        
    }
    public ArrayList<ArrayList<String>> printClients() 
    {
        List<Client> c=cm.readClients(); 
        ArrayList<String> str=new ArrayList<String>();
        ArrayList<ArrayList<String>> s=new ArrayList<ArrayList<String>>();
        for(Client client:c)
        {
            str.add(client.getNume());
            str.add(String.valueOf(client.getIdCard()));
            str.add(client.getAdress());
            s.add(str);
        }
        return s; 
    }
}
