package com.spring.mvc.repository;



import java.util.List;

import com.spring.mvc.repository.model.DeveloperRole;



public interface DeveloperRoleDao {
	public List<DeveloperRole> viewRole();
	public DeveloperRole getDeveloperRole(int roleId);
}
