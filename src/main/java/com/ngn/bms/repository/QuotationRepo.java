package com.ngn.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.Quotation;

@Repository
public interface QuotationRepo extends JpaRepository<Quotation, Integer>{

}
