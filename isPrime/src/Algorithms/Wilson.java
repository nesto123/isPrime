/**
 * 
 */
package Algorithms;

import java.util.concurrent.ExecutionException;

/**
 * @author franv
 *
 */
public class Wilson {
    
    private int num;

    public Wilson(int n) {
        this.num = n;
    } 
    
    private int fact(int n)
    {
        int fact = 1;
         while(n>=1)
        {
            if (fact > Integer.MAX_VALUE / n || fact < Integer.MIN_VALUE / n)
                return -1;
            fact = fact*n;       
            n = n-1;
        }
        return fact;
    }
    
    public boolean wilson() throws ArithmeticException
    {
        if( this.num == 4)
            return false;
        int test =  (fact(this.num >> 1) % this.num);
        if( test == -1)
            throw new ArithmeticException("overflow");
        return (fact(this.num >> 1) % this.num) != 0;
    }
    
    	/**
	 * Is prime n function for Wilson test.
	 * @param n number
	 * @return true if n is a prim number, otherwise false
	 */
	public static boolean isPrime( int n ) throws ArithmeticException
	{
		Wilson test = new Wilson(n);
		
		return test.wilson();
	}
	
	
}
