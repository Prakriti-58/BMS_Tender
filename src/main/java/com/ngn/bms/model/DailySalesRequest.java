package com.ngn.bms.model;

public class DailySalesRequest {

	private int createdBy;
	private String filePath;
	private double cashAmount;
	private int cashMemoType;
	
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
}
