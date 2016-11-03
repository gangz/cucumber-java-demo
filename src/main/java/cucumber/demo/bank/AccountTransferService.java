package cucumber.demo.bank;

public class AccountTransferService {

	public boolean transfer(Account accountFrom, Account accountTo, int amount) {
		if (accountFrom.getBalance()<amount) return false;
		accountFrom.decrease(amount);
		accountTo.increase(amount);
		return true;
	}

}
