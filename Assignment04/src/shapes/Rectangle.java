package shapes;


/**
 * Title: Rectangle class for CSIS 235 Lab #8 Description: CS 235 Lab #8 -
 * Rectangle This class is used to represent a rectangle with integer
 * dimensions.
 * 
 * @author Anthony Varghese
 * @author
 * @email your.n.here@my.uwrf.edu
 * @date October 17th 2012
 */

public class Rectangle extends Shape implements AreaAndPerimeter {

	/**
	 * Data members and class invariants
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	// Private components:
	private int width;
	private int height;

	// Constructor:

	/**
	 * Create a new rectangle with the specified position and dimensions. The
	 * sizes must be non-negative.
	 * 
	 * @require x >= 0 && y >= 0 && w > 0 && h > 0
	 */
	public Rectangle(int x, int y, int w, int h) {
		super(x, y);
		assert x >= 0 : "x is less than 0!";
		assert y >= 0 : "y is less than 0!";
		assert w > 0 : "width is less than 1!";
		assert h > 0 : "height is less than 1!";
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

	public int area() {
		return width * height;
	}

	public int perimeter() {
		return 2*(width + height);
	}
	
	public String toString(){
		return "Rectangle ";
	}
	
	public boolean contains(int x, int y){
		if((this.getX_position() <= x) && (x <= this.getX_position() + width)){
			if((this.getY_position() <= y) && (y <= this.getY_position() + height)){
				System.out.println("Shape is selected within the hitbox! Part 1 of the function.");
				return true;
			}
		}
		return false;
	}
}
