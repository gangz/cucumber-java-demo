package cucumber.demo.bank.steps;

import cucumber.demo.bank.Account;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.TableTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;

import java.lang.reflect.Type;
import java.util.Map;

public class AccountTableTransformer  {
    @DefaultDataTableEntryTransformer
    public Object transform(Map<String, String> fromValue, Type toValueType) throws Throwable {
        String accountId = fromValue.get("账号");
        Integer initAmount = Integer.parseInt(fromValue.get("初始金额"));
        return new Account(accountId,initAmount);
    }
}
