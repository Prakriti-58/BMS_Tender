package com.ngn.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.CountryList;

@Repository
public interface CountryListRepo extends JpaRepository<CountryList, Integer>{

	@Query(value = "SELECT * FROM country_list ORDER BY country_name ASC",nativeQuery = true)
	List<CountryList> findCountryList();


}
