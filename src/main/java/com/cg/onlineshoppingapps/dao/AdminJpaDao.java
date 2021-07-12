package com.cg.onlineshoppingapps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineshoppingapps.entity.AdminEntity;

@Repository
public interface AdminJpaDao extends JpaRepository<AdminEntity, String> {
	
	@Query("select a from AdminEntity a where a.username=:username")
	AdminEntity findByUsername(@Param("username")String username);
	
}
