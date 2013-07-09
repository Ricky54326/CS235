package lab3p2;

/**
 * Title: Part2 class for CSIS 235 Lab 3
 * Description: CS 235 Lab #3 - Part 2
 *              Basic File I/O. Has a lot of elements re-used from lab3p1.Part1.java
 * @author Ricky Mutschlechner and Shirin Asadi
 * @email  riccardo.mutschlechner@my.uwrf.edu and shirin.asadi@my.uwrf.edu
 * @date   September 17th 2012
 */

import java.io.IOException;
import java.util.Scanner;

//import lab3p1.Data; I commented this out after I created DataPlus.java

public class Part2 {
	
	
	/**
	 * These are our private variables used to determine the location
	 * of the file.
	 */
	
	private final static String folder   = "src/lab3p2/";
	private final static String infilename  = folder + "NewDatafile.txt";
	private final static String outfilename = folder + "Outfile.txt";
	private final static java.io.PrintStream out = System.out;
	
	/**
	 * The main method for this program will read data from a file and
	 *   store it in an object. The program then modifies the data and
	 *   stores it back into the file.
	 * Whenever we use file I/O, we have to use exceptions. Make sure
	 *   you know what "try", "catch" and "throw" mean and what 
	 *   exceptions are used for.
	 *   
	 * @param args
	 * @throws Exception 
	 */
	
	public static void main(String[] args) throws Exception{
	
	java.io.FileInputStream fIn = openInputFile( infilename ); 
	if (fIn == null)
		throw new Exception("Bad file name!!");
	Scanner fileReader = new Scanner( fIn );
	
	
	// Read data from the file and store in Data object
	int integerIn = fileReader.nextInt();
	String stringIn = fileReader.next();
	float floatIn = fileReader.nextFloat();
	double doubleIn = fileReader.nextDouble();
	
	DataPlus dataReadIn = new DataPlus( integerIn, stringIn, floatIn,  doubleIn );
	
	closeFile( fIn ); // Once we are done reading, we can close the file
	
	// Print out the Data object for the user to see
	out.println("  Data object set up: " + dataReadIn );
	
	// Set up a new Data object based on a modified version of the Data object
	// Adds 10 to the ID number, adds "Language" after the name, adds 100.0 to the score and adds 0.5 to the GPA.
	DataPlus modData = new DataPlus( dataReadIn.getID() + 10, 
			dataReadIn.getName() + "Language", dataReadIn.getScore() + 100.0f,
			dataReadIn.getGradePointAverage() + 0.5);
	
	// Print the modified Data for the user
	out.println("  after modification, Data object is: " + modData );
	
	// Store modified data into the file.
	java.io.FileOutputStream fOut = openOutFile( outfilename );
	java.io.PrintStream outf = new java.io.PrintStream( fOut );
	outf.println( "" + modData.getID() + "\t" + modData.getName() + "\t" + modData.getScore() + "\t" + modData.getGradePointAverage() );
	// Close the file so that the changes are saved.
	closeFile( fOut );
	
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
	 * openOutFile - a method that opens a file for writing.
	 * 
	 * @param fname - name of the output file
	 */
	private static java.io.FileOutputStream openOutFile(String fname) {
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

