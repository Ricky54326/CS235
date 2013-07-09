package lab5part5;

/**
 * Title: Part5 class for CSIS 235 Lab #5
 * Description: CS 235 Lab #5 - Part 5
 *              This class has a main method that is used to
 *              try out the Account, CheckingAccount, and
 *              SavingsAccount classes.
 * @author Ricky Mutschlechner & Tim Olmstead	
 * @email  riccardo.mutschlechner@my.uwrf.edu & timothy.olmstead@my.uwrf.edu
 * @date   October 5th 2012
 */

public class Part5 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int NUMBER_OF_ACCOUNTS = 6;
		int MONTH1_TRANSFER = 0;
		int MONTH2_TRANSFER = 0;
		
		Account[] starting = new Account[ NUMBER_OF_ACCOUNTS ];
		starting[0] = new CheckingAccount("John Hunchar" ,	500 );
		starting[1] = new SavingsAccount ("Shirin Asadi" ,	750 );
		starting[2] = new CheckingAccount("Eric Brown"   ,	325 );
		starting[3] = new SavingsAccount ("Noah Muth"    ,	600 );
		starting[4] = new CheckingAccount("Jessica Wilson",	242 );
		starting[5] = new SavingsAccount ("Dylan Robey",	521 );
		
		System.out.println("Starting balances");
		for (Account x : starting)
			System.out.println( "  Account - " + x );

		/*
		 * Make a copy of the starting accounts and apply transactions to it.
		 */
		Account[] temp = new Account[ starting.length ];
		for (int i=0; i<starting.length; i++){
			if (starting[i] instanceof CheckingAccount){
				temp[i] = new CheckingAccount( starting[i].getName(), starting[i].currentBalance() );
			} else if (starting[i] instanceof SavingsAccount){
				temp[i] = new SavingsAccount( starting[i].getName(), starting[i].currentBalance() );
			}
		}
		
		/*
		 * Transactions for the first month
		 */
		MONTH1_TRANSFER = 50;
		temp[1].withdraw( MONTH1_TRANSFER );
		temp[0].deposit( MONTH1_TRANSFER);
		
		MONTH1_TRANSFER = 75;
		temp[1].withdraw( MONTH1_TRANSFER );
		temp[3].deposit( MONTH1_TRANSFER );

		MONTH1_TRANSFER = 42;
		temp[1].withdraw( MONTH1_TRANSFER );
		temp[5].deposit( MONTH1_TRANSFER );
		
		MONTH1_TRANSFER = 50;
		temp[1].withdraw( MONTH1_TRANSFER );
		temp[0].deposit( MONTH1_TRANSFER);
		
		MONTH1_TRANSFER = 75;
		temp[1].withdraw( MONTH1_TRANSFER );
		temp[3].deposit( MONTH1_TRANSFER );

		MONTH1_TRANSFER = 42;
		temp[1].withdraw( MONTH1_TRANSFER );
		temp[5].deposit( MONTH1_TRANSFER );
		
		MONTH1_TRANSFER = 50;
		temp[1].withdraw( MONTH1_TRANSFER );
		temp[0].deposit( MONTH1_TRANSFER);
		
		MONTH1_TRANSFER = 75;
		temp[1].withdraw( MONTH1_TRANSFER );
		temp[3].deposit( MONTH1_TRANSFER );

		MONTH1_TRANSFER = 42;
		temp[1].withdraw( MONTH1_TRANSFER );
		temp[5].deposit( MONTH1_TRANSFER );
		
		for (int i = 0; i < 10; i++){
			temp[2]. withdraw(5);
		}
			
		
		//Sets the age of all accounts to 30, which is the "end of the month"
		for(Account a : temp){
			a.incrimentAge(29);
		}

		/*
		 * Make a copy of the starting accounts and apply transactions to it.
		 */
		Account[] month1 = new Account[ starting.length ];
		for (int i=0; i<temp.length; i++){
			if (temp[i] instanceof CheckingAccount){
				month1[i] = new CheckingAccount( temp[i].getName(), temp[i].currentBalance() );
			} else if (temp[i] instanceof SavingsAccount){
				month1[i] = new SavingsAccount( temp[i].getName(), temp[i].currentBalance() );
			}
		}

		System.out.println();
		System.out.println("Ending balances for month 1");
		for (Account x : month1)
			System.out.println( "  Account - " + x );

		/*
		 * Transactions for the second month
		 */
		MONTH2_TRANSFER = 35;
		temp[0].withdraw( MONTH2_TRANSFER );
		temp[1].deposit( MONTH2_TRANSFER );
		
		MONTH2_TRANSFER = 50;
		temp[3].withdraw( MONTH2_TRANSFER );
		temp[2].deposit( MONTH2_TRANSFER );

		MONTH2_TRANSFER=24;
		temp[5].withdraw( MONTH2_TRANSFER );
		temp[4].deposit( MONTH2_TRANSFER );
		
		for (int i =0; i<=11; i++){
			temp[4].withdraw (10);
			temp [1].withdraw(5);
		}
		
		
		
		System.out.println();
		System.out.println("Ending balances for month 2");
		for (Account x : temp)
			System.out.println( "  Account - " + x );

	}
}