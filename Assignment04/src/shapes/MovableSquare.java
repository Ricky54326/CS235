package shapes;

/**
 * MovableSquare - a Square that is both Drawable and Movable on the screen.
* @author Ricky Mutschlechner
* @email riccardo.mutschlechner@my.uwrf.edu
* @author Noah Muth
* @email noah.muth@my.uwrf.edu
* @date   December 13th, 2012
* @version 1.0
*/

public class MovableSquare extends DrawableSquare implements Movable {
	
	/**
	 * Constructor for a MovableSquare
	 * @require  x >= 0 && y >= 0 && size > 0
	 */
	public MovableSquare(int x, int y, int size) {
		super(x, y, size);
		assert (x >= 0 && y >= 0 && size > 0);
	}

	private static final long serialVersionUID = 1L;

	public void move(int dx, int dy) {
		moveTo(this.getX_position()+dx, this.getY_position()+dy);
	}

}
