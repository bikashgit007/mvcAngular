package com.spring.mvc.repository.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DevAttendance{
	
	
	@Id
	@GeneratedValue
	private int dataEntryId;
			
			
	private String month;
	
	private int year;
	
	
	@OneToOne
	@JoinColumn(name="id")
	private Developer developer;
	
	
	private double totalNoOfHoursPresent;
	


	public int getDataEntryId() {
		return dataEntryId;
	}

	public void setDataEntryId(int dataEntryId) {
		this.dataEntryId = dataEntryId;
	}

	


	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}


	public double getTotalNoOfHoursPresent() {
		return totalNoOfHoursPresent;
	}

	public void setTotalNoOfHoursPresent(double totalNoOfHoursPresent) {
		this.totalNoOfHoursPresent = totalNoOfHoursPresent;
	}

	
}
