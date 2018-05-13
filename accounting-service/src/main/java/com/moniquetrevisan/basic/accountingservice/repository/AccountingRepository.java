package com.moniquetrevisan.basic.accountingservice.repository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.moniquetrevisan.basic.accountingservice.model.Accounting;

public class AccountingRepository {
	
	private static Logger log = LogManager.getLogger(AccountingRepository.class);
	
	private static ConcurrentHashMap<String, Accounting> accountingHashMap = new ConcurrentHashMap<>();
	
	private static AccountingRepository instance = null; 
	
	private AccountingRepository(){
	
	}

	public static AccountingRepository getInstance() {
		if (null == instance) {
			instance = new AccountingRepository();
		}
		return instance;
	}
	
	public String save(Accounting accounting) {
		String accountingId = generateAccountingId(accounting);
		accounting.setId(accountingId);
		
		accountingHashMap.put(accountingId, accounting);
		
		return accounting.getId();
	}
	
	public List<Accounting> findByContaContabil(String contaContabil) {
		return  accountingHashMap.values().stream().filter(accounting -> accounting.getContaContabil().equals(contaContabil)).collect(Collectors.toList());
	}
	
	public Accounting findById(String id) {
		return  accountingHashMap.get(id);
	}
	
	public List<Accounting> findAll() {
		return  accountingHashMap.values().stream().collect(Collectors.toList());
	}
	
	private String generateAccountingId(Accounting accounting) {
		try {
			String accountStr = accounting.getContaContabil() + "" + accounting.getData() + "" + String.valueOf(accounting.getValor());
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] idHashed = md.digest(accountStr.getBytes());
			if(null != idHashed) {
				return String.valueOf(idHashed);
			}
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	
}