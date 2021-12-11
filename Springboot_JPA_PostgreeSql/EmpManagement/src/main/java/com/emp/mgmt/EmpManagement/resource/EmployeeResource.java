package com.emp.mgmt.EmpManagement.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.mgmt.EmpManagement.model.Employee;
import com.emp.mgmt.EmpManagement.service.EmployeeService;

@RestController
public class EmployeeResource {
	
// display Employee service
	@Autowired
	EmployeeService service;
	
    @GetMapping("/getEmployee")
	public List<Employee> getEmployee() {
    	return service.getEmployee(); 
    }
	
	// Adding Employee service
	
    @PostMapping("/addEmployee")
	public void addEmployee() {
    }
    
    // update Employee service
    
    @PostMapping("/updateEmployee")
    public void updateEmployee() {

    	    	
    }
    
    // DELETE Employee service
    
    @PostMapping("/deleteEmployee/{empId}")
    public void deleteEmployee(@PathVariable("empId") int empId) {
    	    	
    }

}
