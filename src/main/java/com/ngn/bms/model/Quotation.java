package com.ngn.bms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quotation")
public class Quotation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "tender_id")
	private int tenderId;
	@Column(name = "line_item_no")
	private String lineItemNo;
	@Column(name = "description_of_item")
	private String descriptionOfItem;
	@Column(name = "unit_of_measurement")
	private String unitOfMeasurement;
	@Column(name = "quantity")
	private String quantity;
	@Column(name = "point_of_delivery")
	private String pointOfDelivery;
	@Column(name = "period_of_delivery")
	private String periodOfDelivery;
	@Column(name = "tender_group")
	private String tenderGroup;
	@Column(name = "country_of_origin")
	private String countryOfOrigin;
	@Column(name = "cip_or_cif_price_per_unit")
	private String cipOrCifPricePerUnit;
	@Column(name = "currency_for_cif_or_cip")
	private String currencyForCifOrCip;
	@Column(name = "conversion_rate")
	private String conversionRate;
	@Column(name = "cip_or_cif_place_of_destination")
	private String cipOrCifPlaceOfDestination;
	@Column(name = "unit_price_including_custom_duties")
	private String unitPriceIncludingCustomDuties;
	@Column(name = "custom_duties")
	private String customDuties;
	@Column(name = "cip_or_cif_price_per_line_item")
	private String cipOrCifPricePerLineItem;
	@Column(name = "price_per_line_item_net_of_custom_duties")
	private String pricePerLineItemNetOfCustomDuties;
	@Column(name = "inland_transportation")
	private String inlandTransportation;
	@Column(name = "vat_payable_on_account_of_supplier_if_the_contract_is_awarded")
	private String vatPayableOnAccountOfSupplierIfTheContractIsAwarded;
	@Column(name = "amount_per_line_item")
	private String amountPerLineItem;
	
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
	public String getLineItemNo() {
		return lineItemNo;
	}
	public void setLineItemNo(String lineItemNo) {
		this.lineItemNo = lineItemNo;
	}
	public String getDescriptionOfItem() {
		return descriptionOfItem;
	}
	public void setDescriptionOfItem(String descriptionOfItem) {
		this.descriptionOfItem = descriptionOfItem;
	}
	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}
	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPointOfDelivery() {
		return pointOfDelivery;
	}
	public void setPointOfDelivery(String pointOfDelivery) {
		this.pointOfDelivery = pointOfDelivery;
	}
	public String getPeriodOfDelivery() {
		return periodOfDelivery;
	}
	public void setPeriodOfDelivery(String periodOfDelivery) {
		this.periodOfDelivery = periodOfDelivery;
	}
	public String getTenderGroup() {
		return tenderGroup;
	}
	public void setTenderGroup(String tenderGroup) {
		this.tenderGroup = tenderGroup;
	}
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	public String getCipOrCifPricePerUnit() {
		return cipOrCifPricePerUnit;
	}
	public void setCipOrCifPricePerUnit(String cipOrCifPricePerUnit) {
		this.cipOrCifPricePerUnit = cipOrCifPricePerUnit;
	}
	public String getCurrencyForCifOrCip() {
		return currencyForCifOrCip;
	}
	public void setCurrencyForCifOrCip(String currencyForCifOrCip) {
		this.currencyForCifOrCip = currencyForCifOrCip;
	}
	public String getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(String conversionRate) {
		this.conversionRate = conversionRate;
	}
	public String getCipOrCifPlaceOfDestination() {
		return cipOrCifPlaceOfDestination;
	}
	public void setCipOrCifPlaceOfDestination(String cipOrCifPlaceOfDestination) {
		this.cipOrCifPlaceOfDestination = cipOrCifPlaceOfDestination;
	}
	public String getUnitPriceIncludingCustomDuties() {
		return unitPriceIncludingCustomDuties;
	}
	public void setUnitPriceIncludingCustomDuties(String unitPriceIncludingCustomDuties) {
		this.unitPriceIncludingCustomDuties = unitPriceIncludingCustomDuties;
	}
	public String getCustomDuties() {
		return customDuties;
	}
	public void setCustomDuties(String customDuties) {
		this.customDuties = customDuties;
	}
	public String getCipOrCifPricePerLineItem() {
		return cipOrCifPricePerLineItem;
	}
	public void setCipOrCifPricePerLineItem(String cipOrCifPricePerLineItem) {
		this.cipOrCifPricePerLineItem = cipOrCifPricePerLineItem;
	}
	public String getPricePerLineItemNetOfCustomDuties() {
		return pricePerLineItemNetOfCustomDuties;
	}
	public void setPricePerLineItemNetOfCustomDuties(String pricePerLineItemNetOfCustomDuties) {
		this.pricePerLineItemNetOfCustomDuties = pricePerLineItemNetOfCustomDuties;
	}
	public String getInlandTransportation() {
		return inlandTransportation;
	}
	public void setInlandTransportation(String inlandTransportation) {
		this.inlandTransportation = inlandTransportation;
	}
	public String getVatPayableOnAccountOfSupplierIfTheContractIsAwarded() {
		return vatPayableOnAccountOfSupplierIfTheContractIsAwarded;
	}
	public void setVatPayableOnAccountOfSupplierIfTheContractIsAwarded(
			String vatPayableOnAccountOfSupplierIfTheContractIsAwarded) {
		this.vatPayableOnAccountOfSupplierIfTheContractIsAwarded = vatPayableOnAccountOfSupplierIfTheContractIsAwarded;
	}
	public String getAmountPerLineItem() {
		return amountPerLineItem;
	}
	public void setAmountPerLineItem(String amountPerLineItem) {
		this.amountPerLineItem = amountPerLineItem;
	}
	@Override
	public String toString() {
		return "Quotation [id=" + id + ", tenderId=" + tenderId + ", lineItemNo=" + lineItemNo + ", descriptionOfItem="
				+ descriptionOfItem + ", unitOfMeasurement=" + unitOfMeasurement + ", quantity=" + quantity
				+ ", pointOfDelivery=" + pointOfDelivery + ", periodOfDelivery=" + periodOfDelivery + ", tenderGroup="
				+ tenderGroup + ", countryOfOrigin=" + countryOfOrigin + ", cipOrCifPricePerUnit="
				+ cipOrCifPricePerUnit + ", currencyForCifOrCip=" + currencyForCifOrCip + ", conversionRate="
				+ conversionRate + ", cipOrCifPlaceOfDestination=" + cipOrCifPlaceOfDestination
				+ ", unitPriceIncludingCustomDuties=" + unitPriceIncludingCustomDuties + ", customDuties="
				+ customDuties + ", cipOrCifPricePerLineItem=" + cipOrCifPricePerLineItem
				+ ", pricePerLineItemNetOfCustomDuties=" + pricePerLineItemNetOfCustomDuties + ", inlandTransportation="
				+ inlandTransportation + ", vatPayableOnAccountOfSupplierIfTheContractIsAwarded="
				+ vatPayableOnAccountOfSupplierIfTheContractIsAwarded + ", amountPerLineItem=" + amountPerLineItem
				+ "]";
	}
	
	
	
}
