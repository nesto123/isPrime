/**
 * 
 */
package application;

/**
 * @author franv
 *
 */
public class Service {

	/**
	 * 
	 */		
	public static int getInt(String input)  throws NumberFormatException
	{
		return Integer.parseInt(input);
	}
	public static String answer(boolean flag, String algorithm)
	{
		String str = "";
		
		if(algorithm.equals("sqrt"))
		{
			str += "Square root algorithm: ";
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
