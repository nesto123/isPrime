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
public class StrongPseudoTest {
    
    public StrongPseudoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isPseudo method, of class StrongPseudo.
     */
    @Test
    public void testIsPseudo() {
        System.out.println("StrongPseudo.isPseudo");
        int n = 49, n2 = 99;
        int base = 128, b2 = 68;
        boolean expResult = true, er2 = false;
        boolean result = StrongPseudo.isPseudo(n, base);
        boolean res2 = StrongPseudo.isPseudo( n2, b2 );
        assertEquals(expResult, result);
        assertEquals( er2, res2 );
    }
    
}
