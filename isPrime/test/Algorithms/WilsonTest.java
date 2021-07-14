/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zialen
 */
public class WilsonTest {
    
    public WilsonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of wilson method, of class Wilson.
     */
    @Test
    public void testWilson() {
        System.out.println("wilson");
        Wilson instance = new Wilson( 23 );
        Wilson instance2 = new Wilson( 21 );
        boolean expResult = true;
        boolean expResult2 = false;
        boolean result = instance.wilson();
        boolean result2 = instance2.wilson();
        assertEquals(expResult, result);
        assertEquals( expResult2, result2 );
    }

    /**
     * Test of isPrime method, of class Wilson.
     */
    @Test
    public void testIsPrime() {
        System.out.println("isPrime");
        int prime = 23;
        int complex = 21;
        boolean expResult = true;
        boolean expResult2 = false;
        boolean result = Wilson.isPrime( prime );
        boolean result2 = Wilson.isPrime( complex );
        assertEquals(expResult, result);
        assertEquals( expResult2, result2 );
    }
    
}
