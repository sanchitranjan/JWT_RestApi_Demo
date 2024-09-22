package com.example.manager_microservice.manager_microservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "manager")
@Setter
@Getter
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	int id;
	
	@Column(name="Name")
	String name;

	public Manager() {}

	public Manager(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
