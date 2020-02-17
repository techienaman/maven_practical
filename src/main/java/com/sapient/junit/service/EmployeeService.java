package com.sapient.junit.service;

import com.sapient.junit.dao.EmployeeDAO;
import com.sapient.junit.model.Employee;

public class EmployeeService {
	
	private EmployeeDAO employeeDAO;

	public EmployeeService(EmployeeDAO employeeDAO) {
		this.employeeDAO = new EmployeeDAO();
	}
	
	public void saveEmployee(Employee employee) {
		
		if ( employee.getSalary() > 50000) {
		   this.employeeDAO.save(employee);
		} else {
			throw new IllegalArgumentException("Insufficient salary ..");
		}
	}
}
