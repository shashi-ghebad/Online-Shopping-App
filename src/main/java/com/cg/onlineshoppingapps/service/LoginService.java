package com.cg.onlineshoppingapps.service;

import java.util.List;

import com.cg.onlineshoppingapps.entity.UserEntity;

public interface LoginService {

	public UserEntity addUser(UserEntity user);

	public List<UserEntity> getAllUsers();
	
	public UserEntity findByUsername(String username);

}
