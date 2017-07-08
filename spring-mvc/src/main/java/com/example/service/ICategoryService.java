package com.example.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import com.example.persistence.model.Category;
import com.example.service.exceptions.CategoryExistsException;

public interface ICategoryService {
	public List<Category> findAll();
	
	public Category find(int id);
	public void create(Category category)throws ConstraintViolationException;
	public void updateCategory(Category c);
	public void deleteCategory(int id); 
	public void deleteCategory(Category c);
}
