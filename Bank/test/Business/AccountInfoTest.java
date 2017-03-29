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
public class AccountInfoTest {
    
    public AccountInfoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addAccount method, of class AccountInfo.
     */
    @Test
    public void testAddAccount() {
        System.out.println("addAccount");
        Account a1 = new Account("RO3549226364414584BT", (float)978.49, "6/5/2016", "2770409113686", 1);
        int ID_Employee = 1;
        AccountInfo instance = new AccountInfo();
        boolean expResult = false;
        boolean result = instance.addAccount(a1, ID_Employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAccount method, of class AccountInfo.
     */
    @Test
    public void testUpdateAccount() {
        System.out.println("updateAccount");
        String idNrAccount = "RO3549226364484584BT";
        float ammountOfMoney = 268.90F;
        int ID_Employee = 1;
        AccountInfo instance = new AccountInfo();
        boolean expResult = false;
        boolean result = instance.updateAccount(idNrAccount, ammountOfMoney, ID_Employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAccount method, of class AccountInfo.
     */
    @Test
    public void testDeleteAccount() {
        System.out.println("deleteAccount");
        String idNrAccount = "RO3549226364414584BT";
        String CNP = "2770409113686";
        AccountInfo instance = new AccountInfo();
        boolean expResult = false;
        boolean result = instance.deleteAccount(idNrAccount, CNP);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tranzactie method, of class AccountInfo.
     */
    @Test
    public void testTranzactie() {
        System.out.println("tranzactie");
        String nrAccount1 = "RO4026548120825377BT";
        String nrAccount2 = "RO377219802976861BT";
        float suma = 500.0F;
        int ID_Employee = 2;
        AccountInfo instance = new AccountInfo();
        boolean expResult = false;
        boolean result = instance.tranzactie(nrAccount1, nrAccount2, suma, ID_Employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of payUtilities method, of class AccountInfo.
     */
    @Test
    public void testPayUtilities() {
        System.out.println("payUtilities");
        String nrAccount = "RO377219802976861BT";
        float suma = 256.0F;
        String utility = "Gaz";
        int ID_Employee = 3;
        AccountInfo instance = new AccountInfo();
        boolean expResult = false;
        boolean result = instance.payUtilities(nrAccount, suma, utility, ID_Employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printAccount method, of class AccountInfo.
     */
    @Test
    public void testPrintAccount() {
        System.out.println("printAccount");
        String CNP = "";
        AccountInfo instance = new AccountInfo();
        ArrayList<Account> expResult = null;
        ArrayList<Account> result = instance.printAccount(CNP);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
