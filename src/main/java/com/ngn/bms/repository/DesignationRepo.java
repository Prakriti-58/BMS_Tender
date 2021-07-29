package com.ngn.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.Designation;

@Repository
public interface DesignationRepo extends JpaRepository<Designation, Integer>{

}
