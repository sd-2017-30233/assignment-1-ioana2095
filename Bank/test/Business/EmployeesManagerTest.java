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
public class EmployeesManagerTest {
    
    public EmployeesManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of insertEmployee method, of class EmployeesManager.
     */
    @Test
    public void testInsertEmployee() {
        System.out.println("insertEmployee");
        int idEmployee = 0;
        String username = "alina29";
        String password = "sjgfhasj13";
        String userType = "employee";
        EmployeesManager instance = new EmployeesManager();
        boolean expResult = true;
        boolean result = instance.insertEmployee(idEmployee, username, password, userType);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateEmployee method, of class EmployeesManager.
     */
    @Test
    public void testUpdateEmployee() {
        System.out.println("updateEmployee");
        int idEmployee = 0;
        String username = "alina567";
        String password = "dhfhgdb888sd";
        String userType = "employee";
        EmployeesManager instance = new EmployeesManager();
        boolean expResult = true;
        boolean result = instance.updateEmployee(idEmployee, username, password, userType);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteEmployee method, of class EmployeesManager.
     */
    @Test
    public void testDeleteEmployee() {
        System.out.println("deleteEmployee");
        int idEmployee = 3;
        EmployeesManager instance = new EmployeesManager();
        boolean expResult = true;
        boolean result = instance.deleteEmployee(idEmployee);
        assertEquals(expResult, result);
    }
    
}
