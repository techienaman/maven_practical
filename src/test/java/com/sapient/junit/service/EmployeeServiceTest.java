package com.sapient.junit.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sapient.junit.dao.EmployeeDAO;
import com.sapient.junit.model.Employee;

public class EmployeeServiceTest {
	
	@Mock
	private EmployeeDAO employeeDAO;
	
	@InjectMocks
	private EmployeeService employeeService;
	
	@Before
	public void beforeMethod() {
		MockitoAnnotations.initMocks(this);
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
	
	@Test
	public void testFindAllEmployees() {
		
		Mockito.when(employeeDAO.getAll()).thenReturn(Arrays.asList(
				new Employee(12, "Kishan", 45000),
				new Employee(15, "Kiran", 55000),
				new Employee(16, "Varun", 75000)));
		
		List<Employee> employees = employeeService.fetchAllEmployees();
		assertNotNull(employees);
		assertEquals(employees.size(),  3);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidNullEmployees() {
		
		Mockito.when(employeeDAO.getAll()).thenReturn(null);
		
		List<Employee> employees = employeeService.fetchAllEmployees();
		fail("Exception should be thrown");
	}

	@Test
	public void testInvalidEmptyEmployees() {
		
		Mockito.when(employeeDAO.getAll()).thenReturn(new ArrayList<Employee>());
		
		List<Employee> employees = employeeService.fetchAllEmployees();
		
		assertNotNull(employees);
		assertTrue(employees.isEmpty());
	}
}
