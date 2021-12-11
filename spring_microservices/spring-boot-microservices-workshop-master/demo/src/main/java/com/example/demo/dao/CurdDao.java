package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;


public interface CurdDao extends CrudRepository<Department, Integer>  {

}
