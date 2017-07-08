package com.example.persistence.repository.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.persistence.model.Author;
import com.example.persistence.repository.AbstractHibernateDao;
import com.example.persistence.repository.IAuthorRepository;
@Component
public class AuthorRepositoryImpl extends AbstractHibernateDao<Author> implements IAuthorRepository {
 
}
