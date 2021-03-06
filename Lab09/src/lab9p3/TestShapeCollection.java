package lab9p3;


/**
 * Title: Part3 class for CSIS 235 Lab #9
 * Description: CS 235 Lab #9 - Part2
 *              This class has a main method that
 *              calls methods in a RectangleGUI object.
 * @author Ricky Mutschlechner
 * @date   November 16th 2012
 * @version 1.0
 */

import shapes.DrawableRectangle;
import shapes.Rectangle;
import shapes.Shape;

public class TestShapeCollection {
	// Constants used to generate random numbers.
	private static final int X_MIN = -100,
							 X_MAX = 100,
							 Y_MIN = -100,
							 Y_MAX = 100,
							 MIN_WIDTH = 1,
							 MAX_WIDTH = 40,
							 MIN_HEIGHT  = 1,
							 MAX_HEIGHT  = 50;

	/**
	 * main - this is where the TestShapeCollection program starts
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("TestShapeCollection testing collection c1:");

		// Test the default constructor
		ShapeCollection c1 = new ShapeCollection();

		// Test adding an object and also test the Rectangle constructor
		c1.set( new Rectangle( -10, 25, 300, 840 ) );

		// Test adding another object and the DrawableRectangle constructor
		c1.set( new DrawableRectangle( 34, -95, 335, 672 ) );
		
		// Test the hasSpace method 
		while ( c1.hasSpace() ){
			int x = Shape.random(X_MIN, X_MAX);
			int y = Shape.random(Y_MIN, Y_MAX);
			int wid = Shape.random(MIN_WIDTH, MAX_WIDTH);
			int ht  = Shape.random(MIN_HEIGHT,  MAX_HEIGHT);
			
			c1.set( new Rectangle( x, y, wid, ht) );
		}

		// Test the getSize and getCapacity methods
		if (c1.getSize() == c1.getCapacity())
			System.out.print("  The collection c1 is full.");
		else if (c1.getSize() < c1.getCapacity())
			System.out.print("  There is more room in collection c1.");
		System.out.println(" There are " + c1.getSize() + " shapes in c1.");
		
		// Test the getSize and get methods
		for (int i=0; i<c1.getSize(); i++)
			System.out.println("   Shape: " + c1.get(i) );
		
		System.out.println("\n\nTestShapeCollection testing collection c2:");

		// Test the second constructor of the ShapeCollection class
		ShapeCollection c2 = new ShapeCollection(23);
		while ( c2.hasSpace() ){
			int x = Shape.random(X_MIN, X_MAX);
			int y = Shape.random(Y_MIN, Y_MAX);
			int wid = Shape.random(MIN_WIDTH, MAX_WIDTH);
			int ht  = Shape.random(MIN_HEIGHT,  MAX_HEIGHT);
			
			c2.set( new Rectangle( x, y, wid, ht) );
		}
		
		if (c2.getSize() == c2.getCapacity())
			System.out.print("  The collection c2 is full.");
		else if (c2.getSize() < c2.getCapacity())
			System.out.print("  There is more room in collection c2.");
		System.out.println(" There are " + c2.getSize() + " shapes in c2.");

		for (int i=0; i<c2.getSize(); i++)
			System.out.println("   Shape: " + c2.get(i) );
		
	}
}