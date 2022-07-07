package com.ncs.empconsole.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.empconsole.model.Account;
import com.ncs.empconsole.service.AccountService;

@RestController
@RequestMapping("/empconsole/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/add_account")
	public Account addEmployee(@RequestParam int number, @RequestParam String name, @RequestParam int balance, @RequestParam String branchName){
		Account account = new Account();
		account.setAccountNumber(number);
		account.setAccountHolderName(name);
		account.setBalance(balance);
		account.setBranchName(branchName);
		return accountService.addAccount(account);
	}
	// http://localhost:8081/add_account?number=1&name=%22Julien%22&balance=100&branchName=%22DBS%22
	
	@GetMapping("/view_accounts")
	public List<Account> viewAccounts(){
		return accountService.getAccounts();
	}

}
