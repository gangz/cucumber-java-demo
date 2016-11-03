package cucumber.demo.bank;

public class AccountTransferService {

	public void transfer(Account accountFrom, Account accountTo, int amount) {
		accountFrom.decrease(amount);
		accountTo.increase(amount);
	}

}
