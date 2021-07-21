package com.ngn.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.TenderWorkSheet;

@Repository
public interface TenderWorkSheetRepo extends JpaRepository<TenderWorkSheet, Integer>{

	@Query(value = "SELECT * FROM `tender_work_sheet` a WHERE a.`tender_id`=?1 AND a.`updated_by`=?2",nativeQuery = true)
	List<TenderWorkSheet> getWorkSheetBy(Integer tenderId, Integer userId);

}
