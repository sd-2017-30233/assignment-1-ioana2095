/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ioana
 */
public class ClientInfoTest {
    
    public ClientInfoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addClient method, of class ClientInfo.
     */
    @Test
    public void testAddClient() {
        System.out.println("addClient");
        Client client = null;
        int ID_Employee = 0;
        ClientInfo instance = new ClientInfo();
        boolean expResult = false;
        boolean result = instance.addClient(client, ID_Employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateClient method, of class ClientInfo.
     */
    @Test
    public void testUpdateClient() {
        System.out.println("updateClient");
        Client client = null;
        int ID_Employee = 0;
        ClientInfo instance = new ClientInfo();
        boolean expResult = false;
        boolean result = instance.updateClient(client, ID_Employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printClient method, of class ClientInfo.
     */
    @Test
    public void testPrintClient() {
        System.out.println("printClient");
        String cnp = "";
        int ID_Employee = 0;
        ClientInfo instance = new ClientInfo();
        Client expResult = null;
        Client result = instance.printClient(cnp, ID_Employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printClients method, of class ClientInfo.
     */
    @Test
    public void testPrintClients() {
        System.out.println("printClients");
        ClientInfo instance = new ClientInfo();
        ArrayList<Client> expResult = null;
        ArrayList<Client> result = instance.printClients();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
