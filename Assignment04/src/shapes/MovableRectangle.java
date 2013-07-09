package shapes;

/**
 * MovableRectangle - a Rectangle that is both Drawable and Movable on the screen.
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @email noah.muth@my.uwrf.edu
 * @date   December 13th, 2012
 * @version 1.0
 */
public class MovableRectangle extends DrawableRectangle implements Movable{
	
	/**
	 * Constructor for a MovableRectangle
	 * @require  x >= 0 && y >= 0 && width > 0 && height > 0 
	 */
	public MovableRectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
		assert x >= 0 : "x is less than 0!";
		assert y >= 0 : "y is less than 0!";
		assert width > 0 : "width is less than 1!";
		assert height > 0 : "height is less than 1!";
	}

	private static final long serialVersionUID = 1L;

	public void move(int dx, int dy) {
		moveTo(this.getX_position()+dx, this.getY_position()+dy);
	}

}
