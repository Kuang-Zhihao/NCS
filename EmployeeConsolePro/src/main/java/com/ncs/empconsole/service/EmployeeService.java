package com.ncs.empconsole.service;

import java.util.List;

import com.ncs.empconsole.model.Employee;

public interface EmployeeService {

	public boolean addEmployee(Employee e);
	public Employee getEmployeeDetails(int searchedEmpId);
	public Employee getEmployeeDetails(String searchedEmpName);
	
	public List<Employee> getAllEmployees();
	public List<Employee> getAllEmployees(int salaryRange1,int salaryRange2);
	
	public void updateProject(int searchEmpId,int projectId);
	
	
}
