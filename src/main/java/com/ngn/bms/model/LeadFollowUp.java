package com.ngn.bms.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lead_follow_up")
public class LeadFollowUp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "lead_id")
	private int leadId;
	private String remarks;
	@Column(name = "updated_on")
	private Date updatedOn;
	@Column(name = "updated_by")
	private int updatedBy;
	
	@OneToOne()
	@JoinColumn(name = "updated_by", referencedColumnName = "id",insertable = false,updatable = false)
	private UserList userDetails;
	
	public LeadFollowUp() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
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
