package com.cg.onlineshoppingapps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshoppingapps.dao.CategoryJpaDao;
import com.cg.onlineshoppingapps.entity.CategoryEntity;
import com.cg.onlineshoppingapps.exception.CategoryNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryJpaDao categoryJpaDao;

	public CategoryServiceImpl() {
		super();
	}

	@Override
	public CategoryEntity addCategory(CategoryEntity category) {
		return categoryJpaDao.save(category);
	}

	@Override
	public List<CategoryEntity> viewAllCategory() {
		List<CategoryEntity> viewAll = categoryJpaDao.findAll();
		if (viewAll.isEmpty()) {
			throw new CategoryNotFoundException("No Category Found!!");
		}
		return viewAll;
	}

}
