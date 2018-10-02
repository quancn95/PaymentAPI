/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 11:32:05 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.fre18.qnt.controller;

import java.util.List;
 
import org.fre18.qnt.entity.Orders;
import org.fre18.qnt.service.OrdersService;
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
public class OrdersController {
	@Autowired
	OrdersService ordersService;
	
	@RequestMapping(value="/order", method=RequestMethod.GET)
	@ResponseBody
	public Orders getOrder() {
		// TODO Auto-generated method stub
		return ordersService.getOne(1);
	}
	
	@RequestMapping(value="/orders", method=RequestMethod.GET)
	@ResponseBody
	public List<Orders> getOrders() {
		// TODO Auto-generated method stub
		List<Orders> orders = ordersService.findAll();
		return orders;
	}
	
	@RequestMapping(value="/order", method=RequestMethod.POST,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Orders addOrder(@RequestBody Orders order) {
		// TODO Auto-generated method stub
		return ordersService.create(order);
	}
	
	@RequestMapping(value="/order/{id}", method=RequestMethod.PUT,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Orders updateOrder(@PathVariable("id") int id, @RequestBody Orders order) {
		// TODO Auto-generated method stub
		//accountsDaoImpl.updateAccounts(Accounts);
		
		Orders cus = ordersService.getOne(id);
		if(cus != null) {
			/*cus.set(Accounts.getName_st());
			cus.setAge_st(Accounts.getAge_st());
			cus.setClass_st(Accounts.getClass_st());
			cus.setAddress_st(Accounts.getAddress_st());*/
			
			ordersService.update(cus);
		}
		
		return cus;
	}
	
	@RequestMapping(value="/order/{id}", method=RequestMethod.DELETE,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Orders deleteOrder(@PathVariable("id") int id){
		System.out.println("Delete" + id);
		/*AccountsDaoImpl.deleteAccounts(no); */
		Orders cus = ordersService.getOne(id);
		if(cus != null) {
			ordersService.delete(id);
		}
		
		return cus;
	}
}