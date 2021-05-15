package com.example.cruddemo.service;

import java.util.List;

import com.example.cruddemo.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();
	
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById( long id);
	
	void deleteEmployee(long id);
	
	
}
