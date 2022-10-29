/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Project2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author yueli
 */
public class ModelTest {
    
    public ModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of loginAcc method, of class Model.
     */
    @Test
    public void testLoginAcc() {
        System.out.println("loginAcc");
        String userID = "";
        String password = "";
        Model instance = new Model();
        instance.loginAcc(userID, password);
        
    }

    /**
     * Test of createNewAcc method, of class Model.
     */
    @Test
    public void testCreateNewAcc() {
        System.out.println("createNewAcc");
        String userID = "";
        String userName = "";
        String password = "";
        Model instance = new Model();
        instance.createNewAcc(userID, userName, password);

    }

    /**
     * Test of resetPassword method, of class Model.
     */
    @Test
    public void testResetPassword() {
        System.out.println("resetPassword");
        String userID = "";
        String newPassword = "";
        Model instance = new Model();
        instance.resetPassword(userID, newPassword);
        
    }

}
