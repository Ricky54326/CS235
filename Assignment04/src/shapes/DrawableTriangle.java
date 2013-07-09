package shapes;

/**
 * Title: DrawableTriangle class for CSIS 235 Assignment #4
 * Description: CS 235 Assignment #4 - DrawableTriangle
 *              A class that defines a DrawableTriangle - a Triangle that can be painted to the screen
 * @author Noah Muth
 * @email noah.muth@uwrf.edu
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @date   December 11th 2012
 * @version 1.0
 */

import java.awt.Graphics;
import java.awt.Color;


public class DrawableTriangle extends Triangle implements Drawable{
    private static final long serialVersionUID = 1L;
    
	/**
	 * DrawableTriangle - a Triangle object that can be drawn to the screen
	 * 
	 * @param x1 - X-coordinate of first point
	 * @param y1 - Y-coordinate of first point
	 * @param x2 - X-coordinate of second point
	 * @param y2 - Y-coordinate of second point
	 * @param x3 - X-coordinate of third point
	 * @param y3 - Y-coordinate of third point
	 * @require x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0 && x3 >= 0 && y3 >= 0
	 */
    public DrawableTriangle(int x, int y, int x2, int y2, int x3, int y3) {
        super(x, y, x2, y2, x3, y3);
        assert(x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0 && x3 >= 0 && y3 >= 0) : "Points must all be positive!";
    }

    public void draw(Graphics g) {
    	g.setColor( java.awt.Color.BLUE );
        g.drawLine(getX_position(), getY_position(), x2, y2);
    	g.setColor(java.awt.Color.RED);
        g.drawLine(x2, y2, x3, y3);
    	g.setColor(java.awt.Color.GREEN);
        g.drawLine(getX_position(), getY_position(), x3, y3);

        int[] x = { getX_position(), x2, x3 };
        int[] y = { getY_position(), y2, y3 };
        //g.drawPolygon(x, y, 3);
    }
}
