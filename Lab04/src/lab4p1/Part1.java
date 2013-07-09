package lab4p1;

import java.io.IOException;
import java.util.Scanner;

/**
 * Title: Part1 class for CSIS 235 Lab #4
 * Description: CS 235 Lab #4 - Part 1
 *              Arrays - arrays of ints, floats, Strings
 * @author Ricky Mutschlechner, Noah Muth, Tim Olmstead
 * @email  riccardo.mutschlechner@my.uwrf.edu, noah.muth@my.uwrf.edu, timothy.olmstead@my.uwrf.edu
 * @date   September 25th 2012
 */

/** what was changed?
 *  The println statement was changed to a prinf statement and was formatted to 
 *  make the output more legible
 */
class Part1 {
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
		int[] id = new int[NUMBER_OF_ACCOUNTS];
		float[] balance = new float[NUMBER_OF_ACCOUNTS];
		String[] first = new String[NUMBER_OF_ACCOUNTS];
		String[] last  = new String[NUMBER_OF_ACCOUNTS];

		/*
		 * Read the first line of the input file into a single String 
		 */
		String header = fileReader.nextLine();
		
		/*
		 * Read all lines of the file
		 *  - assuming the NUMBER_OF_ACCOUNTS is set correctly
		 */
		for (int i=0; i<NUMBER_OF_ACCOUNTS; i++){
			last[i] = fileReader.next();
			first[i] = fileReader.next();
			id[i]    = fileReader.nextInt();
			balance[i] = fileReader.nextFloat();
		}

		out.println(" ... read " + NUMBER_OF_ACCOUNTS + " lines from input file:\n\n" + header );
		for (int i=0; i<NUMBER_OF_ACCOUNTS; i++){
			out.printf("%-15s", last[i]);
			out.printf("%-15s", first[i] );
			out.printf("%-15s", id[i] );
			out.printf("%-15s", balance[i] );
			out.println();
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