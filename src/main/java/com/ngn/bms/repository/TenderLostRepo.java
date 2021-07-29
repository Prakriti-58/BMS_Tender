package com.ngn.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.TenderLost;

@Repository
public interface TenderLostRepo extends JpaRepository<TenderLost, Integer>{

}
