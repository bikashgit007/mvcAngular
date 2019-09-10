package com.spring.mvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.repository.DevAttendanceDao;
import com.spring.mvc.repository.DeveloperDao;
import com.spring.mvc.repository.model.DevAttendance;
import com.spring.mvc.repository.model.Developer;
	

@Controller
public class DataEntryController {
	
	
	@Autowired
	DeveloperDao developerDao;
	@Autowired
	DevAttendanceDao dataEntryDao;
	
	
	
	@RequestMapping(value = "fillattendance", method = RequestMethod.GET)
	public String fillAttendance(ModelMap map) {
		List<Developer> dList = developerDao.viewDeveloper();
		map.addAttribute("dataEntry",new DevAttendance());
		map.addAttribute("dList", dList);
		
		
		return "DataEntryAttendance";
		
		
	}
	
	
	@CrossOrigin(origins= {"http://localhost:4200"},maxAge=3600,allowCredentials="false")	
	@RequestMapping(value = "/addAttendance/{devId}/{month}/{year}/{totalNumberOfHoursPresent}", method = RequestMethod.POST)
	public String addAttendance(@PathVariable int devId,@PathVariable String month,@PathVariable int  year,@PathVariable double  totalNumberOfHoursPresent) {
		
		
		
		try {
			DevAttendance dAttendance=new DevAttendance();
			
			dAttendance.setDeveloper(developerDao.getDeveloperById(devId));
			dAttendance.setMonth(month);
			dAttendance.setYear(year);
			dAttendance.setTotalNoOfHoursPresent(totalNumberOfHoursPresent);
			
		 dataEntryDao.fillAttendance(dAttendance);
		}
		catch(Exception e) {
			
			return "DataEntry";
			
			
		}
		return "DataEntry";
		
		
	}
	
	
	

}
