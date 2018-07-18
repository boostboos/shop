package com.legendary.entity;

import java.math.BigDecimal;

public class OrderItem {
 	private String picinfo;
	private String specdetail;
	private BigDecimal sellPrice;
	private Integer number;
	private String gname;
	public String getPicinfo() {
		return picinfo;
	}
	public void setPicinfo(String picinfo) {
		this.picinfo = picinfo;
	}
	public String getSpecdetail() {
		return specdetail;
	}
	public void setSpecdetail(String specdetail) {
		this.specdetail = specdetail;
	}
	public BigDecimal getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	
	@Override
	public String toString() {
		return "OrderItem [picinfo=" + picinfo + ", specdetail=" + specdetail + ", sellPrice=" + sellPrice + ", number="
				+ number + ", gname=" + gname + "]";
	}
	
}
