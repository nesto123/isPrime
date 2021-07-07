/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import database.DataBase;

/**
 *
 * @author zialen
 */
public class EulerPseudo {
    
    /**
     * Checks if number n is Euler pseudoprime for base
     * @param n
     * @param base
     * @return true if n is Euler pseudoprime, false otherwise
     */
    public static boolean isPseudo( int n, int base ){
        DataBase db = new DataBase( "dbase.db" );
        int jacob = (int)SolovayStrassen.jacobian( base, n );
        int mod = MillerRabin.moduloPower( base, (n - 1) / 2, n );
        if( jacob != mod && jacob != ( mod - n )) return false;
        else db.insertEuler( base, n );
        return true;
    }
}
