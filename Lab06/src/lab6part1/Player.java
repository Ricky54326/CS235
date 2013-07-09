package lab6part1;

/**
 * Title: Pile class for CSIS 235 Lab #6
 * Description: CS 235 Lab #6 - Pile 
 *     This class represents a pile of sticks for playing simple nim.
 * 
 * @author Ricky Mutschlechner and Tim Olmstead
 * @email  riccardo.mutschlechner@my.uwrf.edu and timothy.olmstead@my.uwrf.edu
 * @date   10/17/2012
 */

public class Player {
	// Private data members: ----------------------------------------------------
	private String name; // this Player's name
	private int sticksTaken; // sticks taken on this Player's most recent
								// turn; 0 if this Player has not taken a turn.

	// Constructors: ------------------------------------------------------------

	/**
	 * Constructor
	 * 
	 * Create a new Player with the specified name.
	 */
	public Player(String name) {
		this.name = name;
		this.sticksTaken = 0;
	}

	// Queries: -----------------------------------------------------------------

	/**
	 * name:
	 * 
	 * The name of this Player.
	 */
	public String name() {
		return name;
	}

	/**
	 * sticksTaken:
	 * 
	 * The number of sticks this Player removed on this Player's most recent
	 * turn: 1, 2, or 3. Returns 0 if this Player has not yet taken a turn.
	 */
	public int sticksTaken() {
		return sticksTaken;
	}

	// Commands: ----------------------------------------------------------------

	/**
	 * remove:
	 * 
	 * Remove 1, 2, or 3 sticks from the specified Pile. The Pile must not be
	 * empty. Also, must not make a move that makes you lose if possible.
	 */
	public void takeTurn(Pile pile) {
		if(pile.sticks() > 3){ //If you have any more than 3 sticks, take 3 so you can maximize the chance of not losing.
			pile.remove(3);
			sticksTaken = 3;
		}
		
		else if(pile.sticks() == 3){ //if you have 3 sticks, take 2 so you do not lose.
			pile.remove(2);
			sticksTaken = 2;
		}
		
		else if(pile.sticks() == 2 || pile.sticks() == 1){ //if it is 1, however, you lose
			pile.remove(1);
			sticksTaken = 1;
		}
		
		else{ //Used for debugging, should not ever reach this
			System.out.println("Possible error!");
		}
		
	}
	
	
	/**
	 * toString:
	 * Prints the name and data of the current player
	 */
	public String toString(){
		return name;
	}
}