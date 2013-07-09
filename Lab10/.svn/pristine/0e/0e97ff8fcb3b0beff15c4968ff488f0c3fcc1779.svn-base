package lab10p3;

import java.io.IOException;

/**
 * Title: Part3 class for CSIS 235 Lab #10
 * Description: CS 235 Lab #10 - Part3
 *              This class has a main method that
 *              uses a couple of classes that we
 *              will modify to use the Comparable interface.
 *              
 * @author Anthony Varghese 
 * @author 
 * @email  your.n.here@my.uwrf.edu
 * @date   November 17th 2012
 */

class A{
	private int data;
	public A(int data_in){ data = data_in;}
	public String toString(){ return "[ " + data + " ]";	}
	public boolean equals( Object other){ return data == ((A)other).data; }
}

class B{
	private float data;
	public B(float data_in){ data = data_in;}
	public String toString(){ return "[ " + data + " ]";	}
}

class C{
	private double ddata;
	private int    idata;
	public C(double d_in, int i_in){ ddata = d_in; idata = i_in; }
	public String toString(){ return "[ " + ddata + ", " + idata + " ]";	}
}

class CompareDoublesInC implements java.util.Comparator<C>{
	public int compare(C o1, C o2) {
		return 0;
	}
}



public class Part3 {
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
		final String sec = "Part 3 section 1"; 
		System.out.println("----------------- " + sec + " --- Group: " );

		String s1 = "10";
		String s2 = "2";
		System.out.print(" s1 is " + s1 + " and s2 is " + s2 + " and therefore ");
		final int diff = s1.compareTo( s2 ); 
		if ( diff > 0 )
			 System.out.println(" s1 > s2 ");
		else if ( diff < 0 )
			 System.out.println(" s1 < s2 ");
		else System.out.println(" s1 == s2 ");
		
		printdone( sec );
	}

	private static void runSection2() {
		final String sec = "Part 3 section 2"; 
		System.out.println("----------------- " + sec + " --- Group: " );

		A a1 = new A( 20 );
		A a2 = new A( 10 );
		System.out.print(" a1 is " + a1 + " and a2 is " + a2 + " and therefore ");
		final int diff = 0;
//		diff = a1.compareTo( a2 );
		if ( diff > 0)
			 System.out.println(" a1 > a2 ");
		else if ( diff < 0 )
			 System.out.println(" a1 < a2 ");
		else System.out.println(" a1 == a2 ");

		printdone( sec );
	}

	private static void runSection3() {
		final String sec = "Part 3 section 3"; 
		System.out.println("----------------- " + sec + " --- Group: " );
		

		final int SIZE = 20;
		B[] barr = new B[SIZE];
		for (int i=0; i<SIZE; i++)
			barr[i] = new B( (float) (Math.random() * SIZE ) );
		System.out.println("Starting data: ");
		for (B b : barr)
			System.out.println( "   "  + b);
				
		// Sort the barr array in order of increasing values of the float data member
		sort( barr );
				
		System.out.println("\n\nSorted by data member: ");
		for (B b : barr)
			System.out.println( b );
		
		printdone( sec );
	}

	private static void runSection4() {
		final String sec = "Part 3 section 4"; 
		System.out.println("----------------- " + sec + " --- Group: " );

		final int SIZE = 20;
		C[] carr = new C[SIZE];
		for (int i=0; i<SIZE; i++)
			carr[i] = new C( Math.random() * 10, (int) (Math.random() * SIZE) );
		System.out.println("Starting data: ");
		for (C c : carr)
			System.out.println( "   "  + c);
				
		// Sort the carr array in order of increasing values of the double data member
		sort( carr, new CompareDoublesInC() );
				
		System.out.println("\n\nSorted by double data member: ");
		for (C c : carr)
			System.out.println( c );

		printdone( sec );
	}

	private static void printdone(String section){
		System.out.println("--- Done with " + section +
				", hit Enter or Return to continue  -------------------" );
		try{ System.in.read(); } catch (IOException ioe){}		
	}
	
	/**
	 * sort - sort the input array b - not working yet
	 * 
	 * This method uses the Selection sort algorithm to sort
	 * 
	 * Preconditions:  none
	 * Postconditions: the elements of the array b will be in sorted order so that 
	 *     b[i].data <= b[i+1].data for i from 0 to b.length 
	 * @param b - array of B elements
	 */
	private static void sort(B[] b) {
		final int N = b.length;
		if (N <= 1)
			return;

		for (int i=0; i<N; i++) {
			int minIndex = i;

			/*
			 * Find the next smallest item in d
			 */
			for (int j=i+1; j<N; j++)
//				if (b[j].compareTo( b[ minIndex ] ) < 0)
					minIndex = j;

			if (minIndex != i) { //swap
				B temp = b[i];
				b[i] = b[minIndex];
				b[minIndex] = temp;
			}
		}
	}
	
	
	
	/**
	 * sort - sort the input array c using a Comparator
	 * 
	 * This method uses the Selection sort algorithm to sort
	 * 
	 * Preconditions:  none
	 * Postconditions: the elements of the array b will be in sorted order so that 
	 *     c[i].ddata <= c[i+1].ddata for i from 0 to c.length 
	 * @param c - array of C elements
	 */
	private static void sort(C[] c, CompareDoublesInC comparer) {
		final int N = c.length;
		if (N <= 1)
			return;

		for (int i=0; i<N; i++) {
			int minIndex = i;

			/*
			 * Find the next smallest item in d
			 */
			for (int j=i+1; j<N; j++)
				if ( comparer.compare( c[j], c[ minIndex ] ) < 0)
					minIndex = j;

			if (minIndex != i) { //swap
				C temp = c[i];
				c[i] = c[minIndex];
				c[minIndex] = temp;
			}
		}
	}
}