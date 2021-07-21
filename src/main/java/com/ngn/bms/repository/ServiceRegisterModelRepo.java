package com.ngn.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.ServiceRegisterModel;

@Repository
public interface ServiceRegisterModelRepo extends JpaRepository<ServiceRegisterModel, Integer>{

	@Query(value = "SELECT * FROM t_service a WHERE a.status='Y' AND a.acknownledge='N' AND a.assigned_to=?1 ORDER BY a.id DESC",nativeQuery = true)
	List<ServiceRegisterModel> findAllByAssignedToOrderByIdDesc(int userId);

	@Query(value = "SELECT * FROM t_service a WHERE a.status='Y' AND a.acknownledge='Y' AND a.assigned_to=?1 ORDER BY a.id DESC",nativeQuery = true)
	List<ServiceRegisterModel> findAllByinProgressServices(int userId);

	@Query(value = "SELECT * FROM t_service a WHERE a.status='Y' ORDER BY a.id DESC",nativeQuery = true)
	List<ServiceRegisterModel> findAllOrderByIdDesc();

	@Query(value = "SELECT * FROM t_service a WHERE a.status='C' ORDER BY a.id DESC",nativeQuery = true)
	List<ServiceRegisterModel> findAllCompletedServices();

	@Query(value = "SELECT * FROM t_service a WHERE a.status='S' ORDER BY a.id DESC",nativeQuery = true)
	List<ServiceRegisterModel> findAllSparePartNeeded();

	@Query(value = "SELECT * FROM t_service a WHERE a.status='A' ORDER BY a.id DESC",nativeQuery = true)
	List<ServiceRegisterModel> findAllApprovedSparePart();

}
