package org.fre18.qnt;

import org.fre18.qnt.entity.Customers;
import org.fre18.qnt.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentsapiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PaymentsapiApplication.class, args);
	}

	@Autowired
	private CustomersService customersService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Customers cus =  customersService.getOne(1);
		//System.out.println(cus.getCustomerId());
	}
}
