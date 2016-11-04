package cucumber.demo.bank.hooks;

import cucumber.api.java.After;
import cucumber.demo.bank.AccountManager;

public class BankGlobalHook {
	@After
	public void reset() {
		AccountManager.instance().reset();
	}
}
