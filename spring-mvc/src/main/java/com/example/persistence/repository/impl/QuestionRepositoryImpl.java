package com.example.persistence.repository.impl;

import org.springframework.stereotype.Component;

import com.example.persistence.model.Question;
import com.example.persistence.repository.AbstractHibernateDao;
import com.example.persistence.repository.IQuestionRepository;

@Component
public class QuestionRepositoryImpl extends AbstractHibernateDao<Question> implements IQuestionRepository {
	

}
