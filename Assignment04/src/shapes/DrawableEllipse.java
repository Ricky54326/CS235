package shapes;

/**
 * Title: DrawableEllipse class for CSIS 235 Assignment #4
 * Description: CS 235 Assignment #4 - DrawableEllipse
 *              A class that defines a DrawableEllipse - an Ellipse that can be painted to the screen
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @email noah.muth@my.uwrf.edu
 * @date   December 13th, 2012
 * @version 1.0
 */

import java.awt.Graphics;

public class DrawableEllipse extends Ellipse implements Drawable {
	
	/**
	 * DrawableEllipse- an Ellipse that is able to be painted to the screen
	 * @require x >= 0, y >= 0, maj > 0, min > 0
	 * @ensure none
	 */
	public DrawableEllipse(int x, int y, int maj, int min) {
		super(x, y, maj, min);
		assert x >= 0 : "x is less than 0!";
		assert y >= 0 : "y is less than 0!";
		assert maj > 0 : "major axis is less than 1!";
		assert min > 0 : "minor axis is less than 1!";
	}

	private static final long serialVersionUID = 1L;

	/**
	 * draw - paints the "oval" (Ellipse in this case) to the screen.
	 * @require none - g will be provided by JFrame
	 * @ensure none
	 */
	public void draw(Graphics g) {
		g.drawOval(super.getX_position(), super.getY_position(), super.minor_axis(), super.majorAxis());
	}

}
