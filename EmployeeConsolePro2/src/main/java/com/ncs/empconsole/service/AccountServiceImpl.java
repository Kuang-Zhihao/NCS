package com.ncs.empconsole.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ncs.empconsole.exception.OutofRangeSalaryException;
import com.ncs.empconsole.model.Account;
import com.ncs.empconsole.repository.AccountRepository;

public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account addAccount(Account account){
		return accountRepository.save(account);
	}

	@Override
	public List<Account> getAccounts(){
		return accountRepository.findAll();
	}

}
