package com.example.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.persistence.model.Category;
import com.example.persistence.repository.ICategoryRepository;
import com.example.service.exceptions.CategoryExistsException;

@Component
@Transactional
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	ICategoryRepository iCategoryRepository;

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return iCategoryRepository.findAll();
	}

	@Override
	public Category find(int id) {
		// TODO Auto-generated method stub
		return iCategoryRepository.get(id);
	}

	@Override
	public void updateCategory(Category c) {
		iCategoryRepository.update(c);

	}

	@Override
	public void deleteCategory(int id) {
		iCategoryRepository.delete(id);

	}

	@Override
	public void deleteCategory(Category c) {
		iCategoryRepository.delete(c);
	}

	@Override
	public void create(Category category) {
		try {
			iCategoryRepository.create(category);
		} catch (ConstraintViolationException cne) {
			throw new CategoryExistsException("Category Name already exists");
		}
	}

}
