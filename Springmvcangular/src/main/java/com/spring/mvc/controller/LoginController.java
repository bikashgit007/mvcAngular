package com.spring.mvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvc.repository.DeveloperDao;
import com.spring.mvc.repository.model.Developer;


@RestController
@CrossOrigin(origins= {"http://localhost:4200"},maxAge=3600,allowCredentials="false")	
public class LoginController {
	@Autowired
	DeveloperDao developerDao;
	
	
	/*@RequestMapping(value="/",method=RequestMethod.GET)
	public String getHomePage() {
		return "HomePage";
	}
	*/
	 
	/*@RequestMapping(value="Login",method=RequestMethod.GET)
	 public String getLoginPage(ModelMap map) {
		Developer d = new Developer();
		map.addAttribute("dObj", d);
		
		return "LoginPage";
	}*/
	
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public void dO() {
		
	System.out.println();
	}
	
	
	
	
	
	
	
	
	
	@CrossOrigin(origins= {"http://localhost:4200"},maxAge=3600,allowCredentials="false")	
	@RequestMapping(value="/{id}/{password}",method=RequestMethod.POST)
	public ResponseEntity<?> ValidatePage(@PathVariable int id,@PathVariable String password) {
		
		String role;
		System.out.print("Im in validate");
		//int id=dObj.getId();
		//String password=dObj.getPassword();
		//System.out.println(dObj.getPassword());
		boolean b=developerDao.validateDeveloper(id, password);
		
		System.out.println(b);
		if(b)
		{
			 
			Developer d=developerDao.getDeveloperById(id);
			//if(d.getApplicationRole().equals("Admin"))
		//	{
			
			 //return new ResponseEntity<Developer>(d,HttpStatus.OK);
			return new ResponseEntity<Developer>(d,HttpStatus.OK);
				//System.out.print("Role is " + d.getApplicationRole());
				 //return d.getApplicationRole().toString();
		//	}
			
		}		
		else
		{
			return new ResponseEntity<String>("Unauthorised",HttpStatus.UNAUTHORIZED);
				
		}	/*}*/
		/*else if(d.getApplicationRole().equals("DEO"))
			//return new ResponseEntity<String>("DataEntry",HttpStatus.OK);
			return "DataEntry";
		else
				//return new ResponseEntity<String>("Developer",HttpStatus.OK);
			return "Developer";
		}
	
	
		//return new ResponseEntity<String>("LoginPage",HttpStatus.OK);
		return "Hello";*/
		
		
		//}
	}
	
}
