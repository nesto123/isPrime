/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zialen
 */
public class DataBaseTest {
    
    public DataBaseTest() {
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
     * Test of insertEuler method, of class DataBase.
     */
    @Test
    public void testInsertEuler() {
        System.out.println("insertEuler");
        int baza = 0;
        int broj = 0;
        DataBase instance = new DataBase( "test.db" );
        instance.insertEuler(baza, broj);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkEuler method, of class DataBase.
     */
    @Test
    public void testCheckEuler() {
        System.out.println("checkEuler");
        int baza = 100;
        int broj = 100;
        DataBase instance = new DataBase( "test.db" );
        instance.insertEuler(baza, broj);
        boolean expResult = true;
        boolean result = instance.checkEuler(baza, broj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of insertStrong method, of class DataBase.
     */
    @Test
    public void testInsertStrong() {
        System.out.println("insertStrong");
        int baza = 0;
        int broj = 0;
        DataBase instance = new DataBase( "test.db" );
        instance.insertStrong(baza, broj);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkStrong method, of class DataBase.
     */
    @Test
    public void testCheckStrong() {
        System.out.println("checkStrong");
        int baza = 100;
        int broj = 100;
        DataBase instance = new DataBase( "test.db" );
        instance.insertStrong(baza, broj);
        boolean expResult = true;
        boolean result = instance.checkStrong(baza, broj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
