package com.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Employee;


public class HibernateDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession(); // create new session

		Transaction transaction = session.beginTransaction();

		
		//For Save Method
		Employee employee = new Employee();
		
		employee.setEmpName("Mohit");
		employee.setEmail("Mohit@testmail.com");
		employee.setSalary(21000);
		session.save(employee);
		
		//For persist Method
         System.out.println(employee);
		Employee employee1 = new Employee();
		employee1.setEmpName("Rahul");
		employee1.setEmail("Rahul@testmail.com");
		employee1.setSalary(21000);
		session.persist(employee1);
         System.out.println(employee1);
		// For Load method
//		Employee employee = (Employee) session.load(Employee.class, 3);
//		    employee.getEmpId();
//		    employee.getEmpName();
//		    employee.getEmail();
//		    employee.getSalary();
//		    
//		 System.out.println(employee.toString());
//		  
		// For update Employee
//		   Employee employee = session.get(Employee.class, 5);
//		   if(employee != null)
//		   { employee.setEmpName("Nilesh");
//		     employee.setEmail("Nilesh@testmail.com");
//		     employee.setSalary(new Long(30000));
//		   session.update(employee);
//		   }

		// For saveOrupdate Employee
//		  Employee emp = new Employee("Onkar", "Onkar@testmail.com", 20000); //
//		  session.update(emp);// if we used update method and data is not present in database update method throw transientObjectException
//		  
//		  session.saveOrUpdate(emp);
//		 

		// For delete Employee
//		Employee emp1=session.get(Employee.class, 4);
//		if(emp1!=null)
//		{
//		   session.delete(emp1);	
//		}
		transaction.commit();
		session.close();

	}

}
