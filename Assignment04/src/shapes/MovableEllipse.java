package shapes;

/**
 * Title: MovableEllipse class for CSIS 235 Assignment #4
 * Description: CS 235 Assignment #4 - MovableEllipse
 *              A class that defines a MovableEllipse - an Ellipse that can be painted to the screen
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @email noah.muth@my.uwrf.edu
 * @date   December 13th, 2012
 * @version 1.0
 */


public class MovableEllipse extends DrawableEllipse implements Movable {
	
	/**
	 * MovableEllipse- an Ellipse that is able to be painted to the screen and moved around the screen
	 * @require x >= 0, y >= 0, maj > 0, min > 0
	 * @ensure none
	 */
	public MovableEllipse(int x, int y, int maj, int min) {
		super(x, y, maj, min);
		assert x >= 0 : "x is less than 0!";
		assert y >= 0 : "y is less than 0!";
		assert maj > 0 : "major axis is less than 1!";
		assert min > 0 : "minor axis is less than 1!";
	}

	private static final long serialVersionUID = 1L;

	
	public void move(int dx, int dy) {
		moveTo(this.getX_position()+dx, this.getY_position()+dy);
	}

}
