package a2;
/**
 * <p>Title: Shape Class</p>
 * <p>Description: CS 235 Assignment #2 - Shape - this class defines a Shape object </p>
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
public abstract class Shape {
	protected int x_position;
	protected int y_position;
	
	// the constructor to create a shape with the specified x and y position
	protected Shape( int x, int y){
		x_position = x;
		y_position = y; 
	}
}