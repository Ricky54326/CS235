package a2;

/**
 * <p>Title: Ellipse Class</p>
 * <p>Description: CS 235 Assignment #2 - Ellipse - this class defines a Eclipse object with integer dimensions</p>
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
public class Ellipse extends Shape {

	// Private components:
	private int major_axis;
	private int minor_axis;

	// Constructor:

	/**
	 * Create a new ellipse with the specified position and major and minor
	 * axes. The axes must be non-negative.
	 */
	public Ellipse(int x, int y, int maj, int min) {
		super(x, y);
		major_axis = maj;
		minor_axis = min;
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
}