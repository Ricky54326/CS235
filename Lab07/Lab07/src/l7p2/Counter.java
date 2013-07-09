package l7p2;

/**
 * Title: Counter class for CSIS 235 Lab #7
 * Description: CS 235 Lab #7 - Counter
 *              This class is used to count things. 
 *              The count should always be 0 or positive -- i.e. non-negative.
 *              Right now, the count can only be incremented or reset.
 *              
 * @author Ricky Mutschlechner, Tim Olmstead and Noah Muth
 * @email  riccardo.mutschlechner@my.uwrf.edu, timothy.olmstead@my.uwrf.edu and noah.muth@my.uwrf.edu
 * @date   October 23rd, 2012
 */

public class Counter {
  // Private data members: ----------------------------------------------------
  private int count;   // current count

  // Constructors: ------------------------------------------------------------
	  
  /**
   * Constructor - Create a new Counter object, with the count set to 0.
   * 
   * @require no preconditions
   * @ensure  this.currentCount() == 0
   * 			i.e. we guarantee, after this method is done, that count will have been set to 0 
   */
  public Counter () {
	  count = 0;
  }
	  
  /**
   * Constructor - Create a new Counter object, with the count initialized to a non-negative number.
   * 
   * @param start
   * @require start >= 0
   * @ensure  this.currentCount() >= 0 || this.currentCount() == start
   *          i.e. if start >= 0, the count data member will be set to start
   *               otherwise, count will be set to 0
   */
  public Counter (int start) {
	  if(start >= 0)
		  count = start;
	  else
		  count = 0;
  }
  
  // Queries: -----------------------------------------------------------------
  
  /**
   * currentCount - Returns the current value of count.
   * 
   * @require 
   * @ensure this.currentCount() >= 0
   * 		  i.e. (in plain English) this method will always return the current value of the counter
   */
  public int currentCount () {
    return count;
  }
	  
  // Commands: ----------------------------------------------------------------
  
  /**
   * increment - increment the value of count
   *  
   * @ensure  this.currentCount() >= 0 || this.currentCount() = old.currentCount() + 1
   * 			i.e. we guarantee, after this method is done, that count will be increased by 1 and still be positive
   */
  public void increment () {
	  if(this.currentCount() >= 0)
		  count++;
	  else
		  count = 0;
  } 
  
  
  /**
   * decrement - decrement the value of count
   *  
   * @ensure  this.currentCount() >= 0 || this.currentCount() = old.currentCount() -1
   * 			i.e. we guarantee, after this method is done, that count will be decreased and 
   * 					that it will not ever fall below zero.
   */
  public void decrement () {
	  if((this.currentCount() - 1) >= 0)
		  count--;
	  else
		  count = 0;
  } 

  
  
  /**
   * reset - set the value of count to 0
   *  
   * @ensure  this.currentCount() == 0
   * 			i.e. we guarantee, after this method is done, that count will be 0
   */
  public void reset () {
     count = 0;
  } 
}