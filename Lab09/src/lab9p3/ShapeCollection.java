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

import shapes.Shape;

public class ShapeCollection {
	/**
	 * Data members and class invariants
	 * 
	 */
	private static final int DEFAULT_INITIAL_SIZE = 10;
	private Shape[] store;
	private int size;

	public ShapeCollection() {
		store = new Shape[ DEFAULT_INITIAL_SIZE ];
		size  = 0;
	}

	public ShapeCollection(final int startsize) {
		store = new Shape[ startsize ];
		size  = 0;
	}

	public int getSize(){
		return size;
	}

	public Shape get( final int index ) {
		return store[index];
	}
	
	public void set( final Shape s ){
		store[size++] = s;
	}

	public int getCapacity() {
		return store.length;
	}
	
	public boolean hasSpace(){
		return size < store.length;
	}
	
}