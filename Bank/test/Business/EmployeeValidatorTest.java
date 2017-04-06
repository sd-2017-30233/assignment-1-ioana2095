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
public class EmployeeValidatorTest {
    
    public EmployeeValidatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of validare method, of class EmployeeValidator.
     */
    @Test
    public void testValidare_String_String() {
        System.out.println("validare");
        String username = "maria23";
        String password = "123456";
        EmployeeValidator instance = new EmployeeValidator();
        boolean expResult = true;
        boolean result = instance.validare(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of validare method, of class EmployeeValidator.
     */
    @Test
    public void testValidare_3args() {
        System.out.println("validare");
        String username = "maria23";
        String password = "123456";
        String userType = "employee";
        EmployeeValidator instance = new EmployeeValidator();
        boolean expResult = true;
        boolean result = instance.validare(username, password, userType);
        assertEquals(expResult, result);
    }
    
}
