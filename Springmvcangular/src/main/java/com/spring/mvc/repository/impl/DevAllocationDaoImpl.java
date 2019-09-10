package com.spring.mvc.repository.impl;




import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.repository.DevAllocationDao;
import com.spring.mvc.repository.model.DevAllocation;
import com.spring.mvc.repository.model.Developer;
import com.spring.mvc.repository.model.ProjectConfig;








@Repository(value="devAllocationDao")
@Transactional
public class DevAllocationDaoImpl implements DevAllocationDao,Serializable {

	@Autowired
	SessionFactory sf;
	
	public boolean allocateDeveloper(DevAllocation da) {
		
			Session session=sf.getCurrentSession();
			session.persist(da);
			return true;
	}






public List<DevAllocation> getAllDevAllocation() {
	Session session=sf.getCurrentSession();
	Query query=session.createQuery("from DevAllocation");
	return query.getResultList();
}


public ProjectConfig getProjectConfigByAllocationId(int allocationId) {
	

	try {
		
		
		Session session=sf.getCurrentSession();
		ProjectConfig pCfg=session.get(ProjectConfig.class,allocationId);
		return pCfg;
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	return null;
}



public DevAllocation getDeveloperByAllocationId(int allocationId) {
	

	try {
		
		System.out.println(allocationId);
		Session session=sf.getCurrentSession();
		Query q=session.createQuery("from DevAllocation where configid=:x");
		q.setParameter("x", allocationId);
		
		System.out.println();
		
		
		if(q.getResultList().size()==0) {
			
			return null;
		}
		else
		{
		DevAllocation dev=(DevAllocation) q.getResultList().get(0);
		
		
		System.out.println("getDeveloperByAllocationId"+dev);
		return dev;
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	return null;
}






public List<DevAllocation> getDeveloperByConfigId(int configId) {

	try {
		
		Session session=sf.getCurrentSession();
		Query q=session.createQuery("from DevAllocation where configid=:x");
		q.setParameter("x",configId);
		
		
		System.out.println(q.getResultList());
		return  q.getResultList();
		
	}
	catch(Exception e) {
		
		e.printStackTrace();
	}
	
	
	return null;
}






public List<Developer> getAllUnAllocatedDeveloper() {
	
	try {
		
		Session session=sf.getCurrentSession();
		Query q=session.createQuery(" from Developer where id not in(select developer.id from DevAllocation)");
		return q.getResultList();
	}
	catch(Exception e) {
		return null;
		
	}
}

public List<Developer> getAllAllocatedDeveloper() {
	
	try {
		
		Session session=sf.getCurrentSession();
		Query q=session.createQuery(" from Developer where id  in(select developer.id from DevAllocation)");
		return q.getResultList();
	}
	catch(Exception e) {
		e.printStackTrace();
		return null;
	}
}






public List<Developer> getAllDeveloper() {
try {
		
		Session session=sf.getCurrentSession();
		Query q=session.createQuery(" from Developer");
		return q.getResultList();
	}
	catch(Exception e) {
		e.printStackTrace();
		return null;
		
		
	}
	
}






public int getConfigIdByDeveloperId(int devId) {

	try {
		Session session=sf.getCurrentSession();
		
		
		Query q=session.createQuery("from DevAllocation where Id=:x");
		q.setParameter("x", devId);
		
		DevAllocation dAlloc=(DevAllocation) q.getResultList().get(0);
		int allocId=dAlloc.getAllocationId();
		
		DevAllocation dA=session.get(DevAllocation.class,allocId);
		ProjectConfig p=dA.getProjectConfig();
		
		
		
		return p.getConfigid();
	}
	catch(Exception e) {
		
		e.printStackTrace();
	}
	return 0;
}






public Integer getAllocationIdByConfigId(int devId) {
	
	try {
		
		Session session=sf.getCurrentSession();
		//session.get
	}
	catch(Exception e) {
		e.printStackTrace();
		
	}
	
	
	return null;
}








}