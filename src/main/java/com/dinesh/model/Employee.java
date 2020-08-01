package com.dinesh.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Employee {
	
	@NotEmpty(message = "Please provide a name")
	@Length(max = 10, min = 5)
	private String name;
	@Id
	private int id;
	private String company;
	
	public Employee() {
		
	}
	
	public Employee(String name, int id, String company) {
		this.name = name;
		this.id = id;
		this.company = company;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", company=" + company + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
