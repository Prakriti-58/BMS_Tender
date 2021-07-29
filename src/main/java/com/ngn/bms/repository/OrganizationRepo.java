package com.ngn.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngn.bms.model.Organization;


@Repository
public interface OrganizationRepo extends JpaRepository<Organization, Integer>{

	List<Organization> findByOrganizationTypeId(Integer orgTypeId);


}
