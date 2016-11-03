package cucumber.demo.bank;

public class Account {
	
	private String accountId;
	private int balance;

	public Account(String accountId) {
		this.accountId = accountId;
		this.balance = 0;
	}

	public void increase(int amount) {
		balance+=amount;
	}

}
