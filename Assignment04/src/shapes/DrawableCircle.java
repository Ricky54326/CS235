package shapes;

/**
 * Title: DrawableCircle class for CSIS 235 Assignment #4
 * Description: CS 235 Assignment #4 - DrawableCircle
 *              A class that defines a DrawableCircle - a Circle that can be painted to the screen
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @email noah.muth@my.uwrf.edu
 * @date   December 13th, 2012
 * @version 1.0
 */

import java.awt.Graphics;

public class DrawableCircle extends Circle implements Drawable {
	
	/**
	 * DrawableCircle - a Circle that is able to be painted to the screen
	 * @require x >= 0, y >= 0, diameter > 0
	 * @ensure none
	 */
	public DrawableCircle(int x, int y, int diameter) {
		super(x, y, diameter);
		assert (x >= 0) : "x is less than zero!";
		assert (y >= 0) : "y is less than zero!";
		assert (diameter > 0) : "diameter is 0 or less!";
	}

	private static final long serialVersionUID = 1L;

	/**
	 * draw - paints the "oval" (Circle in this case) to the screen.
	 * @require none - g will be provided by JFrame
	 * @ensure none
	 */
	public void draw(Graphics g) {
		g.drawOval(super.getX_position(), super.getY_position(), super.diameter(), super.diameter());
	}
	
	

}
