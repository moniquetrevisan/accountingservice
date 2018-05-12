package com.moniquetrevisan.basic.accountingservice.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moniquetrevisan.basic.accountingservice.model.Accounting;
import com.moniquetrevisan.basic.accountingservice.service.AccountingService;

@RestController
@RequestMapping("/lancamentos-contabeis")
public class AccountingController {
	
	@Autowired
	private AccountingService service;
	
	private static Logger log = Logger.getLogger(AccountingController.class);
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Accounting accounting){
		ResponseEntity<String> response = null;
		try {
			String id = service.create(accounting);
			response = new ResponseEntity<String>(id, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
