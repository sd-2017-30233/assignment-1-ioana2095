/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Ioana
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Business.EmployeeValidatorTest.class, Business.OperatiuniBancareTest.class, Business.AccountValidatorTest.class, Business.ClientValidatorTest.class, Business.LogareTest.class, Business.EmployeesManagerTest.class, Business.ClientManagerTest.class, Business.AccountManagerTest.class})
public class BusinessSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
