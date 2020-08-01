package com.dinesh.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.model.Employee;
import com.dinesh.model.Operations;
import com.dinesh.model.ResponseJson;
import com.dinesh.service.EmpService;

@RestController
public class TestController {

	@Autowired
	private EmpService empService;
	
	@Autowired
	private Operations operations;
	
	@RequestMapping(value = "/getemp", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> getEmployees(){
		System.out.println("Get employee API called..");
		return operations.getEmpList();
	}

	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public ResponseEntity<ResponseJson> addEmp(HttpServletResponse response, @RequestBody Employee emp) {
		System.out.println("ADD employee API called..");
		ResponseJson responsejson = new ResponseJson();
		try {
		empService.addEmp(emp);
	
		responsejson.setId(emp.getId());
		responsejson.setName(emp.getName());
		responsejson.setResponseMsg("Successfully Added");
		responsejson.setStatusCode(response.getStatus());
		
		} catch(Exception e) {
			System.out.println("Error Occurred while adding data..");
			responsejson.setResponseMsg("Failed");
			responsejson.setStatusCode(response.getStatus());
			return new ResponseEntity<ResponseJson>(responsejson, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ResponseJson>(responsejson, HttpStatus.CREATED);
		
	}

	@RequestMapping(value = "/deleteAllEmp", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteAllEmp() {
		System.out.println("deleteAll employee API called..");
		empService.deleteEmp();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping("/getEmployee")
	public List<Employee> getEmployee(){
		System.out.println("get employee list API called..");
		return empService.getEmpList();
	}
	
	@RequestMapping("/getEmployeeById/{id}")
	public List<Employee> getEmployeeById(@PathVariable int id){
		System.out.println("Get employee by ID API called..");
		List<Employee> emp = empService.getEmpById(id);
		return emp;
	}

	@RequestMapping("/getEmployeeByParam/{company}")
	public List<Employee> getEmployeeByParam(@PathVariable String company){
		System.out.println("Heeeeyy");
		List<Employee> getBycomp = empService.getEmpByComp(company);
 		return getBycomp;
	}
	
	
	

}
