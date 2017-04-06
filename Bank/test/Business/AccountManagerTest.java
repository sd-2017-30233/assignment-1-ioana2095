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
public class AccountManagerTest {
    
    public AccountManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addAccount method, of class AccountManager.
     */
    @Test
    public void testAddAccount() {
        System.out.println("addAccount");
        float ammountOfMoney = 5098.0F;
        String dataCreation = "06/04/2017";
        String cnp = "2930126122923";
        int idType = 1;
        int ID_Employee = 35;
        AccountManager instance = new AccountManager();
        boolean expResult = true;
        boolean result = instance.addAccount(ammountOfMoney, dataCreation, cnp, idType, ID_Employee);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateAccount method, of class AccountManager.
     */
    @Test
    public void testUpdateAccount() {
        System.out.println("updateAccount");
        String vechiIdNrAccount = "RO3550432360829223BT";
        String idNrAccount = "RO3550432360829223BT";
        float ammountOfMoney = 6754.0F;
        String dataCreation = "06/04/2017";
        String cnp = "2831129332306";
        int idType = 1;
        int ID_Employee = 35;
        AccountManager instance = new AccountManager();
        boolean expResult = true;
        boolean result = instance.updateAccount(vechiIdNrAccount, idNrAccount, ammountOfMoney, dataCreation, cnp, idType, ID_Employee);
        assertEquals(expResult, result);

    }

    /**
     * Test of deleteAccount method, of class AccountManager.
     */
    @Test
    public void testDeleteAccount() {
        System.out.println("deleteAccount");
        String idNrAccount = "RO3550432360829223BT";
        AccountManager instance = new AccountManager();
        boolean expResult = true;
        boolean result = instance.deleteAccount(idNrAccount);
        assertEquals(expResult, result);
    }

    /**
     * Test of tranzactie method, of class AccountManager.
     */
    @Test
    public void testTranzactie() {
        System.out.println("tranzactie");
        String nrAccount1 = "RO377219802976861BT";
        String nrAccount2 = "RO201405344303282BT";
        float suma = 257.0F;
        int ID_Employee = 35;
        AccountManager instance = new AccountManager();
        boolean expResult = true;
        boolean result = instance.tranzactie(nrAccount1, nrAccount2, suma, ID_Employee);
        assertEquals(expResult, result);
    }

    /**
     * Test of payUtilities method, of class AccountManager.
     */
    @Test
    public void testPayUtilities() throws Exception {
        System.out.println("payUtilities");
        String nrAccount = "RO377219802976861BT";
        float suma = 214.0F;
        String utility = "Gaz";
        int ID_Employee = 35;
        int type = 3;
        String cnp = "1980817097170";
        AccountManager instance = new AccountManager();
        boolean expResult = true;
        boolean result = instance.payUtilities(nrAccount, suma, utility, ID_Employee, type, cnp);
        assertEquals(expResult, result);
    }

    /**
     * Test of printAccount method, of class AccountManager.
     */
    @Test
    public void testPrintAccount() {
        System.out.println("printAccount");
        String CNP = "2920828524661";
        AccountManager instance = new AccountManager();
        ArrayList<ArrayList<String>> expResult = null;
        ArrayList<ArrayList<String>> result = instance.printAccount(CNP);
        assertNotEquals(expResult, result);
    }
    
}
