package com.cg.onlineshoppingapps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineshoppingapps.entity.AddressEntity;
@Repository
public interface AddressJpaDao extends JpaRepository<AddressEntity, Integer> {

	
}
