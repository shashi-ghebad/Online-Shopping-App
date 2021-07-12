package com.cg.onlineshoppingapps.controller;

import java.util.List;

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
import com.cg.onlineshoppingapps.entity.OrderEntity;
import com.cg.onlineshoppingapps.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/osa")
public class OrderController {

	@Autowired
	OrderService iOrderService;

	@PostMapping("/insert-order-details")
	public OrderEntity addOrder(@RequestBody OrderEntity order) {
		System.out.println(order);
		return iOrderService.addOrder(order);
	}

	@GetMapping("/display-order-by-id/{orderid}")
	public OrderEntity viewOrder(@PathVariable("orderid") int orderid) {
		System.out.println(orderid);
		return iOrderService.viewOrder(orderid);
	}

	@PutMapping("/update-order-details") // {order_id}
	public OrderEntity updateOrder(@RequestBody OrderEntity order) {// ("order_id)
		return iOrderService.updateOrder(order);
	}

	@DeleteMapping("/delete-order-details/{order}")
	public boolean removeOrder(@PathVariable int order) {
		return iOrderService.removeOrder(order);
	}

	@GetMapping("/display-all-orders")
	public List<OrderEntity> viewAllOrders() {
		return iOrderService.viewAllOrders();
	}

	@GetMapping("/get-customer-by-id/{username}")
	public CustomerEntity findByCustomerId(@PathVariable("username") String Username) {
		return iOrderService.findByCustomerId(Username);
	}

	@GetMapping("/get-order-by-id/{customerId}")
	public List<OrderEntity> findOrdersByCustomerId(@PathVariable("customerId") int customerId) {
		return iOrderService.findOrdersByCustomerId(customerId);
	}
}
