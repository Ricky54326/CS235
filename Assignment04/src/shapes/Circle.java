package shapes;

/**
 * <p>Title: Circle Class</p>
 * <p>Description: CS 235 Assignment #4 - Circle - this class defines a Circle object with integer dimensions</p>
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @email noah.muth@my.uwrf.edu
 * @date   December 13th, 2012
 * @version 1.0
 */

public class Circle extends Ellipse {
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor for a Circle that reuses the data members from Ellipse.
	 * @require x >= 0 && y >= 0 && diameter > 0
	 */


	public Circle(int x, int y, int diameter){
		super(x, y, diameter, diameter);
		assert (x >= 0) : "x is less than zero!";
		assert (y >= 0) : "y is less than zero!";
		assert (diameter > 0) : "diameter is 0 or less!";
	}
	
	/**
	* <p>diameter</p>
	* <p>Description: Query method that returns the diameter of the current Circle.</p>
	* @require none
	* @ensure none
	*/
	public int diameter(){
		return super.majorAxis(); //Returns the "diameter" of the Circle
	}
	
}
