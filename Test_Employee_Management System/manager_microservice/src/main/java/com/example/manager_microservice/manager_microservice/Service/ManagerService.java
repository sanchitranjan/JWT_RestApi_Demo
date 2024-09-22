package com.example.manager_microservice.manager_microservice.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.manager_microservice.manager_microservice.Entity.Employee;
import com.example.manager_microservice.manager_microservice.Entity.Manager;
import com.example.manager_microservice.manager_microservice.Repository.ManagerRepository;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository managerRepository;
	
	@Autowired
    private RestTemplate restTemplate; 
    
    private static final String EMPLOYEE_SERVICE_URL = "http://localhost:8081/api/v1/employees"; 
	
	public List<Manager> getAllManagers() {
		return managerRepository.findAll();
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> employee = restTemplate.getForObject(EMPLOYEE_SERVICE_URL, ArrayList.class);
        
        return employee;
	}
	
}


