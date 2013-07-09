package l7p3;
/**
 * Title: TestMain class for CSIS 235 Lab #7
 * Description: CS 235 Lab #7 - TestMain
 *              This class has a main method and is the
 *              client of the CombinationLockTest class.
 * @author Ricky Mutschlechner, Tim Olmstead and Noah Muth
 * @email  riccardo.mutschlechner@my.uwrf.edu, timothy.olmstead@my.uwrf.edu and noah.muth@my.uwrf.edu
 * @date   October 23rd, 2012
 */

public class TestMain {
	/**
	 * main method - this is where this test program starts.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting tests of the CombinationLock class ...");
	    (new CombinationLockTest()).runTest();
	    System.out.println("... done!");
	}
}
