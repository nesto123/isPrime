/**
 * 
 */
package Algorithms;

import database.DataBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Class for Solovay-Strassen prime test.
 * @author franv
 *
 */
public class SolovayStrassen {
	/**
	 * Number for testing.
	 */
	private final int n;
	
	/**
	 * Number of bases for testing.
	 */
	private final int k;
	
	/**
	 * Initialize Solovay-Strassen test.
	 * @param n Number for testing
	 * @param k Number of bases for testing
	 */
	SolovayStrassen(int n, int k) {
		this.n = n;
		this.k = k;
	}
	
	/**
	 * Calculates jacobian symbol (a/n).
	 * @param a numerator
	 * @param n denominator
	 * @return result of jacobian (a/n)
	 */
	public static long jacobian(long a, long n)
	{
		if (n <= 0 || n % 2 == 0)
			return 0;
	         
	    long ans = 1L;
	    	     
	    if (a == 1)
	        return ans; 
	         
	    while (a != 0)
	    {
	        if (a < 0)
	        {
	            a *= -1; 
	            if (n % 4 == 3)
	                ans = -ans;
	        }
	         
	        while (a % 2 == 0)
	        {
	            a /= 2;
	            if (n % 8 == 3 || n % 8 == 5)
	                ans = -ans;
	        }
	 
	        long temp = a;
	        a = n;
	        n = temp;
	 
	        if (a % 4 == 3 && n % 4 == 3)
	            ans = -ans;
	             
	        a %= n;
	        if (a > n / 2)
	            a = a - n;
	    }
	     
	    if (n == 1)
	        return ans;
	         
	    return 0;
	}
	
	private boolean solovoyStrassen()
	{
		DataBase db = new DataBase( "dbase.db" );
		if( n < 2  || ( n != 2 && n % 2 == 0))
			return false;
		if( n == 2)
			return true;

		ArrayList<Integer> list = new ArrayList<>();
		Random random = new Random();
		
		/*for (int i = 0; i < k; i++) 
			// nextInt((max - min) + 1) + min;
			list.add( random.nextInt( (n-1)  - 1 + 1 ) + 1 ); 
		
		for (Integer integer : list) {
			int a = integer % (n - 1) + 1;
			int jacob = (int) ((n + jacobian(a, n) ) % n);
			int mod = MillerRabin.moduloPower(a,  (n - 1) / 2, n);
			
			if(jacob == 0 || mod != jacob)
                            return false;
                        else db.insertEuler( integer, n );
		}
		
		return true;*/
                
                for( int i = 0; i < k; i++ ){
                int integer = random.nextInt( (n-1)  - 1 + 1 ) + 1;
                while( list.contains( integer ) )
                    integer = random.nextInt( (n-1)  - 1 + 1 ) + 1;
                list.add( integer );
                //System.out.println( integer );
                int jacob = (int) jacobian( integer, n );
                int mod = MillerRabin.moduloPower(integer, (n-1)/2, n);
                if( jacob != mod && jacob != ( mod - n )) return false;
                else db.insertEuler( integer, n );
            }
            return true;
	}
	
	/**
	 * Is prime n function with certenty.
	 * @param n number
	 * @param certanty percentage
	 * @return true if n is a prim number, otherwise false
	 */
	public static boolean isPrime( int n, double certanty)
	{
		int basesNo = (int) (Math.log(1/(1-certanty)) / Math.log(2) );
		SolovayStrassen alg = new SolovayStrassen(n, basesNo);
		
		return alg.solovoyStrassen();
	}
	
	/**
	 * Testing function.
	 * @param args none
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}*/

}
