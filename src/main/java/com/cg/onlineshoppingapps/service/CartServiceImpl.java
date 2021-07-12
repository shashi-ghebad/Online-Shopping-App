package com.cg.onlineshoppingapps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshoppingapps.dao.CartJpaDao;
import com.cg.onlineshoppingapps.entity.CartEntity;
import com.cg.onlineshoppingapps.exception.CartNotFoundException;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartJpaDao cartJpaDao;

	@Override
	public CartEntity addToCart(CartEntity cartEntity) {
		return cartJpaDao.save(cartEntity);

	}

	@Override
	public List<CartEntity> viewAllCart() {
		List<CartEntity> viewAll = cartJpaDao.findAll();
		if (viewAll.isEmpty()) {
			throw new CartNotFoundException("No Cart Found!!");
		}
		return viewAll;
	}

	@Override
	public CartEntity findByCustomerId(int customerId) {

		return cartJpaDao.findByCustomerId(customerId);
	}

	@Override
	public CartEntity deleteByProductId(int productId) {

		return cartJpaDao.deleteByProductId(productId);
	}

//	@Override
//	public CartEntity updateToCart(CartEntity cartEntity) {
//		
//		return null;
//	}

//	public CartEntity findByProductId(int productId) {
//		return cartJpaDao.findByProductId(productId);
//	}
}
