/**
 * Title: Part1 class for CSIS 235 Lab #4
 * Description: CS 235 Lab #4 - Part 1
 *              Arrays - arrays of ints, floats, Strings
 * @author Ricky Mutschlechner, Noah Muth, Tim Olmstead
 * @email  riccardo.mutschlechner@my.uwrf.edu, noah.muth@my.uwrf.edu, timothy.olmstead@my.uwrf.edu
 * @date   September 25th 2012
 */


/**
 *
 * This class holds the data that a "Bank Account" would hold, when created and instantiated. 
 */

package lab4p2;

public class Account {
	private String lastName;
	private String firstName;
	private int id;
	private float balance;
	private final float MINIMUM_BALANCE = 100.0f;
	
	public Account(String lastName, String firstName, int id, float balance){
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
		this.balance = balance;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public int getid(){
		return id;
	}
	
	public float getBalance(){
		return balance;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public void setid(int id){
		this.id = id;
	}
	
	public void setBalance(float balance){
		this.balance = balance;
	}
	
	public String toString(){
		String s = String.format("%-15s   %-15s   %-15s", firstName, lastName, (balance >= MINIMUM_BALANCE));
			return (s); 

	}
}
