/**
 * 
 */
package Algorithms;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
*	Sqrt algorithm for testing if number is prime.
* @author franv
*/
public class Sqrt implements Callable<Boolean> {

   private final int n;
   private int lowerBound,  upperBound;

   public Sqrt(int n, int lowerBound, int upperBound) {
       this.n = n;
       //  Checking olny odd numbers.
       this.lowerBound = lowerBound % 2 == 1 ? lowerBound : lowerBound + 1;
       this.upperBound = upperBound;
   }
   
   
   private boolean isPrimeInRange()
   {
       if( n==2 || n==3 )
           return true;
       if( n % 2 == 0 || n < 2 )
           return false;
       for(int i = lowerBound < 2 ? 3 : lowerBound; i < upperBound  ; i += 2){
           if( n % i == 0)
               return false;
       }
       return  true;
   }
   
   /**
    *  Is prime Function for sqrt algorithm.
    * @param n input number
    * @return true if n is a prime number
    * @throws InterruptedException some
    * @throws ExecutionException some
    */
   public static boolean isPrime(int n) throws InterruptedException, ExecutionException
   {

       ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()-1);
       List<Sqrt> primeCheckers = new ArrayList<>();
       double blockSize = (double) n / (Runtime.getRuntime().availableProcessors()-1);
       
       for (int x=0; x<Runtime.getRuntime().availableProcessors()-1; x++)
       {
           primeCheckers.add(new Sqrt(n,(int) Math.floor(x*blockSize),(int) Math.floor((x+1)*blockSize)));
       }
       List<Future<Boolean>> futures = executor.invokeAll(primeCheckers);
       
       executor.shutdown();
       
       for(Future<Boolean> future : futures)
           if( future.get() == false)
               return false;

       return true;
   }

   @Override
   public Boolean call() throws Exception {
       return isPrimeInRange();
   }
       

   

   
   
   
}