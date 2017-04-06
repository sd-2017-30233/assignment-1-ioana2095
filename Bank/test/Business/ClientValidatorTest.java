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
public class ClientValidatorTest {
    
    public ClientValidatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of validateCnp method, of class ClientValidator.
     */
    @Test
    public void testValidateCnp() {
        System.out.println("validateCnp");
        String cnp = "2930126122923";
        ClientValidator instance = new ClientValidator();
        boolean expResult = false;
        boolean result = instance.validateCnp(cnp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
