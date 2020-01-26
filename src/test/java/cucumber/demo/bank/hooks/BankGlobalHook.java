package cucumber.demo.bank.hooks;

import cucumber.demo.bank.AccountManager;
import io.cucumber.java.After;

public class BankGlobalHook {
	@After
	public void reset() {
		AccountManager.instance().reset();
	}
}
