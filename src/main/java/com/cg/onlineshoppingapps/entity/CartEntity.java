package com.cg.onlineshoppingapps.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_id")
	@SequenceGenerator(sequenceName = "CART_SEQ6", allocationSize = 1, name = "cart_id")
	@Column(name = "cart_id")
	private int cartId;

	@Column(name = "adding_date")
	private LocalDate addingDate;

	@ManyToMany
	@JoinTable(name = "product_cart", joinColumns = { @JoinColumn(name = "cart_id") }, inverseJoinColumns = {
			@JoinColumn(name = "product_id") })
	private List<ProductEntity> productId = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;

	public CartEntity() {
		super();
	}

	public CartEntity(int cartId, LocalDate addingDate, List<ProductEntity> productId, CustomerEntity customer) {
		super();
		this.cartId = cartId;
		this.addingDate = addingDate;
		this.productId = productId;
		this.customer = customer;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public LocalDate getAddingDate() {
		return addingDate;
	}

	public void setAddingDate(LocalDate addingDate) {
		this.addingDate = addingDate;
	}

	public List<ProductEntity> getProductId() {
		return productId;
	}

	public void setProductId(List<ProductEntity> productId) {
		this.productId = productId;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CartEntity [cartId=" + cartId + ", addingDate=" + addingDate + ", productId=" + productId
				+ ", customer=" + customer + "]";
	}

}
