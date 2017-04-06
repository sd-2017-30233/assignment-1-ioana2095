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
public class OperatiuniBancareTest {
    
    public OperatiuniBancareTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of readOperatiuni method, of class OperatiuniBancare.
     */
    @Test
    public void testReadOperatiuni() throws Exception {
        System.out.println("readOperatiuni");
        int ID_Employee = 35;
        String dindata = "12/03/2017";
        String panadata = "06/04/2017";
        OperatiuniBancare instance = new OperatiuniBancare();
        ArrayList<ArrayList<String>> expResult = null;
        ArrayList<ArrayList<String>> result = instance.readOperatiuni(ID_Employee, dindata, panadata);
        assertNotEquals(expResult, result);
    }
    
}
