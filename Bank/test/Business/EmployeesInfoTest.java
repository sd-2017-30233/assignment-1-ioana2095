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
public class EmployeesInfoTest {
    
    public EmployeesInfoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of insertEmployee method, of class EmployeesInfo.
     */
    @Test
    public void testInsertEmployee() {
        System.out.println("insertEmployee");
        Employees e = null;
        EmployeesInfo instance = new EmployeesInfo();
        boolean expResult = false;
        boolean result = instance.insertEmployee(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateEmployee method, of class EmployeesInfo.
     */
    @Test
    public void testUpdateEmployee() {
        System.out.println("updateEmployee");
        Employees employee = null;
        EmployeesInfo instance = new EmployeesInfo();
        boolean expResult = false;
        boolean result = instance.updateEmployee(employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEmployee method, of class EmployeesInfo.
     */
    @Test
    public void testDeleteEmployee() {
        System.out.println("deleteEmployee");
        int idEmployee = 0;
        EmployeesInfo instance = new EmployeesInfo();
        boolean expResult = false;
        boolean result = instance.deleteEmployee(idEmployee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
