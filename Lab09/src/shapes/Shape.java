package shapes;

import java.io.Serializable;

/**
 * Title: Shape class for CSIS 235 Lab #8
 * Description: CS 235 Lab #8 - Shape
 * 				This class is used to represent an
 * 				abstract shape at some position in 2 dimensions.
 * 
 * @author Anthony Varghese
 * @author
 * @email your.n.here@my.uwrf.edu
 * @date October 17th 2012
 */

public abstract class Shape implements Serializable {
	/**
	 * Data members and class invariants
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x_position;
	private int y_position;
	

	protected Shape( int x, int y){
		x_position = x;
		y_position = y; 
	}

	/**
	 * @return the x_position
	 */
	public int getX_position() {
		return x_position;
	}


	/**
	 * @return the y_position
	 */
	public int getY_position() {
		return y_position;
	}

	/**
	 * moveTo - move this shape to a new position.
	 * 
	 * @param xn
	 * @param yn
	 */
	protected void moveTo( int xn, int yn ){
		x_position = xn;
		y_position = yn;
	}
	
	/**
	 * 
	 * @param min
	 * @param max
	 * @return a random number between min and max.
	 */
	public static int random(final int min, final int max){
		return min + (int)(Math.random() *(max-min));
	}
	
}