package lab6part2;

/**
 * Title: Room class for CSIS 235 Lab #6
 * Description: CS 235 Lab #6 - Room
 *  This class represents a room in a maze game.
 *
 * @author Nino & Hosch - this class is from the textbook.
 * @email  your.n.here@my.uwrf.edu
 * @date   October 10th 2012
 */

public class Room {
	//Instance Variables
	private String name;
	private int numExplorers;
	private int numDenizens;
	
	public Room(String name){
		this.name = name;
	}
	
	public void modifyNumExplorers(int n){
		numExplorers += n;
	}
	
	public void modifyNumDenizens(int n){
		numDenizens += n;
	}
	
	public int getNumDenizens(){
		return numDenizens;
	}
	
	public int getNumExplorers(){
		return numExplorers;
	}
	
	public String toString(){
		return name  + " has " + numDenizens + " Denizens and " + numExplorers+  " Explorers!";
	}
}
