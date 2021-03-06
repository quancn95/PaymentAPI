/*
 * Created on 2018-09-27 ( Date ISO 2018-09-27 - Time 11:32:05 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.fre18.qnt.controller;

import java.util.List;

import org.fre18.qnt.entity.OrderItems;
import org.fre18.qnt.service.OrderItemsService;
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
public class OrderItemsController  {
	@Autowired
	OrderItemsService orderItemsService;
	
	@RequestMapping(value="/orderItem", method=RequestMethod.GET)
	@ResponseBody
	public OrderItems getOrderItem() {
		// TODO Auto-generated method stub
		return orderItemsService.getOne(1);
	}
	
	@RequestMapping(value="/orderItems", method=RequestMethod.GET)
	@ResponseBody
	public List<OrderItems> getOrderItems() {
		// TODO Auto-generated method stub
		List<OrderItems> orderItems = orderItemsService.findAll();
		return orderItems;
	}
	
	@RequestMapping(value="/orderItem", method=RequestMethod.POST,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public OrderItems addOrderItem(@RequestBody OrderItems orderItems) {
		// TODO Auto-generated method stub
		return orderItemsService.create(orderItems);
	}
	
	@RequestMapping(value="/orderItems/{id}", method=RequestMethod.PUT,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public OrderItems updateOrderItem(@PathVariable("id") int id, @RequestBody OrderItems orderItems) {
		// TODO Auto-generated method stub
		//accountsDaoImpl.updateAccounts(Accounts);
		
		OrderItems cus = orderItemsService.getOne(id);
		if(cus != null) {
			/*cus.set(Accounts.getName_st());
			cus.setAge_st(Accounts.getAge_st());
			cus.setClass_st(Accounts.getClass_st());
			cus.setAddress_st(Accounts.getAddress_st());*/
			
			orderItemsService.update(cus);
		}
		
		return cus;
	}
	
	@RequestMapping(value="/orderItems/{id}", method=RequestMethod.DELETE,produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public OrderItems deleteOrderItem(@PathVariable("id") int id){
		System.out.println("Delete" + id);
		/*AccountsDaoImpl.deleteAccounts(no); */
		OrderItems cus = orderItemsService.getOne(id);
		if(cus != null) {
			orderItemsService.delete(id);
		}
		
		return cus;
	}
}