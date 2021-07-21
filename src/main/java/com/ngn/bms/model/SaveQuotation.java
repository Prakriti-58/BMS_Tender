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
@Table(name = "t_quotation")
public class SaveQuotation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "tender_id")
	private int tenderId;
	private int amount;
	private String file_name;
	private String file_path;
	private Date updated_on;
	@Column(name = "updated_by")
	private int updatedBy;
	private String active;
	@Column(name = "win_rate")
	private String winRate;
	private String remark;
	
	@OneToOne()
	@JoinColumn(name = "tender_id", referencedColumnName = "id",insertable = false,updatable = false)
	private Tenders tender;
	
	public SaveQuotation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTenderId() {
		return tenderId;
	}

	public void setTenderId(int tenderId) {
		this.tenderId = tenderId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getWinRate() {
		return winRate;
	}

	public void setWinRate(String winRate) {
		this.winRate = winRate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Tenders getTender() {
		return tender;
	}

	public void setTender(Tenders tender) {
		this.tender = tender;
	}

	
}
