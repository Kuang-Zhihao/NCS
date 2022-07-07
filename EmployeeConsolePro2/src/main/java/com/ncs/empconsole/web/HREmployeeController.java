package com.ncs.empconsole.web;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.empconsole.exception.OutofRangeSalaryException;
import com.ncs.empconsole.model.Employee;
import com.ncs.empconsole.service.EmployeeService;

@RestController
@RequestMapping("/empconsole/hr")
public class HREmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	public HREmployeeController() {
		System.out.println("HR Employee Controller constructor called");
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return empService.getAllEmployees();
	}

	@GetMapping("/employee/id/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)throws IllegalArgumentException,NoSuchElementException
	{
		System.out.println("path varible : "+id);
		try {
			Employee output = empService.getEmployeeDetails(id);
			return new ResponseEntity<Employee>(output,HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(" --->> inside catch ");
			throw new NoSuchElementException(e.getMessage());
		}
	}
	
	@GetMapping("/employee") // ..../employee/hr/employee?name=ramesh
	public Employee getEmployeeByName(@RequestParam String name)
	{
		System.out.println("path varible : "+name);
		Employee e =  empService.getEmployeeDetails(name);
		System.out.println(e);
		return e;
	}
	
	@PutMapping("/employee/{searchEmpId}/project")
	public Employee updateEmployee(@PathVariable int searchEmpId,@RequestParam int projectId)
	{
		return empService.updateProject(searchEmpId, projectId);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e)throws OutofRangeSalaryException
	{
		
		Employee savedEmployee = empService.addEmployee(e);
		
		return new ResponseEntity<Employee>(savedEmployee,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/employees/salary") 
	public ResponseEntity<List<Employee>> getEmployeeBySalaryRange(@RequestParam int r1,@RequestParam int r2)
	{
		
		List<Employee> list =  empService.getAllEmployees(r1, r2);
		System.out.println(list);
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	} 
	
}//end class




















