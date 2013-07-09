package shapes;
/**
 * MovableFilledTriangle - a Triangle that is both Movable and Drawable as well as solid in color
* @author Ricky Mutschlechner
* @email riccardo.mutschlechner@my.uwrf.edu
* @author Noah Muth
* @email noah.muth@my.uwrf.edu
* @date   December 13th, 2012
* @version 1.0
*/

public class MovableFilledTriangle extends FilledTriangle implements Movable {

	/**
	 * MovableFilledTriangle - a Triangle object that is both Movable and Drawable as well as solid in color.
	 * 
	 * @param x1 - X-coordinate of first point
	 * @param y1 - Y-coordinate of first point
	 * @param x2 - X-coordinate of second point
	 * @param y2 - Y-coordinate of second point
	 * @param x3 - X-coordinate of third point
	 * @param y3 - Y-coordinate of third point
	 * @require x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0 && x3 >= 0 && y3 >= 0
	 */
	public MovableFilledTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		super(x1, y1, x2, y2, x3, y3);
		assert (x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0 && x3 >= 0 && y3 >= 0);
	}

	/**
	 * move - moves the triangle
	 * 
	 * This is different from the other shapes because the Triangle shape tracks three points instead of just one.
	 */
	public void move(int dx, int dy) {
		moveTo(x1+dx, y1+dy);
		x2 += dx;
		y2 += dy;
		x3 += dx;
		y3 += dy;
	}
}
