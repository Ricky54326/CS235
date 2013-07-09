package a2;

import java.util.Scanner;

/**
 * <p>Title: ShapeUserInterface Class</p>
 * <p>Description: CS 235 Assignment #2 - ShapeUserInterface - A simple text-based user interface for creating and printing a list of shapes. </p>
 * @author Ricky Mutschlechner
 * @role   Primary Coordinator, secondary Recorder
 * @email  riccardo.mutschlechner@my.uwrf.edu
 * @author Tim Olmstead
 * @role   Primary Recorder
 * @email  timothy.olmstead@my.uwrf.edu
 * @author Hao Chen
 * @role   Secondary recorder, Primary Checker
 * @email  hao.chen@my.uwrf.edu
 * @date   November 1st 2012
 */


public class ShapeUserInterface {
	// Data members -------------------------------------------------------
	// User menu choices:
	private static final int NO_CHOICE = 0;
	private static final int NEW_ELLIPSE = 1;
	private static final int NEW_RECTANGLE = 2;
	private static final int NEW_CIRCLE = 3;
	private static final int NEW_SQUARE = 4;
	private static final int DISPLAY = 5;
	private static final int EXIT = 6;

	private ShapeCollection shapes;
	private Scanner in;
	private java.io.PrintStream out = System.out;

	/**
	 * Create a user interface.
	 */
	public ShapeUserInterface() {
		shapes = new ShapeCollection();
		in = new Scanner(System.in);
	}

	/**
	 * <p>
	 * start - This method computes to run the user interface
	 * </p>
	 * 
	 * @require none
	 * @ensure none
	 */
	public void start() {
		int choice = NO_CHOICE;
		while (choice != EXIT) {
			displayMenu();
			choice = readIntWithPrompt("Enter choice: ");
			executeChoice(choice);
		}
	}

	// Constants used to generate random numbers.
	private static final int X_MIN = 0;
	private static final int X_MAX = 100;
	private static final int Y_MIN = 0;
	private static final int Y_MAX = 100;
	private static final int MIN_LENGTH = 1;
	private static final int MAX_LENGTH = 40;
	private static final int MIN_WIDTH = 1;
	private static final int MAX_WIDTH = 50;

	/**
	 * <p>
	 * random - This method computes to return a random number between min
	 * and max
	 * </p>
	 * 
	 * @param int min – used to get the minimum value
	 * @param int max - used to get the maximum value
	 * @require
	 * @ensure a random number
	 */
	private int random(final int min, final int max) {
		return min + (int) (Math.random() * (max - min));
	}

	/**

	 * <p>
	 * createShape - this method creates a shape based on what menu option you choose
	 * </p>
	 * 
	 * @param int choice - the choice of Shape that the user selected at the menu
	 * @require none
	 * @ensure the Shape selected will be stored and set into the Shape collection.
	 */
	private void createShape(final int choice) {
		int x = random(X_MIN, X_MAX);
		int y = random(Y_MIN, Y_MAX);
		int length = random(MIN_LENGTH, MAX_LENGTH);
		int width = random(MIN_WIDTH, MAX_WIDTH);

		if (shapes.getSize() > 9)
			System.err
					.println("The Shape collection is full, unable to create and add another Shape.");

		else {
			switch (choice) {
			case NEW_ELLIPSE:
				shapes.set(new Ellipse(x, y, length, width));
				out.println("Created an ellipse");
				System.out.println(" at: [" + x + ", " + y
						+ "] with dimensions: " + length + " by " + width);
				break;
			case NEW_RECTANGLE:
				shapes.set(new Rectangle(x, y, length, width));
				out.println("Created a rectangle");
				System.out.println(" at: [" + x + ", " + y
						+ "] with dimensions: " + length + " by " + width);
				break;
			case NEW_CIRCLE:
				shapes.set(new Circle(x, y, length));
				out.println("Created a circle");
				System.out.println(" at: [" + x + ", " + y
						+ "] with a diameter of: " + length);
				break;
			case NEW_SQUARE:
				shapes.set(new Square(x, y, width));
				out.println("Created a square");
				System.out.println(" at: [" + x + ", " + y
						+ "] with dimensions: " + length + " by " + length);
				break;
			default:
				System.err.println("Error: Cannot create shape");
				break;
			}

		}
	}

	/**
	 * displayMenu - Display top level menu.
	 * 
	 * @require none
	 * @ensure none
	 */
	private void displayMenu() {
		out.println("\nEnter the number denoting the action to perform:"
				+ "\nCreate new ellipse ........." + NEW_ELLIPSE
				+ "\nCreate new rectangle ......." + NEW_RECTANGLE
				+ "\nCreate new circle .. ......." + NEW_CIRCLE
				+ "\nCreate new square .........." + NEW_SQUARE
				+ "\nDisplay shapes.............." + DISPLAY
				+ "\nExit........................" + EXIT + "\n");
	}

	/**
	 * executeChoice - Determines whether your choice was to create a shape, or
	 * exit the program
	 * 
	 * @param int choice - Menu choice selected
	 * @require none
	 * @ensure none
	 */
	private void executeChoice(final int choice) {
		switch (choice) {
		default:
			createShape(choice);
			break;
		case EXIT:
			out.println("Goodbye.");
			break;
		case DISPLAY:
			displayShapes();
			break;
		}
	}

	/**
	 * displayShapes - Displays all of the members of the Shape Collection.
	 * 
	 * @param final int choice - Menu choice selected
	 * @require none
	 * @ensure none
	 */
	private void displayShapes() {
		int size = shapes.getSize();
		for (int i = 0; i < size; i++) {
			Shape s = shapes.get(i);
			System.out.println(s);
		}
	}

	/**
	 * readIntWithPrompt - Reads an integer from system in (keyboard) with the
	 * supplied prompt.
	 * 
	 * @param String
	 *            prompt - The user's input number that determines which action
	 *            is completed.
	 * @require none
	 * @ensure none
	 */
	private int readIntWithPrompt(String prompt) {
		out.print(prompt);
		out.flush();
		while (!in.hasNextInt()) {
			in.nextLine();
			out.print(prompt);
			out.flush();
		}
		int input = in.nextInt();
		in.nextLine();
		return input;
	}
}