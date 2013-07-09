package shapes;


/**
 * Title: DrawableEllipse class for CSIS 235 Assignment #4
 * Description: CS 235 Assignment #4 - MovableFilledEllipse
 *              A class that defines a MovableFilledEllipse - a MovableEllipse that can be painted to the screen
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @email noah.muth@my.uwrf.edu
 * @date   December 13th, 2012
 * @version 1.0
 */

public class MovableFilledEllipse extends FilledEllipse implements Movable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * MovableFilledEllipse- an Ellipse that is able to be painted to the screen and Movable, as well as solid colored.
	 * @require x >= 0, y >= 0, maj > 0, min > 0
	 * @ensure none
	 */
	public MovableFilledEllipse(int x, int y, int height, int width){
		super(x, y, height, width); 
		assert x >= 0 : "x is less than 0!";
		assert y >= 0 : "y is less than 0!";
		assert height > 0 : "major axis is less than 1!";
		assert width > 0 : "minor axis is less than 1!";
	}

	@Override
	public void move(int dx, int dy) {
		moveTo(this.getX_position()+dx, this.getY_position()+dy);
	}
	
}
