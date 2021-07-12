package com.cg.onlineshoppingapps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshoppingapps.dao.LoginJpaDao;
import com.cg.onlineshoppingapps.entity.UserEntity;
import com.cg.onlineshoppingapps.exception.UserNotFoundException;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginJpaDao loginJpaDao;
	
	public LoginServiceImpl() {
		super();
	}

	@Override
	public UserEntity addUser(UserEntity user) {
		return loginJpaDao.save(user);
	}
	
	@Override
	public List<UserEntity> getAllUsers() {
		List<UserEntity> viewAll = loginJpaDao.findAll();
		if(viewAll.isEmpty()) {
			throw new UserNotFoundException("No User Found!!");
		}
		return viewAll;
	}

	@Override
	public UserEntity findByUsername(String username) {
		return loginJpaDao.findByUsername(username);
	}
}
