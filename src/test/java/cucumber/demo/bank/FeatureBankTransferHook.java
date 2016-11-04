package cucumber.demo.bank;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class FeatureBankTransferHook {

	@Before("@BankTransferFeature")
	public void setup(){
		System.out.println("Bank transfer feature scenarios begin");
	}
	@After("@BankTransferFeature")
	public void tearDown(){
		System.out.println("Bank transfer feature scenarios end");
	}
	
	@Before("@BankSuccessScenario")
	public void setupSuccessScenario(){
		System.out.println("Bank transfer feature scenario - normal path begin");
	}
	
	@After("@BankSuccessScenario")
	public void tearDownSuccessScenario(){
		System.out.println("Bank transfer feature scenario - normal path end");
	}
}
