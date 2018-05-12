package com.moniquetrevisan.basic.accountingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moniquetrevisan.basic.accountingservice.model.Accounting;
import com.moniquetrevisan.basic.accountingservice.repository.AccountingRepository;

@Service
public class AccountingService {

	@Autowired
	private AccountingRepository repository;

	public String create(Accounting accounting) {
		return repository.save(accounting);
	}
	
}