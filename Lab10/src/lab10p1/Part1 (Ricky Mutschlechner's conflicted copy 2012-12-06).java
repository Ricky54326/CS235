package lab10p1;

/**
 * Title: Part1 and associated classes for CSIS 235 Lab #10
 * Description: CS 235 Lab #10 - Part1
 *              This class has a main method that
 *              uses the Vector and ArrayList classes
 *              from java.util and the MyData class
 *              
 * @author Anthony Varghese
 * @author Ricky Mutschlechner
 * @author Noah Muth
 * @email  riccardo.mutschlechner@my.uwrf.edu, noah.muth@my.uwrf.edu
 * @date   November 29th 2012
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

class MyData{
	private int data;
	public MyData(int data_in){ data = data_in;}
	public String toString(){
		return "" + data;
	}
}
public class Part1 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		runSection1();
		
		runSection2();
		
		runSection3();
		
		runSection4();
		System.out.println("All done!");
	}

	private static void runSection1() {
		final String sec = "Part 1 section 1"; 
		System.out.println("----------------- " + sec + " -----------" );
		
		// Create a Vector object and add names - replace the names with the names of the people in your group
		Vector v1 = new Vector();
		v1.add( "Edith" );
		v1.add( "Paul" );
		v1.add( "Chester" );

		// Show the user what's in the Vector object
		for (Object a : v1 )
			System.out.println("       > " + a);
		System.out.println(" The size of the Vector object v1 is " + v1.size() );
		System.out.println(" The capacity of v1 is               " + v1.capacity() );

		// Add more things to the vector
		System.out.println();
		System.out.println(" Adding more things to v1 ... " );
		for ( int start=100, number=8, i=start; i<start+number; i++ )
			v1.add( i );
		
		// Show the user what's in the Vector object after the additions
		for (Object a : v1 )
			System.out.println("       > " + a);
		System.out.println(" The size of v1 is now     " + v1.size() );
		System.out.println(" The capacity of v1 is now " + v1.capacity() );
		
		printdone( sec );
	}

	private static void runSection2() {
		final String sec = "Part 1 section 2"; 
		System.out.println("----------------- " + sec + " -----------" );

		// Create an ArrayList object and add ints to it
		ArrayList al1 = new ArrayList();
		System.out.println(" The size of the ArrayList object al1 is initially: " + al1.size() );
		System.out.println();
		System.out.println(" Adding things to al1 ... " );
		for ( int start=200, number=12, i=start; i<start+number; i++ )
			al1.add( i );

		// Show the user what's in the ArrayList object
		for (Object a : al1 )
			System.out.println("       > " + a);
		System.out.println(" The size of the ArrayList object al1 is now " + al1.size() );

		// Compute the average of all the elements in al1
		int sum = 0;
		for (Object a : al1 )
			sum = sum + (Integer) a;
		double average = (double) sum/al1.size();
		System.out.println(" The average of the elements of al1 is " + average );

		printdone( sec );
	}

	private static void runSection3() {
		final String sec = "Part 1 section 3"; 
		System.out.println("----------------- " + sec + " -----------" );

		// Create a Vector object and add names - replace the names with the names of the people in your group
		Vector<String> v1 = new Vector<String>();
		v1.add( "Edith" );
		v1.add( "Paul" );
		v1.add( "Chester" );

		// Show the user what's in the Vector object
		for (Object a : v1 )
			System.out.println("       > " + a);
		System.out.println(" The size of the Vector object v1 is " + v1.size() );
		System.out.println(" The capacity of v1 is               " + v1.capacity() );

		// Add more things to the vector
		System.out.println();
		System.out.println(" Adding more things to v1 ... " );
		for ( int start=100, number=8, i=start; i<start+number; i++ )
			v1.add(Integer.toString(i));
		
		// Show the user what's in the Vector object after the additions
		for (Object a : v1 )
			System.out.println("       > " + a);
		System.out.println(" The size of v1 is now     " + v1.size() );
		System.out.println(" The capacity of v1 is now " + v1.capacity() );
		
		printdone( sec );

		//**************************************************************************
		  
				
		// Create an ArrayList object and add ints to it
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		System.out.println(" The size of the ArrayList object al1 is initially: " + al1.size() );
		System.out.println();
		System.out.println(" Adding things to al1 ... " );
		for ( int start=200, number=12, i=start; i<start+number; i++ )
			al1.add( i );

		// Show the user what's in the ArrayList object
		for (Object a : al1 )
			System.out.println("       > " + a);
		System.out.println(" The size of the ArrayList object al1 is now " + al1.size() );

		// Compute the average of all the elements in al1
		int sum = 0;
		for (Object a : al1 )
			sum = sum + (Integer) a;
		double average = (double) sum/al1.size();
		System.out.println(" The average of the elements of al1 is " + average );

		printdone( sec );
	}

	private static void runSection4() {
		final String sec = "Part 1 section 4"; 
		System.out.println("----------------- " + sec + " -----------" );
		Vector<MyData> vec = new Vector<MyData>();
		for (int i=0; i<10; i++)
			vec.add( new MyData( (int)(100*Math.random()) ) );
		
		// Show the user what is in the Vector
		for ( Object md : vec )
			System.out.println("      >" + md);
		printdone( sec );
	}

	private static void printdone(String section){
		System.out.println("--- Done with " + section +
				", hit Enter or Return to continue  -------------------" );
		try{ System.in.read(); } catch (IOException ioe){}		
	}
}
