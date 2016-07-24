package com.ajitesh.hb.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import com.ajitesh.datasource.factories.MySqlSessionFactory;
import com.ajitesh.sh.models.UserCount;
import com.ajitesh.sh.models.UserMaster;

public class UserDetailCrud {
	
	public static void main(String[] args) {
		//saveUserDetails();
		listUserDetails();
		
	}
	@SuppressWarnings("unchecked")
	private static void listUserDetails(){
		SessionFactory sessionFactory = MySqlSessionFactory.getSessionFactory();
		try{
		Session session =  sessionFactory.openSession();
		Criteria crt = session.createCriteria(UserMaster.class);
		crt.setProjection(Projections.count("userName"));
		Long umCount = (Long) crt.uniqueResult();
		System.out.println(umCount);
		
		Criteria crt1 = session.createCriteria(UserMaster.class);
		crt1.setProjection(Projections.groupProperty("department").as("department1"));
		
		List<UserCount> umList = crt1.setResultTransformer(Transformers.aliasToBean(UserCount.class)).list();
		//System.out.println(umList);
		umList.forEach(x -> System.out.println("Department : " + x.getDepartment() + " Department1 : " + x.getDepartment1()));
		
		session.flush();
		session.close();
		
		}finally{
			sessionFactory.close();
		}
	}
	
	private static void saveUserDetails(){

		SessionFactory sessionFactory = MySqlSessionFactory.getSessionFactory();
		try{
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		for(int i=0; i<5;i++){
		UserMaster user =  new UserMaster();
		user.setUserName("Ajitesh" + i);
		user.setPassword("Ajitesh" + i);
		user.setDepartment(i%2 == 0 ? "IT" : "COMP");
		session.save(user);
		}
		session.getTransaction().commit();
		session.flush();
		session.close();
		
		}finally{
			sessionFactory.close();
		}
	
	}

}
