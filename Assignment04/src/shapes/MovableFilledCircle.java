package shapes;


/**
 * Title: DrawableEllipse class for CSIS 235 Assignment #4
 * Description: CS 235 Assignment #4 - MovableFilledCircle
 *              A class that defines a MovableFilledCircle - a MovableFilledCircle that can be painted to the screen
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @email noah.muth@my.uwrf.edu
 * @date   December 13th, 2012
 * @version 1.0
 */

public class MovableFilledCircle extends FilledCircle implements Movable {
	private static final long serialVersionUID = 1L;

	
	/**
	 * Creates a MovableFilledCircle object.
	 * @param x
	 * @param y
	 * @param diameter
	 * @require x >= 0 && y >= 0 && diameter > 0
	 */
	public MovableFilledCircle(int x, int y, int diameter){
		super(x, y, diameter); 
		assert (x >= 0) : "x is less than zero!";
		assert (y >= 0) : "y is less than zero!";
		assert (diameter > 0) : "diameter is 0 or less!";
	}

	@Override
	public void move(int dx, int dy) {
		moveTo(this.getX_position()+dx, this.getY_position()+dy);
	}
	
}
