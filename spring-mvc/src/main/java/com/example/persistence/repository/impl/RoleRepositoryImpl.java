package com.example.persistence.repository.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.persistence.model.Privlege;
import com.example.persistence.model.Role;
import com.example.persistence.repository.AbstractHibernateDao;
import com.example.persistence.repository.IRoleRepository;

@Component
public class RoleRepositoryImpl extends AbstractHibernateDao<Role> implements IRoleRepository {

	@Autowired
	SessionFactory sessionFactory;
	Session session;

	@Override
	public Role findRoleByName(String roleName) {
		session = sessionFactory.openSession();
		Query query = session.getNamedQuery("findRoleByName");
		query.setParameter("roleName", roleName);
		Role role = (Role) query.uniqueResult();
		return role;
	}

	public List<Role> findRoleByPrivleges(Collection<String> privleges) {
		session = sessionFactory.openSession();
		Query query = session.createQuery("SELECT distinct p.roles from Privlege p where p.name IN (:privleges)");
		@SuppressWarnings("unchecked")
		List<Role> roles =query.setParameterList("privleges", privleges).list();
		System.out.println(roles);
		return roles;

	}

}
