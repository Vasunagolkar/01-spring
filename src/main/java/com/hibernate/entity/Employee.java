package com.hibernate.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "employee")
@NamedQueries({
	@NamedQuery(name = "selectEmpNames", query = "Select e.empName from Employee e")
})
@NamedNativeQueries({
    @NamedNativeQuery(name = "selectEmpNamesNative", query = "SELECT e.name FROM employee e")
})
public class Employee {
	
	@Id
	@Column(name = "id")  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	
	@Column(name = "name")
	private String empName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "salary")
	private long salary;
	
	public Employee() {
		
	}
	
	public Employee(String name, String email, long salary) {
		super();
		this.empName = name;
		this.email = email;
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long string) {
		this.salary = string;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", email=" + email + ", salary=" + salary + "]";
	}

	public void setEmpName1(String empName2) {
		// TODO Auto-generated method stub
		
	}
	
}
