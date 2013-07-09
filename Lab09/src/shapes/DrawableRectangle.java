package shapes;

/**
 * <p>Title: RectangleGUI</p>
 * <p>Description: RectangleGUI
 *       Shows how to get started with displaying rectangles in a window.</p>
 * @author Ricky Mutschlechner
 * @date   November 16th 2012
 * @version 1.0
 */

import java.awt.Graphics;

public class DrawableRectangle extends Rectangle implements Drawable{
	/**
	 * Data members and class invariants
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrawableRectangle(int x, int y, int w, int h){
		super( x, y, w, h);
	}

	public void draw(Graphics g) {
		g.drawRect(getX_position(), getY_position(), width(), height() );
	}
	
	public String toString(){
		return "DrawableRectangle";
	}
}
