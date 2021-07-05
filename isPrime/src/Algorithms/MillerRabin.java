/**
 * 
 */
package Algorithms;

import database.DataBase;

/**
 * @author franv
 *
 */
public class MillerRabin {
	
	/**
	 * Determines if number is a prime number.
	 * @param n input number
	 * @param certanty of test
	 * @return true if number is prime, otherwise false
	 */
	public static boolean isPrime(int n, double certanty)
	{
            DataBase db = new DataBase();
            int k = (int) (Math.log(1/(1-certanty)) / Math.log(2) );

            if( n <= 1 || n == 4)
                    return false;
            if( n == 2 || n == 3 )
                    return true;

            int d = n - 1;

            while( d % 2 == 0)
            {
                    d /= 2;
            }

            for(int i = 0; i < k; i++)
                    if( miller(n, d) == false )
                            return false;

            return true;		
	}
	
	/**
	 * Miller test from isPrime.
	 * @param n number 
	 * @param d base 
	 * @return true if n is prime, otherwise false
	 */
	private static boolean miller(int n, int d)
	{
		int a = 2 + (int) (Math.random() % (n - 4));
		
		int x = moduloPower(a, d, n);
		
		if( x == 1 || x == n - 1)
			return true;
		
		for( ; d != n-1; x = (x * x) % n, d *= 2)
		{
			if( x == 1)
				return false;
			if( x == n - 1)
				return true;
		}
		
		return false;
	}
	
	/**
	 * Modular power function, calculates x**y (mod p).
	 * @param x base
	 * @param y exponent
	 * @param p modulo
	 * @return x**y (mod p)
	 */
	public static int moduloPower(int x, int y, int p)
	{
		int result = 1;
		x = x % p;
		
		while( y > 0 )
		{
			if( y % 2 == 1)
				result = (result * x) % p;
			y /= 2;
			x =  (x * x) % p;
		}
		return result;
	}
	
	/**
	 * Testing function.
	 * @param args none
	 */
	public static void main(String[] args) {
		
	}
	
	
}
