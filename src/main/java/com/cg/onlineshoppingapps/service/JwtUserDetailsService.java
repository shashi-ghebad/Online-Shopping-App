package com.cg.onlineshoppingapps.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.onlineshoppingapps.dao.AdminJpaDao;
import com.cg.onlineshoppingapps.dao.LoginJpaDao;
import com.cg.onlineshoppingapps.entity.AdminEntity;
import com.cg.onlineshoppingapps.entity.UserDTO;
import com.cg.onlineshoppingapps.entity.UserEntity;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private LoginJpaDao loginJpaDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private AdminJpaDao adminJpaDao;

	
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username: " + username);
		org.springframework.security.core.userdetails.User data = null;
		if (role.equals("customer")) {
			UserEntity user = loginJpaDao.findByUsername(username);
			if (user == null) {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
			user.setRole(loginJpaDao.findByUsername(username).getRole());
			data = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					new ArrayList<>());
		} else if (role.equals("admin")) {
			AdminEntity adminEntity = adminJpaDao.findByUsername(username);
			if (adminEntity == null) {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
			data = new org.springframework.security.core.userdetails.User(adminEntity.getUsername(),
					adminEntity.getPassword(), new ArrayList<>());
		}
		return data;
//		System.out.println("username: " + username);
//		UserEntity user = loginJpaDao.findByUsername(username);
//		System.out.println("DAO USER :" + user);
//		if (user == null) {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//				new ArrayList<>());
//
	}

	public UserEntity save(UserDTO user) {
		UserEntity newUser = new UserEntity();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		return loginJpaDao.save(newUser);
	}
	

}
