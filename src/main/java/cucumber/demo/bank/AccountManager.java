package cucumber.demo.bank;

import java.util.HashMap;

public class AccountManager {
	HashMap<String, Account> accounts;
	private AccountManager(){
		accounts = new HashMap<String, Account>();
		
	}
	private static AccountManager inst=null;
	public static AccountManager instance() {
		if (inst==null)
			inst = new AccountManager();
		return inst;
	}
	public Account create(String accountId) {
		if (accounts.get(accountId)!=null) return accounts.get(accountId);
		Account account = new Account(accountId);
		accounts.put(accountId, account);
		return account;
	}
	public Account getAccount(String accountId) {
		return accounts.get(accountId);
	}
	public void reset() {
		accounts = new HashMap<>();
	}

}
