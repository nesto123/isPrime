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
	 *  Prints out result.
	 * @param flag test result
	 * @param algorithm test chosen
	 * @return answer
	 */
	public static String answer(boolean flag, String algorithm)
	{
		String str = "";
		
		if(algorithm.equals("sqrt"))
		{
			str += "Square root algorithm: ";
		}
		else if(algorithm.equals("wilson"))
		{
			str += "*NOT IMPLEMENTED - Sqrt for now* Wilson algorithm: ";
		}
		else if(algorithm.equals("miller"))
		{
			str += "Miller-Rabin algorithm: ";
		}
		else if(algorithm.equals("solovay"))
		{
			str += "Solovay-Strassen algorithm: ";
		}
		else
		{
			return "Algorithm undefined!";
		}
		
		if(flag)
		{
			str += "entered number is a prime number.\n";
		}
		else {
			str += "entered number is NOT a prime number.\n";
		}
		return str;
	}

}
