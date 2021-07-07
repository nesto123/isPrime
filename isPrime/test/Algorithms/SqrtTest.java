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
public class SqrtTest {
    
    public SqrtTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isPrime method, of class Sqrt.
     */
    @Test
    public void testIsPrime() throws Exception {
        System.out.println("isPrime");
        int n = 101, n2 = 49;
        boolean expResult = true, er2 = false;
        boolean result = Sqrt.isPrime(n);
        boolean res2 = Sqrt.isPrime( n2 );
        assertEquals(expResult, result);
        assertEquals( er2, res2 );
    }

    /**
     * Test of call method, of class Sqrt.
     */
    @Test
    public void testCall() throws Exception {
        System.out.println( "call" );
    }
    
}
