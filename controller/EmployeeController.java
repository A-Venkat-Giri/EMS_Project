package com.dev.spring.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.spring.beans.Employee;
import com.dev.spring.service.EmployeeService;

/**
 * Handles requests for the Employee service.
 */
@RestController
public class EmployeeController {
	
	//Map to store employees, ideally we should use database
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
	@Autowired
	EmployeeService services;
	
	@RequestMapping(value = "/rest/emp/dummy", method = RequestMethod.GET)
	public Employee getDummyEmployee() {
		Employee emp = new Employee();
		emp.setId(9999);
		emp.setName("Dummy");
		emp.setEmail("emp@mail.com");
		empData.put(9999, emp);
		return emp;
	}
	
	@RequestMapping(value = "/rest/emp/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("id") int empId) {
		Employee employee = services.getEmployee(empId);
		return employee;
	}
	
	@RequestMapping(value = "/rest/emps", method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		List<Employee> employees = services.getAllEmployee();
		return employees;
	}
	
	@RequestMapping(value = "/rest/emp/create", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee emp) {
		Employee employee = services.createEmployee(emp);
		return employee;
	}
	
	@RequestMapping(value = "/rest/emp/delete/{id}", method = RequestMethod.DELETE)
	public Employee deleteEmployee(@PathVariable("id") int empId) {
		Employee employee = services.getEmployee(empId);
		boolean state = services.deleteEmployee(empId);
		if(state)
		{
			return employee;
		}
		else
		{
			return null;
		}
	}
	
	@RequestMapping(value = "/rest/emp/update", method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee emp) {
		Boolean update = services.updateEmployee(emp);
		if(update)
		{
			Employee employee = services.getEmployee(emp.getId());
			return employee;
		}
		else
		{
			return null;
		}
		
	}
}