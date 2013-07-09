package shapes;

import java.awt.Graphics;

/**
 * Title: FilledTriangle class for CSIS 235 Assignment #4
 * Description: CS 235 Assignment #4 - Triangle
 *              A class that draws a solid-colored Triangle to the screen
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @email noah.muth@my.uwrf.edu
 * @date   December 13th, 2012
 * @version 1.0
 */

public class FilledTriangle extends DrawableTriangle{
	private static final long serialVersionUID = 1L;
	
	/**
	 * FilledTriangle - a Triangle filled with a solid color that can be drawn to the screen
	 * @require x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0 && x3 >= 0 && y3 >= 0
	 * @ensure none
	 */
	public FilledTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		super(x1, y1, x2, y2, x3, y3);
	}
	
	public void draw(Graphics g) {
		int[] xpoints = { x1, x2, x3 };
		int[] ypoints = { y1, y2, y3 };
		
		g.setColor(java.awt.Color.CYAN);
		g.fillPolygon(xpoints, ypoints, 3);
		g.setColor(java.awt.Color.BLACK);
	}
}
