
package com.durga.flightbooking.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.durga.flightbooking.model.mysql.EmpDetails;


@Repository
public interface EmployeeRepository extends JpaRepository<EmpDetails, Integer> {

}
