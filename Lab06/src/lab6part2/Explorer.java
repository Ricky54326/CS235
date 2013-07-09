package lab6part2;

/**
 * Title: Denizen class for CSIS 235 Lab #6
 * Description: CS 235 Lab #6 - Denizen
 *  This class represents a maze game player.
 *
 * @author Nino & Hosch - this class is from the textbook.
 * @email  your.n.here@my.uwrf.edu
 * @date   October 10th 2012
 */

public class Explorer {
  
  // Private components:

  private String name;       // name
  private Room location;     // current location
  private int strength;      // current strength (hit points)
  private int tolerance;     // current tolerance (hit points)

  // Constructors:
  
  /**
   * Create a new Explorer with the specified name, initial location, strength,
   * and tolerance.
   */
  public Explorer (String name, Room location, int strength, int tolerance) {
    this.name = name;
    this.location = location;
    this.location.modifyNumExplorers(1); //adds an Explorer to the room since that is where they start
    this.strength = strength;
    this.tolerance = tolerance;
  }
    
  // Queries:
  
  /**
   * Name of this Explorer.
   */
  public String name () {
    return name;
  }
  
  /**
   * Room in which this Explorer is currently located.
   */
  public Room location () {
    return location;
  }
  
  /**
   * Annoyance (hit points) this Explorer causes when poking an opponent.
   */
  public int strength () {
    return strength;
  }

  /**
   * Annoyance (hit points) required to defeat this Explorer.
   */
  public int tolerance () {
    return tolerance;
  }

  // Commands:
  
  /**
   * Move to the specified Room, modify number of Explorers in a room
   */
  public void move (Room newRoom) {
	  location.modifyNumExplorers(-1);
	  location = newRoom;
	  location.modifyNumExplorers(1);
  }
  
  /**
   * Receive a poke of the specified number of hit points.
   */
  public void takeThat (int hitStrength) {
    tolerance = tolerance - hitStrength;
  }
  
  /**
   * Poke the specified Denizen.
   */
  public void poke (Denizen opponent) {
    opponent.takeThat(strength);
  }
  
  public String toString(){
		return ("Name: " + name + "\n" + "Location: " + location + "\n" + "Strength: " + strength + "\n" + "Tolerance: " + tolerance + "\n");
  }

  
}