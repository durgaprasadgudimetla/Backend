package com.emp.mgmt.EmpManagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.mgmt.EmpManagement.dao.EmployeeDao;
import com.emp.mgmt.EmpManagement.model.Employee;
import com.emp.mgmt.EmpManagement.service.EmployeeService;
@Service
public class EmploeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao empDao;
	@Override
	public List<Employee> getEmployee() {  
		// TODO Auto-generated method stub
		return empDao.findAll();
		
		}

}
