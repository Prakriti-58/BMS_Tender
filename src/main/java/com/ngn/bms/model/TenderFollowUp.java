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
@Table(name = "tender_follow_up")
public class TenderFollowUp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int tenders_id;
	private String remarks;
	private int updated_by;
	private Date updated_on;
	
	@OneToOne()
	@JoinColumn(name = "updated_by", referencedColumnName = "id",insertable = false,updatable = false)
	private UserList userDetails;
	
	public TenderFollowUp() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTenders_id() {
		return tenders_id;
	}

	public void setTenders_id(int tenders_id) {
		this.tenders_id = tenders_id;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}

	public UserList getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserList userDetails) {
		this.userDetails = userDetails;
	}

	
	
}
