package cucumber.demo.bank;

import cucumber.api.java.en.*;

public class BankSteps {

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
		System.out.println("Transfer "+amount+" from account:"  +accountOrigin + " to account:" + accountDestination);
	}
	
	@Then("^The account '(\\w+)' should have (\\d+)$")
	public void the_account_should_have(String accountId, int amount) throws Throwable {
		System.out.println("Check account "+ accountId + " balance " + amount);
	}

}
