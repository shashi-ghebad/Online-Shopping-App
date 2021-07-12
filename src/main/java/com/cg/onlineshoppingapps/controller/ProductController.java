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

import com.cg.onlineshoppingapps.entity.ProductEntity;
import com.cg.onlineshoppingapps.service.ProductService;
@CrossOrigin
@RestController
@RequestMapping("osa")
public class ProductController {

	@Autowired
	ProductService iProductService;

	@GetMapping("/display-all-products-details")
	public List<ProductEntity> viewAllProducts() {
		return iProductService.viewAllProducts();
	}

	@PostMapping("/insert-product-details")
	public ProductEntity addProduct(@Valid @RequestBody ProductEntity product) {
		return iProductService.addProduct(product);
	}

	@PutMapping("/update-product-details")
	public ProductEntity updateProduct(@Valid @RequestBody ProductEntity product) {
		return iProductService.updateProduct(product);
	}

	@DeleteMapping("/delete-product-by-id/{productId}")
	public List<ProductEntity> removeProduct(@PathVariable("productId") int prodId) {
		return iProductService.removeProduct(prodId);
	}
	
	@GetMapping("/display-product-by-id/{productId}")
	public ProductEntity viewProductsByProductId(@Valid @PathVariable("productId") int productId) {
		return iProductService.viewProductsByProductId(productId);
	}

}
