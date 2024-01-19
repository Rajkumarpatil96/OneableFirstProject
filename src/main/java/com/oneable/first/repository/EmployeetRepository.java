package com.oneable.first.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.oneable.first.model.Employee;

public interface EmployeetRepository extends MongoRepository<Employee, Long>{
//	 @Query("{id:?0}")
//	Employee findById(long id);
//	@Query(value = "{empid :?0}")
//Employee findByEmpId(long empid);
	@Query(value="{obid:?0}")
	Employee findByObjectId(String obid);
}
