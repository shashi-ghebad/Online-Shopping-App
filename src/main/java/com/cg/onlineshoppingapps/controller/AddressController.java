package com.cg.onlineshoppingapps.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshoppingapps.entity.AddressEntity;
import com.cg.onlineshoppingapps.service.AddressService;
@CrossOrigin
@RestController
@RequestMapping("/osa")
public class AddressController {

	@Autowired
	AddressService iAddressService;

	@PostMapping("/insert-address-details")
	public AddressEntity addAddress(@Valid @RequestBody AddressEntity add) {
		return iAddressService.addAddress(add);
	}

	@GetMapping("/display-all-address")
	public List<AddressEntity> viewAllAddress() {
		return iAddressService.viewAllAddress();
	}

	@DeleteMapping("/delete-address-details/{addid}")
	public boolean removeAddress(@PathVariable("addid") int add) {
		return iAddressService.removeAddress(add);
	}

	@PutMapping("/updating-address-details")
	public AddressEntity updateAddress(@Valid @RequestBody AddressEntity add) {
		return iAddressService.updateAddress(add);
	}

	@GetMapping("/display-address-by-id/{addId}")
	public AddressEntity viewAddress(@Valid @PathVariable("addId") int add) {
		return iAddressService.viewAddress(add);
	}

}
