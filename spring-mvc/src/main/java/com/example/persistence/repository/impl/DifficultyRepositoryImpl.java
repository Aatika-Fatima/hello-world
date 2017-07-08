package com.example.persistence.repository.impl;

import org.springframework.stereotype.Component;

import com.example.persistence.model.DifficultyLevel;
import com.example.persistence.repository.AbstractHibernateDao;
import com.example.persistence.repository.IDifficultyLevelRepository;
@Component
public class DifficultyRepositoryImpl extends AbstractHibernateDao<DifficultyLevel>
implements IDifficultyLevelRepository{

}
