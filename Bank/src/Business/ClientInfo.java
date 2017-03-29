/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import DataOperation.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ioana
 */
public class ClientInfo {
    ClientData c=new ClientData();
    EmpClientData ec=new EmpClientData();
    private boolean VerifyClientExistence(String cnp)
    {
        if(c.readClient(cnp)!=null)
            return true;
        return false;
    }
    public boolean addClient(Client client,int ID_Employee)
    {
        if(VerifyClientExistence(client.getCnp())==false)
        {
            try {
                c.Insert(client.getNume(),client.getIdCard(),client.getCnp(),client.getAdress());
                ec.Insert(client.getCnp(), ID_Employee, "AddClient");
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ClientInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    public boolean updateClient(Client client,int ID_Employee)
    {
        if(VerifyClientExistence(client.getCnp())!=false)
        {
            try {
              c.Update(client.getNume(),client.getIdCard(),client.getCnp(),client.getAdress());
              ec.Insert(client.getCnp(), ID_Employee, "UpdateClient");
              return true;
            } catch (SQLException ex) {
                Logger.getLogger(ClientInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    public Client printClient(String cnp,int ID_Employee) 
    {
        Client client=new Client();
        if(VerifyClientExistence(cnp)!=false)
        {
            return c.readClient(cnp);
        }
        else
        {
            return null;
        }
        
    }
    public ArrayList<Client> printClients() 
    {
        ArrayList<Client> rs=c.readClients();
        return rs;  
    }
}
