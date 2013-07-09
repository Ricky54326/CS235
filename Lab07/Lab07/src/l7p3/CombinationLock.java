package l7p3;

/**
 * Title: CombinationLock class for CSIS 235 Lab #7
 * Description: CS 235 Lab #7 - CombinationLock
 *              This class is used to represent a lock with an integer combination.
 *              
 * @author Ricky Mutschlechner, Tim Olmstead and Noah Muth
 * @email  riccardo.mutschlechner@my.uwrf.edu, timothy.olmstead@my.uwrf.edu and noah.muth@my.uwrf.edu
 * @date   October 23rd, 2012
 */

public class CombinationLock {
  // Private data members: ----------------------------------------------------
  private int combination;    // combination to open the lock
  private boolean isOpen;     // the lock is unlocked
  
  // Constructors: ------------------------------------------------------------

  /**
   * Constructor -  Create a lock with the specified combination.
   * 
   * @require    0 <= combination && combination <= 999
   * @ensure     this.isOpen()
   */
  public CombinationLock (int combination) {
    this.combination = combination;
    isOpen = true;
  }
 
  // Queries: -----------------------------------------------------------------

  /**
   * isOpen - Returns true if this CombinationLock is unlocked.
   * 
   * @require no preconditions 
   * @ensure  no postconditions
   */
  public boolean isOpen () {
    return isOpen;
  }

  // Commands: ----------------------------------------------------------------

  /**
   * close - Lock this CombinationLock.
   * 
   * @ensure     !this.isOpen()
   */
  public void close () {
    isOpen = false;
  }

  /**
   * open - Unlock this CombinationLock if the correct combination is provided.
   *
   * @require no preconditions 
   * @ensure  (combinationToTry==combination && this.isOpen) || (combinationToTry!=combination && !this.isOpen) 
   */
  public void open (int combinationToTry) {
    if (combinationToTry == combination)
      isOpen = true;
  } 
  
  
  /**
   * changeCombination - changes the combination of an existing lock
   * 
   * @require CombinationLock object to exist
   * @ensure Ensures that the lock will be open and that the lock will have the new combination
   */
  public void changeCombination(int combination){
	  this.combination = combination;
	  isOpen = true;
  }
}