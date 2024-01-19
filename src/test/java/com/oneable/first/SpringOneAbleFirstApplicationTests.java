package com.oneable.first;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.oneable.first.model.Employee;
import com.oneable.first.repository.EmployeetRepository;
import com.oneable.first.service.EmployeeServiceImpl;

@SpringBootTest
class SpringOneAbleFirstApplicationTests {
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

	@MockBean
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
		emp.setSallary(80000);
		
		Mockito.when(employeetRepository.save(emp)).thenReturn(emp);
		assertEquals(emp, employeeServiceImpl.createEmployee(emp));
	}
	@Test
	public void testupdateEmployee() {
		Employee emp=new Employee();
		emp.setId(1);
		emp.setObjectId("1cbb6549-b780-4de4-b982-f923ee0dd462");
		emp.setFirstName("asif");
		emp.setLastName("kachve");
		emp.setDesignation("software administrator");
		emp.setSallary(80000);
		
		//Mockito.when(employeetRepository.findById(1l)).thenReturn(emp);
		Mockito.when(employeetRepository.save(emp)).thenReturn(emp);
		assertThat(employeeServiceImpl.UpdateEmployee(emp)).isEqualTo(emp);
	}
}
