package com.example.controller;

import java.io.Serializable;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

public class MyPermissionEvaluator implements PermissionEvaluator {

	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean hasPermission(Authentication auth, Object target, Object permission) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object args[] = { ((User) auth.getPrincipal()).getUsername(), target.getClass().getName(),
				permission.toString() };
		String sql = "select count(*) from permissions p where p.username=?" + " and p.target=? and p.permission=?";
		int count = jdbcTemplate.queryForObject(sql, args, Integer.class);
		if (count == 1)
			return true;
		return false;
	}

	@Override
	public boolean hasPermission(Authentication arg0, Serializable arg1, String arg2, Object arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
