package com.example.persistence.repository.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.example.persistence.model.PasswordResetToken;
import com.example.persistence.repository.AbstractHibernateDao;
import com.example.persistence.repository.IPasswordResetTokenRepository;
@Component
public class PasswordResetTokenRepositoryImpl extends AbstractHibernateDao<PasswordResetToken>
		implements IPasswordResetTokenRepository {

	@Override
	public PasswordResetToken findByToken(String token) {
		Session session = getSession();
		Query query = session.getNamedQuery("findPasswordByToken");
		query.setParameter("token", token);

		return (PasswordResetToken) query.uniqueResult();
	}

}
