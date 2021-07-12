package com.cg.onlineshoppingapps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.onlineshoppingapps.dao.CustomerJpaDao;
import com.cg.onlineshoppingapps.entity.CustomerEntity;
import com.cg.onlineshoppingapps.exception.CustomerDetailsNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerJpaDao customerJpaDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	public CustomerServiceImpl() {
		super();
	}

	@Override
	public CustomerEntity addCustomer(CustomerEntity cust) {
		cust.getUsername().setPassword(bcryptEncoder.encode(cust.getUsername().getPassword()));
		return customerJpaDao.save(cust);
	}

	@Override
	public CustomerEntity updateCustomer(CustomerEntity cust) {
		return customerJpaDao.save(cust);
	}

	@Override
	public boolean removeCustomer(int cust) {
		customerJpaDao.deleteById(cust);
		return true;
	}

	@Override
	public CustomerEntity viewCustomer(int cust) {

		Optional<CustomerEntity> result = customerJpaDao.findById(cust);
		if (result.isPresent()) {
			return result.get();
		}
		return null;
	}

	@Override
	public List<CustomerEntity> ViewAllCustomers() {
		List<CustomerEntity> viewAll = customerJpaDao.findAll();
		if (viewAll.isEmpty()) {
			throw new CustomerDetailsNotFoundException("No Customer Found!!");
		}
		return viewAll;
	}

	@Override
	public CustomerEntity getCustomerByUsername(String username) {
		return customerJpaDao.findByUsername(username);
	}
	
//	@Override
//	public CustomerEntity findByCustomerId(String Username) {
//		return customerJpaDao.findByUsername(Username);
//	}
}
