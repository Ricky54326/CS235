package lab10p2;

import java.io.IOException;

/**
 * Title: Part2 and associated classes for CSIS 235 Lab #10
 * Description: CS 235 Lab #10 - Part2
 *              This class has a main method that
 *              uses a number of small classes and a
 *              few "container" classes that we will "genericize".
 *              
 * @author Anthony Varghese 
 * @author Ricky Mutschlechner
 * @email  riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @email  noah.muth@uwrf.edu
 * @date   December 3rd 2012
 */

class A{
	private int data;
	public A(int data_in){ data = data_in;}
	public boolean equals(Object other){
		return this.data == ((A)other).data;
	}
	public String toString(){ return "[ " + data + " ]";	}
}

class B{
	private float data;
	public B(float data_in){ data = data_in;}
	public boolean equals(Object other){
		return this.data == ((B)other).data;
	}
	public String toString(){ return "[ " + data + " ]";	}
}

class C{
	private String data;
	public C(String data_in){ data = data_in;}
	public boolean equals(Object other){
		return this.data == ((C)other).data;
	}
	public String toString(){ return "[ " + data + " ]";	}
}

class APair{
	private A a1, a2;
	public APair( A a1_in, A a2_in ){ a1 = a1_in; a2 = a2_in; }
	public boolean equals(Object other){
		return ((this.a1.equals(((APair)other).a1)) && (this.a2.equals(((APair)other).a2)));
	}
	public String toString(){ return "[ " + a1 + ", " + a2 + " ]";	}
}

class BPair{
	private B a1, a2;
	public BPair( B a1_in, B a2_in ){ a1 = a1_in; a2 = a2_in; }
	public boolean equals(Object other){
		return ((this.a1.equals(((BPair)other).a1)) && (this.a2.equals(((BPair)other).a2)));
	}
	public String toString(){ return "[ " + a1 + ", " + a2 + " ]";	}
}

class Pair<T>{
	private T a1, a2;
	public Pair( T a1_in, T a2_in ){ a1 = a1_in; a2 = a2_in; }
	public boolean equals(Object other){
		Pair<T> otherPaira1 = (Pair<T>)other;
		Pair<T> otherPaira2 = (Pair<T>)other;
		return (this.a1.equals(otherPaira1.a1) && this.a2.equals(otherPaira2.a2));
	}
	public String toString(){ return "[ " + a1 + ", " + a2 + " ]";	}
}

class Triple<T>{
	private T a1, a2, a3;
	public Triple(T a1, T a2, T a3){
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
	}
	public String toString(){
		return "[ " + a1 + ", " + a2 + ", " + a3 + " ]";
	}
}

