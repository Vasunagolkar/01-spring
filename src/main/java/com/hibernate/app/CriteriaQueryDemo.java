package com.hibernate.app;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Employee;

public class CriteriaQueryDemo {

	public static void main(String[] args) {

		//Configuration
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		//Session Factory
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		//Session
		Session session = sessionFactory.openSession(); //create new session
		
		Criteria createCriteria = session.createCriteria(Employee.class);
		List list = createCriteria.list();
		System.out.println(list);
		
		session.close();
	}

}
