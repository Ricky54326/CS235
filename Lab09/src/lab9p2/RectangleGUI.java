package lab9p2;

/**
 * Title: Part2 class for CSIS 235 Lab #9
 * Description: CS 235 Lab #9 - Part2
 *              This class has a main method that
 *              calls methods in a RectangleGUI object.
 * @author Ricky Mutschlechner
 * @date   November 16th 2012
 * @version 1.0
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import shapes.DrawableRectangle;
import shapes.Shape;

public class RectangleGUI extends JFrame implements ActionListener {
	/**
	 * Data members
	 * serialVersionUID is for serialization 
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

	// shape refers to a Shape object
	private Shape shape;

	// data members for the menu bar
	private JMenuBar menuBar;
	private JMenu    fileMenu;
	private JMenuItem newRectangle,
					  openFile,
					  saveFile;
	
	// common FileChooser for the open and save dialogs
	JFileChooser filechooser;
	
	/**
	 * RectangleGUI default constructor
	 * 
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

		// Set up the menus for this application
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		newRectangle = new JMenuItem("New Rectangle");
		newRectangle.addActionListener( this );
		openFile = new JMenuItem("Open ... ");
		openFile.addActionListener( this );
		saveFile = new JMenuItem("Save As ...");
		saveFile.addActionListener( this );
		
		fileMenu.add( newRectangle );
		fileMenu.add( openFile );
		fileMenu.add( saveFile );
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

			shape = new DrawableRectangle( x, y, width, height );
			repaint();
		} else if (source == openFile){
			File fileToOpen = null;
			if (filechooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION ){
				fileToOpen = filechooser.getSelectedFile();
				
				try {
					shape = read( fileToOpen ); 
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
	}

	
	private Shape read(File fileToOpen) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream oi = new ObjectInputStream( new FileInputStream(fileToOpen) );
		Shape shape  = (Shape) oi.readObject();
		oi.close();
		repaint();
		return shape;		
	}

	private void write(final File fileToSave, final Shape sh) throws IOException {
		ObjectOutputStream oo = new ObjectOutputStream( new FileOutputStream(fileToSave) );
		oo.writeObject( sh );
		oo.close();	
	}

	/**
	 * Paint method - this is where our shapes get drawn.
	 */
	public void paint(java.awt.Graphics graphics) {
		super.paint(graphics);
		/**
		 * We want to draw the Rectangle.
		 */
		if (shape != null)
			((DrawableRectangle)shape).draw(graphics);
	}
}