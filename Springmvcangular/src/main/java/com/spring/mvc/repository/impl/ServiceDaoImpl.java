package com.spring.mvc.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.repository.DevAllocationDao;
import com.spring.mvc.repository.DevAttendanceDao;
import com.spring.mvc.repository.DeveloperDao;
import com.spring.mvc.repository.DeveloperRoleDao;
import com.spring.mvc.repository.ProjectConfigDao;
import com.spring.mvc.repository.ProjectDao;
import com.spring.mvc.repository.ServiceDao;
import com.spring.mvc.repository.model.DevAllocation;
import com.spring.mvc.repository.model.ProjectConfig;

@Repository(value="serviceDao")
@Transactional
public class ServiceDaoImpl implements ServiceDao{

	
	@Autowired
	ProjectDao projectDao;
	
	@Autowired
	DeveloperRoleDao roleDao;
	
	
	@Autowired
	DeveloperDao developerDao;
	
	
	@Autowired
	ProjectConfigDao projectConfigDao;
	
	@Autowired
	DevAllocationDao devAllocationDao;
	
	@Autowired
	DevAttendanceDao devAttendanceDao;
	
	
	
	

	public double getProjectBillingMonthly(int projectId,String month,int year) {
		
		
		double totalSalary=0.0;
		
		List<ProjectConfig> pConfigList=projectConfigDao.getallConfigByProjectId(projectId);
		
		System.out.println(pConfigList);
		
		List<DevAllocation> dAllocList=null;
		
		
		System.out.println("list of project config"+pConfigList);
		
		for(ProjectConfig pConfigLists:pConfigList) {
		
		
		 dAllocList=devAllocationDao.getDeveloperByConfigId(pConfigLists.getConfigid());
		 
		 
		 
		 
		 
		 totalSalary=totalSalary+getDeveloperBillingMonthly(pConfigLists.getConfigid(),month,year);
		 System.out.println("totalSalary"+totalSalary);
		}
		
		
		
		
		
		return totalSalary;
		
		
	}


	public double getProjectBillingYearly() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
	public double getDeveloperBillingMonthly(int configId,String month,int year) {
	
		double totalWorkingHour=0.0;
		
		//configId=devAllocationDao.getConfigIdByDeveloperId(configId);
		
		ProjectConfig pConfig=devAllocationDao.getProjectConfigByAllocationId(configId);
		
		DevAllocation devAllocation=devAllocationDao.getDeveloperByAllocationId(configId);
		
	
		
		try {
			
		totalWorkingHour=devAttendanceDao.getAttendanceById(devAllocation.getDeveloper().getId(),month,year);

		double totalBill=(totalWorkingHour)*(pConfig.getPerHourBilling());
	
		return totalBill;
		}
		catch(Exception e) {
			return 0.0;
		}
		
	}

	
	

	public double getDeveloperBillingYearly() {
		// TODO Auto-generated method stub
		return 0;
	}

		
		
}