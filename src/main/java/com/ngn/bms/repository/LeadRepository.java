package com.ngn.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer>{

	@Query(value = "SELECT * FROM lead u WHERE u.lead_status = 'lead' AND u.active = 'Y' ORDER BY u.id DESC",nativeQuery = true)
	List<Lead> getAll();

	@Query(value = "SELECT * FROM lead u WHERE u.lead_status = 'opportunity' AND u.active = 'N' ORDER BY u.id DESC",nativeQuery = true)
	List<Lead> getAllOpportunities();

	@Query(value = "SELECT * FROM lead u WHERE u.forwarded_to=?1 AND u.lead_status = 'lead' AND u.acknowledge = 'Y' AND u.active = 'Y' ORDER BY u.id DESC",nativeQuery = true)
	List<Lead> findByForwardedTo(int userId);

	@Query(value = "SELECT * FROM lead u WHERE u.forwarded_to=?1 AND u.lead_status = 'lead' AND u.acknowledge = 'N' AND u.active = 'Y' ORDER BY u.id DESC",nativeQuery = true)
	List<Lead> leadNotAcknownledge(int userId);
	
	@Query(value = "SELECT * FROM lead u WHERE u.lead_status = 'tender' AND u.active = 'N' ORDER BY u.id DESC",nativeQuery = true)
	  List<Lead> getAllTender();
	
	
}
