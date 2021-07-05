/**
 * 
 */
package application;

/**
 * Service class for all tests.
 * @author franv
 *
 */
public class Service {

	/**
	 * Parses user input if possible to int.
	 * @param input user input string
	 * @return input as int
	 * @throws NumberFormatException if input can't be parssed
	 */
	public static int getInt(String input)  throws NumberFormatException
	{
		return Integer.parseInt(input);
	}
        
        /**
         * Parses user input if possible to double / 100.
         * @param input input string
         * @return double value / 100
         * @throws NumberFormatException  if input can't be parsed
         */
        public static double getCertenty(String input)  throws NumberFormatException
	{
		return Double.parseDouble(input) / 100;
	}

	
	/**
	 *  Prints out result.
	 * @param flag test result
	 * @param algorithm test chosen
	 * @param time test time
	 * @return answer
	 */
	public static String answer(boolean flag, String algorithm, long time)
	{
		String str = "";
		
		if(algorithm.equals("sqrt"))
		{
			str += "> Square root algorithm: ";
		}
		else if(algorithm.equals("wilson"))
		{
			str += "> *NOT IMPLEMENTED - Sqrt for now* Wilson algorithm: ";
		}
		else if(algorithm.equals("miller"))
		{
			str += "> Miller-Rabin algorithm: ";
		}
		else if(algorithm.equals("solovay"))
		{
			str += "> Solovay-Strassen algorithm: ";
		}
		else
		{
			return "> Algorithm undefined!";
		}
		
		if(flag)
		{
			str += "entered number is a prime number.\n>> Time: " + time + "ms.\n";
		}
		else {
			str += "entered number is NOT a prime number.\n>> Time: " + time + "ms.\n";
		}
                
		return str;
	}
        

}
