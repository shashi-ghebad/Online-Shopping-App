package com.cg.onlineshoppingapps.service;

import java.util.List;

import com.cg.onlineshoppingapps.entity.CategoryEntity;

public interface CategoryService {

	public CategoryEntity addCategory(CategoryEntity category);

	public List<CategoryEntity> viewAllCategory();

}
