package cucumber.demo.bank;

public class Account {
	
	private String accountId;
	private int balance;

	public Account(String accountId,int balance) {
		this.accountId = accountId;
		this.balance = balance;
	}
	

	public void increase(int amount) {
		balance+=amount;
	}

	public int getBalance() {
		return balance;
	}

	public void decrease(int amount) {
		if (amount<=balance)
			balance-=amount;
	}

	public String getId() {
		return accountId;
	}

}
