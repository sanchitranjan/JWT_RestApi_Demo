package com.example.manager_microservice.manager_microservice.Entity;

public class Employee {
	
	int id;
	String name;
	String department;
	String email;
	String salary;
	String phone;
		
	public Employee() {	}
	
	public Employee(String Name, String Department, String emailId, String salary, String phone) {
		super();
		this.name = Name;
		this.department = Department;
		this.email = emailId;
		this.salary = salary;
		this.phone = phone;
	}
	
}