public class Part2 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		runSection1();
		
		runSection2();
		
		runSection3();
		
		runSection4();

		runSection5();
		
		runSection6();
		System.out.println("All done!");
	}

	private static void runSection1() {
		final String sec = "Part 2 section 1"; 
		System.out.println("----------------- " + sec + " --- Group members: Ricky Mutschlechner and Noah Muth" );
		
		A object1 = new A( 10 );
		A object2 = new A( 29 );
		APair pairOfAObjects = new APair( object1, object2 );
		APair pairOfAObjects2 = new APair( new A( 15 ), new A( 30 ) );
		
		System.out.println("  pairOfAObjects has: " + pairOfAObjects );
		System.out.println("  pairOfAObjects2 has : " + pairOfAObjects2);
		
		BPair pairOfBObjects = new BPair( new B(2.3f), new B(923.65f) );
		BPair pairOfBObjects2 = new BPair( new B(3.14f), new B(123.45f) );
		
		System.out.println("  pairOfBObjects has: " + pairOfBObjects );
		System.out.println("  pairOfBObjects2 has: " + pairOfBObjects2 );
		printdone( sec );
	}

	private static void runSection2() {
		final String sec = "Part 2 section 2"; 
		System.out.println("----------------- " + sec + " --- Group members: Ricky Mutschlechner and Noah Muth" );

		Pair<A> pairOfAObjects = new Pair<A>( new A( 10 ), new A( 29 ) );
		
		System.out.println("  pairOfAObjects has: " + pairOfAObjects );
		
		Pair<B> pairOfBObjects = new Pair<B>( new B(2.3f), new B(923.65f) );
		
		System.out.println("  pairOfBObjects has: " + pairOfBObjects );
		
		printdone( sec );
	}

	private static void runSection3() {
		final String sec = "Part 2 section 3"; 
		System.out.println("----------------- " + sec + " --- Group members: Ricky Mutschlechner and Noah Muth" );
		
		Triple<A> triple1 = new Triple<A>( new A(42), new A(203), new A(192) );
		System.out.println("  triple1 has: " + triple1 );
		
		Triple<B> triple2 = new Triple<B>( new B(3.14f), new B(2.71f), new B(32.54f) );
		System.out.println("  triple2 has: " + triple2 );

		Triple<C> triple3 = new Triple<C>( new C("John"), new C("Paul"), new C("George") );
		System.out.println("  triple3 has: " + triple3 );
		
		printdone( sec );
	}

	private static void runSection4() {
		final String sec = "Part 2 section 4"; 
		System.out.println("----------------- " + sec + " --- Group members: Ricky Mutschlechner and Noah Muth" );

		A a1 = new A( 10 ); System.out.println("   a1 is " + a1 );
		A a2 = new A( 29 ); System.out.println("   a2 is " + a2 );
		A a3 = new A( 10 ); System.out.println("   a3 is " + a3 );
		A a4 = a1;          System.out.println("   a4 is " + a4 );

		if ( a1.equals( a2 ) )  System.out.println("     a1 equals a2" );
		else					System.out.println("     a1 does not equal a2" );
		
		if ( a1.equals(a3) ) System.out.println("     a1 equals a3");
		else				 System.out.println("     a1 does not equal a3" );
		
		if ( a1.equals(a4) ) System.out.println("     a1 equals a4");
		else 				 System.out.println("    a1 does not equal a4");

		
		B b1 = new B(10/3f);
		B b2 = new B(200/30f);
		B b3 = new B(1000/300f);
		B b4 = b1;
		
		if ( b1.equals( b2 ) )  System.out.println("     b1 equals b2" );
		else					System.out.println("     b1 does not equal b2" );
		if ( b1.equals( b3 ) )  System.out.println("     b1 equals b3" );
		else					System.out.println("     b1 does not equal b3" );
		if ( b1.equals( b4 ) )  System.out.println("     b1 equals b4" );
		else					System.out.println("     b1 does not equal b4" );
		
		
		printdone( sec );
	}

	private static void runSection5() {
		final String sec = "Part 2 section 5"; 
		System.out.println("----------------- " + sec + " --- Group members: Ricky Mutschlechner and Noah Muth" );

		APair pair1 = new APair( new A( 10 ), new A( 29 ) );
		System.out.println("  pair1 has: " + pair1 );
		APair pair2 = new APair( new A( 11 ), new A( 134 ) );
		System.out.println("  pair2 has: " + pair2 );
		APair pair3 = new APair( new A( 10 ), new A( 29 ) );
		System.out.println("  pair3 has: " + pair3 );
		
		// Check if pairs are equal using .equals
		if(pair1.equals(pair2)){
			System.out.println("Pair1 equals Pair2");
		}
		else
			System.out.println("Pair1 does not equal Part2");
		
		if(pair1.equals(pair3)){
			System.out.println("Pair1 equals Pair3");
		}
		else
			System.out.println("Pair1 does not equal Part3");

		printdone( sec );
	}

	private static void runSection6() {
		final String sec = "Part 2 section 6"; 
		System.out.println("----------------- " + sec + " --- Group: " );

		Pair<A> pair1 = new Pair<A>( new A( 10 ), new A( 29 ) );
		System.out.println("  pair1 has: " + pair1 );
		Pair<A> pair2 = new Pair<A>( new A( 11 ), new A( 134 ) );
		System.out.println("  pair2 has: " + pair2 );
		Pair<A> pair3 = new Pair<A>( new A( 10 ), new A( 29 ) );
		System.out.println("  pair3 has: " + pair3 );
		
		// Check if pairs are equal using .equals
		if ( pair1.equals( pair2 ) )
			System.out.println("     pair1 equals pair2" );
		else
			System.out.println("     pair1 does not equal pair2" );
		if ( pair1.equals( pair3 ) )
			System.out.println("     pair1 equals pair3" );
		else
			System.out.println("     pair1 does not equal pair3" );

		printdone( sec );
	}

	private static void printdone(String section){
		System.out.println("--- Done with " + section +
				", hit Enter or Return to continue  -------------------" );
		try{ System.in.read(); } catch (IOException ioe){}		
	}
}