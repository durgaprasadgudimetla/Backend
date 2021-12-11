package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Department;

public interface CurdDeptDao extends CrudRepository<Department, Integer> {

}
