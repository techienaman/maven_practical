package com.sapient.junit.service;

import java.util.List;

import com.sapient.junit.dao.EmployeeDAO;
import com.sapient.junit.model.Employee;

public class EmployeeService {
	
	private EmployeeDAO employeeDAO;

	public EmployeeService(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	public void saveEmployee(Employee employee) {
		
		if ( employee.getSalary() > 50000) {
		   this.employeeDAO.save(employee);
		} else {
			throw new IllegalArgumentException("Insufficient salary ..");
		}
	}
	
	public List<Employee> fetchAllEmployees(){
		List<Employee> employees = this.employeeDAO.getAll();
		if (employees == null) {
			throw new IllegalArgumentException("No employees");
		}
		return employees;
	}
}
