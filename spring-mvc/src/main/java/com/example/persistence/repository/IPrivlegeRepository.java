package com.example.persistence.repository;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.persistence.model.Privlege;
import com.example.persistence.model.Role;

public interface IPrivlegeRepository extends IDao<Privlege> {
 
	public Collection<Privlege> findPrivlegeByName(String name);
		
	 
}
