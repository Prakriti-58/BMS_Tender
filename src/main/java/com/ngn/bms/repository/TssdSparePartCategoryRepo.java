package com.ngn.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.TssdSparePartCategory;

@Repository
public interface TssdSparePartCategoryRepo extends JpaRepository<TssdSparePartCategory, Integer>{

}
