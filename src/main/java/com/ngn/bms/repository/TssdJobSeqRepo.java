package com.ngn.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.TssdJobSeq;

@Repository
public interface TssdJobSeqRepo extends JpaRepository<TssdJobSeq, Integer>{

	@Query(value = "SELECT * FROM tssd_job_seq a WHERE a.job_seq_initial = 'TH'",nativeQuery = true)
	TssdJobSeq findByInitial(String initial);

}
