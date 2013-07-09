package lab6part4;

/**
 * Title: TrafficSignalTestClient class for CSIS 235 Lab #6
 * Description: CS 235 Lab #6 - TrafficSignalTestClient 
 * 				This class has a main method and is the client
 * 				 of TrafficSignalTest and TrafficSignal classes.
 * 
 * @author Ricky Mutschlechner and Tim Olmstead
 * @email  riccardo.mutschlechner@my.uwrf.edu and timothy.olmstead@my.uwrf.edu
 * @date   10/17/2012
 */

public class TrafficSignalTestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    TrafficSignalTest test;
	    test = new TrafficSignalTest();
	    try{
	    test.runTest();
	    }catch(TrafficSignalTestException tse){
	    	System.err.println("The initial state does not match green!");
	    }
	}
}