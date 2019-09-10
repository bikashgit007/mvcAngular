package com.spring.mvc.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.mvc.repository.model.Project;


@Repository
public interface ProjectDao {
	public List<Project> viewProject();
	public Project getProjectById(int id);
	
	
	
	
	
	
}
