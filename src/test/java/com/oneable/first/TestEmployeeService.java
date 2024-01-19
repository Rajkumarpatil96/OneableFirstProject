package com.oneable.first;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.oneable.first.model.Employee;
import com.oneable.first.repository.EmployeetRepository;
import com.oneable.first.service.EmployeeServiceImpl;

@SpringBootTest(classes =TestEmployeeService.class )
 public class TestEmployeeService  {
@InjectMocks
EmployeeServiceImpl employeeServiceImpl;

@Mock
EmployeetRepository employeetRepository;

	@Test
	@SuppressWarnings("deprecation")
	public void testCreateEmployee() {
		Employee emp=new Employee();
		emp.setId(1);
		emp.setObjectId("1cbb6549-b780-4de4-b982-f923ee0dd462");
		emp.setFirstName("asif");
		emp.setLastName("kachve");
		emp.setDesignation("software administrator");
		emp.setSallary(900000);
		
		when(employeetRepository.save(emp)).thenReturn(emp);
		assertEquals(emp, employeeServiceImpl.createEmployee(emp));
	}
	
	
}
