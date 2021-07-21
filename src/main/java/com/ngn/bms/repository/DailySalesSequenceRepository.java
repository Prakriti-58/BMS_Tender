package com.ngn.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ngn.bms.model.DailySalesSequence;

public interface DailySalesSequenceRepository extends JpaRepository<DailySalesSequence, Integer> {

	
	DailySalesSequence findByUserId(String userId);
	
	@Query(value="SELECT * FROM daily_sales_sequence WHERE user_id=?1 AND cash_id=?2",nativeQuery=true)
	DailySalesSequence findByCashId(String userId,int cashId);
}
