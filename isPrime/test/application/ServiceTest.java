/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zialen
 */
public class ServiceTest {
    
    public ServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getInt method, of class Service.
     */
    @Test
    public void testGetInt() {
        System.out.println("getInt");
        String input = "34";
        int expResult = 34;
        int result = Service.getInt(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCertenty method, of class Service.
     */
    @Test
    public void testGetCertenty() {
        System.out.println("getCertenty");
        String input = "0.95";
        double expResult = 0.95;
        double result = Service.getCertenty(input);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of answer method, of class Service.
     */
    @Test
    public void testAnswer() {
        System.out.println("answer");
        boolean flag = false;
        String algorithm = "";
        long time = 0L;
        String expResult = "> Algorithm undefined!entered number is NOT a prime number.\n>> Time: " + time + "ms.\n";
        String result = Service.answer(flag, algorithm, time);
        assertEquals(expResult, result);
    }

    /**
     * Test of answerPseudo method, of class Service.
     */
    @Test
    public void testAnswerPseudo() {
        System.out.println("answerPseudo");
        boolean flag = false;
        String algorithm = "";
        long time = 0L;
        String expResult = "is NOT a > Algorithm undefined!";
        String result = Service.answerPseudo(flag, algorithm, time);
        assertEquals(expResult, result);
    }
    
}
