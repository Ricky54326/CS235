package shapes;

import java.awt.Graphics;

/**
 * <p>Title: MovableFilledSquare Class</p>
 * <p>Description: CS 235 Assignment #4 - MovableFilledSquare - this class defines a Movable FilledSquare object</p>
 * @author Ricky Mutschlechner
 * @role   Coordinator, Recorder
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @role Coordinator, Checker
 * @email noah.muth@my.uwrf.edu
 * 
 */

public class MovableFilledSquare extends FilledSquare implements Movable {
	private static final long serialVersionUID = 1L;

	/**
	 * MovableFilledSquare - a square that is Movable, Drawable and solid in color.
	 * @param x
	 * @param y
	 * @param size
	 */
	public MovableFilledSquare(int x, int y, int size){
		super(x, y, size); //"Size" is the length of a side
		assert x >= 0 : "x is less than 0!";
		assert y >= 0 : "y is less than 0!";
		assert size > 0 : "side length is less than 1!";
	}
	
	/**
	 * size - returns the side length of this Square
	 * @require none
	 * @ensure none
	 */
	public int size(){
		return super.width();
	}
	
	/**
	 * draw - paints the "rectangle" (which in this case is actually a Square) to the screen.
	 * @require none - g will be provided by JFrame
	 * @ensure none
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(java.awt.Color.GREEN);
		g.fillRect(getX_position(), getY_position(), super.width(), super.width());
		g.setColor(java.awt.Color.BLACK);
	}

	@Override
	public void move(int dx, int dy) {
		moveTo(this.getX_position()+dx, this.getY_position()+dy);
	}
	
}
