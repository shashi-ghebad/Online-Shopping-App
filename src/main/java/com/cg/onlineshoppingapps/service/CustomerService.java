package com.cg.onlineshoppingapps.service;

import java.util.List;

import com.cg.onlineshoppingapps.entity.CustomerEntity;

public interface CustomerService {
	public CustomerEntity addCustomer(CustomerEntity cust);

	public boolean removeCustomer(int cust);

	public CustomerEntity updateCustomer(CustomerEntity cust);

	public CustomerEntity viewCustomer(int cust);

	public List<CustomerEntity> ViewAllCustomers();
	
	public CustomerEntity getCustomerByUsername(String username);

	//public CustomerEntity findByCustomerId(String Username);
}
