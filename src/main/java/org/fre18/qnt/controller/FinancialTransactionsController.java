/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 11:32:05 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.fre18.qnt.controller;

import java.util.List;

import org.fre18.qnt.entity.FinancialTransactions; 
import org.fre18.qnt.service.FinancialTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins ="*", maxAge = 3600)	
@RestController
public class FinancialTransactionsController {
	@Autowired
	FinancialTransactionsService financialTransactionsService;
	
	@RequestMapping(value="/financialTransaction", method=RequestMethod.GET)
	@ResponseBody
	public FinancialTransactions getCustomer() {
		// TODO Auto-generated method stub
		return financialTransactionsService.getOne(1);
	}
	
	@RequestMapping(value="/financialTransactions", method=RequestMethod.GET)
	@ResponseBody
	public List<FinancialTransactions> getFinancialTransactions() {
		// TODO Auto-generated method stub
		List<FinancialTransactions> financialTransactions = financialTransactionsService.findAll();
		return financialTransactions;
	}
	
	@RequestMapping(value="/financialTransaction", method=RequestMethod.POST,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public FinancialTransactions addFinancialTransactions(@RequestBody FinancialTransactions financialTransactions) {
		// TODO Auto-generated method stub
		return financialTransactionsService.create(financialTransactions);
	}
	
	@RequestMapping(value="/financialTransaction/{id}", method=RequestMethod.PUT,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public FinancialTransactions updateFinancialTransactions(@PathVariable("id") int id, @RequestBody FinancialTransactions financialTransactions) {
		// TODO Auto-generated method stub
		//FinancialTransactionsDaoImpl.updateFinancialTransactions(FinancialTransactions);
		
		FinancialTransactions cus = financialTransactionsService.getOne(id);
		if(cus != null) {
			/*cus.set(FinancialTransactions.getName_st());
			cus.setAge_st(FinancialTransactions.getAge_st());
			cus.setClass_st(FinancialTransactions.getClass_st());
			cus.setAddress_st(FinancialTransactions.getAddress_st());*/
			
			financialTransactionsService.update(cus);
		}
		
		return cus;
	}
	
	@RequestMapping(value="/financialTransaction/{id}", method=RequestMethod.DELETE,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public FinancialTransactions deleteFinancialTransactions(@PathVariable("id") int id){
		System.out.println("Delete" + id);
		/*FinancialTransactionsDaoImpl.deleteFinancialTransactions(no); */
		FinancialTransactions cus = financialTransactionsService.getOne(id);
		if(cus != null) {
			financialTransactionsService.delete(id);
		}
		
		return cus;
	}
}