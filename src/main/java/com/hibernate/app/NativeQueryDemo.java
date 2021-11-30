package com.hibernate.app;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.hibernate.entity.Employee;

public class NativeQueryDemo {

	public static void main(String[] args) {
		
				
				Configuration cfg = new Configuration();
				cfg.configure("hibernate.cfg.xml");
				
				
				SessionFactory sessionFactory = cfg.buildSessionFactory();
				
			
				Session session = sessionFactory.openSession(); //create new session
				
				
				Transaction transaction = session.beginTransaction();
				
				NativeQuery createNativeQuery = session.createNativeQuery("Select * from employee", Employee.class);
				List resultList = createNativeQuery.getResultList();
				System.out.println(resultList);
				
				Query q = session.createNativeQuery("SELECT e.name, e.salary FROM employee e WHERE e.id = ?");
				q.setParameter(1, 5);
				Object[] emp = (Object[]) q.getSingleResult();
				 
				System.out.println("Employee: "
				        + emp[0] + "::" + emp[1]);
				
				Query namedQuery = session.createNamedQuery("selectEmpNames");
				List list = namedQuery.getResultList();
				System.out.println("Employees with named query:");
				System.out.println(list);
				
				
				Query namedNativeQuery = session.createNamedQuery("selectEmpNamesNative");
				List<String> empNameList = namedNativeQuery.getResultList();
				
				System.out.println("Employee names fetched with NamedNativeQuery"); 
				for (String eName : empNameList) {
				    System.out.println(eName);
				}
				
				transaction.commit();
				session.close();
	}

}
