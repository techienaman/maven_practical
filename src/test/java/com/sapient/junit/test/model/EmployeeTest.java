package com.sapient.junit.test.model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.sapient.junit.model.*;

public class EmployeeTest {
	
	private  Employee employee1;

	private Employee employee2;
	
	@BeforeClass
	public static void setUp() {
		System.out.println("Setup method called only once");
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("tearDown method called only once....");
	}

	@Before
	public void beforeTest() {
		employee1 = new Employee(12,"Vishal", 35000);
		employee2 = new Employee(14, "Kiran", 45000);
	}
	
	@Test
	public void testSetName() {
		assertEquals("Vishal", employee1.getName());
		
		employee1.setName("Kishore");
		
		assertNotNull(employee1.getName());
		assertEquals("Kishore", employee1.getName());
	}	
	
	
	@Test
	public void testSetSalary() {
		assertEquals(35000, employee1.getSalary(), 0);
		
		employee1.setSalary(15000);
		
		assertEquals(15000, employee1.getSalary(), 0);
	}
	
	@Test
	public void testSetId() {
		assertEquals(12, employee1.getId());
		
		employee1.setId(15);
		
		assertEquals(15, employee1.getId());
	}
	
	@Test
	public void testEqualsWithNull() {
		Employee employee2 = null;
		
		assertFalse(employee1.equals(employee2));
		 
	}
	
	@Test
	public void testEqualsWithInvalidValues() {
		employee1.setId(15);
		employee1.setName("Kiran");
		employee1.setSalary(50000);
		
		
		employee2.setId(15);
		employee2.setName("Harsh");
		employee2.setSalary(50000);
		
		assertFalse(employee1.equals(employee2));
		 
	}
	
	@Test
	public void testEqualsWithValidValues() {
		employee1.setId(15);
		employee1.setName("Kiran");
		employee1.setSalary(50000);
		
		employee2.setId(15);
		employee2.setName("Kiran");
		employee2.setSalary(50000);
		
		assertTrue(employee1.equals(employee2));
		 
	}
	
	@Test
	public void testToString() {
		employee1.setId(15);
		employee1.setName("Kiran");
		employee1.setSalary(50000);
		
		assertEquals("Employee [id=15, name=Kiran, salary=50000.0]", employee1.toString());
	}
	
	@Test
	public void testHashCodeWithInValidValues() {
		employee1.setId(18);
		employee1.setName("Kiran");
		employee1.setSalary(50000);
		
		employee2.setId(15);
		employee2.setName("Kiran");
		employee2.setSalary(50000);
		
		assertNotEquals(employee1.hashCode(), employee2.hashCode());
		 
	}
	
	@Test
	public void testHashCodeWithValidValues() {
		employee1.setId(15);
		employee1.setName("Kiran");
		employee1.setSalary(50000);
		
		employee2.setId(15);
		employee2.setName("Kiran");
		employee2.setSalary(50000);
		
		assertEquals(employee1.hashCode(), employee2.hashCode());
		 
	}

	
	
	

}
