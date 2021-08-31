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
@Table(name = "tender_work_sheet")
public class TenderWorkSheet {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "tender_id")
  private int tenderId;
  private int country_of_origin;
  private float exchange_rate;
  private int particularts;
  private String specification;
  private float cp_foriegn;
  private float cp_btn;
  private float sale_tax_percent;
  private float sale_tax_amt;
  private float custome_tax_percent;
  private float custome_tax_amt;
  private float total_tax;
  private float transportation;
  private float installation;
  private float support;
  private float cif;
  private float wci_percent;
  private float wci;
  private float wci_with_cif;
  private float margin;
  private float sp;
  private float qty;
  private float asse_val_cd;
  private String unit;
  private float kol_jaigoan;
  private float trans_invoice;
  private float trans_mdp_charges;
  private float trans_loading;
  private float trans_pling_sorchen;
  private float trans_sorchen_tphu;
  private float total_amount;
  private String remarks;
  private Date updated_on;
  @Column(name = "updated_by")
  private int updatedBy;
  private int lost_by_amt;
  private int competitor_id;
  private int gain_qty;
  private String won_lost;
  private float gain_amt;
  
  @OneToOne()
  @JoinColumn(name = "tender_id", referencedColumnName = "id",insertable = false,updatable = false)
  private Tenders tender;
  
  @OneToOne()
  @JoinColumn(name = "particularts", referencedColumnName = "id",insertable = false,updatable = false)
  private ProductModel product;
  
  
  @OneToOne()
  @JoinColumn(name = "country_of_origin", referencedColumnName = "id",insertable = false,updatable = false)
  private CountryList countryName;


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


public int getCountry_of_origin() {
	return country_of_origin;
}


public void setCountry_of_origin(int country_of_origin) {
	this.country_of_origin = country_of_origin;
}


public float getExchange_rate() {
	return exchange_rate;
}


public void setExchange_rate(float exchange_rate) {
	this.exchange_rate = exchange_rate;
}


public int getParticularts() {
	return particularts;
}


public void setParticularts(int particularts) {
	this.particularts = particularts;
}


public String getSpecification() {
	return specification;
}


public void setSpecification(String specification) {
	this.specification = specification;
}


public float getCp_foriegn() {
	return cp_foriegn;
}


public void setCp_foriegn(float cp_foriegn) {
	this.cp_foriegn = cp_foriegn;
}


public float getCp_btn() {
	return cp_btn;
}


public void setCp_btn(float cp_btn) {
	this.cp_btn = cp_btn;
}


public float getSale_tax_percent() {
	return sale_tax_percent;
}


public void setSale_tax_percent(float sale_tax_percent) {
	this.sale_tax_percent = sale_tax_percent;
}


public float getSale_tax_amt() {
	return sale_tax_amt;
}


public void setSale_tax_amt(float sale_tax_amt) {
	this.sale_tax_amt = sale_tax_amt;
}


public float getCustome_tax_percent() {
	return custome_tax_percent;
}


public void setCustome_tax_percent(float custome_tax_percent) {
	this.custome_tax_percent = custome_tax_percent;
}


public float getCustome_tax_amt() {
	return custome_tax_amt;
}


public void setCustome_tax_amt(float custome_tax_amt) {
	this.custome_tax_amt = custome_tax_amt;
}


public float getTotal_tax() {
	return total_tax;
}


public void setTotal_tax(float total_tax) {
	this.total_tax = total_tax;
}


public float getTransportation() {
	return transportation;
}


public void setTransportation(float transportation) {
	this.transportation = transportation;
}


public float getInstallation() {
	return installation;
}


public void setInstallation(float installation) {
	this.installation = installation;
}


public float getSupport() {
	return support;
}


public void setSupport(float support) {
	this.support = support;
}


public float getCif() {
	return cif;
}


public void setCif(float cif) {
	this.cif = cif;
}


public float getWci_percent() {
	return wci_percent;
}


public void setWci_percent(float wci_percent) {
	this.wci_percent = wci_percent;
}


public float getWci() {
	return wci;
}


public void setWci(float wci) {
	this.wci = wci;
}


public float getWci_with_cif() {
	return wci_with_cif;
}


public void setWci_with_cif(float wci_with_cif) {
	this.wci_with_cif = wci_with_cif;
}


public float getMargin() {
	return margin;
}


public void setMargin(float margin) {
	this.margin = margin;
}


public float getSp() {
	return sp;
}


public void setSp(float sp) {
	this.sp = sp;
}


public float getQty() {
	return qty;
}


public void setQty(float qty) {
	this.qty = qty;
}


public float getAsse_val_cd() {
	return asse_val_cd;
}


public void setAsse_val_cd(float asse_val_cd) {
	this.asse_val_cd = asse_val_cd;
}


public String getUnit() {
	return unit;
}


public void setUnit(String unit) {
	this.unit = unit;
}


public float getKol_jaigoan() {
	return kol_jaigoan;
}


public void setKol_jaigoan(float kol_jaigoan) {
	this.kol_jaigoan = kol_jaigoan;
}


public float getTrans_invoice() {
	return trans_invoice;
}


public void setTrans_invoice(float trans_invoice) {
	this.trans_invoice = trans_invoice;
}


public float getTrans_mdp_charges() {
	return trans_mdp_charges;
}


public void setTrans_mdp_charges(float trans_mdp_charges) {
	this.trans_mdp_charges = trans_mdp_charges;
}


public float getTrans_loading() {
	return trans_loading;
}


public void setTrans_loading(float trans_loading) {
	this.trans_loading = trans_loading;
}


public float getTrans_pling_sorchen() {
	return trans_pling_sorchen;
}


public void setTrans_pling_sorchen(float trans_pling_sorchen) {
	this.trans_pling_sorchen = trans_pling_sorchen;
}


public float getTrans_sorchen_tphu() {
	return trans_sorchen_tphu;
}


public void setTrans_sorchen_tphu(float trans_sorchen_tphu) {
	this.trans_sorchen_tphu = trans_sorchen_tphu;
}


public float getTotal_amount() {
	return total_amount;
}


public void setTotal_amount(float total_amount) {
	this.total_amount = total_amount;
}


public String getRemarks() {
	return remarks;
}


public void setRemarks(String remarks) {
	this.remarks = remarks;
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


public int getLost_by_amt() {
	return lost_by_amt;
}


public void setLost_by_amt(int lost_by_amt) {
	this.lost_by_amt = lost_by_amt;
}


public int getCompetitor_id() {
	return competitor_id;
}


public void setCompetitor_id(int competitor_id) {
	this.competitor_id = competitor_id;
}


public int getGain_qty() {
	return gain_qty;
}


public void setGain_qty(int gain_qty) {
	this.gain_qty = gain_qty;
}


public String getWon_lost() {
	return won_lost;
}


public void setWon_lost(String won_lost) {
	this.won_lost = won_lost;
}


public float getGain_amt() {
	return gain_amt;
}


public void setGain_amt(float gain_amt) {
	this.gain_amt = gain_amt;
}


public Tenders getTender() {
	return tender;
}


public void setTender(Tenders tender) {
	this.tender = tender;
}


public ProductModel getProduct() {
	return product;
}


public void setProduct(ProductModel product) {
	this.product = product;
}


public CountryList getCountryName() {
	return countryName;
}


public void setCountryName(CountryList countryName) {
	this.countryName = countryName;
} 
  
}