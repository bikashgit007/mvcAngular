package com.spring.mvc.repository;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.mvc.repository.model.DevAllocation;
import com.spring.mvc.repository.model.ProjectConfig;




@Repository
public interface DevAllocationDao  {
	
	public boolean allocateDeveloper(DevAllocation da);
	public List<DevAllocation> getAllDevAllocation();
	
	public ProjectConfig getProjectConfigByAllocationId(int devAllocationId);
	
	public DevAllocation getDeveloperByAllocationId(int allocationId);

	

	public List<DevAllocation> getDeveloperByConfigId(int configid);
	public int getConfigIdByDeveloperId(int devId);
	public Integer getAllocationIdByConfigId(int devId );
	
	
	
	
	
	//public ProjectConfig getDeveloperById(int id);
	
}
