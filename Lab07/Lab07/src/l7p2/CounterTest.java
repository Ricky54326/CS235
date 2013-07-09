package l7p2;

/**
 * Title: CounterTest class for CSIS 235 Lab #7
 * Description: CS 235 Lab #7 - CounterTest
 *              This class has a main method and is the
 *              client of the Counter class.
 * @author Ricky Mutschlechner, Tim Olmstead and Noah Muth
 * @email  riccardo.mutschlechner@my.uwrf.edu, timothy.olmstead@my.uwrf.edu and noah.muth@my.uwrf.edu
 * @date   October 23rd, 2012
 */

public class CounterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println( "This program will set up Counter objects which have only non-negative counts" );

		// Testing Counter object c1 by calling the increment method.
		Counter c1 = new Counter();
		System.out.println( "1. Counter c1 has been initialized to " + c1.currentCount() );
		final int STEPS = 1000;
		for (int i=0; i<STEPS; i++)
			c1.increment();
		System.out.println("   After " + STEPS + " increments, c1 is " + c1.currentCount() );
		System.out.println();
		
		
		
		// Testing Counter object c2 by starting with a non-zero value and calling the increment method.
		final int C2START = 100;
		Counter c2 = new Counter( C2START );
		System.out.println( "2. Counter c2 has been initialized to " + c2.currentCount() );
		for (int i=0; i<STEPS; i++)
			c2.increment();
		System.out.println("   After " + STEPS + " increments, c2 is " + c2.currentCount() );
		System.out.println();
		
		
		
		
		// Testing Counter object c3 by starting with a negative value and calling the increment method.
		final int BADSTART = -100;
		System.out.println( "3. Attempting to initialize counter c3 to " + BADSTART );
		Counter c3 = new Counter( BADSTART );
		System.out.println( "   Counter c3 has been initialized to " + c3.currentCount() );
		for (int i=0; i<STEPS; i++)
			c3.increment();
		System.out.println( "    After " + STEPS + " increments, c3 is " + c3.currentCount() );
		System.out.println();
		
		
		//Testing Counter object c4 by starting with a positive value and trying to decrement it below 0.
		final int DECTEST = 999;
		System.out.println( "4. Attempting to initialize counter c4 to " +  DECTEST);
		Counter c4 = new Counter( DECTEST );
		System.out.println( "   Counter c4 has been initialized to " + c4.currentCount() );
		for (int i=0; i<STEPS; i++)
			c4.decrement();
		System.out.println( "    After " + STEPS + " decrements, c4 is " + c4.currentCount() );
		
		
	}
}
