package lab6part3;

/**
 * Title: RectangleDisplay class for CSIS 235 Lab #6 Description: CS 235 Lab #6
 * - RectangleDisplay This class implements simple text based Rectangle viewer.
 * 
 * @author Ricky Mutschlechner and Tim Olmstead
 * @email  riccardo.mutschlechner@my.uwrf.edu and timothy.olmstead@my.uwrf.edu
 * @date   10/17/2012
 */
public class RectangleViewer {

	/**
	 * Describe the specified Rectangle.
	 */
	public void displayRectangle(Rectangle rectangle) {
		int outputValue = rectangle.length();
		System.out.println("length: " + outputValue);

		outputValue = rectangle.width();
		System.out.println("width: " + outputValue);

		outputValue = rectangle.area();
		System.out.println("area: " + outputValue);

		outputValue = rectangle.perimeter();
		System.out.println("perimeter: " + outputValue);
	}
}