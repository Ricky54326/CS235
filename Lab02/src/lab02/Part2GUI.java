package lab02;
/**
 * Title: Part2GUI class for CSIS 235 Lab 2
 * Description: CS 235 Lab #1 - example program
 *    Basic object oriented GUI program used to show how to draw a shape.
 * 
 * @author Ricky Mutschlechner and Shirin Asadi
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @date September 10th 2012
 */
import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Part2GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * main method - this is a smaller main method
	 * @param args
	 */
	public static void main(String[] args) {
		new Part2GUI( FRAME_LOCATION_X, FRAME_LOCATION_Y );
		/*
		 * When we use an object oriented style, it becomes easy to
		 *  to make multiple windows. To see this, uncomment the line 
		 *  below and run. Can we do this with ASimpleGUI?
		 */
		// new Part2GUI( FRAME_LOCATION_X+FRAME_SIZE_X, FRAME_LOCATION_Y );
	}


	/*
	 * Data members used to initialize a window.
	 */
	private static String TITLE = "Lab 2: A more object-oriented GUI program";
	private static int FRAME_LOCATION_X = 100;
	private static int FRAME_LOCATION_Y = 200;
	private static int FRAME_SIZE_X     = 400;
	private static int FRAME_SIZE_Y     = 300;
	
	/*
	 * Data members used to set the sizes of shapes to
	 * be drawn inside the window.
	 */
	private Shape circle;
	private Shape rectangle;
	
	//This is for the circle.
	private static float CIRCLE_LOCATION_X = 150.0f;
	private static float CIRCLE_LOCATION_Y = 75.0f;
	private static float CIRCLE_SIZE_X     = 100.0f;
	//We do not need a SIZE_Y as this is a circle, therefore sizeX = sizeY
	
	//This is for the rectangle.
	private static float RECT_LOCATION_X = 200.0f;
	private static float RECT_LOCATION_Y = 225.0f;
	private static float RECT_SIZE_X     = 50.0f;
	private static float RECT_SIZE_Y     = 50.0f;

	
	/**
	 * Constructor - takes care of creating the window
	 *  and the shape we want to draw in it.
	 */
	public Part2GUI( int x, int y) {
		// Set up the title, location and size of the window
		super( TITLE);
		setLocation( x, y );
		setSize( FRAME_SIZE_X, FRAME_SIZE_Y );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setVisible( true );

		/* At this point, the window should be visible and we are ready to draw shapes. */
		rectangle = new Rectangle2D.Float( RECT_LOCATION_X, RECT_LOCATION_Y, RECT_SIZE_X, RECT_SIZE_Y );

		/* Pause the program for a second */

		/*
		 * Let's draw an oval shape. We have to create the new shape and add it to the
		 * "drawing area" and ask the window to repaint itself - Swing will cause
		 * the DrawArea to "refresh" itself
		*/
		
		
		//This for loop slowly moves the shapes around the screen.
		for(int i = 0; i < 100; i++){ 
			try { Thread.sleep( 200 /* milliseconds */ ); } catch (InterruptedException e) {	}
			
		Random rand = new Random();
		
		circle = new Ellipse2D.Float( CIRCLE_LOCATION_X += (rand.nextInt(50) - rand.nextInt(50)), CIRCLE_LOCATION_Y += (rand.nextInt(2) - rand.nextInt(2)), CIRCLE_SIZE_X, CIRCLE_SIZE_X );
//		repaint(); //^ this is a circle now, not an ellipse.
		


		rectangle = new Rectangle2D.Float( RECT_LOCATION_X += (rand.nextInt(30) - rand.nextInt(30)), RECT_LOCATION_Y += (rand.nextInt(2) - rand.nextInt(2)), RECT_SIZE_X, RECT_SIZE_Y);
		repaint();
		
		}
		
		/*
		 *  And, finally, add code that will make the shapes move around smoothly
		 *   for about 5 seconds inside the window
		 */
		
		

	}

	/**
	 * The paint method is called whenever the Java runtime system thinks
	 * it needs to draw or redraw something.
	 */
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		if(circle != null)
			g2d.draw( circle );
		if(rectangle != null)
			g2d.draw( rectangle );
	}
}