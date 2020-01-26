package cucumber.demo.bank;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


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
