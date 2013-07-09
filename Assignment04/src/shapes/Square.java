package shapes;

/**
 * Title: Square Class
 * Description: CS 235 Assignment #4 - Square - this class defines a Square object
* @author Ricky Mutschlechner
* @email riccardo.mutschlechner@my.uwrf.edu
* @author Noah Muth
* @email noah.muth@my.uwrf.edu
* @date   December 13th, 2012
* @version 1.0
*/

public class Square extends Rectangle {
	private static final long serialVersionUID = 1L;

	/**
	 * Square- a Square object
	 * @require x >= 0, y >= 0, size > 0
	 * @ensure none
	 */
	public Square(int x, int y, int size){
		super(x, y, size, size); //"Size" is the length of a side
		assert x >= 0 : "x is less than 0!";
		assert y >= 0 : "y is less than 0!";
		assert size > 0 : "side length is less than 1!";
	}
	
	/**
	 * size - returns the side length of this Square
	 * @require none
	 * @ensure none
	 */
	public int size(){
		return super.width();
	}
	
}
