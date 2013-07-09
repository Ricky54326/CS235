package lab9p1;
/**
 * Title: Part1_1 class for CSIS 235 Lab #9
 * Description: CS 235 Lab #9 - Part1
 *              This class has a main method that
 *              tries to serialize a simple object.
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

class A implements Serializable{
	private static final long serialVersionUID = 1L;
	private int x = 10;
	public String toString(){ return " A.x is " + x;}
}
public class Part1_1 {
	static final String folder = "src/lab9p1/",
						file1 = folder + "File1";
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		System.out.println(" ----------------- writing a simple object to file: " + file1);
		A a1 = new A();
		System.out.println(" Writing a1: " + a1);

		ObjectOutputStream oo = new ObjectOutputStream( new FileOutputStream(file1) );
		oo.writeObject( a1 );
		oo.close();
		A a2;
		ObjectInputStream oi = new ObjectInputStream( new FileInputStream(file1) );
		a2 = (A) oi.readObject();
		oi.close();
		System.out.println(" Read a2 from file: " + a2);
	}
}
