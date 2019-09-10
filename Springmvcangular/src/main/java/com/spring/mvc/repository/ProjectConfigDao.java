package com.spring.mvc.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.mvc.repository.model.ProjectConfig;


@Repository
public interface ProjectConfigDao {

		public boolean addConfiguration(ProjectConfig projectConfig);
		
		public List<ProjectConfig> getAllConfig();
		
		public ProjectConfig getConfigByAllocationId(int allocationId);
		
		public ProjectConfig getConfigByConfigId(int configId);

		
		public List<ProjectConfig> getallConfigByProjectId(int projectId);
		
}
