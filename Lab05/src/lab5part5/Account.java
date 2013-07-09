package lab5part5;

/**
 * 
 * Title: Account class for CSIS 235 Lab #5
 * Description: CS 235 Lab #5 - Part 5
 *              This Account class is used to represent a bank account
 *              for a person or organization 
 *              It has two data members:
 *              - a String for the name of the owner
 *                   that the account belongs to
 *              - a float for the current balance
 * @author Ricky Mutschlechner & Tim Olmstead	
 * @email  riccardo.mutschlechner@my.uwrf.edu & timothy.olmstead@my.uwrf.edu
 * @date   October 5th 2012
 */

public abstract class Account {
	/**
	 * Data members:
	 * name - Name of person/organization
	 * balance - current balance
	 */
	private String name;
	private float balance;
	protected static final int UNDER_MIN_BALANCE_FEE = 1;
	private int age;
	
	/**
	 * Constructor - the two parameters are used to 
	 *   initialize the data members
	 * @param n
	 * @param b
	 */
	public Account(String n, float b){
		name = n;
		balance = b;
		age = 1;
	}
	
	/**
	 * Default Constructor - this is one we do not want used
	 */
	public Account(){
		name = null;
		balance = 0;
	}
	
	public void incrimentAge(int modifier){
		age += modifier;
		if(age % 30 == 0) //implying that 30 "days" is a "month"
			monthlyCheck(balance);
	}
	
	public abstract void monthlyCheck(float balance);
	public abstract int getTransactions();
	public abstract String toString();
	
	
	/**
	 * deposit - The deposit method should either 
	 *  increase the balance or leave it 
	 *  the same as before. 
	 * @param amount
	 */
	public void deposit(float amount){
		balance = balance + amount;
	}
	/**
	 * withdraw - The withdraw method should either 
	 *  decrease the balance or leave it 
	 *  the same as before.
	 * @param amount
	 */
	public void withdraw(float amount){
		balance = balance - amount;
	}

	/**
	 * getName - Returns the name data member.
	 * @return a String - name
	 */
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}

	/**
	 * currentBalance - Returns the current value of
	 *   the balance data member.
	 * @return a float == balance
	 */
	public float currentBalance(){
		return balance;
	}
	
	
}