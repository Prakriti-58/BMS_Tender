package com.ngn.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.TenderStage;

@Repository
public interface TenderStageRepo extends JpaRepository<TenderStage, Integer>{

}
