package lab9p1;
/**
 * Title: Part1_3 class for CSIS 235 Lab #9
 * Description: CS 235 Lab #9 - Part1_3
 *              This class has a main method that
 *              tries to serialize an object that has
 *              a data member that is an array.
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

class C implements Serializable{
	private static final long serialVersionUID = 1L;
	private B[] store;
	private int count;
	public C(int count_in, String input){
		count = count_in;
		store = new B[ count ];
		for (int i=0; i<count; i++)
			store[i] = new B(i,input+(i*10) );
	}
	public String toString(){
		String result = " C: [" + count + ", ";
		for (B b : store)
			result += b + ", ";
		return result  + "]";
	}
}
public class Part1_3 {
	private static final String file4 = Part1_1.folder + "File4";
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		System.out.println(" ----------------- writing an object containing an array to file: " + file4);

		C c1 = new C( 10, "Hello" );
		System.out.println(" Writing c1 to file: " + c1);
		write(c1);
		
		C c2 = read();
		System.out.println(" c2 read from file:  " + c2);
		
	}
	private static void write(C c) throws IOException {
		ObjectOutputStream oo = new ObjectOutputStream( new FileOutputStream(file4) );
		oo.writeObject( c );
		oo.close();		
	}
	private static C read() throws IOException, ClassNotFoundException {
		ObjectInputStream oi = new ObjectInputStream( new FileInputStream(file4) );
		C c = (C) oi.readObject();
		oi.close();
		return c;
	}
}