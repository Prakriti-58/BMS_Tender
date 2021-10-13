package com.ngn.bms.model;

public class DailySalesRequest {

	private int createdBy;
	private String filePath;
	private double cashAmount;
	private int cashMemoType;
	private String status;
	private String weeklyStatus;
	
	public int getCashMemoType() {
		return cashMemoType;
	}
	public void setCashMemoType(int cashMemoType) {
		this.cashMemoType = cashMemoType;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public double getCashAmount() {
		return cashAmount;
	}
	public void setCashAmount(double cashAmount) {
		this.cashAmount = cashAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWeeklyStatus() {
		return weeklyStatus;
	}
	public void setWeeklyStatus(String weeklyStatus) {
		this.weeklyStatus = weeklyStatus;
	}
	
}
