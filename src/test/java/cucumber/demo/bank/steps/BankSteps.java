package cucumber.demo.bank.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import cucumber.demo.bank.Account;
import cucumber.demo.bank.AccountManager;
import cucumber.demo.bank.AccountTransferService;
import cucumber.demo.bank.Person;
import gherkin.formatter.model.DataTableRow;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	/*
	 * | name | value |
          | OrderNumber | 1 |
          | Name | Zhang San|
          | Age | 20|
          | Height| 180|
	 */
	@Given("^Create a complex data structure with:$")
	public void create_a_complex_data_structure_with(DataTable data) throws Throwable {
		Map<String, String> map = data.asMap(String.class, String.class);
		Person p = new Person();
		p.orderNumber = map.get("OrderNumber");
		p.name =  map.get("Name");
		p.age = Integer.parseInt(map.get("Age"));
		p.height = Integer.parseInt(map.get("Height"));
	}
}
