/** Class of Bank Account.
 *  A bank account has a balance and a mechanism for applying interest or fees at 
 *  the end of month.
 */

public class BankAccount
{
	private double balance;

	/**
	Constructs a bank account with zero balance.
	*/
	public BankAccount(){
		balance = 0;
	}

	/**
	Deposit money into the account.
	@param amount: the amount of deposit
   	*/
	public void deposit(double amount){
     		balance = balance + amount;
	}
   

	/**
	Withdraw money from the account.
	Also include action of charging penalty if the balance is insufficient.
	@param amount the amount of the withdrawal
	*/
	public void withdraw(double amount){
		balance = balance - amount;
	}
   
	/**
	Action would be carried out at the end of month.
	To be defined.
	*/
	public void monthEnd(){
	}
   
	/**
	Get the balance in bank account.
	@return the current balance
	*/
	public double getBalance(){
      		return balance;
   	}
}
