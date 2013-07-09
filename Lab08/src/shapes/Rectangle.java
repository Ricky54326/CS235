package shapes;
import java.io.Serializable;

/**
 * Title: Rectangle class for CSIS 235 Lab #8 Description: CS 235 Lab #8 -
 * Rectangle This class is used to represent a rectangle with integer
 * dimensions.
 * 
 * @author Ricky Mutschlechner
 * @email  riccardo.mutschlechner@my.uwrf.edu
 * @date  November 8th, 2012
 */

public class Rectangle extends Shape implements AreaAndPerimeter, Serializable {

	/**
	 * Had to add this in order for this to work.
	 */
	private static final long serialVersionUID = 1L;
	
	// Private components:
	private int width;
	private int height;

	// Constructor:

	/**
	 * Create a new rectangle with the specified position and dimensions. The
	 * sizes must be non-negative.
	 */
	public Rectangle(int x, int y, int w, int h) {
		super(x, y);
		width = w;
		height = h;
	}

	// Queries:

	/**
	 * The length of this rectangle.
	 */
	public int width() {
		return width;
	}

	/**
	 * The width of this rectangle.
	 */
	public int height() {
		return height;
	}
	
	/**
	 * The area of this rectangle.
	 */
	public int area(){
		return width * height;
	}
	
	/**
	 * The perimeter of this rectangle.
	 */
	public int perimeter(){
		return (2 * width) + (2 * height);
	}
}
