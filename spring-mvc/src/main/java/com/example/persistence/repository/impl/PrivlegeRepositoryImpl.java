package com.example.persistence.repository.impl;

import java.util.Collection;

import org.hibernate.Session;

import com.example.persistence.model.PasswordResetToken;
import com.example.persistence.model.Privlege;
import com.example.persistence.repository.AbstractHibernateDao;
import com.example.persistence.repository.IPasswordResetTokenRepository;
import com.example.persistence.repository.IPrivlegeRepository;

public class PrivlegeRepositoryImpl extends AbstractHibernateDao<Privlege> implements IPrivlegeRepository {

	@Override
	public Collection<Privlege> findPrivlegeByName(String name) {
		Session session = getSession();
		return null;
	}

}
