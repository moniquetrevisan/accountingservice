package com.moniquetrevisan.basic.accountingservice.service;

import org.springframework.stereotype.Service;

import com.moniquetrevisan.basic.accountingservice.model.Accounting;
import com.moniquetrevisan.basic.accountingservice.repository.AccountingRepository;

@Service
public class AccountingService {

	private AccountingRepository repository;

	public AccountingService () {
		repository = AccountingRepository.getInstance();
	}
	
	public String create(Accounting accounting) {
		return repository.save(accounting);
	}
	
}