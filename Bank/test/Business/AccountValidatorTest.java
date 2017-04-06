/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ioana
 */
public class AccountValidatorTest {
    
    public AccountValidatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of validare method, of class AccountValidator.
     */
    @Test
    public void testValidare_4args() {
        System.out.println("validare");
        String idNrAccount = "RO3574716286738894BT";
        float ammountOfMoney = 3789.0F;
        String dataCreation = "22/03/2017";
        String cnp = "2920828524661";
        AccountValidator instance = new AccountValidator();
        boolean expResult = true;
        boolean result = instance.validare(idNrAccount, ammountOfMoney, dataCreation, cnp);
        assertEquals(expResult, result);
    }

    /**
     * Test of validare method, of class AccountValidator.
     */
    @Test
    public void testValidare_String() {
        System.out.println("validare");
        String idNrAccount = "RO3574716286738894BT";
        AccountValidator instance = new AccountValidator();
        boolean expResult = true;
        boolean result = instance.validare(idNrAccount);
        assertEquals(expResult, result);
    }

    /**
     * Test of isDateValid method, of class AccountValidator.
     */
    @Test
    public void testIsDateValid() {
        System.out.println("isDateValid");
        String date = "22/03/2017";
        boolean expResult = true;
        boolean result = AccountValidator.isDateValid(date);
        assertEquals(expResult, result);
    }
    
}
