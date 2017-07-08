package com.example.persistence.repository;

import com.example.persistence.model.User;

public interface IUserRepository extends IDao<User>{
	public User registerNewUserAccount(User user);
	
	public User findUserByEmail(String userName);
	
	public boolean validateUser(String userName, String password);
}
