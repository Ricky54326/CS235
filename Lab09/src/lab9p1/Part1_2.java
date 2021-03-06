package lab9p1;
/**
 * Title: Part1_2 class for CSIS 235 Lab #9
 * Description: CS 235 Lab #9 - Part1_2
 *              This class has a main method that
 *              tries to serialize and deserialize objects.
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

class B implements Serializable{
	private static final long serialVersionUID = 1L;
	private int x;
	private String y;
	public B(int x_in, String y_in){
		x = x_in; y = y_in;
	}
	public String toString(){
		return " B: [" + x + ", " + y + "]";
	}
}
public class Part1_2 {
	private static final String file2 = Part1_1.folder + "File2";
	private static final String file3 = Part1_1.folder + "File3";
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		System.out.println(" Section 1 ----------------- writing simple object to file: " + file2);

		B b1 = new B( 10, "Hello" );
		System.out.println(" Writing b1 to file: " + b1);
		write(b1);
		
		B b2 = read();
		System.out.println(" b2 read from file:  " + b2);
		
		System.out.println("\n Section 2 ----------------- writing array to file: " + file3);
		
		B[] bar = new B[3];
		for (int i=0; i < bar.length; i++){
			bar[i] = new B( i+100, "Test" + (i+10) );
			System.out.println(" Write bar[" + i + "]: " + bar[i]);
		}
		writeArray( bar );
		System.out.println();
		
		B[] foo = readArray();
		for (int i=0; i<foo.length; i++){
			System.out.println(" Read foo[" + i + "]: " + foo[i]);
		}
		
	}
	private static void write(B b) throws IOException {
		ObjectOutputStream oo = new ObjectOutputStream( new FileOutputStream(file2) );
		oo.writeObject( b );
		oo.close();		
	}
	private static B read() throws IOException, ClassNotFoundException {
		ObjectInputStream oi = new ObjectInputStream( new FileInputStream(file2) );
		B b = (B) oi.readObject();
		oi.close();
		return b;
	}
	private static void writeArray(B[] barray) throws IOException {
		ObjectOutputStream oo = new ObjectOutputStream( new FileOutputStream(file3) );
		oo.writeInt( barray.length );
		for (B b : barray)
			oo.writeObject( b );
		oo.close();		
	}
	private static B[] readArray() throws IOException, ClassNotFoundException {
		ObjectInputStream oi = new ObjectInputStream( new FileInputStream(file3) );
		int length = oi.readInt(); //The first character of the saved B is the length of the array.
		B[] temp = new B[length];
		for(int i = 0; i < length; i++){
			temp[i] = (B)oi.readObject();
		}
		oi.close();
		return temp;
	}
}