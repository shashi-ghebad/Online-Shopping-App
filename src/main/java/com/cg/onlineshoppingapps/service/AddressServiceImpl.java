package com.cg.onlineshoppingapps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshoppingapps.dao.AddressJpaDao;
import com.cg.onlineshoppingapps.entity.AddressEntity;
import com.cg.onlineshoppingapps.exception.AddressNotFoundException;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressJpaDao addressJpaDao;

	public AddressServiceImpl() {
	}

	@Override
	public AddressEntity addAddress(AddressEntity add) {
		return addressJpaDao.save(add);
	}

	@Override
	public AddressEntity updateAddress(AddressEntity add) {
		return addressJpaDao.save(add);
	}

	@Override
	public boolean removeAddress(int add) {
		addressJpaDao.deleteById(add);
		return true;
	}

	@Override
	public List<AddressEntity> viewAllAddress(){
		List<AddressEntity> viewAll = addressJpaDao.findAll();
		if(viewAll.isEmpty()) {
			throw new AddressNotFoundException("No Address Found!!");
		}
		return viewAll;
	}

	@Override
	public AddressEntity viewAddress(int add) {
		Optional<AddressEntity> result = addressJpaDao.findById(add);
		if (result.isPresent()) {
			return result.get();
		}
		return null;
	}
}
