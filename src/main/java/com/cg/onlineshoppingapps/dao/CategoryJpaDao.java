package com.cg.onlineshoppingapps.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineshoppingapps.entity.CategoryEntity;
@Repository
public interface CategoryJpaDao extends JpaRepository<CategoryEntity, Integer> {

}
