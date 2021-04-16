package org.demo.dao;


import org.demo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
