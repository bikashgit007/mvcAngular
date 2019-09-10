package com.spring.mvc.repository;




import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.mvc.repository.model.DevAttendance;




@Repository
public interface DevAttendanceDao {
	
	
	public boolean fillAttendance(DevAttendance de);
	public List<DevAttendance> viewAttendance();
	
	public double getAttendanceById(int id);
	public double getAttendanceById(int id, String month, int year);
	

}
