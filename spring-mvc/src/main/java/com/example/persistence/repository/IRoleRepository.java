package com.example.persistence.repository;

import java.util.Collection;
import java.util.List;

import com.example.persistence.model.Privlege;
import com.example.persistence.model.Role;
import com.example.persistence.model.User;

public interface IRoleRepository  extends IDao<Role> {
	public Role findRoleByName(String roleName);
	public List<Role> findRoleByPrivleges(Collection<String> privleges);
}
