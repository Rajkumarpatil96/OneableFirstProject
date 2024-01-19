package com.oneable.first.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import com.oneable.first.model.Employee;
import com.oneable.first.repository.EmployeetRepository;

@Service
public class EmployeeServiceImpl implements ServiceIface {
	
	@Autowired
	EmployeetRepository employeetRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		employee.setObjectId(UUID.randomUUID().toString());
		
		return employeetRepository.save(employee);
	}

	@Override
	public Employee UpdateEmployee(Employee employee) {
		Employee existUser = employeetRepository.findById(employee.getId()).get();
		
				//existUser.setId(employee.getId());
				existUser.setObjectId(existUser.getObjectId());
				existUser.setFirstName(employee.getFirstName());
				existUser.setLastName(employee.getLastName());
				existUser.setDesignation(employee.getDesignation());
				existUser.setSallary(employee.getSallary());
				return employeetRepository.save(existUser);
			
				
		
		
	}

	@Override
	public Employee getEmployee(long empid) {
		System.out.println(empid);
		Employee emp = employeetRepository.findById(empid).get();
		System.out.println(emp);
		return emp;
		
	}

	@Override
	public void deleteEmployee(long id) {
		employeetRepository.deleteById(id);
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeetRepository.findAll();
	}
	
	public Employee findbyObjectId(String obid)
	{	System.out.println(obid);
	
		
		Employee userdata = employeetRepository.findByObjectId(obid);
		System.out.println(userdata);
		return userdata;
		
		
	}

}
