package com.dinesh.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class Operations {
	private List<Employee> empList = new ArrayList<>();

	@PostConstruct
	public void fillEmployee() {
		empList.add(new Employee("Dinesh", 1, "Infosys"));
		empList.add(new Employee("Srinivasan", 2, "Mphasis"));
		empList.add(new Employee("Murali", 3, "Own"));
		empList.add(new Employee("vinoth", 4, "DXC"));
		empList.add(new Employee("Sri", 5, "Own"));
	}

	public List<Employee> getEmpList() {
		return empList;
	}
	
	public void save(Employee e) {
		empList.add(e);
	}
	
	public void deleteAll() {
		empList.clear();
	}
	
}
