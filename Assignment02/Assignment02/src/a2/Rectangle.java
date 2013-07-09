package a2;

/**
 * <p>Title: Circle Class</p>
 * <p>Description: CS 235 Assignment #2 - Circle - this class defines a rectangle object with integer dimensions</p>
 * @author Ricky Mutschlechner
 * @role   Primary Coordinator, secondary Recorder
 * @email  riccardo.mutschlechner@my.uwrf.edu
 * @author Tim Olmstead
 * @role   Primary Recorder
 * @email  timothy.olmstead@my.uwrf.edu
 * @author Hao Chen
 * @role   Secondary recorder, Primary Checker
 * @email  hao.chen@my.uwrf.edu
 * @date   November 1st 2012
 */

public class Rectangle extends Shape {

	// Private components:
	private int length;
	private int width;

	// Constructor:

	/**
	 * Create a new rectangle with the specified position and dimensions.
	 * The sizes must be non-negative.
	 */
	public Rectangle(int x, int y, int maj, int min) {
		super( x, y );
		length = maj;
		width = min;
	}

	// Queries:
	
	/**
	* <p>length</p>
	* <p>Description: This method computes the length of this rectangle.</p>
	* @require none
	* @ensure  none
	*/
	public int length() {
		return length;
	}

	/**
	 * <p>width</p>
	* <p>Description: This method computes the width of this rectangle.</p>
	* @require none
	* @ensure  none
	*/
	public int width() {
		return width;
	}
}
