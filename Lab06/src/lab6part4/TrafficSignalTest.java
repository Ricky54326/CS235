package lab6part4;

/**
 * Title: TrafficSignalTest class for CSIS 235 Lab #6 Description: CS 235 Lab #6
 * - TrafficSignalTest This class is a simple tester for the class
 * TrafficSignal.
 * 
 * @author Ricky Mutschlechner and Tim Olmstead
 * @email  riccardo.mutschlechner@my.uwrf.edu and timothy.olmstead@my.uwrf.edu
 * @date   10/17/2012
 */
class TrafficSignalTestException extends Exception { 
	private static final long serialVersionUID = 1L;//just to stop the compiler warnings

	public TrafficSignalTestException(String a) {
		super(a);
	}
}

public class TrafficSignalTest {

	private String errorMessage = "The Light is not Green!";

	private TrafficSignal signal; // the object to test

	/**
	 * Create a TrafficSignalTest
	 */
	public TrafficSignalTest() {
		// create a signal to test:
		signal = new TrafficSignal();
	}

	/**
	 * Run the test.
	 * 
	 * @throws TrafficSignalTestException
	 */
	public void runTest() throws TrafficSignalTestException {
		testInitialState();
		testChange();
	}

	/**
	 * Test the TrafficSignal's initial state.
	 * 
	 * @throws TrafficSignalTestException
	 */
	private void testInitialState() throws TrafficSignalTestException {
		System.out.println("testInitialState:");
		if (signal.light() == 1 || signal.light() == 2) {
			throw new TrafficSignalTestException(errorMessage);
		} else {

			System.out.println("Initial light: " + signal.light());
		}
	}

	/**
	 * Test the method change.
	 * @throws TrafficSignalTestException 
	 */
	private void testChange() throws TrafficSignalTestException {
		System.out.println("testChange:");
		System.out.println("Starting light: " + signal.light());
		signal.change();

		System.out.println("Initial light: " + signal.light());
		if ((signal.light() == 1 || signal.light() == 2)) {
			throw new TrafficSignalTestException(errorMessage);
		}
		else{
		System.out.println("After 1 change: " + signal.light());
		signal.change();
		System.out.println("After 2 changes: " + signal.light());
		signal.change();
		System.out.println("After 3 changes: " + signal.light());
	}
}
}