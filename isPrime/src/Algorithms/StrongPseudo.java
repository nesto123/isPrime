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
public class StrongPseudo {
    
    /**
     * Checks if number is strong pseudoprime for given base
     * @param n
     * @param base
     * @return true if n is strong pseudoprime, false otherwise
     */
    public static boolean isPseudo( int n, int base ){
        DataBase db = new DataBase( "dbase.db" );
        int d = n - 1;
        while( d % 2 == 0){
                d /= 2;
        }
        int x = MillerRabin.moduloPower(base, d, n);
        if( x == 1 || x == n - 1){
            if( x == 1 ){
                db.insertStrong( base, n );
                db.insertEuler(base, n);
            }
            return true;
        }

        for( ; d != n-1; x = (x * x) % n, d *= 2)
        {
                if( x == 1)
                        return false;
                if( x == n - 1){
                    db.insertStrong( base, n );
                    db.insertEuler( base, n );
                    return true;
                }
        }

        return false;
    }
}
