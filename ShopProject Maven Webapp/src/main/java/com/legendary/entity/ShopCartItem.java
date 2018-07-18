package com.legendary.entity;

import java.math.BigDecimal;

public class ShopCartItem {
	//是否上架
	private Integer shelves;
	//货物名称
	private String gname;
	//规格详情
	private String specdetail;
	//售价
	private BigDecimal sellprice;
	//市场价
	private BigDecimal marketprice;
	//图片id
	private String picinfo;
	//用户id
	private Integer meid;
	//购买数量
	private Integer number;
	//商品详情id
	private Integer gdid;
	
	

	@Override
	public String toString() {
		return "ShopCartItem [shelves=" + shelves + ", gname=" + gname + ", specdetail=" + specdetail + ", sellprice="
				+ sellprice + ", marketprice=" + marketprice + ", picinfo=" + picinfo + ", meid=" + meid + ", number="
				+ number + ", gdid=" + gdid + "]";
	}
	public Integer getGdid() {
		return gdid;
	}
	public void setGdid(Integer gdid) {
		this.gdid = gdid;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getMeid() {
		return meid;
	}
	public void setMeid(Integer meid) {
		this.meid = meid;
	}
	public Integer getShelves() {
		return shelves;
	}
	public void setShelves(Integer shelves) {
		this.shelves = shelves;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getSpecdetail() {
		return specdetail;
	}
	public void setSpecdetail(String specdetail) {
		this.specdetail = specdetail;
	}
	public BigDecimal getSellprice() {
		return sellprice;
	}
	public void setSellprice(BigDecimal sellprice) {
		this.sellprice = sellprice;
	}
	public BigDecimal getMarketprice() {
		return marketprice;
	}
	public void setMarketprice(BigDecimal marketprice) {
		this.marketprice = marketprice;
	}
	public String getPicinfo() {
		return picinfo;
	}
	public void setPicinfo(String picinfo) {
		this.picinfo = picinfo;
	}
}
