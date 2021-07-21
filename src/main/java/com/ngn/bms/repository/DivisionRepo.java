package com.ngn.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.Division;


@Repository
public interface DivisionRepo extends JpaRepository<Division, Integer>{

}
