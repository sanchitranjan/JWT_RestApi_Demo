package com.example.Test_Employee_Management.Service;

import com.example.Test_Employee_Management.Entity.User;
import com.example.Test_Employee_Management.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Test_Employee_Management.Entity.Employee;
import com.example.Test_Employee_Management.Exception.ResourceNotFoundException;
import com.example.Test_Employee_Management.Repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmployeeRepository repo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<User> getUsers(){
		return userRepository.findAll();
	}

	public User createUser(User user){
		user.setUserId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public Employee createEmployee(Employee employee) {
		repo.save(employee);
		return employee;
	}

	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	public Employee getEmployeeById(int id) {
		return repo.findAll().stream()
						.filter(employee -> employee.getId() == id)
						.findFirst()
						.orElse(null);
	}

	public Employee updateEmployee(int id, Employee updatedEmployee) {
		Optional<Employee> employee = repo.findById(id);
		Employee emp = employee.get();
		
		if (employee.isPresent()) {
			emp.setId(updatedEmployee.getId());
			emp.setName(updatedEmployee.getName());
			emp.setDepartment(updatedEmployee.getDepartment());
			emp.setEmail(updatedEmployee.getEmail());
			emp.setSalary(updatedEmployee.getSalary());
			emp.setPhone(updatedEmployee.getPhone());
		}
		
		repo.save(emp);
		return emp;
	}

	public Employee deleteEmployee(int id) {
		
		Employee deletedEmployee = repo.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		repo.delete(deletedEmployee);
		return deletedEmployee;
		
	}


}
