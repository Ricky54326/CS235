package a2;

/**
 * <p>Title: Square Class</p>
 * <p>Description: CS 235 Assignment #2 - Square - this class defines a Square object</p>
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

public class Square extends Rectangle {
	
	public Square(int x, int y, int size){
		super(x, y, size, size); //"Size" is the length of a side
	}
	
	/**
	 * size
	 * Query method that returns the size (length of a side) of the current Square.
	 * @require none
	 * @ensure none
	 */
	public int size(){
		return super.length();
	}
	
	
}
