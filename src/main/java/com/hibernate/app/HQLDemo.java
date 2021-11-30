package com.hibernate.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.config.HibernateUtil;
import com.hibernate.entity.Employee;

public class HQLDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		//Select
		//Select * from employee;
		Query query = session.createQuery("from Employee where empName = :name");
		query.setParameter("name", "Virat");
		List<Employee> list = query.list();
		System.out.println(list);
		
		//Update
		String updateHQL = "Update Employee SET empName = :name where empId = :id";
		Query updateQuery = session.createQuery(updateHQL);
		updateQuery.setParameter("name", "Raj");
		updateQuery.setParameter("id", 5);
		int updateCount = updateQuery.executeUpdate();
		System.out.println("Rows updated: " + updateCount);
		
		//Delete
		//Delete Statement
		String deleteHQL = "DELETE Employee where empId = :id";
		 
		Query deleteQuery = session.createQuery(deleteHQL);
		deleteQuery.setParameter("id", 6);
		 
		int rowsDeleted = deleteQuery.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("Deleted Rows :" + rowsDeleted);
		}
		
		System.out.println("Sorting");
		
		String sortHQL = "from Employee order by salary ASC";
		Query sortQuery = session.createQuery(sortHQL);
		List<Employee> sortedEmpList = sortQuery.list();
		sortedEmpList.forEach(e -> System.out.println(e.toString()));
		
		
		
		String insertHQL = "insert into Employee (empName,email,salary)"
		        + " select empName, email, salary from Employee where empId = 1";
		 
		Query insertQuery = session.createQuery(insertHQL);
		 
		int rowsInserted = insertQuery.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("Inserted copied record count:" + rowsInserted);
		} 
		
		
		transaction.commit();
		session.close();
	}

}
