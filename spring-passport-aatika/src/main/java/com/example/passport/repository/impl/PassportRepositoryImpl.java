package com.example.passport.repository.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.passport.model.Passport;
import com.example.passport.repository.AbstractHibernateDao;
import com.example.passport.repository.IPassportRepository;
 
@Component
public class PassportRepositoryImpl extends AbstractHibernateDao<Passport> implements IPassportRepository {
	@Autowired
	SessionFactory sessionFactory;
	
	Session session;

	@Override
	public Passport findDocumentByApplicationId(Integer applicationId) {
		session = sessionFactory.openSession();
		Query query = session.getNamedQuery("findDocumentByApplicationId");
		query.setParameter("applicationId", applicationId);
		Passport passport = (Passport) query.uniqueResult();
		System.out.println(passport);
		return passport;

	}

	@Override
	public void updatePassport(String photoURL, String addressProofDocNumber, String addressProofDocFileUrl,
			int photoIdProofDocNumber, String photoIdProofDocUrl, int applicationId) {
		session = sessionFactory.openSession();
		Query query = session.getNamedQuery("updatePassport");
		query.setParameter("photoURL", photoURL);
		query.setParameter("addressProofDocNumber", addressProofDocNumber);
		query.setParameter("addressProofDocFileUrl", addressProofDocFileUrl);
		query.setParameter("photoIdProofDocNumber", photoIdProofDocNumber);
		query.setParameter("photoIdProofDocUrl", photoIdProofDocUrl);
		query.setParameter("applicationId", applicationId);
		query.executeUpdate();
		//Passport passport = (Passport) query.uniqueResult();
		//return passport;

	}

}
