package com.ngn.bms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lead_converted_tender")
public class LeadToTender {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "lead_ref")
	private String leadRef;
	@Column(name = "tender_ref")
	private String tenderRef;
	@Column(name = "updated_on")
	private String updatedOn;
	@Column(name = "updated_by")
	private int updatedBy;
	
	public LeadToTender() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLeadRef() {
		return leadRef;
	}

	public void setLeadRef(String leadRef) {
		this.leadRef = leadRef;
	}

	public String getTenderRef() {
		return tenderRef;
	}

	public void setTenderRef(String tenderRef) {
		this.tenderRef = tenderRef;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	
	
}
