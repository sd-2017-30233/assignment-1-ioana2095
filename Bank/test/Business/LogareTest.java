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
public class LogareTest {
    
    public LogareTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of logareEmployee method, of class Logare.
     */
    @Test
    public void testLogareEmployee() {
        System.out.println("logareEmployee");
        String userName = "maria23";
        String parola = "123456";
        Logare instance = new Logare();
        StringBuilder expResult = null;
        StringBuilder result = instance.logareEmployee(userName, parola);
        assertNotEquals(expResult, result);
    }
    
}
