package assign4;

/**
 * Title: ShapeGUI class for CSIS 235 Assignment #4
 * Description: CS 235 Assignment #4 - ShapeGUI
 *              Creates a GUI that can display different Shapes.
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @date   December 4th, 2012
 * @version 1.0
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import shapes.Drawable;
import shapes.DrawableCircle;
import shapes.DrawableEllipse;
import shapes.DrawableRectangle;
import shapes.DrawableSquare;
import shapes.DrawableTriangle;
import shapes.FilledCircle;
import shapes.FilledEllipse;
import shapes.FilledRectangle;
import shapes.FilledSquare;
import shapes.FilledTriangle;
import shapes.Movable;
import shapes.MovableCircle;
import shapes.MovableEllipse;
import shapes.MovableFilledCircle;
import shapes.MovableFilledEllipse;
import shapes.MovableFilledRectangle;
import shapes.MovableFilledSquare;
import shapes.MovableRectangle;
import shapes.MovableSquare;
import shapes.MovableTriangle;
import shapes.Shape;

public class ShapeGUI extends JFrame implements ActionListener, MouseListener {
	/**
	 * Data members
	 */
	private static final long serialVersionUID = 1L;
	// Position and size of the window frame
	private static final int FRAME_X_POSITION = 200, FRAME_Y_POSITION = 100,
							 FRAME_WIDTH = 400, FRAME_HEIGHT = 300;
	
	private int initialSelectedX, initialSelectedY, releasedX, releasedY;

	private JLabel text; // Tells user what to do
	private String DESCRIPTION = "Let's draw shapes.";
	// Position and size of the description label
	private static final int LABEL_TOP_LEFT_X = 30, // pixels from left edge of window
							 LABEL_TOP_LEFT_Y = 0, // pixels from top edge of window
							 LABEL_WIDTH = FRAME_WIDTH - 2*30, // pixels wide
							 LABEL_HEIGHT = 30;   // pixels high

	// shape refers to a ShapeCollection of Drawable shapes.
	private ShapeCollection shape = new ShapeCollection(10);

	// data members for the menu bar
	private JMenuBar menuBar;
	private JMenu    fileMenu, squareMenu, rectangleMenu, ellipseMenu, circleMenu, triangleMenu;
	private JMenuItem newRectangle,
					  newMovableRectangle,
					  newFilledRectangle,
					  newMovableFilledRectangle,
					  
					  newSquare,
					  newFilledSquare,
					  newMovableSquare,
					  newMovableFilledSquare,
					  
					  newEllipse,
					  newMovableEllipse,
					  newFilledEllipse,
					  newMovableFilledEllipse,
					  
					  newCircle,
					  newFilledCircle,
					  newMovableCircle,
					  newMovableFilledCircle,
					  
					  newTriangle,
					  newFilledTriangle,
					  newMovableTriangle,
					  newMovableFilledTriangle,
					  
					  openFile,
					  saveFile,
					  clearScreen;
	
	// common FileChooser for the open and save dialogs
	JFileChooser filechooser;
	
	/**
	 * RectangleGUI default constructor
	 * 
	 */
	public ShapeGUI(){
		super("Graphical User Interface for Shapes");
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
		
		

		// Set up the menus for this application
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		JMenu newShape = new JMenu("New Shape");
		squareMenu = new JMenu("Square");
		rectangleMenu = new JMenu("Rectangle");
		ellipseMenu = new JMenu("Ellipse");
		circleMenu = new JMenu("Circle");
		triangleMenu = new JMenu("Triangle");
		
		
		
		newShape.addActionListener(this);
		newRectangle = new JMenuItem("Rectangle");
		newRectangle.addActionListener( this );
		newMovableRectangle = new JMenuItem("Movable Rectangle");
		newMovableRectangle.addActionListener(this);
		newFilledRectangle = new JMenuItem("Filled Rectangle");
		newFilledRectangle.addActionListener(this);
		newMovableFilledRectangle = new JMenuItem("Movable Filled Rectangle");
		newMovableFilledRectangle.addActionListener(this);
		
		
		newSquare = new JMenuItem("Square"); 
		newSquare.addActionListener( this ); 
		newMovableSquare = new JMenuItem("Movable Square"); 
		newMovableSquare.addActionListener(this); 
		newFilledSquare = new JMenuItem("Filled Square"); 
		newFilledSquare.addActionListener(this); 
		newMovableFilledSquare = new JMenuItem("Movable Filled Square"); 
		newMovableFilledSquare.addActionListener(this);

		
		
		
		newEllipse = new JMenuItem("Ellipse");
		newEllipse.addActionListener( this );
		newMovableEllipse = new JMenuItem("Movable Ellipse");
		newMovableEllipse.addActionListener(this);
		newFilledEllipse = new JMenuItem("Filled Ellipse");
		newFilledEllipse.addActionListener( this );
		newMovableFilledEllipse = new JMenuItem("Movable Filled Ellipse");
		newMovableFilledEllipse.addActionListener(this);
		
		
		
		newCircle = new JMenuItem("Circle");
		newCircle.addActionListener( this );
		newMovableCircle = new JMenuItem("Movable Circle");
		newMovableCircle.addActionListener(this);
		newFilledCircle = new JMenuItem("Filled Circle");
		newFilledCircle.addActionListener(this);
		newMovableFilledCircle = new JMenuItem("Movable Filled Circle");
		newMovableFilledCircle.addActionListener(this);
		
		newTriangle = new JMenuItem("Triangle");
		newTriangle.addActionListener(this);
		newMovableTriangle = new JMenuItem("Movable Triangle");
		newMovableTriangle.addActionListener(this);
		newFilledTriangle = new JMenuItem("Filled Triangle");
		newFilledTriangle.addActionListener(this);
		newMovableFilledTriangle = new JMenuItem("Movable Filled Triangle");
		newMovableFilledTriangle.addActionListener(this);
		
		openFile = new JMenuItem("Open ... ");
		openFile.addActionListener( this );
		saveFile = new JMenuItem("Save As ...");
		saveFile.addActionListener( this );
		clearScreen = new JMenuItem("Clear");
		clearScreen.addActionListener( this );
		
		addMouseListener(this);
		
		
		fileMenu.add( newShape );
		
		
		/*
		 * Square menu and menu options
		 */
		newShape.add( squareMenu ); 
		
		squareMenu.add( newSquare );
		squareMenu.add(newMovableSquare);
		squareMenu.add(newFilledSquare); 
		squareMenu.add(newMovableFilledSquare);
		
		
		/*
		 * Rectangle menu and menu options
		 */
		newShape.add(rectangleMenu);
		
		rectangleMenu.add( newRectangle );
		rectangleMenu.add(newMovableRectangle);
		rectangleMenu.add(newFilledRectangle);
		rectangleMenu.add(newMovableFilledRectangle);
		
		
		/*
		 * Ellipse menu and menu options
		 */
		newShape.add(ellipseMenu);
		
		ellipseMenu.add( newEllipse );
		ellipseMenu.add(newMovableEllipse);
		ellipseMenu.add(newFilledEllipse);
		ellipseMenu.add(newMovableFilledEllipse);
		
		/*
		 * Circle menu and menu options
		 */
		newShape.add(circleMenu);
		
		circleMenu.add( newCircle );
		circleMenu.add(newMovableCircle);
		circleMenu.add(newFilledCircle);
		circleMenu.add(newMovableFilledCircle);
		
		/*
		 * Triangle menu and menu options
		 */
		newShape.add(triangleMenu);
		
		triangleMenu.add(newTriangle);
		triangleMenu.add(newMovableTriangle);
		triangleMenu.add(newFilledTriangle);
		triangleMenu.add(newMovableFilledTriangle);
		
		fileMenu.add( openFile );
		fileMenu.add( saveFile );
		fileMenu.add( clearScreen );
		menuBar.add( fileMenu );
		setJMenuBar( menuBar );
		
		// Set up a common file chooser object for opening and saving files
		filechooser = new JFileChooser("Open");
		//filechooser.setFileFilter( new FileNameExtensionFilter("Rectangle object files", "objects") );
		
		text = new JLabel( DESCRIPTION );
		text.setBounds(LABEL_TOP_LEFT_X, LABEL_TOP_LEFT_Y, LABEL_WIDTH, LABEL_HEIGHT);
		add( text );
		
	}

	/**
	 * actionPerformed method for MainClient
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		
		if (source == newRectangle){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( LABEL_TOP_LEFT_Y, FRAME_HEIGHT);
			final int width = Shape.random( 1 , FRAME_WIDTH);
			final int height  = Shape.random( 1 , FRAME_HEIGHT - (LABEL_TOP_LEFT_Y) );
			shape.set(new DrawableRectangle( x, y, width, height ));
			shape.sort();
			repaint();
		}
		
		if (source == newMovableRectangle){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( LABEL_TOP_LEFT_Y, FRAME_HEIGHT);
			final int width = Shape.random( 1 , FRAME_WIDTH);
			final int height  = Shape.random( 1 , FRAME_HEIGHT - (LABEL_TOP_LEFT_Y) );
			shape.set(new MovableRectangle( x, y, width, height ));
			shape.sort();
			repaint();
		}
		
		if (source == newFilledRectangle){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( LABEL_TOP_LEFT_Y, FRAME_HEIGHT);
			final int width = Shape.random( 1 , FRAME_WIDTH);
			final int height  = Shape.random( 1 , FRAME_HEIGHT - (LABEL_TOP_LEFT_Y) );
			shape.set(new FilledRectangle( x, y, width, height ));
			shape.sort();
			repaint();
		}
		
		if (source == newMovableFilledRectangle){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( LABEL_TOP_LEFT_Y, FRAME_HEIGHT);
			final int width = Shape.random( 1 , FRAME_WIDTH);
			final int height  = Shape.random( 1 , FRAME_HEIGHT - (LABEL_TOP_LEFT_Y) );
			shape.set(new MovableFilledRectangle( x, y, width, height ));
			shape.sort();
			repaint();
		}
		
		else if(source == newSquare){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( LABEL_TOP_LEFT_Y, FRAME_HEIGHT);
			final int width = Shape.random( 1 , 200);
			shape.set(new DrawableSquare(x, y, width));
			shape.sort();
			repaint();
		}
		
		else if(source == newFilledSquare){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( LABEL_TOP_LEFT_Y, FRAME_HEIGHT);
			final int width = Shape.random( 1 , 200);
			shape.set(new FilledSquare(x, y, width));
			shape.sort();
			repaint();
		}
		
		else if(source == newMovableSquare){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( LABEL_TOP_LEFT_Y, FRAME_HEIGHT);
			final int width = Shape.random( 1 , 200);
			shape.set(new MovableSquare(x, y, width));
			shape.sort();
			repaint();
		}
		
		else if(source == newMovableFilledSquare){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( LABEL_TOP_LEFT_Y, FRAME_HEIGHT);
			final int width = Shape.random( 1 , 200);
			shape.set(new MovableFilledSquare(x, y, width));
			shape.sort();
			repaint();
		}
		
		else if (source == newEllipse){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( LABEL_TOP_LEFT_Y, FRAME_HEIGHT);
			final int width = Shape.random( 1 , FRAME_WIDTH);
			final int height  = Shape.random( 1 , FRAME_HEIGHT - (LABEL_TOP_LEFT_Y) );
			shape.set(new DrawableEllipse(x, y, width, height));
			shape.sort();
			repaint();
		}
		
		else if (source == newMovableEllipse){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( LABEL_TOP_LEFT_Y, FRAME_HEIGHT);
			final int width = Shape.random( 1 , FRAME_WIDTH);
			final int height  = Shape.random( 1 , FRAME_HEIGHT - (LABEL_TOP_LEFT_Y) );
			shape.set(new MovableEllipse(x, y, width, height));
			shape.sort();
			repaint();
		}
		
		else if (source == newFilledEllipse){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( LABEL_TOP_LEFT_Y, FRAME_HEIGHT);
			final int width = Shape.random( 1 , FRAME_WIDTH);
			final int height  = Shape.random( 1 , FRAME_HEIGHT - (LABEL_TOP_LEFT_Y) );
			shape.set(new FilledEllipse(x, y, width, height));
			shape.sort();
			repaint();
		}
		
		else if (source == newMovableFilledEllipse){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( LABEL_TOP_LEFT_Y, FRAME_HEIGHT);
			final int width = Shape.random( 1 , FRAME_WIDTH);
			final int height  = Shape.random( 1 , FRAME_HEIGHT - (LABEL_TOP_LEFT_Y) );
			shape.set(new MovableFilledEllipse(x, y, width, height));
			shape.sort();
			repaint();
		}
		
		
		else if (source == newCircle){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( LABEL_TOP_LEFT_Y, FRAME_HEIGHT);
			final int diameter = Shape.random( 1 , FRAME_WIDTH);
			shape.set(new DrawableCircle(x, y, diameter));
			shape.sort();
			repaint();
		}
		
		else if (source == newFilledCircle){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( LABEL_TOP_LEFT_Y, FRAME_HEIGHT);
			final int diameter = Shape.random( 1 , FRAME_WIDTH);
			shape.set(new FilledCircle(x, y, diameter));
			shape.sort();
			repaint();
		}
		
		else if (source == newMovableCircle){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( LABEL_TOP_LEFT_Y, FRAME_HEIGHT);
			final int diameter = Shape.random( 1 , FRAME_WIDTH);
			shape.set(new MovableCircle(x, y, diameter));
			shape.sort();
			repaint();
		}
		
		else if (source == newMovableFilledCircle){
			final int x = Shape.random( 0 , FRAME_WIDTH);
			final int y = Shape.random( LABEL_TOP_LEFT_Y, FRAME_HEIGHT);
			final int diameter = Shape.random( 1 , FRAME_WIDTH);
			shape.set(new MovableFilledCircle(x, y, diameter));
			shape.sort();
			repaint();
		}
		
		
		
		if (source == newTriangle){
			final int x1 = Shape.random(0, FRAME_WIDTH);
			final int y1 = Shape.random( LABEL_TOP_LEFT_Y+100, FRAME_HEIGHT);
			
			final int x2 = Shape.random(0, FRAME_WIDTH);
			final int y2 = Shape.random( LABEL_TOP_LEFT_Y+100, FRAME_HEIGHT);
			
			final int x3 = Shape.random(0, FRAME_WIDTH);
			final int y3 = Shape.random( LABEL_TOP_LEFT_Y+100, FRAME_HEIGHT);
			
			System.out.println("creating new triangle " + x1 + " " + y1 + ", " + x2 + " " + y2 + ", " + x3 + " " + y3);
			shape.set(new DrawableTriangle(x1, y1, x2, y2, x3, y3));
			//shape.sort();
			repaint();
		}
		
		if (source == newFilledTriangle){
			final int x1 = Shape.random(0, FRAME_WIDTH);
			final int y1 = Shape.random( LABEL_TOP_LEFT_Y+100, FRAME_HEIGHT);
			
			final int x2 = Shape.random(0, FRAME_WIDTH);
			final int y2 = Shape.random( LABEL_TOP_LEFT_Y+100, FRAME_HEIGHT);
			
			final int x3 = Shape.random(0, FRAME_WIDTH);
			final int y3 = Shape.random( LABEL_TOP_LEFT_Y+100, FRAME_HEIGHT);
			
			System.out.println("creating new triangle " + x1 + " " + y1 + ", " + x2 + " " + y2 + ", " + x3 + " " + y3);
			shape.set(new FilledTriangle(x1, y1, x2, y2, x3, y3));
			//shape.sort();
			repaint();
		}
		
		if (source == newMovableTriangle){
			final int x1 = Shape.random(0, FRAME_WIDTH);
			final int y1 = Shape.random( LABEL_TOP_LEFT_Y+100, FRAME_HEIGHT);
			
			final int x2 = Shape.random(0, FRAME_WIDTH);
			final int y2 = Shape.random( LABEL_TOP_LEFT_Y+100, FRAME_HEIGHT);
			
			final int x3 = Shape.random(0, FRAME_WIDTH);
			final int y3 = Shape.random( LABEL_TOP_LEFT_Y+100, FRAME_HEIGHT);
			
			System.out.println("creating new triangle " + x1 + " " + y1 + ", " + x2 + " " + y2 + ", " + x3 + " " + y3);
			shape.set(new MovableTriangle(x1, y1, x2, y2, x3, y3));
			//shape.sort();
			repaint();
		}
		
		if (source == newMovableFilledTriangle){
			final int x1 = Shape.random(0, FRAME_WIDTH);
			final int y1 = Shape.random( LABEL_TOP_LEFT_Y+100, FRAME_HEIGHT);
			
			final int x2 = Shape.random(0, FRAME_WIDTH);
			final int y2 = Shape.random( LABEL_TOP_LEFT_Y+100, FRAME_HEIGHT);
			
			final int x3 = Shape.random(0, FRAME_WIDTH);
			final int y3 = Shape.random( LABEL_TOP_LEFT_Y+100, FRAME_HEIGHT);
			
			System.out.println("creating new triangle " + x1 + " " + y1 + ", " + x2 + " " + y2 + ", " + x3 + " " + y3);
			shape.set(new DrawableTriangle(x1, y1, x2, y2, x3, y3));
			//shape.sort();
			repaint();
		}
		
		
		else if (source == openFile){
			File fileToOpen = null;
			if (filechooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION ){
				fileToOpen = filechooser.getSelectedFile();
				
				try {
					shape = (read( fileToOpen )); 
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} else if (source == saveFile){
			File fileToSave = null;
			if (filechooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION ){
				fileToSave = filechooser.getSelectedFile();
				
				try {
					write( fileToSave, shape );
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		else if (source == clearScreen){
			clearScreen();
		}
	}

	
	private ShapeCollection read(File fileToOpen) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream oi = new ObjectInputStream( new FileInputStream(fileToOpen) );
		ShapeCollection shape  = (ShapeCollection)(oi.readObject());
		oi.close();
		repaint();
		return shape;		
	}

	private void write(final File fileToSave, final ShapeCollection sh) throws IOException {
		ObjectOutputStream oo = new ObjectOutputStream( new FileOutputStream(fileToSave) );
		oo.writeObject( sh );
		oo.close();	
	}
	
	/**
	 * clearScreen - empties the ArrayList, thus "Clearing" the screen.
	 * @require none
	 * @ensure shape.isEmpty()
	 */
	private void clearScreen(){
		shape.clear();
		assert (shape.getCapacity() == 0) : "Screen was not cleared successfully.";
		repaint();
	}

	/**
	 * Paint method - this is where our shapes get drawn.
	 */
	public void paint(java.awt.Graphics graphics) {
		super.paint(graphics);
		/**
		 * We want to draw the Shapes.
		 */
		if (shape != null)
				shape.draw(graphics);
	}
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		System.out.println("\n\n\n");
		initialSelectedX = arg0.getX();
		initialSelectedY = arg0.getY();
		System.out.println(" Set x, y as: " + initialSelectedX + ", " + initialSelectedY);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		releasedX = arg0.getX();
		releasedY = arg0.getY();
		
		System.out.println("Released x, y at: " + releasedX + ", " + releasedY);
		
		for(int i = 0; i < shape.getSize(); i++){
			if(shape.get(i).contains(initialSelectedX, initialSelectedY) && shape.get(i) instanceof Movable){
				
				int relativeDeltaX = releasedX-initialSelectedX;
				int relativeDeltaY = releasedY-initialSelectedY;
				
				((Movable)(shape.get(i))).move(relativeDeltaX, relativeDeltaY);
				repaint();
				break;
			}
		}
	}
	
	
	
	
}