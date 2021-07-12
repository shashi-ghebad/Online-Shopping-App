package com.cg.onlineshoppingapps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineshoppingapps.entity.CartEntity;

@Repository
public interface CartJpaDao extends JpaRepository<CartEntity, Integer> {
	
	@Query(value = "select * from Cart c where c.customer_id=:customerId", nativeQuery = true)
	public CartEntity findByCustomerId(@Param("customerId") int customerId);
	
	@Query(value = "select * from Cart p where  p.product_id=:productId", nativeQuery = true)
	public CartEntity deleteByProductId(@Param("productId") int productId);
	
	
}
