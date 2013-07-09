package shapes;

/**
 * Title: Triangle class for CSIS 235 Assignment #4
 * Description: CS 235 Assignment #4 - Triangle
 *              A class that defines a Triangle
* @author Ricky Mutschlechner
* @email riccardo.mutschlechner@my.uwrf.edu
* @author Noah Muth
* @email noah.muth@my.uwrf.edu
* @date   December 13th, 2012
* @version 1.0
*/


public class Triangle extends Shape {
	private static final long serialVersionUID = 1L;
	protected int x1, y1, x2, y2, x3, y3;
	
	/**
	 * Triangle - a Triangle object
	 * 
	 * @param x1 - X-coordinate of first point
	 * @param y1 - Y-coordinate of first point
	 * @param x2 - X-coordinate of second point
	 * @param y2 - Y-coordinate of second point
	 * @param x3 - X-coordinate of third point
	 * @param y3 - Y-coordinate of third point
	 * @require x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0 && x3 >= 0 && y3 >= 0
	 */
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		super(x1, y1);
		assert (x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0 && x3 >= 0 && y3 >= 0);
		this.x1 = x1; this.y1 = y1;
		this.x2 = x2; this.y2 = y2;
		this.x3 = x3; this.y3 = y3;
	}
	
	@Override
	public int area() {
		int area = Math.abs( ( x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2) )/2 ); //This is the area-from-three-points formula
		
		return area;
	}

	@Override
	public boolean contains(int xn, int yn) {
		//Create a rectangular bounding box
		
		//First, find leftmost & rightmost points
		int leftmost;
		
		if (x1 < x2 && x1 < x3)
			leftmost = x1;
		else if (x2 < x1 && x2 < x3)
			leftmost = x2;
		else
			leftmost = x3;
		
		int rightmost;
		if (x1 > x2 && x1 > x3)
			rightmost = x1;
		else if (x2 > x1 && x2 > x3)
			rightmost = x2;
		else
			rightmost = x3;
		
		//Now, find top and bottom points
		int top;
		if (y1 < y2 && y1 < y3)
			top = y1;
		else if (y2 < y1 && y2 < y3)
			top = y2;
		else
			top = y3;
		
		int bottom;
		if (y1 > y2 && y1 > y3)
			bottom = y1;
		else if (y2 > y1 && y2 > y3)
			bottom = y2;
		else
			bottom = y3;
		
		Rectangle hitBox = new Rectangle(leftmost, top, rightmost, bottom); 
		
		return hitBox.contains(xn, yn);
	}

}
