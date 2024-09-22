package com.example.manager_microservice.manager_microservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manager_microservice.manager_microservice.Entity.Employee;
import com.example.manager_microservice.manager_microservice.Entity.Manager;
import com.example.manager_microservice.manager_microservice.Service.ManagerService;

@RestController
@RequestMapping("/api/v1")
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	
	@GetMapping("/managers")
	public List<Manager> getAllManagers() {
		return managerService.getAllManagers();
	}
	
	@GetMapping("managers/employees")
    public List<Employee> getAllEmployees() {
        return managerService.getAllEmployees();
    } 
	
}
