package cucumber.demo.glue;

import io.cucumber.java.After;
import io.cucumber.java.Before;

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
