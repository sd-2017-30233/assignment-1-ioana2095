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
public class ClientManagerTest {
    
    public ClientManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addClient method, of class ClientManager.
     */
    @Test
    public void testAddClient() {
        System.out.println("addClient");
        String nume = "ana";
        int idCard = 65274;
        String cnp = "2930126122923";
        String adress = "str luncii";
        int ID_Employee = 35;
        ClientManager instance = new ClientManager();
        boolean expResult = true;
        boolean result = instance.addClient(nume, idCard, cnp, adress, ID_Employee);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateClient method, of class ClientManager.
     */
    @Test
    public void testUpdateClient() {
        System.out.println("updateClient");
        String nume = "maria";
        int idCard = 63478;
        String cnp = "2930126122923";
        String adress = "str luncii";
        int ID_Employee = 35;
        ClientManager instance = new ClientManager();
        boolean expResult = true;
        boolean result = instance.updateClient(nume, idCard, cnp, adress, ID_Employee);
        assertEquals(expResult, result);
    }

    /**
     * Test of printClient method, of class ClientManager.
     */
    @Test
    public void testPrintClient() {
        System.out.println("printClient");
        String cnp = "2930126122923";
        int ID_Employee = 0;
        ClientManager instance = new ClientManager();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.printClient(cnp, ID_Employee);
        assertNotEquals(expResult, result);

    }

    /**
     * Test of printClients method, of class ClientManager.
     */
    @Test
    public void testPrintClients() {
        System.out.println("printClients");
        ClientManager instance = new ClientManager();
        ArrayList<ArrayList<String>> expResult = null;
        ArrayList<ArrayList<String>> result = instance.printClients();
        assertNotEquals(expResult, result);
    }
    
}
