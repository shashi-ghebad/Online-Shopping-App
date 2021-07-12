package com.cg.onlineshoppingapps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineshoppingapps.entity.UserEntity;
@Repository
public interface LoginJpaDao extends JpaRepository<UserEntity, String> {

	@Query("select u from UserEntity u where u.username=:username")
	public UserEntity findByUsername(@Param("username")String username);

}
