package shapes;

/**
 * Title: MovableTriangle class for CSIS 235 Assignment #4
 * Description: CS 235 Assignment #4 - MovableTriangle
 *              Creates a Triangle that is both Movable and Drawable on the screen.
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @email noah.muth@my.uwrf.edu
 * @date   December 4th, 2012
 * @version 1.0
 */

public class MovableTriangle extends DrawableTriangle implements Movable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * MovableTriangle - a Triangle that can be drawn to the screen and moved around
	 * @param x1 - X-coordinate of first point
	 * @param y1 - Y-coordinate of first point
	 * @param x2 - X-coordinate of second point
	 * @param y2 - Y-coordinate of second point
	 * @param x3 - X-coordinate of third point
	 * @param y3 - Y-coordinate of third point
	 * @require x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0 && x3 >= 0 && y3 >= 0
	 * @ensure none
	 */
	public MovableTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		super(x1, y1, x2, y2, x3, y3);
		assert (x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0 && x3 >= 0 && y3 >= 0);
	}
	
	public void move(int dx, int dy) {
		
		moveTo(this.x1+dx, this.y1+dy);
		this.x2 += dx;
		this.y2 += dy;
		this.x3 += dx;
		this.y3 += dy;
	}
}
