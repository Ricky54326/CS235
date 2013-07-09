package lab5part1;

/**
 * Title: Part1 class for CSIS 235 Lab #5
 * Description: CS 235 Lab #5 - Part 1
 *              This class has a main method that is used to
 *              try out the Account, CheckingAccount, and
 *              SavingsAccount classes.
 * @author Ricky Mutschlechner & Tim Olmstead	
 * @email  riccardo.mutschlechner@my.uwrf.edu & timothy.olmstead@my.uwrf.edu
 * @date   October 5th 2012
 */

public class Part1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Account a = new Account("John Hunchar" , 500 );
		Account b = new Account("Shirin Asadi" , 750 );
		Account c = new Account("Eric Brown"   , 325 );
		Account d = new Account("Noah Muth"    , 600 );
		CheckingAccount e = new CheckingAccount("Jessica Wilson", 242);
		SavingsAccount f = new SavingsAccount("Dylan Robey", 521);

		System.out.println("Starting balances");
		System.out.println( "  Account a has: $" + a.currentBalance() );
		System.out.println( "  Account b has: $" + b.currentBalance() );
		System.out.println( "  Account c has: $" + c.currentBalance() );
		System.out.println( "  Account d has: $" + d.currentBalance() );
		System.out.println( "  Account e has: $" + e.currentBalance() );
		System.out.println( "  Account f has: $" + f.currentBalance() );

		float transfer1 = 50;
		b.withdraw( transfer1 );
		a.deposit( transfer1);
		
		float transfer2 = 100;
		c.withdraw( transfer2 );
		d.deposit( transfer2 );
		
		float transfer3 = 42;
		e.withdraw( transfer3 );
		f.deposit ( transfer3 );

		System.out.println("Ending balances");
		System.out.println( "  Account a has: $" + a.currentBalance() );
		System.out.println( "  Account b has: $" + b.currentBalance() );
		System.out.println( "  Account c has: $" + c.currentBalance() );
		System.out.println( "  Account d has: $" + d.currentBalance() );
		System.out.println( "  Account e has: $" + e.currentBalance() );
		System.out.println( "  Account f has: $" + f.currentBalance() );
	}
}
