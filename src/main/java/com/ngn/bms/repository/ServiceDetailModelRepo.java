package com.ngn.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.ServiceDetailModel;

@Repository
public interface ServiceDetailModelRepo extends JpaRepository<ServiceDetailModel, Integer>{

	List<ServiceDetailModel> findByServiceIdOrderByIdDesc(int serviceId);

}
