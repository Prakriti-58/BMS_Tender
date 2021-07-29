package com.ngn.bms.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transportation_histroy")
public class TransportationHistroy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "product_model_id")
	private int productModelId;
	@Column(name = "tender_id")
	private int tenderId; 
	private int quantity;
	private int amount;
	private Date updated_on;
	private String remarks;
	@Column(name = "updated_by")
	private int updatedBy;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductModelId() {
		return productModelId;
	}
	public void setProductModelId(int productModelId) {
		this.productModelId = productModelId;
	}
	public int getTenderId() {
		return tenderId;
	}
	public void setTenderId(int tenderId) {
		this.tenderId = tenderId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getUpdated_on() {
		return updated_on;
	}
	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	} 
}
