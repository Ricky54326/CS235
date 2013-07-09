package lab3p2;
/**
 * Title: Data class for CSIS 235 Lab 3
 * Description: CS 235 Lab #3 - Data
 *              Basic "server" (see definition of server in the Nino book) class.
 *              All this class does is store 3 pieces of data in data members.
 *              For good encapsulation: all data members should be private unless
 *              there is a real good reason for it to be anything else, like public.
 * @author Ricky Mutschlechner and Shirin Asadi
 * @email  riccardo.mutschlechner@my.uwrf.edu and shirin.asadi@my.uwrf.edu
 * @date   September 17th 2012
 */

public class DataPlus {
	/**
	 * Data members
	 *  -- all 4 are private
	 */
	private int idNumber;
	private String name;
	private float score;
	private double gradePointAverage;

	/**
	 * Constructor for Data class
	 *  -- takes four parameters, one for each data member
	 * @param w
	 * @param x
	 * @param y
	 * @param z
	 */
	public DataPlus(int id, String nm, float sc,  double gpa) {
		this.idNumber = id;
		this.name     = nm;
		this.score    = sc;
		this.gradePointAverage = gpa;
	}
	
	public DataPlus(int id, String nm, float sc){
		this.idNumber = id;
		this.name = nm;
		this.score = sc;
	}

	/**
	 * 3 Getters and 3 Setters, one for each data member.
	 * @return
	 */
	public int getID() {
		return idNumber;
	}

	public void setID(int id) {
		this.idNumber = id;
	}
	
	public float getScore() {
		return score;
	}

	public void setScore(float sc) {
		this.score = sc;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String nm) {
		this.name = nm;
	}

	
	public void setGradePointAverage(double gpa){
		this.gradePointAverage = gpa;
	}
	
	public double getGradePointAverage(){
		return gradePointAverage;
	}

	/**
	 * toString method to allow data to be printed out easily
	 *  prints the 4 data members inside square brackets.
	 */
	@Override
	public String toString() {
		return "Data [ID= " + idNumber + ", Name =  "+  name + ", Score= " + score  + ", GPA: " + gradePointAverage +  "]";
	}	
}
