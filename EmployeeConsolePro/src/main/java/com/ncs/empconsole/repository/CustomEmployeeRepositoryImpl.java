package com.ncs.empconsole.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.ncs.empconsole.model.Employee;

public class CustomEmployeeRepositoryImpl implements CustomEmployeeRepository{

	@Autowired
	EntityManager springDataJPA;
	// Session in hibernate 
	
	
	@Override
	public Employee getEmployeeDetails(String searchedEmpName) {
		
			
		String query = "from Employee e where e.name = :searchName";
		Query q = springDataJPA.createQuery(query,Employee.class);
		q.setParameter("searchName", searchedEmpName);
		
		Employee queryOutput = (Employee) q.getSingleResult();
		return queryOutput;
	}

	@Override
	public List<Employee> getAllEmployees(int salaryRange1, int salaryRange2) {
		String query = "from Employee e where e.salary >= :salaryRange1 and e.salary <= :salaryRange2";
		Query q = springDataJPA.createQuery(query,Employee.class);
		q.setParameter("salaryRange1", salaryRange1).setParameter("salaryRange2", salaryRange2);
		
		List<Employee> queryOutput = (List<Employee>) q.getResultList();
		return queryOutput;
	}

	@Override
	public void updateProject(int searchEmpId, int projectId) {
		String query = "UPDATE Employee e SET e.project_info = :projectId WHERE e.emp_id = :searchEmpId";
		Query q = springDataJPA.createQuery(query, Employee.class);
		q.executeUpdate();
	}
	
	

}

















