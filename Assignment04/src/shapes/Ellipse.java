package shapes;

/**
 * <p>Title: Ellipse Class</p>
 * <p>Description: CS 235 Assignment #4 - Ellipse - this class defines a Eclipse object with integer dimensions</p>
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @email noah.muth@my.uwrf.edu
 * @date   December 13th, 2012
 * @version 1.0
 */
public class Ellipse extends Shape {

	private static final long serialVersionUID = 1L;
	// Private components:
	private int major_axis;
	private int minor_axis;

	// Constructor:

	/**
	 * Create a new ellipse with the specified position and major and minor
	 * axes. The axes must be non-negative.
	 * 
	 * @require x >= 0 && y >= 0 && maj > 0 && min > 0
	 */
	public Ellipse(int x, int y, int maj, int min) {
		super(x, y);
		major_axis = maj;
		minor_axis = min;
		assert x >= 0 : "x is less than 0!";
		assert y >= 0 : "y is less than 0!";
		assert maj > 0 : "major axis is less than 1!";
		assert min > 0 : "minor axis is less than 1!";
	}
	

	// Queries:
	
	/**
	* <p>majorAxis</p>
	* <p>Description: This method computes the major axis or length of this ellipse.</p>
	* @require none
	* @ensure  none
	*/

	public int majorAxis() {
		return major_axis;
	}


	/**
	* <p>minor_axis</p>
	* <p>Description: This method computes the minor axis or width of this ellipse.</p>
	* @require none
	* @ensure  none
	*/
	public int minor_axis() {
		return minor_axis;
	}


	public boolean contains(int xn, int yn) {
		Rectangle hitBox = new Rectangle(this.getX_position(), this.getY_position(), minor_axis, major_axis);
		return hitBox.contains(xn, yn);
	}


	/**
	 * area - returns an Integer approximation of the area of the current instance of Ellipse.
	 */
	public int area() {
		return (int)(Math.PI * 0.5 * (this.majorAxis() * this.minor_axis()));
	}
}