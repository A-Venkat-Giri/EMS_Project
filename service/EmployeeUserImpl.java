package com.dev.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.spring.beans.Employee;
import com.dev.spring.dao.EmployeeDAO;
@Service
public class EmployeeUserImpl implements EmployeeService {

	@Autowired
	EmployeeDAO dao;
	@Override
	public Employee createEmployee(Employee employee) {
		return dao.createEmployee(employee);
	}

	@Override
	public Employee getEmployee(int employeeId) {
		return dao.getEmployee(employeeId);
	}

	@Override
	public Boolean updateEmployee(Employee employee) {
		return dao.updateEmployee(employee);
	}

	@Override
	public Boolean deleteEmployee(int employeeId) {
		return dao.deleteEmployee(employeeId);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return dao.getAllEmployee();
	}

}
