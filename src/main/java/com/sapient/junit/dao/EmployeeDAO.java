package com.sapient.junit.dao;

import java.util.ArrayList;
import java.util.List;

import com.sapient.junit.model.Employee;

public class EmployeeDAO {
	
	private static List<Employee> employees = new ArrayList<>();
	
	public void save(Employee employee) {
		this.employees.add(employee);
	}
	
	public List<Employee> getAll(){
		return this.employees;
	}

}
