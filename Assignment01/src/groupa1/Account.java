/**
 * Title: Account class for CSIS 235 Assignment 1
 * Description: CS 235 Assignment 1
 *              Arrays -  an Account array that holds Accounts.
 * @author Ricky Mutschlechner, Noah Muth, Tim Olmstead
 * @email  riccardo.mutschlechner@my.uwrf.edu, noah.muth@my.uwrf.edu, timothy.olmstead@my.uwrf.edu
 * @date   October 5th 2012
 */

package groupa1;

//Data members
public class Account {
	private String lastName;
	private String firstName;
	private int id;
	private float balance;
	private final int MINIMUM_BALANCE = 100;
	
	//Standard constructor
	public Account(String lastName, String firstName, int id, float balance){
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
		this.balance = balance;
	}
	
	//Default constructor
	public Account(){
		this.lastName = null;
		this.firstName = null;
		this.id = 0;
		this.balance = 0.0f;
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
	
	public boolean meetsMinimumBalance() {
		return balance > MINIMUM_BALANCE;
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
			return String.format("You Chose: %-5s %-5s ID: %-5s $%-5s", firstName, lastName, id, balance);
	}
}
