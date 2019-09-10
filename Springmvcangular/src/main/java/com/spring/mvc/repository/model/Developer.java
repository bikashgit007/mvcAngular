package com.spring.mvc.repository.model;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Developer {
	
	@Id
	private int id;
	
	
	private String name;
	private String gender;
	private String contactno;
	private String email;
	private String applicationRole;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getApplicationRole() {
		return applicationRole;
	}
	public void setApplicationRole(String applicationRole) {
		this.applicationRole = applicationRole;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Developer [id=" + id + ", name=" + name + ", gender=" + gender + ", contactno=" + contactno + ", email="
				+ email + ", applicationRole=" + applicationRole + ", password=" + password + "]";
	}
	
	
	
	
	
}
