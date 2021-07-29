package com.ngn.bms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tender_lost")
public class TenderLost {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int tenders_id;
	private int competitors_id;
	private int lost_by_amount;
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
	public int getCompetitors_id() {
		return competitors_id;
	}
	public void setCompetitors_id(int competitors_id) {
		this.competitors_id = competitors_id;
	}
	public int getLost_by_amount() {
		return lost_by_amount;
	}
	public void setLost_by_amount(int lost_by_amount) {
		this.lost_by_amount = lost_by_amount;
	} 

}
