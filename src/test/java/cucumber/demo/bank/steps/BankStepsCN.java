package cucumber.demo.bank.steps;

import cucumber.api.java.After;
import cucumber.api.java.zh_cn.*;

public class BankStepsCN {
	

	BankSteps steps = new BankSteps();
	@假如("^创建一个账户 '(\\w+)'$")
	public void 创建一个账户(String accountId) throws Throwable {
		steps.create_an_account(accountId);
	}

	@假如("^向账户'(\\w+)'存入(\\d+)元$")
	public void 向账户_存入_元(String accountId,int amount) throws Throwable {
		steps.save_to_account(amount, accountId);
	}

	@假如("^从账户 '(\\w+)'向账户 '(\\w+)'转账(\\d+)元$")
	public void 从账户_向账户_转账_元(String accountOrigin, String accountDestination, int amount) throws Throwable {
		steps.transfer_from_account_to(amount,accountOrigin,accountDestination);
	}

	@假如("^账户 '(\\w+)'应该有(\\d+)元$")
	public void 账户_应该有_元(String accountId, int amount) throws Throwable {
		steps.account_should_have(accountId,amount);
	}
}
