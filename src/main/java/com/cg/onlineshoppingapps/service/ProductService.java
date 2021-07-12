package com.cg.onlineshoppingapps.service;

import java.util.List;

import com.cg.onlineshoppingapps.entity.ProductEntity;

public interface ProductService {
	public List<ProductEntity> viewAllProducts();

	public ProductEntity addProduct(ProductEntity product);

	public ProductEntity updateProduct(ProductEntity product);

	public ProductEntity viewProductsByProductId(int productId);

	public List<ProductEntity> removeProduct(int prodId);

}
