package com.ncs.empconsole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ncs.empconsole.model.Employee;
import com.ncs.empconsole.repository.CustomEmployeeRepository;
import com.ncs.empconsole.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	CustomEmployeeRepository customEmployeeRepository;
	
	@Override
	public boolean addEmployee(Employee e) {
		Employee savedEntity =  employeeRepository.save(e);
		
		return (savedEntity != null);
	
	}

	@Override
	public Employee getEmployeeDetails(int searchedEmpId) {
		Employee returnedEmployee =  employeeRepository.getById(searchedEmpId);
		return (returnedEmployee!=null)? returnedEmployee : null;
	}

	@Override
	public Employee getEmployeeDetails(String searchedEmpName) {	
		return employeeRepository.getEmployeeDetails(searchedEmpName);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getAllEmployees(int salaryRange1, int salaryRange2) {
		return employeeRepository.findBySalaryBetween(salaryRange1, salaryRange2);
	}

	@Override
	public void updateProject(int searchEmpId, int projectId) {
		customEmployeeRepository.updateProject(searchEmpId, projectId);
	}

	
}
