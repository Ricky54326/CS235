package l7p1;

/**
 * Title: BooleanConditionsInMethods class for CSIS 235 Lab #7
 * Description: CS 235 Lab #7 - BooleanConditionsInMethods
 *              This class has a main method which calls 
 *              methods involving boolean conditions.
 *              
 * @author Ricky Mutschlechner, Tim Olmstead and Noah Muth
 * @email  riccardo.mutschlechner@my.uwrf.edu, timothy.olmstead@my.uwrf.edu and noah.muth@my.uwrf.edu
 * @date   October 23rd, 2012
 */

public class BooleanConditionsInMethods {
	
	/**
	 * main method - this is where the program starts
	 * 			Do not change this main method to fix your bugs.
	 * 			All changes must be made in the methods called from main.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// 1: check if a number is negative
		int x = 10;
		System.out.print("1: x is " + x +  ". Therefore, it is a ");
		if ( checkNegative( x ) )
			System.out.println("negative number.");
		else
			System.out.println("non-negative number.");

		
		// 2: check if a number is in a range
		System.out.println();
		System.out.println("2: x is initially " + x + ".");
		System.out.println("   If -5 < x < 0, we will set y to -10. If x is >= 0, we will set y to 20.");
		int y = 0;
		y = checkRange( x, y );
		System.out.println("2: OK, done! y is now " + y + ".");
	}
	
	/**
	 * checkNegative - a method that will return true of the 
	 * 				input parameter is < 0 and false otherwise 
	 * @param input
	 * @return true if input < 0, false otherwise
	 */
	private static boolean checkNegative(final int input ){
		if (input < 0)
			return true;
		else 
			return false;
	}
	
	/**
	 * checkRange - a method that will return:
	 *  -10 if the first input parameter is between -5 and 0 and
	 *   20 if the first input parameter is >= 0
	 *   the second input parameter otherwise
	 * @param input
	 * @return either the defaultvalue, 10 or 20 depending on the input.
	 */
	private static int checkRange(final int input, final int defaultvalue ){
		if (input < 0 && input > -5)
			return -10;
		else
			return 20;
	}
}