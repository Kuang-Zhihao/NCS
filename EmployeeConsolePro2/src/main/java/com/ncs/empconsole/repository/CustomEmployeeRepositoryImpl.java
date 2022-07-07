package com.ncs.empconsole.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

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
		String query = "from Employee e where e.salary > :r1 and e.salary < :r2";
		Query q = springDataJPA.createQuery(query,Employee.class);
		q.setParameter("r1", salaryRange1);
		q.setParameter("r2", salaryRange2);
		List<Employee> list= q.getResultList();
		System.err.println("INFO : Custom Repository IMPL "+list.size());
		return list;
	}

	@Override
	@Transactional
	public boolean updateProject(int searchEmpId, int projectId) {
		String query = "Update Employee set projectInfo = :pid where empId = :eid";
		Query q = springDataJPA.createQuery(query);
		q.setParameter("pid", projectId);
		q.setParameter("eid", searchEmpId);
		int x = q.executeUpdate();
		
		
		return (x==1)?true:false;
	}
	
	

}
