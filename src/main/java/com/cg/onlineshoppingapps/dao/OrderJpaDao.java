package com.cg.onlineshoppingapps.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineshoppingapps.entity.CustomerEntity;
import com.cg.onlineshoppingapps.entity.OrderEntity;

@Repository
public interface OrderJpaDao extends JpaRepository<OrderEntity, Integer> {
	
	@Query(value= "select * from customer where username in (select username from users where username=?1)", nativeQuery=true)
	public CustomerEntity findByCustomerId(String Username);
	
	@Query(value="select * from orders where customer_id in (select customer_id from customer where customer_id = ?1)", nativeQuery = true)
	public List<OrderEntity> findOrdersByCustomerId(@Param("customerId") int customerId);
}
