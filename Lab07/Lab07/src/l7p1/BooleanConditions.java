package l7p1;

/**
 * Title: BooleanConditions class for CSIS 235 Lab #7
 * Description: CS 235 Lab #7 - BooleanConditions
 *              This class has a main method with a 
 *              number of "scopes" or compound statements.
 *              
 * @author Ricky Mutschlechner, Tim Olmstead and Noah Muth
 * @email  riccardo.mutschlechner@my.uwrf.edu, timothy.olmstead@my.uwrf.edu and noah.muth@my.uwrf.edu
 * @date   October 23rd, 2012
 */

public class BooleanConditions {

	/**
	 * main method - this is where the program starts
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		{	// Scope 1
			final int x = 10;
			// What the code is supposed to do:
			//   Now we want to print a message if x is negative
			if ( x < 0)
				System.out.println("1: x is " + x +  ". Therefore, it is a negative number.");
			
			else
				System.out.println("1: x is " + x +  ". Therefore, it is a positive number.");
			

		}
		
		{	// Scope 2
			System.out.println();

			int x = 10;
			System.out.println("2: x is initially " + x + ".");
			System.out.println("   If -5 < x < 0, we will set y to -10. If x is >= 0, we will set y to 20.");

			// What the code is supposed to do:
			//   If -5 < x < 0, we will set y to -10. If x is >= 0, we will set y to 20.
			int y = 0;
			if (x < 0 && x >-5)
					y = -10;
			else
				y = 20;
			System.out.println("2: OK, done! y is now " + y + ".");
		}
		
		{	// Scope 3
			System.out.println();

			int x = 10;
			int y = 20;
			System.out.println("3: Initially x is " + x + " and y is " + y + "." );
			System.out.println("   If x is negative we will increment both, if x is positive or 0, do nothing.");

			// What the code is supposed to do:
			//   If x is negative increment both x and y, if x is positive or 0, do nothing.
			if ( x < 0){
				y++; x++;
			}
			System.out.println("3: Done! x is now " + x + " and y is " + y);
			
		}
		
		{	// Scope 4
			System.out.println();

			int x = 20;

			System.out.println("4: x is initially " + x + "." );
			System.out.println("   We will now decrement x until it is outside the range from 10 to 20.");

			// What the code is supposed to do:
			//   Now we want to decrement x until it is outside the range from 10 to 20 
			do{
				x--;
			} while ( (x<20) && (x>10));
			System.out.println("4: x is " + x + ". Therefore it is no longer greater than 10, less than 20.");
		}
		
		{	// Scope 5
			System.out.println();

			int x = 10, y = 20;

			System.out.println("5: x is initially " + x + " and y is " + 20 + ".");
			System.out.println("   If x is less than y we will set y to 0; if not, we will set x to 0.");

			// What the code is supposed to do:
			//   Now we want to either set y to 0 (if x is less than y) or x to 0 (if y is less than or equal to x). 
			if ( x < y ){
				y = 0;
			}
			else 
				x = 0;
			System.out.println("5: Done!  x is now " + x + ",  and y is " + y + ".");
		}
	}
}