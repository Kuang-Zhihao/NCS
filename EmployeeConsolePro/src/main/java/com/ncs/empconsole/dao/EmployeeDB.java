package com.ncs.empconsole.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ncs.empconsole.model.Employee;

@Component
public class EmployeeDB {
	
	public List<Employee> employeeDB = new ArrayList<>();

	EmployeeDB()
	{
		Employee e1 = new Employee(101, "Ramesh", 2000);
		Employee e2 = new Employee(102, "Suresh", 3000);
		Employee e3 = new Employee(103, "Mahesh", 1500);
		Employee e4 = new Employee(104, "Rakesh", 7000);
	
		employeeDB.add(e1);
		employeeDB.add(e2);
		employeeDB.add(e3);
		employeeDB.add(e4);
		
	}

	public boolean addEmployee(Employee e)
	{
		System.out.println("--->> 2) list.size() :- "+employeeDB.size() + " - "+e);
		boolean status =  employeeDB.add(e);
		
		System.err.println("--->> 3) inside Employee DB "+status);
		
		return status;
		
	}
	
	public Employee getEmployee(int id)
	{
		List<Employee> list =   employeeDB.stream().filter((e)->{
			if(e.getEmpId() == id)
			{
				return true;
			}
			else return false;
		}).collect(Collectors.toList());
		
		if(list.size()==1)	return list.get(0);
		else return null;
		
	}
	
	public Employee getEmployee(String name)
	{
		List<Employee> list =   employeeDB.stream().filter((e)->{
			if(e.getName().equalsIgnoreCase(name))
			{
				return true;
			}
			else return false;
		}).collect(Collectors.toList());
		
		if(list.size()==1)	return list.get(0);
		else return null;
		
	}
	
	
	public Employee updateProjectInfo(int searchId,int projectId)
	{
		
		
		Employee empFromDB = getEmployee(searchId);
		
		if(empFromDB != null)
		{
			empFromDB.setProjectInfo(projectId);
			return empFromDB;
		}
		
		
		
		return null;
	}
	
	public List<Employee> getEmployeeDB() {
		return employeeDB;
	}

	
	
	
	
}














