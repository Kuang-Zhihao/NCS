package com.ncs.empconsole.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.empconsole.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, CustomEmployeeRepository{
	
	public List<Employee> findBySalaryBetween(int salaryRange1, int salaryRange2);

}
