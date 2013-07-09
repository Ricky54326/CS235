package lab4p2;

import java.io.IOException;
import java.util.Scanner;

/**
 * Title: Part2 class for CSIS 235 Lab #4
 * Description: CS 235 Lab #4 - Part 2
 *              Arrays - arrays of accounts
 * @author Ricky Mutschlechner, Noah Muth, Tim Olmstead
 * @email  riccardo.mutschlechner@my.uwrf.edu, noah.muth@my.uwrf.edu, timothy.olmstead@my.uwrf.edu
 * @date   September 25th 2012
 */

public class Part2 {
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
	private final static String folder   = "src/lab4p1/";
	private final static String infilename = folder + "Accounts.txt";
	private final static java.io.PrintStream out = System.out;

	/*
	 * The array data members
	 */
	private static final int NUMBER_OF_ACCOUNTS = 20;
	

	public static void main(String[] args) throws Exception {
		out.println( "Reading data from " + infilename + " ...");
		
		// Open the named file for reading
		java.io.FileInputStream fIn = openInputFile( infilename ); 
		if (fIn == null)
			throw new Exception("Bad file name!!");
		Scanner fileReader = new Scanner( fIn );

		/**
		 * Set up arrays with enough space to read in data.
		 */
		
		Account[] accs = new Account[NUMBER_OF_ACCOUNTS];

		/*
		 * Read the first line of the input file into a single String 
		 */
		String header = fileReader.nextLine(); // Changed this to match the new format
		header = "First Name: \t Last Name: \t Has Minimum Balance:";
		
		/*
		 * Read all lines of the file
		 *  - assuming the NUMBER_OF_ACCOUNTS is set correctly
		 */
		for (int i=0; i<NUMBER_OF_ACCOUNTS; i++){
			accs[i] = new Account(fileReader.next(), fileReader.next(),
			fileReader.nextInt(), fileReader.nextFloat()); //Adds Accounts to the accs array.
		}

		out.println(" ... read " + NUMBER_OF_ACCOUNTS + " lines from input file:\n\n" + header );
		for(int i = 1; i < NUMBER_OF_ACCOUNTS; i++){
			System.out.println(accs[i]); //no need for .toString() as it is automatically called
		}
		closeFile( fIn ); // Once we are done reading, we can close the file
		
	}

	/**
	 * openFile - a method that opens a file for reading.
	 * 
	 * @param fname - name of the input file
	 */
	private static java.io.FileInputStream openInputFile(String fname) {
		java.io.FileInputStream fIn = null;
		try {
			fIn = new java.io.FileInputStream( fname );
		} catch(java.io.FileNotFoundException fex){
			System.err.println(" Error! This program is trying to open " + fname + " but it does not exist! Or it's some place else.");
		}
		return fIn;
	}

	/**
	 * closeFile - a method that closes a file 
	 *    that was previously opened for reading
	 *    or writing.
	 * 
	 * @param fs - an open FileInputStream or FileOutputStream object
	 */
	private static void closeFile(java.io.Closeable fs) {
		if (fs == null)
			return; // nothing to close
		try {
			fs.close();
		} catch (IOException e) {
			System.err.println(" Error! This program is trying to close a file but something went wrong.");
		}
	}
}