package com.ngn.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.TenderFollowUp;

@Repository
public interface TenderFollowUpRepo extends JpaRepository<TenderFollowUp, Integer>{

	@Query(value = "SELECT * FROM `tender_follow_up` u WHERE u.`tenders_id` = ?1 ORDER BY u.id DESC",nativeQuery = true)
	List<TenderFollowUp> followUpByTenderId(Integer tenderId);

}
