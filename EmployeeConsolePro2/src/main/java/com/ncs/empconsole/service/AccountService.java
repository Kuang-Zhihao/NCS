package com.ncs.empconsole.service;

import java.util.List;
import com.ncs.empconsole.model.Account;

public interface AccountService {
	
	public Account addAccount(Account account);
	public List<Account> getAccounts();

}
