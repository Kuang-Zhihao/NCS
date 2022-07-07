package com.ncs.empconsole.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.empconsole.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, CustomEmployeeRepository{

}
