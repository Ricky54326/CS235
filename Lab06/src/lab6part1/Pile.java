package lab6part1;

/**
 * Title: Pile class for CSIS 235 Lab #6
 * Description: CS 235 Lab #6 - Pile
 *  This class represents a pile of sticks for playing simple nim.
 *
 * @author Ricky Mutschlechner and Tim Olmstead
 * @email  riccardo.mutschlechner@my.uwrf.edu and timothy.olmstead@my.uwrf.edu
 * @date   10/17/2012
 */

public class Pile {
  // Private data members: ----------------------------------------------------
  private int sticksLeft;

  // Constructors: ------------------------------------------------------------
  
  /**
   * Constructor
   * 
   * Create a new Pile, with the specified number of sticks.
   * sticks must be non-negative.
   * 
   * @param sticks
   */
  public Pile (int sticks) {
    sticksLeft = sticks;
  }
  
  // Queries: -----------------------------------------------------------------
  
  /**
   * sticks: 
   * 
   * Returns the number of sticks remaining in this Pile.
   */
  public int sticks () {
    return sticksLeft;
  }
  
  // Commands: ----------------------------------------------------------------
  
  /**
   * remove:
   *  
   * Reduce the number of sticks by the specified amount.
   * number must be non-negative and not greater than the
   * number of sticks remaining.
   */
  public void remove (int number) {
    sticksLeft = sticksLeft - number;
  } 
}