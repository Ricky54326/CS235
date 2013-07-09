package shapes;


/**
 * Title: DrawableRectangle class for CSIS 235 Lab #8
 * Description: CS 235 Lab #8 - DrawableRectangle
 * 				This class is used to represent a
 * 				DrawableRectangle at some position in 2 dimensions.
 * 
 * @author Ricky Mutschlechner
 * @email  riccardo.mutschlechner@my.uwrf.edu
 * @date  November 8th, 2012
 */


import java.awt.Graphics;

import java.io.Serializable;

public class DrawableRectangle extends Rectangle implements Drawable, Serializable {
	private static final long serialVersionUID = 1L;
	private int x, y, w, h;

	/**
	 * DrawableRectangle - a constructor
	 * @param x X-position
	 * @param y Y-position
	 * @param w Width
	 * @param h Height
	 * @require Non-negative values for x, y, w, h
	 * @ensure (x, y, w, h > 0), all of the values will be greater than zero or the object will not be created.
	 */
	public DrawableRectangle(int x, int y, int w, int h){
		super( x, y, w, h);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		assert x>0 : "X coordinate is less than zero";
		assert y>0 : "Y coordinate is less than zero";
		assert w>0 : "Width is less than zero.";
		assert h>0 : "Height is less than zero.";
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(x, y, w, h);
	}
}
