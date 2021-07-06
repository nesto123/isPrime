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
public class SolovayStrassenTest {
    
    public SolovayStrassenTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isPrime method, of class SolovayStrassen.
     */
    @Test
    public void testIsPrime() {
        System.out.println("SolovayStrassen.isPrime");
        int n = 23, n2 = 22;
        double certanty = 0.99;
        boolean expResult = true, expResult2 = false;
        boolean result = SolovayStrassen.isPrime(n, certanty);
        boolean result2 = SolovayStrassen.isPrime(n2, certanty);
        assertEquals(expResult, result);
        assertEquals( expResult2, result2 );
    }
    
}
