package com.dinesh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinesh.model.Employee;
import com.dinesh.model.Operations;

@Service
public class EmpService {

	@Autowired
	private Operations operations;
	
	public void addEmp(Employee emp) {
		operations.save(emp);
		
	}

	public void deleteEmp() {
		operations.deleteAll();
	}

	public List<Employee> getEmpList() {
		List<Employee> empList = new ArrayList<>();
		operations.getEmpList().forEach(e->empList.add(e));
		return empList;
	}

	public List<Employee> getEmpById(int id) {
		List<Employee> empList = operations.getEmpList().stream().filter(e -> e.getId() == id).collect(Collectors.toList());
		System.out.println("Emp by Id: " + empList);
		return empList;
	}

	public List<Employee> getEmpByComp(String company) {
		System.out.println("Company Name is : "+company);
		List<Employee> listByComp = operations.getEmpList().stream().filter(e -> e.getCompany().equals(company)).collect(Collectors.toList());
		System.out.println("EmpList by CompanyName: " + listByComp);
		return listByComp;
	} 
}
