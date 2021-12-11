package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CurdDao;
import com.example.demo.dao.CurdDeptDao;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;

@RestController
public class AddController {
	@Autowired
	CurdDao repo;
	@Autowired
	Employee emp;
	@Autowired
	CurdDeptDao repoDept;
	@Autowired
	Department dept;
	@RequestMapping(value= "/add/{eno}/{name}/{address}/{dno}/{dname}",produces= {"application/json"})
	public Department addMethod(@PathVariable("eno") int  eno, @PathVariable("name") String name, @PathVariable("address") String address,@PathVariable("dno") int dno,@PathVariable("dname") String dname) {
		
	
		emp.seteAddress(address);
		emp.setEno(eno); 
		emp.seteName(name);
		
		
		dept.setDepNo(dno);
		dept.setDepName(dname);
		
		
		//emp.setDept(dept);
		
		dept.setEmp(emp);
		
		
		
		
	/*	Employee listEmp = (Employee) repo.findById(eno).orElse(null); 
		System.out.println(listEmp);*/
		Department e =repo.save(dept);
		return e; 
	}
	
	@RequestMapping(value= "/delete/{eno}",produces= {"application/json"})
	public void deleteMethod(@PathVariable("eno") int eno) {
		//emp.setEno(eno);
		repo.deleteById(eno);
	}
	
	@RequestMapping(value= "/get/{eno}",produces= {"application/json"})
	public Department getMethod(@PathVariable int eno) {
		 
		Department listEmp = (Department) repo.findById(eno).orElse(null); 
		System.out.println(listEmp);
		/*Employee e =(Employee) repo.findAll();
		System.out.println(e);*/
		return listEmp;
	}
	
}
