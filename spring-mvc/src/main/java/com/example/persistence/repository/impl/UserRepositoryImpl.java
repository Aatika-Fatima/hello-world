package com.example.persistence.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.persistence.model.User;
import com.example.persistence.repository.AbstractHibernateDao;
import com.example.persistence.repository.IUserRepository;

@Component
public class UserRepositoryImpl extends AbstractHibernateDao<User> implements IUserRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public User registerNewUserAccount(User user) {
		 
 		create(user); 
 		return user;
	}

	@Override
	public User findUserByEmail(String email) {
 
		Session session =getSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.or(Restrictions.eq("email", email) , Restrictions.eq("userName", email)));
		User user = (User) criteria.uniqueResult();
		//System.out.println("User = " + user.getEmail());
 		return user;
	}

	@Override
	public boolean validateUser(String userName, String password) {
		Session session = getSession();
		Query query = session.getNamedQuery("validateUser");
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		 
		return  (boolean) query.list().get(0);
	}
	
	

}
