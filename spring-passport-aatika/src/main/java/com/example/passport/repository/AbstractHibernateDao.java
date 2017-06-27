package com.example.passport.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

 

public abstract class AbstractHibernateDao<T extends Object> implements IDao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> domainClass;

	@SuppressWarnings("unchecked")
	private Class<T> getDomainClass() {
		
		if (domainClass == null) {
			ParameterizedType parametrizedType = (ParameterizedType) getClass().getGenericSuperclass();
			this.domainClass = (Class<T>) parametrizedType.getActualTypeArguments()[0];
		}
		System.out.println("Name = " + domainClass.getName());
 		return domainClass;
	}

	private String getDomainClassName() {
		return getDomainClass().getName();
	}

	public Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException he) {
			session = sessionFactory.openSession();
		}
		return session;

	}

	@Override
	public void create(T t) {
		
		getSession().save(t);
		getSession().flush();
		System.out.println(t);
		System.out.println("saved");
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Serializable T) {

		return (T) getSession().get(getDomainClass(), T);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(Serializable T) {
		// TODO Auto-generated method stub
		return (T) getSession().load(getDomainClass(), T);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		System.out.println("Doman class Name - " + getDomainClass());
		return getSession().createQuery("from " + getDomainClassName()).list();
	}

	@Override
	public void update(T t) {
		getSession().update(t);

	}

	@Override
	public void delete(T t) {
		getSession().delete(t);

	}

	@Override
	public void delete(long i) {
		getSession().delete(load(i));
	}

	@Override
	public void deleteAll() {
		getSession().createQuery("delete " + getDomainClassName()).executeUpdate();

	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		//String domaninClassName = domainClass.getName();
		//System.out.println("Domain Class = " + domaninClassName);
		return (Long) getSession().createQuery("select count(*) from " + getDomainClassName()).uniqueResult();
	}

	@Override
	public boolean exists(Serializable id) {
		// TODO Auto-generated method stub
		return (get(id) != null);
	}

}

