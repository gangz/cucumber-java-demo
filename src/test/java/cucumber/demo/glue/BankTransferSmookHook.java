package cucumber.demo.glue;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BankTransferSmookHook {

	@Before("@Smoke")
	public void setup(){
		System.out.println("Smoke scenarios begin");
	}
	
	@After("@Smoke")
	public void tearDownSuccessScenario(){
		System.out.println("Smoke scenarios end");
	}
}
