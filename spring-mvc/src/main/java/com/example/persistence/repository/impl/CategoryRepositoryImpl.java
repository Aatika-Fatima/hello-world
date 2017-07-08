package com.example.persistence.repository.impl;

import org.springframework.stereotype.Component;

import com.example.persistence.model.Category;
import com.example.persistence.repository.AbstractHibernateDao;
import com.example.persistence.repository.ICategoryRepository;
@Component
public class CategoryRepositoryImpl extends AbstractHibernateDao<Category> implements ICategoryRepository {
	
}
