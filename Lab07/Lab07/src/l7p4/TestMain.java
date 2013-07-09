package l7p4;

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
	public static void main(String[] args){
		NewCombinationLock lock1 = new NewCombinationLock(123);
		System.out.println("Made new lock lock1, with combination 123.");
		lock1.close();
		System.out.println("Is the lock open? " + lock1.isOpen());
		
		System.out.println("Entering the number 1...");
		lock1.enter(1);
		
		System.out.println("Entering the number 2...");
		lock1.enter(2);
		
		System.out.println("Entering the number 3...");
		lock1.enter(3);
		
		System.out.println("Did the lock open after inputting 123? " + lock1.isOpen());
	}
}
