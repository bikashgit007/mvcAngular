package com.spring.mvc.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.repository.DevAllocationDao;
import com.spring.mvc.repository.DevAttendanceDao;
import com.spring.mvc.repository.DeveloperDao;
import com.spring.mvc.repository.DeveloperRoleDao;
import com.spring.mvc.repository.ProjectConfigDao;
import com.spring.mvc.repository.ProjectDao;
import com.spring.mvc.repository.ServiceDao;
import com.spring.mvc.repository.model.DevAllocation;
import com.spring.mvc.repository.model.Developer;
import com.spring.mvc.repository.model.DeveloperRole;
import com.spring.mvc.repository.model.Project;
import com.spring.mvc.repository.model.ProjectConfig;



@RestController
@CrossOrigin(origins= {"http://localhost:4200"},maxAge=3600,allowCredentials="false")	
public class AdminController {
	
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
	
	@Autowired
	ServiceDao serviceDao;
	
	@CrossOrigin(origins= {"http://localhost:4200"},maxAge=3600,allowCredentials="false")	
	@RequestMapping(value="/getAllProject",method=RequestMethod.GET)
	public List<Project> projectConfig() {
		List<Project> pList = projectDao.viewProject();
		List<DeveloperRole> rList=roleDao.viewRole();
		
		
		
		
	//	return new ResponseEntity<Developer>(d,HttpStatus.OK);
		return pList;
		
		
	}
	
	
	
	
	@CrossOrigin(origins= {"http://localhost:4200"},maxAge=3600,allowCredentials="false")	
	@RequestMapping(value="/getAllRole",method=RequestMethod.GET)
	public List<DeveloperRole> getRole() {
				List<DeveloperRole> rList=roleDao.viewRole();
		
		
		
		
		return rList;
		
		
	}
	
	
	
	
	
	@Autowired
	DeveloperRoleDao developerRoleDao;
	
	
	
	@CrossOrigin(origins= {"http://localhost:4200"},maxAge=3600,allowCredentials="false")	
	@RequestMapping(value="/addProjectConfig/{pId}/{roleId}/{location}/{perHourBilling}",method=RequestMethod.POST)
	public String addProjectConfig(@PathVariable Integer pId,@PathVariable Integer roleId,@PathVariable String location,@PathVariable Integer perHourBilling) {
		try {
			
		
			System.out.println("Developer Role Dao's object : "+developerRoleDao);
			ProjectConfig pConfig=new ProjectConfig();
			
			System.out.println("Role ID in controller : "+roleId);
			
		pConfig.setRole(developerRoleDao.getDeveloperRole(roleId));
		pConfig.setProject(projectDao.getProjectById(pId));
		pConfig.setLocation(location);
		pConfig.setPerHourBilling(perHourBilling);
			
			
			System.out.println(pConfig);
			
		boolean b=projectConfigDao.addConfiguration(pConfig);
	
		return "HomePage";
		}
		catch(Exception e) {
		e.printStackTrace();
		return "ErrorPage";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@CrossOrigin(origins= {"http://localhost:4200"},maxAge=3600,allowCredentials="false")	
	@RequestMapping(value="/getAllDeveloper",method=RequestMethod.GET)
	
	public List<Developer> getDeveloperList() {
		//developerAllocationDao.allocateDeveloper();
		
		List<Developer> dList = developerDao.viewDeveloper();
		
	
		
		
		
		
		
		return dList;
		
		
	}
	
	@CrossOrigin(origins= {"http://localhost:4200"},maxAge=3600,allowCredentials="false")	
	@RequestMapping(value="/getAllProjectConfig",method=RequestMethod.GET)
	
	public List<ProjectConfig> getProjectConfigList() {
		//developerAllocationDao.allocateDeveloper();
		
		
		List<ProjectConfig> configList=projectConfigDao.getAllConfig();
	
		
		
		
		
		
		return configList;
		
		
	}
	
	
	@CrossOrigin(origins= {"http://localhost:4200"},maxAge=3600,allowCredentials="false")	
	@RequestMapping(value="/developerAllocation/{devId}/{configId}",method=RequestMethod.POST)
	public String developerAllocation(@PathVariable Integer devId,@PathVariable Integer configId) {
		//developerAllocationDao.allocateDeveloper();
		
		DevAllocation devAlloc=new DevAllocation();
		
		devAlloc.setDeveloper(developerDao.getDeveloperById(devId));
		devAlloc.setProjectConfig(projectConfigDao.getConfigByConfigId(configId));
		
		try {
		boolean b=devAllocationDao.allocateDeveloper(devAlloc);
		if(b) {
			
			return "HomePage";
		}
		}
		catch(Exception e) {
			
			
			return "Error";
			
		}
		
		
		
		
		
		
		
		return "DeveloperAllocation";
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	@CrossOrigin(origins= {"http://localhost:4200"},maxAge=3600,allowCredentials="false")	
	@RequestMapping(value="/developerBilling/{devId}/{month}/{year}",method=RequestMethod.POST)
	public double seeDeveloperBilling(@PathVariable int devId,@PathVariable String month,@PathVariable int year) {
		
		
		try {
			
			int configId=devAllocationDao.getConfigIdByDeveloperId(devId);
			
			
				//allocId=devAllocationDao.
			
			
		//	ProjectConfig pCfg=devAllocationDao.getProjectConfigByAllocationId(devAllocationId);
					
			
			
			
			
			System.out.println("devBilling"+devId+configId);
			
			double totalBill = serviceDao.getDeveloperBillingMonthly(configId,month,year);
					

			
			
			
			return totalBill;
		} catch (Exception e) {

			return 0.0;
		}
		
	}
}
