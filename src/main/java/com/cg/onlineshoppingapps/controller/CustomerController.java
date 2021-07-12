package com.cg.onlineshoppingapps.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshoppingapps.entity.CustomerEntity;
import com.cg.onlineshoppingapps.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/osa")
public class CustomerController {

	@Autowired
	CustomerService iCustomerService;

	@PostMapping("/insert-customer-details")
	public CustomerEntity addCustomer(@Valid @RequestBody CustomerEntity cust) {
		return iCustomerService.addCustomer(cust);
	}

	@PutMapping("/update-customer-details")
	public CustomerEntity updateCustomer(@Valid @RequestBody CustomerEntity cust) {
		return iCustomerService.updateCustomer(cust);
	}

	@DeleteMapping("/delete-customer-by-id/{custId}")
	public boolean removeCustomer(@PathVariable("custId") int cust) {
		return iCustomerService.removeCustomer(cust);
	}

	@GetMapping("/display-customer-by-id/{custId}")
	public CustomerEntity viewCustomer(@Valid @PathVariable("custId") int cust) {
		return iCustomerService.viewCustomer(cust);
	}

	@GetMapping("/display-all-customers")
	public List<CustomerEntity> ViewAllCustomers() {
		return iCustomerService.ViewAllCustomers();
	}

	@GetMapping("/uname/{username}")
	public CustomerEntity getCustomerByUsername(@PathVariable("username") String username) {
		System.out.println(username);
		return iCustomerService.getCustomerByUsername(username);
	}
	
//	@GetMapping("/get-customer-id/{username}")
//	public CustomerEntity findByCustomerId(@PathVariable("username") String Username) {
//		return iCustomerService.findByCustomerId(Username);
//	}
}
