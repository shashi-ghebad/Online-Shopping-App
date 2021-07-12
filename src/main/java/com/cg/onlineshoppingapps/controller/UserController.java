package com.cg.onlineshoppingapps.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshoppingapps.entity.UserEntity;
import com.cg.onlineshoppingapps.service.LoginService;
@CrossOrigin
@RestController
@RequestMapping("/osa")
public class UserController {

	@Autowired
	LoginService iLoginService;

	@PostMapping("/insert-user-details")
	public UserEntity addUser(@Valid @RequestBody UserEntity user) {
		return iLoginService.addUser(user);
	}

	@GetMapping("/get-all-users-details")
	public List<UserEntity> getAllUsers() {
		return iLoginService.getAllUsers();
	}
	@GetMapping("/get-username")
		public UserEntity findByUsername(String username) {
		return iLoginService.findByUsername(username);
	}
}
