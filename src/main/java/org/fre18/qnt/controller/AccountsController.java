/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 11:32:05 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.fre18.qnt.controller;

import java.util.List;

import org.fre18.qnt.entity.Accounts;
import org.fre18.qnt.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins ="*", maxAge = 3600)	
@RestController
public class AccountsController {
	
	@Autowired
	AccountsService accountsService;
	
	@RequestMapping(value="/account", method=RequestMethod.GET)
	@ResponseBody
	public Accounts getCustomer() {
		// TODO Auto-generated method stub
		return accountsService.getOne(1);
	}
	
	@RequestMapping(value="/accounts", method=RequestMethod.GET)
	@ResponseBody
	public List<Accounts> getAccounts() {
		// TODO Auto-generated method stub
		List<Accounts> Accounts = accountsService.findAll();
		return Accounts;
	}
	
	@RequestMapping(value="/account", method=RequestMethod.POST,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Accounts addAccounts(@RequestBody Accounts Accounts) {
		// TODO Auto-generated method stub
		return accountsService.create(Accounts);
	}
	
	@RequestMapping(value="/accounts/{id}", method=RequestMethod.PUT,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Accounts updateAccounts(@PathVariable("id") int id, @RequestBody Accounts Accounts) {
		// TODO Auto-generated method stub
		//accountsDaoImpl.updateAccounts(Accounts);
		
		Accounts cus = accountsService.getOne(id);
		if(cus != null) {
			/*cus.set(Accounts.getName_st());
			cus.setAge_st(Accounts.getAge_st());
			cus.setClass_st(Accounts.getClass_st());
			cus.setAddress_st(Accounts.getAddress_st());*/
			
			accountsService.update(cus);
		}
		
		return cus;
	}
	
	@RequestMapping(value="/accounts/{id}", method=RequestMethod.DELETE,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Accounts deleteAccounts(@PathVariable("id") int id){
		System.out.println("Delete" + id);
		/*AccountsDaoImpl.deleteAccounts(no); */
		Accounts cus = accountsService.getOne(id);
		if(cus != null) {
			accountsService.delete(id);
		}
		
		return cus;
	}
}