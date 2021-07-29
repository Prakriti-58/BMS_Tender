package com.ngn.bms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tssd_job_seq")
public class TssdJobSeq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String jobSeqInitial;
	private int sequence;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobSeqInitial() {
		return jobSeqInitial;
	}
	public void setJobSeqInitial(String jobSeqInitial) {
		this.jobSeqInitial = jobSeqInitial;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	
}
