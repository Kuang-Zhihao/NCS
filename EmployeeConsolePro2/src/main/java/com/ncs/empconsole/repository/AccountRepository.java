package com.ncs.empconsole.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.empconsole.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
