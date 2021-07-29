package com.ngn.bms.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_service_detail")
public class ServiceDetailModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int serviceId;
	private String problemFound;
	private String remarks;
	private Date updatedOn;
	private int updatedBy;
	
	@OneToOne()
	@JoinColumn(name = "updatedBy", referencedColumnName = "id",insertable = false,updatable = false)
	private UserList userDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getProblemFound() {
		return problemFound;
	}

	public void setProblemFound(String problemFound) {
		this.problemFound = problemFound;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public UserList getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserList userDetails) {
		this.userDetails = userDetails;
	}
	
	
	
}
