package l8p1;

/**
 * Title: RectangleTUI class for CSIS 235 Lab #8
 * Description: CS 235 Lab #8 - RectangleTUI
 *              This class sets up a user interface 
 *              to set up Rectangle objects.
 *              
 * @author Ricky Mutschlechner
 * @email  riccardo.mutschlechner@my.uwrf.edu
 * @date  November 8th, 2012
 */

import java.util.Scanner;
import shapes.Shape;
import shapes.Rectangle;

public class RectangleTUI1 {
	// User menu choices:
	private static final int NO_CHOICE = 0,
							 X_COORD   = 1,
							 Y_COORD   = 2,
							 WIDTH     = 3,
							 HEIGHT    = 4,
							 AREA      = 5,
							 PERIMETER = 6,
							 NEW       = 7,
							 EXIT      = 8;

	private Shape shape;
	private Scanner in;

	/**
	 * Create a user interface.
	 */
	public RectangleTUI1() {
		shape = null;
		in = new Scanner(System.in);
	}

	/**
	 * Run the user interface.
	 */
	public void start() {
		System.out.println("RectangleTUI1: enter the details of a rectangle.");
		createRectangle();
		int choice = NO_CHOICE;
		while (choice != EXIT) {
			displayMenu();
			choice = readIntWithPrompt("Enter choice: ");
			executeChoice(choice);
		}
	}

	/**
	 * Create a Rectangle with dimensions provided by the user.
	 */
	private void createRectangle() {
		int top_left_corner_x = -1;
		while (top_left_corner_x < 0)
			top_left_corner_x = readIntWithPrompt("X Position of top left corner (a non-negative integer): ");
		int top_left_corner_y = -1;
		while (top_left_corner_y < 0)
			top_left_corner_y = readIntWithPrompt("Y Position of top left corner (a non-negative integer): ");

		int width = -1;
		while (width < 0)
			width = readIntWithPrompt("Rectangle width (a non-negative integer): ");
		int height = -1;
		while (height < 0)
			height = readIntWithPrompt("Rectangle height (a non-negative integer): ");
		shape = new Rectangle(top_left_corner_x, top_left_corner_y,	width, height);
	}

	/**
	 * Display top level menu.
	 */
	private void displayMenu() {
		System.out.println();
		System.out.println("Enter the number denoting the action "
				+ "to perform:");
		System.out.println("Display position............" + X_COORD + " or " + Y_COORD);
		System.out.println("Display width..............." + WIDTH);
		System.out.println("Display height.............." + HEIGHT);
		System.out.println("Display area................" + AREA);
		System.out.println("Display perimeter..........." + PERIMETER);
		System.out.println("Create new rectangle........" + NEW);
		System.out.println("Exit........................" + EXIT);
	}

	/**
	 * Execute user's menu choice.
	 */
	private void executeChoice(int choice) {
		System.out.println();
		
		if (choice == X_COORD || choice == Y_COORD)
			System.out.println(" X coordinate is " + shape.getX_position() + " and Y coodinate is " + shape.getY_position());

		// Need a "reference-to" a Rectangle object to do get things like width and height.
		Rectangle r = (Rectangle) shape;
		if (choice == WIDTH)
			System.out.println("Width is " + r.width());
		else if (choice == HEIGHT)
			System.out.println("Height is " + r.height());
		else if (choice == AREA)
			System.out.println("Area is " + r.area());
		else if (choice == PERIMETER)
			System.out.println("Perimeter is " + r.perimeter());
		else if (choice == NEW)
			createRectangle();
		else if (choice == EXIT)
			System.out.println("Goodbye.");
	}

	/**
	 * Read an int from system in with the specified prompt.
	 */
	private int readIntWithPrompt(String prompt) {
		System.out.print(prompt);
		System.out.flush();
		while (!in.hasNextInt()) {
			in.nextLine();
			System.out.print(prompt);
			System.out.flush();
		}
		int input = in.nextInt();
		in.nextLine();
		return input;
	}
}