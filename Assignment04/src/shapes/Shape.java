package shapes;

import java.io.Serializable;

/**
 * Title: Shape class for CSIS 235 Assignment #4
 * Description: CS 235 Assignment #4
 * 				This class is used to represent an
 * 				abstract shape at some position in 2 dimensions.
 * 
 * @author Anthony Varghese
* @author Ricky Mutschlechner
* @email riccardo.mutschlechner@my.uwrf.edu
* @author Noah Muth
* @email noah.muth@my.uwrf.edu
* @date   December 13th, 2012
* @version 1.0
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
	 * set the x_position
	 */
	public void setX_position(int newx){
		x_position = newx;
	}
	
	/**
	 * set the y_position
	 */
	public void setY_position(int newy){
		y_position = newy;
	}

	/**
	 * moveTo - move this shape to a new position.
	 * 
	 * @param xn
	 * @param yn
	 */
	public void moveTo( int xn, int yn ){
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
	
	public abstract int area();
	
	public abstract boolean contains(int xn, int yn);
	
}