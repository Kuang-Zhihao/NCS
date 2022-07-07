package com.ncs.empconsole.util;

import org.springframework.stereotype.Component;


import com.ncs.empconsole.model.Employee;

@Component
public class ValidateEmployee {

	public boolean validateEmployeeSalary(Employee e)
	{
		String designation = e.getDesignation();
		int salary = e.getSalary();
		
		if(designation.equalsIgnoreCase("executive") && salary>3000)
		{
			return false;
		}
		else return true;
	}
}
