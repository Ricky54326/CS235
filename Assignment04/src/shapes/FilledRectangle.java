package shapes;

/**
 * Title: FilledRectangle class for CSIS 235 Assignment #4
 * Description: CS 235 Assignment #4 - FilledRectangle
 *              A class that defines a FilledRectangle - a FilledRectangle that can be painted to the screen
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @email noah.muth@my.uwrf.edu
 * @date   December 13th, 2012
 * @version 1.0
 */


import java.awt.Graphics;

public class FilledRectangle extends DrawableRectangle{
	private static final long serialVersionUID = 1L;
	
	/**
	 * DrawableSquare- a Square that is able to be painted to the screen
	 * @require x >= 0, y >= 0, size > 0
	 * @ensure none
	 */
	public FilledRectangle(int x, int y, int height, int width) {
		super(x, y, height, width);
		assert x >= 0 : "x is less than 0!";
		assert y >= 0 : "y is less than 0!";
		assert height > 0 : "height is less than 1!";
		assert width > 0 : "width is less than 1!";
	}
	

	/**
	 * draw - paints the "rectangle" (which in this case is actually a Square) to the screen.
	 * @require none - g will be provided by JFrame
	 * @ensure none
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(java.awt.Color.RED);
		g.fillRect(this.getX_position(), this.getY_position(), this.height(), this.width());
		g.setColor(java.awt.Color.BLACK);
	}
	
	
	public boolean contains(int x, int y){
		Rectangle hitbox = new Rectangle(this.getX_position(), this.getY_position(), this.height(), this.width());
		if (hitbox.contains(x, y)){
			System.out.println("The Square is selected within the rectangle hitbox! Part 2 of the function.");
			return true;
		}
		else
			return false;
	}
}
