package lab6part4;

/**
 * Title: TrafficSignal class for CSIS 235 Lab #6
 * Description: CS 235 Lab #6 - TrafficSignal
 *  This class represents a traffic signal with 3 colors -
 *   a simple green-yellow-red traffic signal.
 *
 * @author Ricky Mutschlechner and Tim Olmstead
 * @email  riccardo.mutschlechner@my.uwrf.edu and timothy.olmstead@my.uwrf.edu
 * @date   10/17/2012
 */


public class TrafficSignal {
  
  // Named constant class data members:
  
  /**
   * The green signal light.
   */
  public static final int GREEN = 0;
  
  /**
   * The yellow signal light.
   */
  public static final int YELLOW = 1;
  
  /**
   * The red signal light.
   */
  public static final int RED = 2;
  
  // Private components:
  
  private int light;      // current light
  
  // Constructor:
  
  /**
   * Create a new TrafficSignal, initially green.
   */
  public TrafficSignal () {
    light = GREEN;
  }
  
  // Queries:
  
  /**
   * The current light that is on.
   * Returns TrafficSignal.GREEN, TrafficSignal.YELLOW, or TrafficSignal.RED.
   */
  public int light () {
    return light;
  }
  
  // Commands:
  
  /**
   * Change to the next light.
   */
  public void change () {
    light = (light + 1) % 3;
  }
}