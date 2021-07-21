package com.ngn.bms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "lead")
public class LeadSaveModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "lead_type_id")
	private int leadTypeId;
	@Column(name = "leadReference")
	private String lead_reference;
	@Column(name = "productCategoryId")
	private int product_category_id;
	@Column(name = "leadName")
	private String lead_name;
	@Column(name = "lead_amount")
	private float lead_amount;
	@Column(name = "organization_type_id")
	private int organization_type_id;
	@Column(name = "organization_id")
	private int organization_id;
	@Column(name = "contact_person")
	private String contactPerson;
	@Column(name = "contact_number")
	private String contactNumber;
	@Column(name = "address")
	private String address;
	@Column(name = "email_address")
	private String emailAddress;
	@Column(name = "lead_description")
	private String leadDescription;
	@Column(name = "addedOn")
	private Date added_on;
	@Column(name = "added_by")
	private int addedBy;
	@Column(name = "forwarded_on")
	private Date forwardedOn;
	@Column(name = "forwarded_to")
	private int forwardedTo;
	@Column(name = "acknowledge")
	private String acknowledge;
	@Column(name = "acknowledge_on")
	private Date acknowledgeOn;
	@Column(name = "updated_on")
	private Date updatedOn;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "lead_status")
	private String leadStatus;
	private String active;
	public LeadSaveModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLeadTypeId() {
		return leadTypeId;
	}
	public void setLeadTypeId(int leadTypeId) {
		this.leadTypeId = leadTypeId;
	}
	public String getLead_reference() {
		return lead_reference;
	}
	public void setLead_reference(String lead_reference) {
		this.lead_reference = lead_reference;
	}
	public int getProduct_category_id() {
		return product_category_id;
	}
	public void setProduct_category_id(int product_category_id) {
		this.product_category_id = product_category_id;
	}
	public String getLead_name() {
		return lead_name;
	}
	public void setLead_name(String lead_name) {
		this.lead_name = lead_name;
	}
	public float getLead_amount() {
		return lead_amount;
	}
	public void setLead_amount(float lead_amount) {
		this.lead_amount = lead_amount;
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
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getLeadDescription() {
		return leadDescription;
	}
	public void setLeadDescription(String leadDescription) {
		this.leadDescription = leadDescription;
	}
	public Date getAdded_on() {
		return added_on;
	}
	public void setAdded_on(Date added_on) {
		this.added_on = added_on;
	}
	public int getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(int addedBy) {
		this.addedBy = addedBy;
	}
	public Date getForwardedOn() {
		return forwardedOn;
	}
	public void setForwardedOn(Date forwardedOn) {
		this.forwardedOn = forwardedOn;
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
	public Date getAcknowledgeOn() {
		return acknowledgeOn;
	}
	public void setAcknowledgeOn(Date acknowledgeOn) {
		this.acknowledgeOn = acknowledgeOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getLeadStatus() {
		return leadStatus;
	}
	public void setLeadStatus(String leadStatus) {
		this.leadStatus = leadStatus;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}

//	@OneToMany(targetEntity = LeadFollowUp.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "lead_id",referencedColumnName = "id",insertable=false,updatable=false)
//	private List<LeadFollowUp> leadFollowUp;


	
}
