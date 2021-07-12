package com.cg.onlineshoppingapps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshoppingapps.entity.CategoryEntity;
import com.cg.onlineshoppingapps.service.CategoryService;
@CrossOrigin
@RestController
@RequestMapping("/osa")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@PostMapping("/insert-category-details")
	public CategoryEntity addCategory(@RequestBody CategoryEntity category) {
		return categoryService.addCategory(category);
	}

	@GetMapping("/display-all-category")
	public List<CategoryEntity> viewAllCategory() {
		return categoryService.viewAllCategory();
	}

}
