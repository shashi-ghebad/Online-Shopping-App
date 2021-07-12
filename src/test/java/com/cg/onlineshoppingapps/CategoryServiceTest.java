package com.cg.onlineshoppingapps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.onlineshoppingapps.dao.CategoryJpaDao;
import com.cg.onlineshoppingapps.entity.CategoryEntity;
import com.cg.onlineshoppingapps.service.CategoryService;
import com.cg.onlineshoppingapps.service.CategoryServiceImpl;

@SpringBootTest
public class CategoryServiceTest {
	
	@InjectMocks
	CategoryService categoryService = new CategoryServiceImpl();

	@Mock
	CategoryJpaDao categoryJpaDao;

	@Test
	public void testAddCategory(CategoryEntity category) {
		CategoryEntity mockReturnCategory = new CategoryEntity();

		mockReturnCategory.setCatId(1);
		mockReturnCategory.setCategoryName("electronic");

		CategoryEntity mockArgumentCategory = new CategoryEntity();

		mockArgumentCategory.setCatId(1);
		mockReturnCategory.setCategoryName("electronic");

		Mockito.when(categoryJpaDao.save(mockArgumentCategory)).thenReturn(mockReturnCategory);
		assertEquals(1, categoryJpaDao.save(mockArgumentCategory).getCatId());
	}

	@Test
	public void testviewAllCategory() {

		List<CategoryEntity> category = new ArrayList<>();

		category.add(new CategoryEntity("Sangram"));
		Mockito.when(categoryJpaDao.findAll()).thenReturn(category);
		assertEquals(1, categoryService.viewAllCategory().size());

	}

}