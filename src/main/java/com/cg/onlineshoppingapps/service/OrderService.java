package com.cg.onlineshoppingapps.service;

import java.util.List;

import com.cg.onlineshoppingapps.entity.CustomerEntity;
import com.cg.onlineshoppingapps.entity.OrderEntity;

public interface OrderService {
	public OrderEntity addOrder(OrderEntity order);

	public OrderEntity updateOrder(OrderEntity order);

	public boolean removeOrder(int order);

	public OrderEntity viewOrder(int orderId);

	public List<OrderEntity> viewAllOrders();

	public CustomerEntity findByCustomerId(String Username);
	
	public List<OrderEntity> findOrdersByCustomerId(int customerId);
}
