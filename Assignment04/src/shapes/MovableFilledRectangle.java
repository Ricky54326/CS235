package shapes;

import java.awt.Graphics;

/**
 * <p>Title: MovableFilledRectangle Class</p>
 * <p>Description: CS 235 Assignment #4 - MovableFilledRectangle- this class defines a Movable FilledRectangle object</p>
 * @author Ricky Mutschlechner
 * @role   Coordinator, Recorder
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @role Coordinator, Checker
 * @email noah.muth@my.uwrf.edu
 * 
 */

public class MovableFilledRectangle extends FilledRectangle implements Movable {
	private static final long serialVersionUID = 1L;

	
	/**
	 * Constructor for a MovableFilledRectangle
	 * @require  x >= 0 && y >= 0 && width > 0 && height > 0 
	 */
	public MovableFilledRectangle(int x, int y, int height, int width){
		super(x, y, height, width); 
		assert x >= 0 : "x is less than 0!";
		assert y >= 0 : "y is less than 0!";
		assert width > 0 : "width is less than 1!";
		assert height > 0 : "height is less than 1!";
	}
	
	
	/**
	 * draw - paints the "rectangle" (which in this case is actually a Square) to the screen.
	 * @require none - g will be provided by JFrame
	 * @ensure none
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(java.awt.Color.RED);
		g.fillRect(getX_position(), getY_position(), super.height(), super.width());
		g.setColor(java.awt.Color.BLACK);
	}

	@Override
	public void move(int dx, int dy) {
		moveTo(this.getX_position()+dx, this.getY_position()+dy);
	}
	
}
