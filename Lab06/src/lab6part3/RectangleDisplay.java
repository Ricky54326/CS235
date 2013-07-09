package lab6part3;

/**
 * Title: RectangleDisplay class for CSIS 235 Lab #6
 * Description: CS 235 Lab #6 - RectangleDisplay 
 * 				This class has a main method and is the client
 * 				 of the RectangleViewer and Rectangle classes.
 * 
 * @author Ricky Mutschlechner and Tim Olmstead
 * @email  riccardo.mutschlechner@my.uwrf.edu and timothy.olmstead@my.uwrf.edu
 * @date   10/17/2012
 */

public class RectangleDisplay {

	/**
	 * main - This program starts execution here.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*Rectangle theModel;
		RectangleViewer theUserInterface;
		theModel = new Rectangle(100, 50);
		theUserInterface = new RectangleViewer();
		theUserInterface.displayRectangle(theModel);
		*/

		
		//Easier printing using toString()
		Rectangle rect = new Rectangle(30, 50);
		System.out.println(rect);
		
		Rectangle sq = new Square(10);
		System.out.println(sq);
		
		System.out.println();
		System.out.println();
		
		//Alternate unnecessary method to print the same thing. Works for squares, too
		RectangleViewer theUserInterface = new RectangleViewer();
		theUserInterface.displayRectangle(sq);
	}
}