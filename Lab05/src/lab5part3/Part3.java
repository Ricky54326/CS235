package lab5part3;

/**
 * Title: Part3 class for CSIS 235 Lab #5
 * Description: CS 235 Lab #5 - Part 3
 *              This class has a main method that is used to
 *              try out the Account, CheckingAccount, and
 *              SavingsAccount classes.
 * @author Ricky Mutschlechner & Tim Olmstead	
 * @email  riccardo.mutschlechner@my.uwrf.edu & timothy.olmstead@my.uwrf.edu
 * @date   October 5th 2012
 */

import lab5part1.Account;
import lab5part1.CheckingAccount;
import lab5part1.SavingsAccount;

public class Part3 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int NUMBER_OF_ACCOUNTS = 6;
		Account[] accounts = new Account[ NUMBER_OF_ACCOUNTS ];
		accounts[0] = new CheckingAccount("John Hunchar" ,	500 );
		accounts[1] = new SavingsAccount ("Shirin Asadi" ,	750 );
		accounts[2] = new CheckingAccount("Eric Brown"   ,	325 );
		accounts[3] = new SavingsAccount ("Noah Muth"    ,	600 );
		accounts[4] = new CheckingAccount("Jessica Wilson",	242 );
		accounts[5] = new SavingsAccount ("Dylan Robey",	521 );
		
		System.out.println("Starting balances");
		for (Account x : accounts)
			System.out.println( "  Account - " + x );

		float transfer1 = 50;
		accounts[1].withdraw( transfer1 );
		accounts[0].deposit( transfer1);
		
		float transfer2 = 100;
		accounts[2].withdraw( transfer2 );
		accounts[3].deposit( transfer2 );

		float transfer3 = 42;
		accounts[4].withdraw( transfer3 );
		accounts[5].deposit( transfer3 );
		
		System.out.println("Ending balances");
		for (Account x : accounts)
			System.out.println( "  Account - " + x );
	}
}
