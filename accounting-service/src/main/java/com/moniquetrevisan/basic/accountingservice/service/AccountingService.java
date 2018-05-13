package com.moniquetrevisan.basic.accountingservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moniquetrevisan.basic.accountingservice.model.Accounting;
import com.moniquetrevisan.basic.accountingservice.model.Stats;
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
	
	public List<Accounting> findByContaContabil(String contaContabil) {
		return repository.findByContaContabil(contaContabil);
	}
	
	public Accounting findById(String id) {
		return repository.findById(id);
	}
	
	public List<Accounting> findAll() {
		return repository.findAll();
	}
	
	public Stats getGeneralStats(){
		return repository.getGeneralStats();
	}
	
	public Stats getStatsByContaContabil(String contaContabil){
		return repository.getStatsByContaContabil(contaContabil);
	}	
	
}