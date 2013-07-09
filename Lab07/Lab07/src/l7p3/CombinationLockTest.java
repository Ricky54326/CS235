package l7p3;

/**
 * Test for class CombinationLock.
/**
 * Title: CombinationLockTest class for CSIS 235 Lab #7
 * Description: CS 235 Lab #7 - CombinationLockTest
 *              This class tests the CombinationLock class.
 *              
 * @author Ricky Mutschlechner, Tim Olmstead and Noah Muth
 * @email  riccardo.mutschlechner@my.uwrf.edu, timothy.olmstead@my.uwrf.edu and noah.muth@my.uwrf.edu
 * @date   October 23rd, 2012
 */

public class CombinationLockTest {

	private CombinationLock lock;

	/**
	 * Constructor - set up a test by setting the data member, lock, to null.
	 * 
	 */
	public CombinationLockTest() {
		lock = null;
	}

	/**
	 * runTest - Runs a test to change the combination, however is incomplete at this point. 
	 * Needs to be implemented into the testLock function instead of kept in main.
	 * 
	 */
	public void runTest() {
		testLock(000); // test lock with minimum combination
		testLock(123); // test lock with typical combination
		testLock(999); // test lock with maximum combination
	}

	/**
	 * testLock - Test a lock with the specified combination.
	 * 
	 */
	private void testLock(int combination) {
		System.out.println("Creating a lock with combination " + combination);
		lock = new CombinationLock(combination);
		testInitialState();
		testClose();
		testOpen(combination);
		int newCombination = 321;
		testChangeCombination(newCombination);
		testOpen(combination);
		testOpen(newCombination);
		System.out.println("\n");

	}

	/**
	 * testInitialState - Test lock is initially open.
	 * 
	 */
	private void testInitialState() {
		System.out.println("Is the lock already open? " + lock.isOpen());
	}

	/**
	 * testClose - Test close operation.
	 * 
	 */
	private void testClose() {
		lock.close(); // close an open lock
		System.out.println("Closed the lock.");
	}

	/**
	 * testOpen - Test open operation.
	 * 
	 */
	private void testOpen(int combination) {
		// Close the lock and then try to open it
		// with the "good" combination - should work.
		System.out.println("Attemtping to open the lock with combination " + combination);
		lock.close();
		lock.open(combination); // open a closed lock
		System.out.println("Did the lock open with " + combination + "? " + lock.isOpen());
		
	}
	
	
	private void testChangeCombination(int combination){
		//Change the combination of a lock, and then close it.
		System.out.println("Changing the lock's combination to " +combination);
		lock.changeCombination(combination);
		lock.close();
	}
}