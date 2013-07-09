package lab5part5;

/**
 * Title: CheckingAccount class for CSIS 235 Lab #5
 * Description: CS 235 Lab #5 - Part 1
 * This class inherits from Account, with some unique features (not in Part1, however)
 * @author Ricky Mutschlechner & Tim Olmstead	
 * @email  riccardo.mutschlechner@my.uwrf.edu & timothy.olmstead@my.uwrf.edu
 * @date   October 5th 2012
 */

public class CheckingAccount extends Account {
	/*
	 * Instance Variables
	 */
	private static int transactions; //How many transactions have been made
	private final float MIN_BALANCE = 100.00f;
	private final int MAX_FREE_TRANSACTIONS = 10;
	
	
	
	public CheckingAccount(String n, float b){
		super(n, b);
		transactions = 0;
	}
	
	
	
	public String toString(){
		return " checking: " + getName() + ", $" + currentBalance();
	}
	
	
	
	public int getTransactions(){
		return transactions;
	}
	
	
	
	public void withdraw(float amount){
		if(transactions < MAX_FREE_TRANSACTIONS){
			super.withdraw(amount);
			transactions++;
		}
		else{
			System.err.println(getName() + " has exceeded " + MAX_FREE_TRANSACTIONS + " withdrawals for the month, a $1 fee has been added");
			super.withdraw(amount + UNDER_MIN_BALANCE_FEE);
			transactions++;
		}		
	}
	
	
	
	/**
	 * This checks the minimum balance once a "month"
	 * It also resets the number of transactions to zero once a "month" as well.
	 * @param balance
	 */
	public void monthlyCheck(float balance){
		if(balance < MIN_BALANCE){ // checks if balance is under 100
			System.err.println(getName() + " is under the minimum MONTHLY CHECKING balance of $" + MIN_BALANCE + ", withdrawing the MONTHLY fee of $" + 
								UNDER_MIN_BALANCE_FEE);
			super.withdraw(UNDER_MIN_BALANCE_FEE); //This $1 "withdrawal" does not count towards the 10 free withdrawals.
		}
		transactions = 0; //sets monthly transactions to zero every 30 days.
	}


}
