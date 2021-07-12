package com.cg.onlineshoppingapps.service;

import java.util.List;

import com.cg.onlineshoppingapps.entity.CartEntity;

public interface CartService {

	public CartEntity addToCart(CartEntity cartEntity);

	public List<CartEntity> viewAllCart();
	
	public CartEntity findByCustomerId(int customerId);
	
	public CartEntity deleteByProductId(int productId);


}
