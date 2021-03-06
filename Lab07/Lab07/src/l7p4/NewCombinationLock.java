package l7p4;

/**
 * Title: NewCombinationLock class for CSIS 235 Lab #7
 * Description: CS 235 Lab #7 - NewCombinationLock
 *              This class is used to represent a lock with digit-by-digit combination.
 *              
 * @author Ricky Mutschlechner, Tim Olmstead and Noah Muth
 * @email  riccardo.mutschlechner@my.uwrf.edu, timothy.olmstead@my.uwrf.edu and noah.muth@my.uwrf.edu
 * @date   October 23rd, 2012
 */

public class NewCombinationLock {
  // Private data members: ----------------------------------------------------
   private boolean isOpen; // the lock is unlocked
   private int digit1;     // 1st combination digit
   private int digit2;     // 2nd combination digit
   private int digit3;     // 3rd combination digit
   /* invariant:
    *  digit1 >= 0 && digit1 <= 9 &&
    *  digit2 >= 0 && digit2 <= 9 &&
    *  digit3 >= 0 && digit3 <= 9
    */
   
    /*
     *  thirdToLast, secondToLast, last store the history of the last three
     *  digits entered, with last containing the most recent.
     *  a value of -1 indicates the digit has not been entered.
     */
   private int thirdToLast;   // the third to last digit entered
   private int secondToLast;  // the second to last digit entered
   private int last;          // the most recent digit entered
   /* invariant:
    *  thirdToLast >= -1 && thirdToLast <= 9 &&
    *  secondToLast >= -1 && secondToLast <= 9 &&
    *  last >= -1 && last <= 9
    */

   
  // Constructors: ------------------------------------------------------------
  
  /**
   * Constructor - Create a lock with the given three digit combination;
   * combination values < 100 are assumed to have leading zeros.
   * @require    combination >= 0 && combination <= 999
   * @ensure     this.isOpen()
   */
  public NewCombinationLock (int combination) {
	// extract the last 3 digits from the input combination
    digit3 = combination % 10;
    combination = combination / 10;
    digit2 = combination % 10;
    combination = combination / 10;
    digit1 = combination % 10;
    isOpen = true;
    // clear the history
    last = -1;
    secondToLast = -1;
    thirdToLast = -1;
  }
  
  // Queries: -----------------------------------------------------------------
  
  /**
   * isOpen - This lock is unlocked.
   */
  public boolean isOpen () {
    return isOpen;
  }
  
  // Commands: ----------------------------------------------------------------
  
  /**
   * close - Lock and reset this lock; partially entered combination is lost.
   */
  public void close () {
    isOpen = false;
    // "forget" past history
    last = -1;
    secondToLast = -1;
    thirdToLast = -1;
  }
   
   /**
    * enter - Enter a digit of the combination;
    *         lock unlocks if the three digits
    *         of the combination are entered in order.
    * @require    digit >= 0 && digit <= 9
    */
   public void enter (final int digit) {
     thirdToLast = secondToLast;
     secondToLast = last;
     last = digit;
     if (thirdToLast == digit1 && secondToLast == digit2
           && last == digit3){
       isOpen = true;
       System.out.println("Congratulations! You opened the lock! The combination was " +thirdToLast+ "" + secondToLast + "" + last);
     }
   }
}