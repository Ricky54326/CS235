package shapes;

/**
 * Title: DrawableSquare class for CSIS 235 Assignment #4
 * Description: CS 235 Assignment #4 - DrawableSquare
 *              A class that defines a DrawableSquare - a Square that can be painted to the screen
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @email noah.muth@my.uwrf.edu
 * @date   December 13th, 2012
 * @version 1.0
 */


import java.awt.Graphics;

public class DrawableSquare extends Square implements Drawable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * DrawableSquare- a Square that is able to be painted to the screen
	 * @require x >= 0, y >= 0, size > 0
	 * @ensure none
	 */
	public DrawableSquare(int x, int y, int size) {
		super(x, y, size);
		assert x >= 0 : "x is less than 0!";
		assert y >= 0 : "y is less than 0!";
		assert size > 0 : "side length is less than 1!";
	}
	

	/**
	 * draw - paints the "rectangle" (which in this case is actually a Square) to the screen.
	 * @require none - g will be provided by JFrame
	 * @ensure none
	 */
	@Override
	public void draw(Graphics g) {
		g.drawRect(getX_position(), getY_position(), super.width(), super.width());
	}
}
