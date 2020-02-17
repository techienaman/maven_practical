package com.sapient.junit.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sapient.junit.dao.EmployeeDAO;
import com.sapient.junit.model.Employee;

public class EmployeeServiceTest {
	
	private EmployeeDAO employeeDAO;
	private EmployeeService employeeService;
	
	@Before
	public void beforeMethod() {
		employeeDAO = new EmployeeDAO();
		employeeService = new EmployeeService(employeeDAO);
	}
	
	@Test
	public void saveEmployeeInvalidValues() {
	
		Employee employee = new Employee(14,"Akash", 25000);
		try {
			employeeService.saveEmployee(employee);
			fail("SHould not execute this statement");
		} catch(Exception exception) {
			assertNotNull(exception);
			assertTrue(exception instanceof IllegalArgumentException);
			assertEquals("Insufficient salary ..", exception.getMessage());
		}
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void saveEmployeeInvalidValues1() {
		Employee employee = new Employee(14,"Akash", 25000);
		employeeService.saveEmployee(employee);
		fail("SHould not execute this statement");
	}
	
	@Test
	public void saveEmployeeValidValues() {
	
		Employee employee = new Employee(14,"Akash", 55000);
		try {
			employeeService.saveEmployee(employee);
		} catch(Exception exception) {
			fail("Exception should not be thrown");
		}
	}

}
