package com.ngn.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.Tenders;

@Repository
public interface TenderRepository extends JpaRepository<Tenders, Integer>{

	@Query(value = "SELECT * FROM Tenders a WHERE a.status='Y' AND a.acknowledge='N' AND a.forwarded_to=?1 ORDER BY a.`updated_on` DESC",nativeQuery = true)
	List<Tenders> findAllAssignedTender(Integer userId);

	@Query(value = "SELECT * FROM Tenders a WHERE (added_by=?1 OR forwarded_to=?1) AND a.status='Y'  ORDER BY a.`updated_on` DESC",nativeQuery = true)
	List<Tenders> findAllOpenTender(Integer userId);

	@Query(value = "SELECT * FROM Tenders a WHERE a.updated_by=?1 AND a.status='Y' AND a.tender_stage_id=2 AND a.acknowledge='Y' ORDER BY a.`updated_on` DESC",nativeQuery = true)
	List<Tenders> findAllPreparedTender(Integer userId);

	@Query(value = "SELECT * FROM Tenders a WHERE a.updated_by=?1 AND a.status='Y' AND a.tender_stage_id=8 OR a.tender_stage_id=9 OR a.tender_stage_id=10 AND a.acknowledge='Y' ORDER BY a.`updated_on` DESC",nativeQuery = true)
	List<Tenders> findQuotedTenderByUser(int userId);

	@Query(value = "SELECT * FROM Tenders a WHERE a.tender_stage_id=?1 AND a.updated_by=?2 ORDER BY a.`updated_on` DESC",nativeQuery = true)
	List<Tenders> findByTenderStage(int tenderStage, int userId);

	@Query(value = "SELECT * FROM Tenders a WHERE a.`status`='Not Collected' OR a.`status`='Collected' ORDER BY a.`updated_on` DESC",nativeQuery = true)
	List<Tenders> findAllTenderCollection();
		
}
