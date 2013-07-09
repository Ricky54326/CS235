package lab5part5;

public class Tester {

	public static void main(String[] args){
	/*	Account a = new SavingsAccount("Ricky M", 500);
		//for(int i = 1; i <= 12; i++){
			a.incrimentAge(29); // one "day" goes by
			a.withdraw(25);
			System.out.println(a);
			a.incrimentAge(30);
			System.out.println(a);
			//System.out.println(a.getTransactions()); //for checking only
		
	*/   //}
			
			
			
		Account b = new CheckingAccount("Tim", 100);
		//for(int i = 0; i < 11; i++){
		b.withdraw(10);
		b.incrimentAge(29);
		System.out.println(b);
		//}
	}
}
