package a2;

/**
 * <p>Title: Circle Class</p>
 * <p>Description: CS 235 Assignment #2 - Circle - this class defines a Circle object with integer dimensions</p>
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

public class Circle extends Ellipse {
	
	/*
	 * Constructor for a Circle that reuses the data members from Ellipse.
	 */
	
	public Circle(int x, int y, int diameter){
		super(x, y, diameter, diameter);
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
