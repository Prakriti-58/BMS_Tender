package com.ngn.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.TssdSparePart;

@Repository
public interface TssdSparePartRepo extends JpaRepository<TssdSparePart, Integer>{

	@Query(value = "SELECT * FROM spare_part a WHERE a.spare_part_category_id=?1",nativeQuery = true)
	List<TssdSparePart> findBySparePartCategoryId(int categoryId);

	

}
