package com.ngn.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.EmployeeDetails;


@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeDetails, Integer>{

}
