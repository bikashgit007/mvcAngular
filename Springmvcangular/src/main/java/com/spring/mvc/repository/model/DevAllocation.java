package com.spring.mvc.repository.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DevAllocation{
	
	
	
	@Id
	@GeneratedValue
	private int allocationId;
	
	
	

	@OneToOne
	@JoinColumn(name="id")
	private Developer developer;
	
	
	@OneToOne
	@JoinColumn(name="configid")
	private ProjectConfig projectConfig;


	public Developer getDeveloper() {
		return developer;
	}


	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}


	public ProjectConfig getProjectConfig() {
		return projectConfig;
	}


	public void setProjectConfig(ProjectConfig projectConfig) {
		this.projectConfig = projectConfig;
	}


	public int getAllocationId() {
		return allocationId;
	}


	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}


	@Override
	public String toString() {
		return "DevAllocation [allocationId=" + allocationId + ", developer=" + developer + ", projectConfig="
				+ projectConfig + "]";
	}
	
	
	


	


	


	
	
	
		

}
