package com.ngn.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.TssdSparePartIncluded;

@Repository
public interface TssdSparePartIncludedRepo extends JpaRepository<TssdSparePartIncluded, Integer>{

	@Query(value = "SELECT * FROM `spare_part_used_in_service` a WHERE a.service_id=?1",nativeQuery = true)
	List<TssdSparePartIncluded> findAllByServiceId(int serviceId);

}
