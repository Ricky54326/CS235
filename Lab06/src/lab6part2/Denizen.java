package lab6part2;

/**
 * Title: Denizen class for CSIS 235 Lab #6 Description: CS 235 Lab #6 - Denizen
 * This class represents a creature that lives in a maze.
 * 
 * @author Ricky Mutschlechner and Tim Olmstead
 * @email  riccardo.mutschlechner@my.uwrf.edu and timothy.olmstead@my.uwrf.edu
 * @date   10/17/2012
 */

public class Denizen {
	private String name; // current name of Denizen
	private Room location; // current location
	private int strength; // current strength (hit points)
	private int tolerance; // current tolerance (hit points)

	public Denizen() {
		name = null;
		location = null;
		strength = 0;
		tolerance = 0;
	}

	public Denizen(String name, Room location, int strength, int tolerance) {
		this.name = name;
		this.location = location;
		this.location.modifyNumDenizens(1); //Adds a Denizen to the room right away as that is where they start
		this.strength = strength;
		this.tolerance = tolerance;

	}

	public void takeThat(int strength) {
		tolerance = tolerance - strength;
	}

	public void poke(Explorer opponent) {
		opponent.takeThat(strength);
		takeThat(strength);
	}

	  /**
	   * Move to the specified Room, modify number of Explorers in a room
	   */
	  public void move (Room newRoom) {
		  if(location.getNumDenizens() != 0)
			  location.modifyNumDenizens(-1);
		  location = newRoom;
		  location.modifyNumDenizens(1);
	  }

	public String getName() {
		return name;
	}

	public Room location() {
		return location;
	}

	/**
	 * Annoyance (hit points) this Denizen causes when poking an opponent.
	 */
	public int strength() {
		return strength;
	}

	/**
	 * Annoyance (hit points) required to defeat the Explorer.
	 */
	public int tolerance() {
		return tolerance;
	}

	public String toString() {
		return ("Name: " + name + "\n" + "Location: " + location + "\n" + "Strength: " + strength + "\n" + "Tolerance: " + tolerance + "\n\n");
	}
}
