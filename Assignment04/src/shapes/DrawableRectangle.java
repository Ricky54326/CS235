package shapes;

/**
 * Title: DrawableRectangle class for CSIS 235 Assignment #4
 * Description: CS 235 Assignment #4 - DrawableRectangle
 *              A class that defines a DrawableRectangle - a Rectangle that can be painted to the screen
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @email noah.muth@my.uwrf.edu
 * @date   December 13th, 2012
 * @version 1.0
 */

import java.awt.Graphics;

public class DrawableRectangle extends Rectangle implements Drawable{

	private static final long serialVersionUID = 1L;

	/**
	 * DrawableRectangle- a Rectangle that is able to be painted to the screen
	 * @require x >= 0, y >= 0, w > 0, h > 0
	 * @ensure none
	 */
	public DrawableRectangle(int x, int y, int w, int h){
		super( x, y, w, h);
		assert x >= 0 : "x is less than 0!";
		assert y >= 0 : "y is less than 0!";
		assert w > 0 : "width is less than 1!";
		assert h > 0 : "height is less than 1!";
	}
	/**
	 * draw - paints the "rectangle" (which in this case is actually a Rectangle) to the screen.
	 * @require none - g will be provided by JFrame
	 * @ensure none
	 */
	public void draw(Graphics g) {
		g.drawRect(getX_position(), getY_position(), width(), height() );
	}
	
	public String toString(){
		return "DrawableRectangle";
	}
}
