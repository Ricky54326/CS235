package lab9p1;
/**
 * Title: Part1_5 class for CSIS 235 Lab #9
 * Description: CS 235 Lab #9 - Part1_5
 *              This class has a main method that
 *              tries to serialize/deserialize objects that
 *              have a few levels of inheritance.
 *              
 * @author Ricky Mutschlechner
 * @email  riccardo.mutschlechner@my.uwrf.edu
 * @date   November 14th 2012
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class E1 implements Serializable{
	private static final long serialVersionUID = 1L;
	protected int x;
	public E1(){ x = 1; }
	public E1(int x_in){ x = x_in; System.out.println("E1 constructor 2");}
	public String toString(){ return " E1: [" + x + "]"; }
}
class E2 extends E1{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public E2(){ x = 2; System.out.println("E2 constructor 1"); }
	public E2(int x_in){ super(x_in); System.out.println("E2 constructor 2"); }	
}
class E3 extends E2 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public E3(){ x = 3; System.out.println("E3 constructor 1"); }
	public E3(int x_in){ super(x_in); System.out.println("E3 constructor 2"); }	
}
public class Part1_5 {
	private static final String file6 = Part1_1.folder + "File6";
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		System.out.println(" ----------------- writing an object to file: " + file6);

		/**/
		E1 e1 = new E3( );
		System.out.println(" Writing e1 to file: " + e1 );
		write(e1);
		/**/
		
		System.out.println(" About to read e1 from file: ... ");
		E1 e1new = read();
		System.out.println(" e1new read from file:  " + e1new );
		
	}
	private static void write(E1 e) throws IOException {
		ObjectOutputStream oo = new ObjectOutputStream( new FileOutputStream(file6) );
		oo.writeObject( e );
		oo.close();		
	}
	private static E3 read() throws IOException, ClassNotFoundException {
		ObjectInputStream oi = new ObjectInputStream( new FileInputStream(file6) );
		E3 e  = (E3) oi.readObject();
		oi.close();
		return e;
	}
}