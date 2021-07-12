package com.cg.onlineshoppingapps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshoppingapps.dao.CustomerJpaDao;
import com.cg.onlineshoppingapps.dao.OrderJpaDao;
import com.cg.onlineshoppingapps.entity.CustomerEntity;
import com.cg.onlineshoppingapps.entity.OrderEntity;
import com.cg.onlineshoppingapps.exception.OrderDetailsNotFoundException;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderJpaDao orderJpaDao;
	
	@Autowired
	CustomerJpaDao customerJpaDao;

	public OrderServiceImpl() {
	}

	@Override
	public OrderEntity addOrder(OrderEntity order) {
		
		return orderJpaDao.save(order);
	}

	@Override
	public OrderEntity updateOrder(OrderEntity order) {// set order_id to order object
		return orderJpaDao.save(order);
	}

	@Override
	public boolean removeOrder(int order) {
		orderJpaDao.deleteById(order);
		return true;
	}

	@Override
	public OrderEntity viewOrder(int orderId) {
		Optional<OrderEntity> result = orderJpaDao.findById(orderId);
		System.out.println(result);
		if (result.isPresent()) {
			return result.get();
		}
		return null;
	}

	@Override
	public List<OrderEntity> viewAllOrders() {
		List<OrderEntity> viewAll = orderJpaDao.findAll();
		if (viewAll.isEmpty()) {
			throw new OrderDetailsNotFoundException("No Order Details Found!!");
		}
		return viewAll;
	}

	@Override
	public CustomerEntity findByCustomerId(String Username) {
		return customerJpaDao.findByUsername(Username);
	}
	
	@Override
	public List<OrderEntity> findOrdersByCustomerId(int customerId){
		return orderJpaDao.findOrdersByCustomerId(customerId);
	}
}
