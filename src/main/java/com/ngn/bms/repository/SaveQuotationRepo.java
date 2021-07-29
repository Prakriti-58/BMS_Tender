package com.ngn.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.SaveQuotation;

@Repository
public interface SaveQuotationRepo extends JpaRepository<SaveQuotation, Integer>{

	@Query(value = "SELECT* FROM t_quotation a WHERE a.`active`='Y' AND a.`updated_by`=?1",nativeQuery = true)
	List<SaveQuotation> findAllByUpdatedBy(int userId);

	@Query(value = "SELECT* FROM t_quotation a WHERE a.`active`='Y' AND a.tender_id=?1",nativeQuery = true)
	SaveQuotation findByTenderId(int tender_id);
	
}
