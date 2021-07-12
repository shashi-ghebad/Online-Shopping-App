package com.cg.onlineshoppingapps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineshoppingapps.entity.ProductEntity;
@Repository
public interface ProductJpaDao extends JpaRepository<ProductEntity, Integer> {
	

}
