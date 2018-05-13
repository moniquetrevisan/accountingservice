package com.moniquetrevisan.basic.accountingservice.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moniquetrevisan.basic.accountingservice.model.Accounting;
import com.moniquetrevisan.basic.accountingservice.service.AccountingService;

@RestController
@RequestMapping("/api")
public class AccountingController {
	
	@Autowired
	private AccountingService service;
	
	private static Logger log = LogManager.getLogger(AccountingController.class);
	
	@RequestMapping(value = "/lancamentos-contabeis/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Accounting>> findAll(){
		ResponseEntity<List<Accounting>> response = null;
		try {
			List<Accounting> accountings = service.findAll();
			response = new ResponseEntity<List<Accounting>>(accountings, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response = new ResponseEntity<List<Accounting>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@RequestMapping(value = "/lancamentos-contabeis/{id}", method = RequestMethod.GET)
	public ResponseEntity<Accounting> findById(@PathVariable("id") String id){
		ResponseEntity<Accounting> response = null;
		try {
			Accounting accounting = service.findById(id);
			if(accounting == null) {
				return new ResponseEntity<Accounting>(accounting, HttpStatus.NOT_FOUND);
			}
			response = new ResponseEntity<Accounting>(accounting, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response = new ResponseEntity<Accounting>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@RequestMapping(value = "/lancamentos-contabeis/", params = "contaContabil", method = RequestMethod.GET)
	public ResponseEntity<List<Accounting>> findByContaContabil(@RequestParam("contaContabil") String contaContabil){
		ResponseEntity<List<Accounting>> response = null;
		try {
			List<Accounting> accountings = service.findByContaContabil(contaContabil);
			if(accountings == null || accountings.isEmpty()) {
				return new ResponseEntity<List<Accounting>>(accountings, HttpStatus.NOT_FOUND);
			}
			response = new ResponseEntity<List<Accounting>>(accountings, HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response = new ResponseEntity<List<Accounting>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@RequestMapping(value = "/lancamentos-contabeis/", method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Accounting accounting){
		ResponseEntity<String> response = null;
		try {
			String id = service.create(accounting);
			response = new ResponseEntity<String>("id:" + id, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
