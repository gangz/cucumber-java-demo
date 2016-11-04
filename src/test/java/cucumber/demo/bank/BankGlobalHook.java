package cucumber.demo.bank;

import cucumber.api.java.After;

public class BankGlobalHook {
	@After
	public void reset() {
		AccountManager.instance().reset();
	}
}
