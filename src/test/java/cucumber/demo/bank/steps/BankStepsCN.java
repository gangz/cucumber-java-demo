package cucumber.demo.bank.steps;

import cucumber.demo.bank.Account;
import cucumber.demo.bank.AccountManager;
import cucumber.demo.bank.AccountTransferService;
import io.cucumber.java.zh_cn.假如;

import static org.junit.Assert.assertEquals;

public class BankStepsCN {
	private boolean lastTransferResult;

	@假如("创建一个账户{string}")
	public void 创建一个账户(String accountId) throws Throwable {
		AccountManager.instance().create(accountId);
	}

	@假如("向账户{string}存入{int}元")
	public void 向账户_存入_元(String accountId,int amount) throws Throwable {
		Account account = AccountManager.instance().getAccount(accountId);
		account.increase(amount);
	}

	@假如("从账户{string}向账户{string}转账{int}元")
	public void 从账户_向账户_转账_元(String accountOrigin, String accountDestination, int amount) throws Throwable {
		Account accountFrom = AccountManager.instance().getAccount(accountOrigin);
		Account accountTo = AccountManager.instance().getAccount(accountDestination);
		AccountTransferService service = new AccountTransferService();
		lastTransferResult = service.transfer(accountFrom, accountTo, amount);
	}

	@假如("账户{string}应该有{int}元")
	public void 账户_应该有_元(String accountId, int amount) throws Throwable {
		Account account = AccountManager.instance().getAccount(accountId);
		assertEquals(amount,account.getBalance());
	}
}
