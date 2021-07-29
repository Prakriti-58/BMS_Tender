package com.ngn.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.TransportationHistroy;

@Repository
public interface TransportationRepo extends JpaRepository<TransportationHistroy, Integer>{

	@Query(value = "SELECT * FROM transportation_histroy a WHERE a.tender_id=?1 AND a.`product_model_id`=?2",nativeQuery = true)
	List<TransportationHistroy> findByProductModelId(Integer tenderId,Integer productModelId);

}
