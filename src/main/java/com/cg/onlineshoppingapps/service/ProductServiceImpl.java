package com.cg.onlineshoppingapps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.onlineshoppingapps.dao.ProductJpaDao;
import com.cg.onlineshoppingapps.entity.ProductEntity;
import com.cg.onlineshoppingapps.exception.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductJpaDao productJpaDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	public ProductServiceImpl() {
		super();
	}

	@Override
	public List<ProductEntity> viewAllProducts() {
		List<ProductEntity> viewAll = productJpaDao.findAll();
		if (viewAll.isEmpty()) {
			throw new ProductNotFoundException("Products Not Found");
		}
		return viewAll;
	}

	@Override
	public ProductEntity addProduct(ProductEntity product) {
		//product.getUsername().setPassword(bcryptEncoder.encode(product.getUsername().getPassword()));
		return productJpaDao.save(product);
	}

	@Override
	public ProductEntity updateProduct(ProductEntity product) {
		return productJpaDao.save(product);
	}

	@Override
	public ProductEntity viewProductsByProductId(int productId) {
		Optional<ProductEntity> result = productJpaDao.findById(productId);
		if (result.isPresent()) {
			return result.get();
		}
		return null;
	}

	@Override
	public List<ProductEntity> removeProduct(int prodId) {
		productJpaDao.deleteById(prodId);
		return productJpaDao.findAll();
	}

}
