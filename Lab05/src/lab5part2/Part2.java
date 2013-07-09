package lab5part2;

/**
 * Title: Part2 class for CSIS 235 Lab #5
 * Description: CS 235 Lab #5 - Part 2
 *              This class has a main method that is used to
 *              try out the Account, CheckingAccount, and
 *              SavingsAccount classes.
 * @author Anthony Varghese
 * @email  your.n.here@my.uwrf.edu
 * @date   October 5th 2012
 */

import lab5part1.Account;
import lab5part1.CheckingAccount;
import lab5part1.SavingsAccount;

public class Part2 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Account a = new CheckingAccount("John Hunchar" , 500 );
		Account b = new SavingsAccount("Shirin Asadi" , 750 );
		Account c = new CheckingAccount("Eric Brown"   , 325 );
		Account d = new SavingsAccount("Noah Muth"    , 600 );
		Account e = new CheckingAccount("Jessica Wilson", 242 );
		Account f = new SavingsAccount("Dylan Robey", 521 );
		
		System.out.println("Starting balances");
		System.out.println( "  Account a: " + a );
		System.out.println( "  Account b: " + b );
		System.out.println( "  Account c: " + c );
		System.out.println( "  Account d: " + d );
		System.out.println( "  Account e: " + e );
		System.out.println( "  Account f: " + f );

		float transfer1 = 50;
		b.withdraw( transfer1 );
		a.deposit( transfer1);
		
		float transfer2 = 100;
		c.withdraw( transfer2 );
		d.deposit( transfer2 );

		float transfer3 = 42;
		e.withdraw( transfer3 );
		f.deposit( transfer3 );
		
		System.out.println("Ending balances");
		System.out.println( "  Account a: " + a );
		System.out.println( "  Account b: " + b );
		System.out.println( "  Account c: " + c );
		System.out.println( "  Account d: " + d );
		System.out.println( "  Account e: " + e );
		System.out.println( "  Account f: " + f );
	}
}
