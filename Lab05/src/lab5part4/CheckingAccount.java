package lab5part4;

/**
 * Title: CheckingAccount class for CSIS 235 Lab #5
 * Description: CS 235 Lab #5 - Part 1
 * This class inherits from Account, with some unique features (not in Part1, however)
 * @author Ricky Mutschlechner & Tim Olmstead	
 * @email  riccardo.mutschlechner@my.uwrf.edu & timothy.olmstead@my.uwrf.edu
 * @date   October 5th 2012
 */

public class CheckingAccount extends Account {
	public CheckingAccount(String n, float b){
		super(n, b);
	}
	
	public String toString(){
		return " checking: " + getName() + ", $" + currentBalance();
	}

}
