package com.spring.mvc.repository.impl;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.repository.DeveloperRoleDao;
import com.spring.mvc.repository.model.DeveloperRole;





@Repository(value="roleDao")
@Transactional
public class DeveloperRoleDaoImpl implements DeveloperRoleDao{
	@Autowired
	SessionFactory sf;
	public List<DeveloperRole> viewRole() {
		try{
			Session session=sf.getCurrentSession();
			Query q=session.createQuery("from DeveloperRole");
			 return q.getResultList();
			
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public DeveloperRole getDeveloperRole(int roleId) {
		try{
			System.out.println("Role Id : "+roleId);
			Session session=sf.getCurrentSession();
			System.out.println("got session");
			DeveloperRole obj=session.get(DeveloperRole.class,roleId);
			System.out.println("Developer Role Obj : "+obj);
			 return obj;
			
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	

}
