package com.example.passport.repository;

import java.io.Serializable;
import java.util.List;

public interface IDao<T extends Object> {
	public void create(T t);
	
	public T get(Serializable T);
	public T load(Serializable T);
	
	public List<T> findAll();
	
	public void update(T t);
	public void delete(T t); 
	public void delete(long i);
	public void deleteAll();
	public long count();
	public boolean exists(Serializable id);
}
