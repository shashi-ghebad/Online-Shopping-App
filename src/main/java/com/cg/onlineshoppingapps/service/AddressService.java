package com.cg.onlineshoppingapps.service;

import java.util.List;

import com.cg.onlineshoppingapps.entity.AddressEntity;

public interface AddressService {

	public AddressEntity addAddress(AddressEntity add);

	public AddressEntity updateAddress(AddressEntity add);

	public boolean removeAddress(int add);

	public List<AddressEntity> viewAllAddress();

	public AddressEntity viewAddress(int add);

}
