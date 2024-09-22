package com.example.manager_microservice.manager_microservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.manager_microservice.manager_microservice.Entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer>{

}
