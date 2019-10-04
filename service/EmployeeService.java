package com.dev.spring.service;

import java.util.List;

import com.dev.spring.beans.Employee;

public interface EmployeeService {
	
	public Employee createEmployee(Employee employee);
	public Employee getEmployee(int employeeId);
	public Boolean updateEmployee(Employee employee);
	public Boolean deleteEmployee(int employeeId);
	public List<Employee> getAllEmployee();
	

}
