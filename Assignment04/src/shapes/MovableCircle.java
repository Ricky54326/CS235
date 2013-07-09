package shapes;

/**
 * Title: MovableCircle class for CSIS 235 Assignment #4
 * Description: CS 235 Assignment #4 - MovableCircle
 *              A class that defines a MovableCircle - an MovableCircle that can be painted to the screen
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @email noah.muth@my.uwrf.edu
 * @date   December 13th, 2012
 * @version 1.0
 */

public class MovableCircle extends DrawableCircle implements Movable {
	
	/**
	 * MovableCircle- a Circle that is able to be painted to the screen
	 * @require x >= 0, y >= 0, diameter > 1
	 * @ensure none
	 */
	public MovableCircle(int x, int y, int diameter) {
		super(x, y, diameter);
		assert x >= 0 : "x is less than 0!";
		assert y >= 0 : "y is less than 0!";
		assert diameter >= 1 : "diameter is less than 1!";
	}

	private static final long serialVersionUID = 1L;

	
	public void move(int dx, int dy) {
		moveTo(this.getX_position()+dx, this.getY_position()+dy);
	}

}
