package com.ngn.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.Warranty;

@Repository
public interface WarrantyRepo extends JpaRepository<Warranty, Integer>{

	Warranty findAllByModelSerialNo(String serialNo);

	List<Warranty> findByCustomerName(String customerName);


}
