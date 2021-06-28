/**
 * 
 */
package Algorithms;

/**
 * @author franv
 *
 */
public class Wilson {
	public static native void nativeWilson();
	
	static {
		System.loadLibrary("Wilsonlib");
	}
	
	
	
	
	public static void main(String[] args) {
		Wilson.nativeWilson();
	}
	
	
}
