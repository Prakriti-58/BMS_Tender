package com.ngn.bms.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tenders")
public class Tenders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String reference_no;
	private int source_id;
	private int organization_type_id;
	private int organization_id;
	private int tender_type_id;
	private String publication_date;
	private String description;
	private String contact_person;
	private int contact_number;
	private String sale_date;
	private float cost;
	private String submission_date;
	private String added_on;
	@Column(name = "added_by")
	private int addedBy;
	private String forwarded_on;
	@Column(name = "forwarded_to")
	private int forwardedTo;
	private String acknowledge;
	private String acknowledge_date;
	private String status;
	private int tender_stage_id;
	@UpdateTimestamp
	private Timestamp updateOn;
	@Column(name = "tender_opening")
	private Date tenderOpening;
	private int updatedBy;
	private String bid_name; 
	private String clientTenderRefNo; 
    private int tender_amt; 
    private int final_amt; 
	
	@OneToOne()
	@JoinColumn(name = "tender_stage_id", referencedColumnName = "id",insertable = false,updatable = false)
	private TenderStage tenderStage;
	
	@OneToOne()
	@JoinColumn(name = "organization_id", referencedColumnName = "id",insertable = false,updatable = false)
	private Organization organization;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReference_no() {
		return reference_no;
	}

	public void setReference_no(String reference_no) {
		this.reference_no = reference_no;
	}

	public int getSource_id() {
		return source_id;
	}

	public void setSource_id(int source_id) {
		this.source_id = source_id;
	}

	public int getOrganization_type_id() {
		return organization_type_id;
	}

	public void setOrganization_type_id(int organization_type_id) {
		this.organization_type_id = organization_type_id;
	}

	public int getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(int organization_id) {
		this.organization_id = organization_id;
	}

	public int getTender_type_id() {
		return tender_type_id;
	}

	public void setTender_type_id(int tender_type_id) {
		this.tender_type_id = tender_type_id;
	}

	public String getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContact_person() {
		return contact_person;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	public int getContact_number() {
		return contact_number;
	}

	public void setContact_number(int contact_number) {
		this.contact_number = contact_number;
	}

	public String getSale_date() {
		return sale_date;
	}

	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}

	public String getAdded_on() {
		return added_on;
	}

	public void setAdded_on(String added_on) {
		this.added_on = added_on;
	}

	public int getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(int addedBy) {
		this.addedBy = addedBy;
	}

	public String getForwarded_on() {
		return forwarded_on;
	}

	public void setForwarded_on(String forwarded_on) {
		this.forwarded_on = forwarded_on;
	}

	public int getForwardedTo() {
		return forwardedTo;
	}

	public void setForwardedTo(int forwardedTo) {
		this.forwardedTo = forwardedTo;
	}

	public String getAcknowledge() {
		return acknowledge;
	}

	public void setAcknowledge(String acknowledge) {
		this.acknowledge = acknowledge;
	}

	public String getAcknowledge_date() {
		return acknowledge_date;
	}

	public void setAcknowledge_date(String acknowledge_date) {
		this.acknowledge_date = acknowledge_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTender_stage_id() {
		return tender_stage_id;
	}

	public void setTender_stage_id(int tender_stage_id) {
		this.tender_stage_id = tender_stage_id;
	}

	public Timestamp getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Timestamp updateOn) {
		this.updateOn = updateOn;
	}

	public Date getTenderOpening() {
		return tenderOpening;
	}

	public void setTenderOpening(Date tenderOpening) {
		this.tenderOpening = tenderOpening;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getBid_name() {
		return bid_name;
	}

	public void setBid_name(String bid_name) {
		this.bid_name = bid_name;
	}

	public String getClientTenderRefNo() {
		return clientTenderRefNo;
	}

	public void setClientTenderRefNo(String clientTenderRefNo) {
		this.clientTenderRefNo = clientTenderRefNo;
	}

	public int getTender_amt() {
		return tender_amt;
	}

	public void setTender_amt(int tender_amt) {
		this.tender_amt = tender_amt;
	}

	public int getFinal_amt() {
		return final_amt;
	}

	public void setFinal_amt(int final_amt) {
		this.final_amt = final_amt;
	}

	public TenderStage getTenderStage() {
		return tenderStage;
	}

	public void setTenderStage(TenderStage tenderStage) {
		this.tenderStage = tenderStage;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	
	 
}
