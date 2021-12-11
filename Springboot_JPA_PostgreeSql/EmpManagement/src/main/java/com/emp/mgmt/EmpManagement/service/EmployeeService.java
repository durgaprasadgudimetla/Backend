package com.emp.mgmt.EmpManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.mgmt.EmpManagement.model.Employee;
@Service
public interface EmployeeService {

	public List<Employee> getEmployee();
}
