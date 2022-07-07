package com.ncs.empconsole.repository;

import java.util.List;

import com.ncs.empconsole.model.Employee;

public interface CustomEmployeeRepository {

	public Employee getEmployeeDetails(String searchedEmpName);
	public List<Employee> getAllEmployees(int salaryRange1,int salaryRange2);
	public void updateProject(int searchEmpId,int projectId);
	
}
