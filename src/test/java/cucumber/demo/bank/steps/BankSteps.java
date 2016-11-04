package cucumber.demo.bank.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import cucumber.demo.bank.Account;
import cucumber.demo.bank.AccountManager;
import cucumber.demo.bank.AccountTransferService;

import static org.junit.Assert.*;

import java.util.List;
public class BankSteps {

	private boolean lastTransferResult;

	@Given("^Create an account '(\\w+)'")
	public void create_an_account(String accountId) throws Throwable {
		AccountManager.instance().create(accountId);
	}
	
	@Given("^Save (\\d+) to account '(\\w+)'$")
	public void save_to_account(int amount, String accountId) throws Throwable {
		Account account = AccountManager.instance().getAccount(accountId);
		account.increase(amount);
	}
	
	
	@Given("^Transfer (\\d+) from account '(\\w+)' to '(\\w+)'$")
	public void transfer_from_account_to(int amount, String accountOrigin, String accountDestination) throws Throwable {
		Account accountFrom = AccountManager.instance().getAccount(accountOrigin);
		Account accountTo = AccountManager.instance().getAccount(accountDestination);
		AccountTransferService service = new AccountTransferService();
		lastTransferResult = service.transfer(accountFrom, accountTo, amount);
	}
	
	@Then("^The account '(\\w+)' should have (\\d+)$")
	public void account_should_have(String accountId, int amount) throws Throwable {
		Account account = AccountManager.instance().getAccount(accountId);
		assertEquals(amount,account.getBalance());
	}

	@Then("^The transfer result should be '(.*)'$")
	public void the_transfer_result_should_be_fail(String result) throws Throwable {
		boolean expectedResult = Boolean.parseBoolean(result);
		assertEquals(expectedResult,lastTransferResult);
	}

	@Given("^The following accounts:$")
	public void createAccount(List<Account> accounts){
		for (Account account:accounts){
			AccountManager.instance().addAccount(account);
		}
	}
}
