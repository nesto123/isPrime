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
public class MillerRabinTest {
    
    public MillerRabinTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isPrime method, of class MillerRabin.
     */
    @Test
    public void testIsPrime() {
        System.out.println("MillerRabin.isPrime");
        int n = 23, n2 = 22;
        double certanty = 0.99;
        boolean expResult = true, expResult2 = false;
        boolean result = MillerRabin.isPrime(n, certanty);
        boolean result2 = MillerRabin.isPrime( n2, certanty );
        assertEquals(expResult, result);
        assertEquals( expResult2, result2 );
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of moduloPower method, of class MillerRabin.
     */
    @Test
    public void testModuloPower() {
        System.out.println("moduloPower");
        int x = 20;
        int y = 37;
        int p = 76;
        int expResult = 20, eR = 0;
        int result = MillerRabin.moduloPower(x, y, p);
        int res = MillerRabin.moduloPower( x, y, 1 );
        assertEquals(expResult, result);
        assertEquals( eR, res );
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
