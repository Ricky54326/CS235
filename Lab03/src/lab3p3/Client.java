package lab3p3;

import java.io.IOException;
import java.util.Scanner;

/**
 * Title: Client class for CSIS 235 Lab 3
 * Description: CS 235 Lab #3 - Client
 *              Basic "client" class.
 *                 see definition of the terms "client" and "server" in the Nino book
 *              All this class does is use a "server" class called Data to store
 *              information.
 *              For good encapsulation: all data members should be private unless
 *              there is a real good reason for it to be anything else, like public.
 *              Note that this "client" class is, in turn, a "server" class for the Part2 class.
 * @author Ricky Mutschlechner and Shirin Asadi
 * @email  riccardo.mutschlechner@my.uwrf.edu and shirin.asadi@my.uwrf.edu
 * @date   September 17th 2012
 */

public class Client {
	/**
	 * Data members of the Client class
	 * - infilename - the name of the file we will read
	 * - outfilename - the name of the file we will write to
	 * - dataIn stores the data we read in
	 * - dataOut has the data we will write out
	 */
	private String infilename;
	private String outfilename;
	private lab3p1.Data dataIn;
	private lab3p1.Data dataOut;
	private final static java.io.PrintStream out = System.out;

	/**
	 * Constructor
	 * 
	 */
	public Client( ) {
		
	}

	/**
	 * readData - this is where we read data in from a file
	 * @throws Exception 
	 */
	public void readData(String inf) throws Exception {
		infilename = inf;
		out.println( "Reading data from " + infilename + " ...");

		// Open the named file for reading
		java.io.FileInputStream fIn = openInputFile( infilename ); 
		if ( fIn == null )
			throw new Exception("Bad file name!!");
		Scanner fileReader = new Scanner( fIn );
		
		// Read data from the file and store in Data object
		int integerIn = fileReader.nextInt();
		String stringIn = fileReader.next();
		float floatIn = fileReader.nextFloat();
		
		dataIn = new lab3p1.Data( integerIn, stringIn, floatIn );
		
		closeFile( fIn ); // Once we are done reading, we can close the file
	}

	/**
	 * modifyInputData - Set up a new Data object based on a modified
	 *  version of the Data object read from file
	 */
	public void modifyInputData() {
		dataOut = new lab3p1.Data( dataIn.getID() + 10,
							dataIn.getName() + "Language", 
							dataIn.getScore() + 105.0f );
	}
	
	/**
	 * writeData - this is where we write data to a file
	 */
	public void writeData(String of) {
		outfilename = of;

		// Store modified data into the file.
		java.io.FileOutputStream fOut = openOutFile( outfilename );
		java.io.PrintStream outf = new java.io.PrintStream( fOut );
		outf.println( "" + dataOut.getID() + "\t" + dataOut.getScore() + "\t" + dataOut.getName() );
		// Close the file so that the changes are saved.
		closeFile( fOut );
	}

	/**
	 * printInputData - Print out the Data object for the user to see
	 */
	public void printInputData() {
		out.println("  Data object set up: " + dataIn );
	}
	
	/**
	 * printModifiedData - Print out the Data object for the user to see
	 */
	public void printModifiedData() {
		out.println("  Data object set up: " + dataOut );
	}

	/**
	 * openFile - a method that opens a file for reading.
	 * 
	 * @param fname - name of the input file
	 */
	private java.io.FileInputStream openInputFile(String fname) {
		java.io.FileInputStream fIn = null;
		try {
			fIn = new java.io.FileInputStream( fname );
		} catch(java.io.FileNotFoundException fex){
			System.err.println(" Error! This program is trying to open " + fname + " but it does not exist! Or it's some place else.");
		}
		return fIn;
	}

	/**
	 * openOutFile - a method that opens a file for writing.
	 * 
	 * @param fname - name of the output file
	 */
	private java.io.FileOutputStream openOutFile(String fname) {
		java.io.FileOutputStream fOut = null;
		try {
			fOut = new java.io.FileOutputStream( fname );
		} catch(java.io.FileNotFoundException fex){
			System.err.println(" Error! This program is trying to open " + fname + " but it does not exist! Or it's some place else.");
		}
		return fOut;
	}

	/**
	 * closeFile - a method that closes a file 
	 *    that was previously opened for reading
	 *    or writing.
	 * 
	 * @param fs - an open FileInputStream or FileOutputStream object
	 */
	private void closeFile(java.io.Closeable fs) {
		if (fs == null)
			return; // nothing to close
		try {
			fs.close();
		} catch (IOException e) {
			System.err.println(" Error! This program is trying to close a file but something went wrong.");
		}
	}
}
