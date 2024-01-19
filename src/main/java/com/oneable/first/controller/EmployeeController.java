package com.oneable.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oneable.first.model.Employee;
import com.oneable.first.service.EmployeeServiceImpl;
import com.oneable.first.service.ServiceIface;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
@Autowired
ServiceIface serviceIface;
@Autowired
EmployeeServiceImpl empser;
@PostMapping("/api/create/employee")
public Employee createEmployee(@Valid @RequestBody Employee employee)
{
	return serviceIface.createEmployee(employee);
	
}
@GetMapping("/api/get/{id}")
public Employee getEmployee(@Valid @PathVariable("id") long id)
{
	return serviceIface.getEmployee(id);
	
}
@GetMapping("/api/findAll")
public List <Employee> getAllEmployee()
{
	return serviceIface.getAllEmployee();
	
}
@PutMapping("/api/update/employee")
public Employee updateEmployee(@RequestBody Employee employee)
{
	return serviceIface.UpdateEmployee(employee);
	
}
@DeleteMapping("/api/delete/{id}")
public void deleteEmployee(@PathVariable long id)
{
	serviceIface.deleteEmployee(id);
	
}
@GetMapping("/get/{objectid}")
public Employee findbyObjectId(@PathVariable String objectid)
{
	return empser.findbyObjectId(objectid);
	
}


}
