package com.spring.mvc.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.mvc.repository.model.Developer;


@Repository
public interface DeveloperDao {
	public List<Developer> viewDeveloper();
	public Developer getDeveloperById(int id);
	public boolean validateDeveloper(int id,String password);
	
	}
