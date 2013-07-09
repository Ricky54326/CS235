package lab9p1;
/**
 * Title: Part1_4 class for CSIS 235 Lab #9
 * Description: CS 235 Lab #9 - Part1_4
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

class D implements Serializable{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	public D(int x_in, int y_in){
		x = x_in;
		y = y_in;
	}
	public String toString(){
		return " D: [" + x + ", " + y + "]";
	}
}
public class Part1_4 {
	private static final String file5 = Part1_1.folder + "File5";
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		System.out.println(" Section 1 ----------------- writing simple object to file: " + file5);

		/**/
		D d1 = new D( 10, 20 );
		System.out.println(" Writing d1 to file: " + d1);
		write(d1);
		/**/
		
		D d2 = read();
		System.out.println(" d2 read from file:  " + d2);
		
	}
	private static void write(D d) throws IOException {
		ObjectOutputStream oo = new ObjectOutputStream( new FileOutputStream(file5) );
		oo.writeObject( d );
		oo.close();		
	}
	private static D read() throws IOException, ClassNotFoundException {
		ObjectInputStream oi = new ObjectInputStream( new FileInputStream(file5) );
		D d = (D) oi.readObject();
		oi.close();
		return d;
	}
}