package com.spring.mvc.repository.impl;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.repository.DevAttendanceDao;
import com.spring.mvc.repository.model.DevAttendance;







@Repository(value="devAttendanceDao")
@Transactional
public class DevAttendanceDaoImpl implements DevAttendanceDao {

	
	
	@Autowired
	SessionFactory sf;
	public boolean fillAttendance(DevAttendance de) {
		
		try
		{
			
			Session session=sf.getCurrentSession();
			session.saveOrUpdate(de);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public List<DevAttendance> viewAttendance() {
		try
		{
			
			Session session=sf.getCurrentSession();
			Query q=session.createQuery("from DevAttendance");
			
			return q.getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	
	public double getAttendanceById(int id) {
		try {
			
			
			
			
			Session session=sf.getCurrentSession();
			System.out.println("inside dev attendence"+id);
			Query q=session.createQuery("SELECT SUM(totalNoOfHoursPresent) FROM DevAttendance WHERE developer.id=:x");
			q.setParameter("x",id);
			
			System.out.println("inside dev attendence x");
			
			
			
			return (Double) q.getResultList().get(0);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return 0.0;
	}

	public double getAttendanceById(int id, String month, int year) {
		
try {
			
			
			
			
			Session session=sf.getCurrentSession();
			System.out.println("inside dev attendence"+id);
			Query q=session.createQuery("SELECT totalNoOfHoursPresent FROM DevAttendance WHERE developer.id=:x and month=:y and year=:z");
			q.setParameter("x",id);
			q.setParameter("y", month);
			q.setParameter("z", year);
			
			//System.out.println("inside dev attendence x"+q.getResultList());
			
			if(q.getResultList().size()==0) {
				
				return 0.0;
			}
			else
			{
			return    (Double) q.getResultList().get(0);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return 0.0;
}

}

		
		
	