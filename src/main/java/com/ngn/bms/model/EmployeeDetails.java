package com.ngn.bms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_details")
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "emp_first_name")
	private String empFirstName;
	@Column(name = "emp_second_name")
	private String empSecondName;
	@Column(name = "designation_id")
	private int designationId;
	@Column(name = "division_id")
	private int divisionId;
	@Column(name = "user_initial")
	private String userInitial;
	@Column(name = "user_active")
	private String userActive;
	private int contactNo;
	
	@OneToOne()
	@JoinColumn(name = "division_id", referencedColumnName = "id",insertable = false,updatable = false)
	private Division division;
	
	@OneToOne()
	@JoinColumn(name = "designation_id", referencedColumnName = "id",insertable = false,updatable = false)
	private Designation designation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpSecondName() {
		return empSecondName;
	}

	public void setEmpSecondName(String empSecondName) {
		this.empSecondName = empSecondName;
	}

	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public int getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public String getUserInitial() {
		return userInitial;
	}

	public void setUserInitial(String userInitial) {
		this.userInitial = userInitial;
	}

	public String getUserActive() {
		return userActive;
	}

	public void setUserActive(String userActive) {
		this.userActive = userActive;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	
	
}
