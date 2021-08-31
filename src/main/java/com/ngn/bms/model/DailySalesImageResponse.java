package com.ngn.bms.model;

public class DailySalesImageResponse {
	
	private String cashMemoNo;
	private byte[] image;
	public String getCashMemoNo() {
		return cashMemoNo;
	}
	public void setCashMemoNo(String cashMemoNo) {
		this.cashMemoNo = cashMemoNo;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}

}
