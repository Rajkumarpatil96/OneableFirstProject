package com.oneable.first.service;

import java.util.List;

import com.oneable.first.model.Employee;

public interface ServiceIface {
	Employee createEmployee(Employee employee);
	Employee UpdateEmployee(Employee employee);
	Employee getEmployee(long id);
	void deleteEmployee(long id);
	List<Employee>getAllEmployee();

}
