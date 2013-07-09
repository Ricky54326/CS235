package a3start;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class PlayingCard implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon image;
	
	public PlayingCard(){
		image = null;
	}
	
	public PlayingCard(ImageIcon i){
		image = i;
	}

	public ImageIcon getImage(){
		return image;
	}
	
	// test for images
	public String toString(){
		return image.toString();
	}
}
