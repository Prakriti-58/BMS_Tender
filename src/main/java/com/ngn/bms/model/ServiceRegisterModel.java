package com.ngn.bms.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_service")
public class ServiceRegisterModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String work_order_no;
	private String job_id;
	private Date jobAddedOn;
	private String oem;
	private String product;
	private String model;
	private String specification;	
	private String serialNo;
	private String warranty;
	private String customerName;
	private String customerAddress;
	private String customerEmail;
	private int customerContactNo;
	private String problemStated;
	private int assignedTo;
	private Date assignedDate;
	private String acknownledge;
	private Date acknownledgeDate;
	private Date jobEndDate ;
	private Date updatedOn;
	private int updatedBy;
	private String jobStatus;
	private String status;
	private String forwarded;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWork_order_no() {
		return work_order_no;
	}
	public void setWork_order_no(String work_order_no) {
		this.work_order_no = work_order_no;
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public Date getJobAddedOn() {
		return jobAddedOn;
	}
	public void setJobAddedOn(Date jobAddedOn) {
		this.jobAddedOn = jobAddedOn;
	}
	public String getOem() {
		return oem;
	}
	public void setOem(String oem) {
		this.oem = oem;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public int getCustomerContactNo() {
		return customerContactNo;
	}
	public void setCustomerContactNo(int customerContactNo) {
		this.customerContactNo = customerContactNo;
	}
	public String getProblemStated() {
		return problemStated;
	}
	public void setProblemStated(String problemStated) {
		this.problemStated = problemStated;
	}
	public int getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}
	public Date getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}
	public String getAcknownledge() {
		return acknownledge;
	}
	public void setAcknownledge(String acknownledge) {
		this.acknownledge = acknownledge;
	}
	public Date getAcknownledgeDate() {
		return acknownledgeDate;
	}
	public void setAcknownledgeDate(Date acknownledgeDate) {
		this.acknownledgeDate = acknownledgeDate;
	}
	public Date getJobEndDate() {
		return jobEndDate;
	}
	public void setJobEndDate(Date jobEndDate) {
		this.jobEndDate = jobEndDate;
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
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getForwarded() {
		return forwarded;
	}
	public void setForwarded(String forwarded) {
		this.forwarded = forwarded;
	}
	
	
	
}
