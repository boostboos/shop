package com.legendary.entity;

import java.math.BigDecimal;

public class CommentHelper {
	private String oid;
	private String picinfo;
	private BigDecimal sellPrice;
	private String specdetail;
	private String gname;
	private Integer gid;
	
	
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getOid() {
		return oid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getPicinfo() {
		return picinfo;
	}
	public void setPicinfo(String picinfo) {
		this.picinfo = picinfo;
	}
	public BigDecimal getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}
	public String getSpecdetail() {
		return specdetail;
	}
	public void setSpecdetail(String specdetail) {
		this.specdetail = specdetail;
	}
	@Override
	public String toString() {
		return "CommentHelper [oid=" + oid + ", picinfo=" + picinfo + ", sellPrice=" + sellPrice + ", specdetail="
				+ specdetail + ", gname=" + gname + ", gid=" + gid + "]";
	}
	
	
	
	
	
}
