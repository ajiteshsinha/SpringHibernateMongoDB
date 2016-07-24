package com.ajitesh.hb.main;

import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ajitesh.datasource.factories.MySqlSessionFactory;
import com.ajitesh.sh.models.Department;
import com.ajitesh.sh.models.Employee;
import com.ajitesh.sh.models.Location;

public class EmployeeCrud {
	
	public static void main(String[] args) {
		saveEmployee();
		
	}
	
	
	private static void saveEmployee(){
		SessionFactory sessionFactory = null;
		try{
		sessionFactory = MySqlSessionFactory.getSessionFactory();
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		Location loc =  new Location();
		loc.setLocationName("NEW DELHI");
		Department dep =  new Department();
		dep.setDepartmentName("COMP");
		dep.setLocationList(Arrays.asList(loc));
		Employee emp = new Employee();
		emp.setEmployeeName("Ajitesh");
		emp.setDepartment(dep);
		session.save(emp);
		session.getTransaction().commit();
		session.flush();
		session.close();
		
	}catch(Exception e){
		e.printStackTrace();

	}finally{
		sessionFactory.close();
	}

		
	}

}
