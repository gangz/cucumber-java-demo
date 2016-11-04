package cucumber.demo.bank;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","json:target/json/output.json","html:target/html/"},
        features = {"src/test/resources/cucumber/demo/bank/BankTransfer.feature"},
        tags={"@Smoke"},
        glue={"cucumber/demo/bank","cucumber/demo/glue"}
		)
public class AccountTransferSmokeTest {

	
	@Test
	public void test() {
	}

}
