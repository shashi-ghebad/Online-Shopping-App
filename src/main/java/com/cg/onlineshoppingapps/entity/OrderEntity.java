package com.cg.onlineshoppingapps.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id")
	@SequenceGenerator(sequenceName = "ORDERS_SEQ", allocationSize = 1, name = "order_id")
	@Column(name = "order_id")
	private int orderId;

	@Column(name = "order_date")
	private LocalDate orderDate;

	@Column(name = "order_status")
	private String orderStatus;
	
	@ManyToMany
	@JoinTable(name = "product_order", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = {
			@JoinColumn(name = "product_id") })
	private List<ProductEntity> product = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;

	public OrderEntity() {
		super();
	}

	public OrderEntity(int orderId, LocalDate orderDate, String orderStatus, List<ProductEntity> product, CustomerEntity customer) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.product = product;
		this.customer = customer;
	}

	public OrderEntity(int i) {
	}

	public OrderEntity(String string) {
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public List<ProductEntity> getProduct() {
		return product;
	}

	public void setProducts(List<ProductEntity> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + ", product="
				+ product + ", customer=" + customer + "]";
	}

}
