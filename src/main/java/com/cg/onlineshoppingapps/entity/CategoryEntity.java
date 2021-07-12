package com.cg.onlineshoppingapps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id")
	@SequenceGenerator(sequenceName = "CATEGORY_SEQ2", allocationSize = 1, name = "category_id")
	@Column(name = "category_id")
	private int catId;

	@Column(name = "category_name")
	private String categoryName;

	public CategoryEntity() {
		super();
	}

	public CategoryEntity(int catId, String categoryName) {
		super();
		this.catId = catId;
		this.categoryName = categoryName;

	}

	public CategoryEntity(String string) {
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", categoryName=" + categoryName + "]";
	}

}
