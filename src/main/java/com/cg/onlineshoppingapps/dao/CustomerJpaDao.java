package com.cg.onlineshoppingapps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineshoppingapps.entity.CustomerEntity;
@Repository
public interface CustomerJpaDao extends JpaRepository<CustomerEntity, Integer> {
	
	@Query(value = "select * from customer u where u.username=:username", nativeQuery = true )
	public CustomerEntity findByUsername(@Param("username") String username);
	
	
	
}
