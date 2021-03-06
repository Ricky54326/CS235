package a3start;

import java.io.Serializable;


public class Hand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlayingCard[] array;
	private Hand[] temp = new Hand[4];
	private int size;
	private int startX;
	private int startY;
	
	public Hand(int sX, int sY){
		array = new PlayingCard[52];
		size=0;
		startX = sX;
		startY = sY;
	}
	
	public void addCard(PlayingCard c){
		if ( size >= array.length || c == null )
		   return;
		// put the card in the next empty slot
		if (array[size] == null)
			array[size++] = c;
	}
	
	public PlayingCard removeCard(){
		if (size <= 0)
			return null;

		// get the last card and empty that slot
		PlayingCard temp = array[ --size ];
		array[size] = null;
		return temp;
	}

	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}

	public PlayingCard getCard(int position){
		return array[position];
	}

	public int size() {
		return size;
	}
	
}
