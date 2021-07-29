package com.ngn.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.LeadFollowUp;

@Repository
public interface LeadFollowUpRepository extends JpaRepository<LeadFollowUp, Integer>{

	@Query(value = "SELECT * FROM lead_follow_up a WHERE a.lead_id=?1 ORDER BY a.id DESC",nativeQuery = true)
	List<LeadFollowUp> findByleadId(int leadId);
}
