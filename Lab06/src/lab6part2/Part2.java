package lab6part2;

/**
 * Title: Part2 class for CSIS 235 Lab #6
 * Description: CS 235 Lab #6 - Part2
 * 				This class has a main method and is the client of
 * 				 the Denizen, Explorer and Room classes.
 * 
 * @author Ricky Mutschlechner and Tim Olmstead
 * @email  riccardo.mutschlechner@my.uwrf.edu and timothy.olmstead@my.uwrf.edu
 * @date   10/17/2012
 */

public class Part2 {

	/**
	 * main - this is where the Part2 program starts
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Room attic = new Room("Attic");
		Room kitchen = new Room("Kitchen");
		Room pantry = new Room("Pantry");
		Explorer dora = new Explorer("Dora", attic, 10, 60);
		Denizen dragon = new Denizen( "Swiper" , kitchen, 13,50);
		
		System.out.println("Round 1:");
		dora.poke(dragon);
		dora.move(kitchen);
		dragon.poke(dora);
		dragon.move(attic);
		System.out.println(dragon.toString() + dora.toString());
		
		System.out.println("Round 2:");
		dragon.move(kitchen);
		dragon.poke(dora);
		dora.poke(dragon);
		dora.move(pantry);
		System.out.println(dragon.toString() + dora.toString());
		
		Denizen cyclops = new Denizen ("One Eye", pantry, 6, 25);
		Explorer diego = new Explorer ("Diego", kitchen, 2, 20);
		
		System.out.println("Round 3:");
		cyclops.poke(diego);
		cyclops.move(attic);
		diego.poke(cyclops);
		diego.move(attic);
		System.out.println(cyclops.toString() + diego.toString());
		
		System.out.println("Round 4:");
		cyclops.poke(diego);
		diego.poke(cyclops);
		cyclops.move(kitchen);
		diego.move(pantry);
		System.out.println(cyclops.toString() + diego.toString());

		Denizen centaur = new Denizen("Centaur", kitchen, 5, 20);
		
		System.out.println("Round 5:");
		diego.move(pantry);
		centaur.poke(diego);
		diego.poke(cyclops);
		centaur.move(kitchen);
		System.out.println(centaur.toString() + cyclops.toString() + diego.toString());
	
		System.out.println("End of fight results: " + "\n" +centaur.toString() + "\n" +  cyclops.toString() + diego.toString() + "\n" + dragon.toString() + dora.toString());
	}
}