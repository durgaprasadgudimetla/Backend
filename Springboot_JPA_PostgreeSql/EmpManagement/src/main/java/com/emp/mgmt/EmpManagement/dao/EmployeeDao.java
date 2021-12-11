package com.emp.mgmt.EmpManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.mgmt.EmpManagement.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
		
}
