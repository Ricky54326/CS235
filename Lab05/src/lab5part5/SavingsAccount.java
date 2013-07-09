package lab5part5;

/**
 * Title: SavingsAccount class for CSIS 235 Lab #5
 * Description: CS 235 Lab #5 - Part 1
 * This class inherits from Account, with some unique features (not in Part1, however)
 * @author Ricky Mutschlechner & Tim Olmstead	
 * @email  riccardo.mutschlechner@my.uwrf.edu & timothy.olmstead@my.uwrf.edu
 * @date   October 5th 2012
 */


public class SavingsAccount extends Account {
	
	private final float MIN_BALANCE = 500.00f;
	private final float INTEREST_RATE = 0.03f;
	
	public SavingsAccount(String n, float b){
		super(n, b);
	}
	
	
	public int getTransactions(){return -1;} //unused for Savings
	
	
	
	
	public void withdraw(float amount){
		if(currentBalance() < MIN_BALANCE){
			super.withdraw(amount);
		}
		else{
			System.err.println(getName() + " is below the minimum SAVINGS balance of $" + MIN_BALANCE +", a $"+UNDER_MIN_BALANCE_FEE+" fee has been added");
			super.withdraw(amount + UNDER_MIN_BALANCE_FEE);
		}		
	}
	
	
	
	
	public void monthlyCheck(float balance){
		if(balance < MIN_BALANCE){ // checks if balance is under MIN_BALANCE
			System.err.println(getName() + " is under the the minimum MONTHLY SAVINGS balance of $" + MIN_BALANCE + ", withdrawing the MONTHLY fee of $" + 
					UNDER_MIN_BALANCE_FEE);
			super.withdraw(UNDER_MIN_BALANCE_FEE); //This $1 "withdrawal" does not count towards the 10 free withdrawals.
		}
		
		balance *= (1 + INTEREST_RATE/12); //Monthly compounded annual interest
	}
	
	public String toString(){
		return " savings: " + getName() + ", $" + currentBalance();
	}

}
