package lab3p4;

//import lab3p4.ClientPlus;

/**
 * Title: Part3 class for CSIS 235 Lab 3
 * Description: CS 235 Lab #3 - Part 3
 *              Basic File I/O and Multiple Classes.
 * @author Ricky Mutschlechner and Shirin Asadi
 * @email  riccardo.mutschlechner@my.uwrf.edu and shirin.asadi@my.uwrf.edu
 * @date   September 18th 2012
 */

public class Part4 {
	/**
	 * Data members
	 *  The static String named "filename" is used to hold the name of
	 *   the file that we will read from.
	 *       ** Note that when using Eclipse this file will be in the
	 *       ** package folder and not in the Project or src folders.
	 *       
	 *  The static PrintStream object named "out" is used for convenience - 
	 *   it is not really necessary. 
	 */
	private final static String folder   = "src/lab3p2/";
	private final static String infilename  = folder + "NewDatafile.txt"; //Reads the input file here
	private final static String outfilename = folder + "NewOutfile.txt"; //Saves the modified output file here

	
	/**
	 * The main method for this program will read data from a file and
	 *   store it in an object. The program then modifies the data and
	 *   stores it back into the file.
	 *   
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// Set up a client object and read in data from a file
		ClientPlus mainClient = new ClientPlus( );
		mainClient.readData( infilename );
		
		mainClient.printInputData(); // print out the data we just read in
		
		/* Modify the data read in and print it out */
		mainClient.modifyInputData();
		mainClient.printModifiedData();
		
		// Store the data - a "new" file should be created after this step.
		mainClient.writeData( outfilename );
	}
}