package lab6part1;

/**
 * Title: Part1 class for CSIS 235 Lab #6
 * Description: CS 235 Lab #6 - Part1
 *              This class has a main method and is the
 *              client of the Player and Pile classes.
 * @author Ricky Mutschlechner and Tim Olmstead
 * @email  riccardo.mutschlechner@my.uwrf.edu and timothy.olmstead@my.uwrf.edu
 * @date   10/17/2012
 */

public class Part1 {

	/**
	 * main - this is where the Part1 program starts
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Pile pile = new Pile( 10 );
		System.out.println("Number of sticks in the pile is " + pile.sticks());
		
		Player[] players = new Player[3];
		players[0]  = new Player("Phil");
		players[1] = new Player("Edith");
		players[2] = new Player("Chester");
		
		for(Player p: players)
			System.out.println(p + " ");
		System.out.println("\n");
		
		
		int turn = 0;
		int lastplayer = 0;
		while(pile.sticks() >= 0){
				players[turn].takeTurn(pile);
				lastplayer = turn;
				System.out.println("--> " + players[turn] + " " + players[turn].sticksTaken());
				turn = (turn + 1) % players.length;
			
				if(pile.sticks() == 0)
					break;
		}
		

		System.out.print("Last player was " + players[lastplayer]);
	}
}