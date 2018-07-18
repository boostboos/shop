package com.legendary.entity;

import java.math.BigDecimal;

public class GoodsDetail {
	//货物详情id
	private Integer gdid;
	//规格详情
	private String specdetail;
	//进价
	private BigDecimal purchprice;
	//售价
	private BigDecimal sellprice;
	//市场价
	private BigDecimal marketprice;
	//库存
	private Integer number;
	//货物id
	private Integer gid;
	//图片id
	private String pid;
	
	@Override
	public String toString() {
		return "GoodsDetail [gdid=" + gdid + ", specdetail=" + specdetail + ", purchprice=" + purchprice
				+ ", sellprice=" + sellprice + ", marketprice=" + marketprice + ", number=" + number + ", gid=" + gid
				+ ", pid=" + pid + "]";
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Integer getGdid() {
		return gdid;
	}
	public void setGdid(Integer gdid) {
		this.gdid = gdid;
	}
	public String getSpecdetail() {
		return specdetail;
	}
	public void setSpecdetail(String specdetail) {
		this.specdetail = specdetail;
	}
	public BigDecimal getPurchprice() {
		return purchprice;
	}
	public void setPurchprice(BigDecimal purchprice) {
		this.purchprice = purchprice;
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
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
		
}
