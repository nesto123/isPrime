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
        int[] primes = new int[]{ 73, 283, 661, 1381, 2011, 2437, 4423, 6197, 7001, 7829 };
        int[] complex = new int[]{ 77, 289, 663, 1382, 2010, 2439, 4422, 6195, 7009, 7827 };
        boolean expResultPrime = true;
        boolean expResultComplex = false;
        for( int i = 0; i < 9; i++ ){
            boolean resultPrime = SolovayStrassen.isPrime( primes[i], 0.99 );
            boolean resultComplex = SolovayStrassen.isPrime( complex[i], 0.99 );
            assertEquals( expResultPrime, resultPrime );
            assertEquals( expResultComplex, resultComplex );
        }
    }
    
}
