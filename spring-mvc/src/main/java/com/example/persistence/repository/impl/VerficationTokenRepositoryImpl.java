package com.example.persistence.repository.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.persistence.model.User;
import com.example.persistence.model.VerificationToken;
import com.example.persistence.repository.AbstractHibernateDao;
import com.example.persistence.repository.IVerificationTokenRepository;

@Component
public class VerficationTokenRepositoryImpl extends AbstractHibernateDao<VerificationToken>
		implements IVerificationTokenRepository {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public VerificationToken findByToken(String token) {
		Session session = getSession();
		Query query = session.getNamedQuery("findByToken");
		query.setParameter("token", token);
		VerificationToken verificationToken = (VerificationToken) query.uniqueResult();
		return verificationToken;
	}

	@Override
	public VerificationToken findByUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("findByUser");
		query.setParameter("user", user);
		VerificationToken verificationToken = (VerificationToken) query.uniqueResult();
		return verificationToken;
	}

	@Override
	public VerificationToken generateNewVerificationToken(String token) {
		Session session = getSession();
		VerificationToken verificationToken = findByToken(token);
		verificationToken.setToken(UUID.randomUUID().toString());
		verificationToken.setExpiryDate(calculateExpiryDate());
		session.update(verificationToken);
		return verificationToken;
	}

	private Date calculateExpiryDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Timestamp(calendar.getTime().getTime()));
		calendar.add(Calendar.MINUTE, 24 * 60);
		return new Date(calendar.getTime().getTime());
	}
}
