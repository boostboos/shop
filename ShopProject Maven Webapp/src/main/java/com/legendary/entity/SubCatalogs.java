package com.legendary.entity;

public class SubCatalogs {
	Integer scid;
	String scname;	
	String subcata;
	Integer cid;
	public String getScname() {
		return scname;
	}
	public void setScname(String scname) {
		this.scname = scname;
	}
	public String getSubcata() {
		return subcata;
	}
	public void setSubcata(String subcata) {
		this.subcata = subcata;
	}
	public Integer getScid() {
		return scid;
	}
	public void setScid(Integer scid) {
		this.scid = scid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "SubCatalogs [scid=" + scid + ", scname=" + scname + ", subcata=" + subcata + ", cid=" + cid + "]";
	}
	
	
}
