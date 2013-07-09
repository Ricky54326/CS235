package a3start;

/**
 * <p>Title: Starter code for Assignment #3</p>
 * <p>Description: Shows how to get started with displaying card images.</p>
 * <p>Copyright: Copyright (c) 2003-2013</p>
 * <p>Company: UWRF</p>
 * @author Anthony Varghese
 * @version 4.0
 */

// Most recent assignment 3 version

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainClass extends JFrame implements MouseListener, ActionListener, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hand hand1,
				 hand2,
				 hand3,
				 hand4;
	private final int FRAME_X = 100;
	private final int FRAME_Y = 20;
	private final int FRAME_WIDTH  = 1000;
	private final int FRAME_HEIGHT = 700;
	private final int HAND1_X = 20;
	private final int HAND1_Y = 55;
	private final int HAND2_X = 40;
	private final int HAND2_Y = 200;
	private final int HAND3_X = 60;
	private final int HAND3_Y = 350;
	private final int HAND4_X = 80;
	private final int HAND4_Y = 500;
	private JMenuItem newMenu;
	private JMenuItem saveMenu;
	private JMenuItem openMenu;
	Hand [] hand = new Hand[4];
	Hand [] temp = new Hand[4];
	private JFileChooser filechooser = new JFileChooser();
	
	/*
	 * Location of card images and file name properties
	 */
	final String imagedirectory = "src/CardImages/";
	final String suffix    = ".jpg";
	
	/*public enum Suits{
		CLUBS, DIAMONDS, HEARTS, SPADES;
	}*/
	final char CLUBS       = 'a';
	final char DIAMONDS    = 'b';
	final char HEARTS      = 'c';
	final char SPADES      = 'd';
	final int  STARTNUMBER = 1;  // Ace
	final int  ENDNUMBER   = 13; // King
	
	public MainClass(){
		setBounds( FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT );
		
		getImagesFromFiles();

		setJMenuBar(setupMenu());
		addMouseListener( this );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setVisible(true);

	}
	
	public void paint(Graphics graphics) {
		super.paint( graphics );
		/*
		 * Draw the first hand
		 */
		for (int i = 0; i < hand1.size(); i++) {
			PlayingCard c = hand1.getCard(i);
			if (c == null) continue;
			ImageIcon ic = c.getImage();
			if (ic == null) continue;
			int w = ic.getIconWidth();
			ic.paintIcon(this, graphics, hand1.getStartX() +  i*w, hand1.getStartY() );
		}
		
		/*
		 * Draw the second hand
		 */
		for (int i = 0; i < hand2.size(); i++) {
			PlayingCard c = hand2.getCard(i);
			if (c == null) continue;
			ImageIcon ic = c.getImage();
			if (ic == null) continue;
			int w = ic.getIconWidth();
			ic.paintIcon(this, graphics, hand2.getStartX() + i*w, hand2.getStartY() );
		}
		
		/*
		 * Draw the third hand
		 */
		for (int i = 0; i < hand3.size(); i++) {
			PlayingCard c = hand3.getCard(i);
			if (c == null) continue;
			ImageIcon ic = c.getImage();
			if (ic == null) continue;
			int w = ic.getIconWidth();
			ic.paintIcon(this, graphics, hand3.getStartX() + i*w, hand3.getStartY() );
		}
		
		/*
		 * Draw the fourth hand
		 */
		for (int i = 0; i < hand4.size(); i++) {
			PlayingCard c = hand4.getCard(i);
			if (c == null) continue;
			ImageIcon ic = c.getImage();
			if (ic == null) continue;
			int w = ic.getIconWidth();
			ic.paintIcon(this, graphics, hand4.getStartX() + i*w, hand4.getStartY() );
		}
	}
	
	private void getImagesFromFiles(){
		PlayingCard[] deck = new PlayingCard[52];

		
		int cardID = 0;
		for (char c=CLUBS; c<=SPADES; c++){
			for (int num=1; num<14; num++){
				String card = ( (num < 10) ? "0" : "" ) + num + c;
				
				String filename = imagedirectory + card + suffix;
				ImageIcon im = new ImageIcon( filename );
				deck[cardID] = new PlayingCard( im );
				cardID++;
			}
		}

		/*
		 * Move cards randomly from the deck into hands
		 */
		hand1 = new Hand( HAND1_X, HAND1_Y );
		for (int i=0; i<5; i++){
			int j = 0;
			do{  j = randomIndex();  } while (deck[j]==null);
			hand1.addCard(deck[j]);
			deck[j] = null;
		}
		
		hand2 = new Hand( HAND2_X, HAND2_Y );
		for (int i=5; i<10; i++){
			int j = 0;
			do{  j = randomIndex();  } while (deck[j]==null);
			hand2.addCard(deck[j]);
			deck[j] = null;
		}
		
		hand3 = new Hand( HAND3_X, HAND3_Y );
		for (int i=10; i<15; i++){
			int j = 0;
			do{  j = randomIndex();  } while (deck[j]==null);
			hand3.addCard(deck[j]);
			deck[j] = null;
		}
		
		hand4 = new Hand( HAND4_X, HAND4_Y );
		for (int i=15; i<20; i++){
			int j = 0;
			do{  j = randomIndex();  } while (deck[j]==null);
			hand4.addCard(deck[j]);
			deck[j] = null;
		}
		repaint();

		hand[0] = hand1;
		hand[1] = hand2;
		hand[2] = hand3;
		hand[3] = hand4;
	}

	private int randomIndex() {
		int index = (int)( Math.random() * 52 );
		return index;
	}

	public void mouseClicked(MouseEvent e) {
		boolean hand1Clicked = false;
		boolean hand2Clicked = false;
		boolean hand3Clicked = false;
		boolean hand4Clicked = false;
		
		// check where the mouse was clicked
		if ( e.getY() > HAND1_Y && e.getY() < HAND2_Y )
			hand1Clicked = true;
		if ( e.getY() > HAND2_Y && e.getY() < HAND3_Y )
			hand2Clicked = true;
		if ( e.getY() > HAND3_Y && e.getY() < HAND4_Y )
			hand3Clicked = true;
		if ( e.getY() > HAND4_Y )
			hand4Clicked = true;
		
		if ( hand1Clicked )
			hand2.addCard( hand1.removeCard() );

		if ( hand2Clicked )
			hand1.addCard( hand2.removeCard() );
		
		if ( hand3Clicked )
			hand4.addCard ( hand3.removeCard());
		
		if ( hand4Clicked )
			hand3.addCard ( hand4.removeCard());
		
		repaint();
	}

	private JMenuBar setupMenu() {
		final String FILE_MENU = "File";
		final String NEW_MENU_STRING = "New";
		final String OPEN_MENU_STRING = "Open";
		final String SAVE_MENU_STRING = "Save";

		JMenuBar bar = new JMenuBar();
		JMenu fmenu = new JMenu(FILE_MENU);

		newMenu = new JMenuItem(NEW_MENU_STRING);
		newMenu.addActionListener(this);
		openMenu = new JMenuItem(OPEN_MENU_STRING);
		openMenu.addActionListener(this);
		saveMenu = new JMenuItem(SAVE_MENU_STRING);
		saveMenu.addActionListener(this);

		fmenu.add(newMenu);
		fmenu.add(saveMenu);
		fmenu.add(openMenu);

		bar.add(fmenu);
		return bar;
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source.equals(newMenu)){
			getImagesFromFiles();
		}
		
		else if(source.equals(saveMenu)){
			System.out.println("Saving file...");
			if ( filechooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
				File file = filechooser.getSelectedFile();
				
				try {
					ObjectOutputStream oos = new ObjectOutputStream( new PrintStream(file));
					for (int i=0; i<4; i++){
						oos.writeObject(hand[i]);
					}
					System.out.println("test");
					oos.close();
				} catch (FileNotFoundException ea){
					ea.printStackTrace();
				} catch (IOException ea){
					ea.printStackTrace();
				}
			}
		}
		
		else if (source.equals(openMenu)){
			System.out.println("Opening file...");
			if (filechooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION);
				File file = filechooser.getSelectedFile();
				
				try {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream (file));
					for (int i=0; i<4; i++){
						temp[i] = (Hand) ois.readObject();
					}
					//temp = (Hand[]) ois.readObject();
					ois.close();
				} catch (FileNotFoundException fnf){
					fnf.printStackTrace();
				} catch (ClassNotFoundException cnfe){
					cnfe.printStackTrace();
				} catch (IOException ioe){
					ioe.printStackTrace();
				}
				System.out.println("test");
				
				//repaint();
				for (int i=0; i<4; i++){
					hand[i] = temp[i];
					//System.out.println(hand[i].getCard(1));
				}
				
				hand1 = hand[0];
				hand2 = hand[1];
				hand3 = hand[2];
				hand4 = hand[3];
				
				System.out.println("test");
					//hand = temp;
			
				repaint();
		}
	}
	
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) {	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MainClass();
	}


}
