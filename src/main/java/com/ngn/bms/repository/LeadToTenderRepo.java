package com.ngn.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.LeadToTender;

@Repository
public interface LeadToTenderRepo extends JpaRepository<LeadToTender, Integer>{

}
