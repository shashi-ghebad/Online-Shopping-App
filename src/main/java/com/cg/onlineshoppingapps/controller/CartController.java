package com.cg.onlineshoppingapps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshoppingapps.entity.CartEntity;
import com.cg.onlineshoppingapps.service.CartService;

@CrossOrigin
@RestController
@RequestMapping("/osa")
public class CartController {

	@Autowired
	CartService cartService;

	@PostMapping("/add-product-to-cart")
	public CartEntity addToCart(@RequestBody CartEntity cartEntity) {
		return cartService.addToCart(cartEntity);
	}

	@GetMapping("/view-all-cart-details")
	public List<CartEntity> viewAllCart() {
		return cartService.viewAllCart();
	}

	@GetMapping("/find-customer/{customerId}")
	public CartEntity findByCustomerId(@PathVariable("customerId") int customerId) {
		return cartService.findByCustomerId(customerId);

	}

	@DeleteMapping("/delete-product/{productId}")
	public CartEntity deleteByProductId(@PathVariable("prodId") int productId) {
		return cartService.deleteByProductId(productId);
	}

//	public CartEntity findByProductId(int productId) {
//		return cartService.findByProductId(productId);
//	}  get cart by  customer id**** pass url(customer id) 
}
