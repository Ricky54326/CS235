package l8p4;

/**
 * <p>Title: RectangleGUI</p>
 * <p>Description: RectangleGUI
 *       Shows how to get started with displaying rectangles in a window.</p>
 *       Used some of the Oracle Tutorials for help with actionListener and JFileChooser as well as the Java SE 7 API.
 * @author Ricky Mutschlechner
 * @email  riccardo.mutschlechner@my.uwrf.edu
 * @date  November 8th, 2012
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import shapes.DrawableRectangle;
import shapes.Shape;

import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import shapes.Rectangle;

public class RectangleGUI extends JFrame implements ActionListener, Serializable {
	/**
	 * Data members
	 * serialVersionUID is for serialization - ignore this for now.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Position and size of the window frame
	private static final int FRAME_X_POSITION = 200, FRAME_Y_POSITION = 100,
							 FRAME_WIDTH = 400, FRAME_HEIGHT = 300;

	private JLabel text; // Tells user what to do
	private String DESCRIPTION = "Let's draw rectangles.";
	// Position and size of the description label
	private static final int LABEL_TOP_LEFT_X = 30, // pixels from left edge of window
							 LABEL_TOP_LEFT_Y = 0, // pixels from top edge of window
							 LABEL_WIDTH = FRAME_WIDTH - 2*30, // pixels wide
							 LABEL_HEIGHT = 30;   // pixels high
	
	
	private static final int SAVE_BUTTON_X = 5;
	private static final int SAVELOAD_BUTTON_Y = 215;

	// shape refers to a Shape object
	private static Shape shape;

	private JFileChooser fc;
	private JButton drawButton; // Allows us to draw shapes in a list
	private JButton drawButton2;
	private JButton drawButton3;
	
	// Position and size of the delete button
	private static final int BUTTON_TOP_LEFT_X = LABEL_TOP_LEFT_X + 200, // pixels from left edge of window
							 BUTTON_TOP_LEFT_Y = LABEL_TOP_LEFT_Y, // pixels from top edge of window
							 BUTTON_WIDTH = 90, // pixels wide
							 BUTTON_HEIGHT = 35;   // pixels high
	
	/**
	 * RectangleGUI default constructor
	 * @require none
	 * @ensure setUpWindow() will be called - A GUI will be set up for the Rectangle
	 */
	public RectangleGUI(){
		super("Graphical User Interface for a Rectangle");
		setUpWindow();
	}

	/**
	 * setUpWindow - add all the doo-dads we need in the window.
	 * 
	 */
	private void setUpWindow() {
		setBounds( FRAME_X_POSITION, FRAME_Y_POSITION, FRAME_WIDTH, FRAME_HEIGHT);
		// Without the next line, the program is still running even if the window is "closed"
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// We want to position our components - labels and buttons - ourselves. So disable
		//   any default layout managers that might try to position things
		setLayout( null );
		
		text = new JLabel( DESCRIPTION );
		text.setBounds(LABEL_TOP_LEFT_X, LABEL_TOP_LEFT_Y, LABEL_WIDTH, LABEL_HEIGHT);
		add( text );
		
		
		drawButton = new JButton("Draw");
		drawButton.setBounds(BUTTON_TOP_LEFT_X, BUTTON_TOP_LEFT_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
		add( drawButton );
		drawButton.addActionListener(this);
		
		
		drawButton2 = new JButton("Save");
		drawButton2.setBounds(SAVE_BUTTON_X, SAVELOAD_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
		add(drawButton2);
		drawButton2.addActionListener(this);
		
		drawButton3 = new JButton("Load");
		drawButton3.setBounds(SAVE_BUTTON_X+BUTTON_WIDTH, SAVELOAD_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
		add(drawButton3);
		drawButton3.addActionListener(this);
		
		//Experimental, but working
		fc = new JFileChooser();
		add(fc);
		
	}

	/**
	 * actionPerformed method for MainClient
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Action performed is " +arg0.getActionCommand());
		
		if(arg0.getSource() == drawButton){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( BUTTON_TOP_LEFT_Y + BUTTON_HEIGHT , FRAME_HEIGHT);
			final int width = Shape.random( 1 , FRAME_WIDTH);
			final int height  = Shape.random( 1 , FRAME_HEIGHT -(BUTTON_TOP_LEFT_Y + BUTTON_HEIGHT) );
			shape = new DrawableRectangle( x, y, width, height );
			repaint();
		}
		
		else if(arg0.getSource() == drawButton2){
			int returnVal = fc.showOpenDialog(RectangleGUI.this);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File file = fc.getSelectedFile();
				saveRectangle(file);
			}
		}
		
		else if(arg0.getSource() == drawButton3){
			int returnVal = fc.showOpenDialog(RectangleGUI.this);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					File file = fc.getSelectedFile();
					loadRectangle(file);
				}
			repaint(); //Must repaint here since we cannot repaint from the loadRectangle method
		}
	}

	/**
	 * Paint method - this is where our shapes get drawn.
	 */
	public void paint(java.awt.Graphics graphics) {
		super.paint(graphics);
		if (shape != null)
			((DrawableRectangle)shape).draw(graphics);
	}
	
	
	/**
	 * changeRectangle - changes the current state of shape to a new state of Shape, and echoes to the console that it has been done.
	 * @param Rectangle r - the desired state to change the shape to
	 * @require: Rectangle r to be non-null
	 * @ensure Current instance of "shape" will be changed to whatever is passed through to this function as an argument
	 */
	public static void changeRectangle(Rectangle r){
		shape = new DrawableRectangle(r.getX_position(), r.getY_position(), (((Rectangle)r).width()), (((Rectangle)r).height()));
		System.out.println("The Rectangle object has been changed."); //debug
	}
	
	/**
	 * getRectangle - returns the current Rectangle object
	 * @return Rectangle shape - Current instance of "shape" which is a Rectangle in this class.
	 */
	public static Rectangle getRectangle(){
		return (Rectangle)shape;
	}
	
	
	/**
	 * saveRectangle - saves the current Rectangle you are working with to a file of your choice.
	 * @require Rectangle to be non-null
	 * @ensures (File.isFile()) Rectangle will be saved to a non-null file
	 */
	public static void saveRectangle(File file){
		assert file.isFile();
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(RectangleGUI.getRectangle());
			oos.close();
			System.out.println("Saved the Rectangle to " +file.getName());
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * loadRectangle - loads a Rectangle from the file that you specify
	 * @require A valid file to be selected and for the File to exist
	 * @ensure (File.isFile()), The File you choose will not be null and it will only load if it contains a rectangle.
	 */
	public static void loadRectangle(File file){
		assert file.isFile();
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			Rectangle r = (Rectangle)ois.readObject();
			changeRectangle(r);
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Loaded the Rectangle from " +file.getName());
	}
}