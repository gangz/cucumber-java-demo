package cucumber.demo.bank;

import cucumber.api.java.After;

public class BankStepsEnv {
	@After
	public void reset() {
		AccountManager.instance().reset();
	}
}
