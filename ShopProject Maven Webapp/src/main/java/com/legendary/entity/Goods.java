
package com.legendary.entity;

import java.math.BigDecimal;

public class Goods {
	//货物id
	private Integer gid;
	//货物名称
	private String gname;
	//货物详情
	private String detail;
	//关键字
	private String keyword;
	//状态
	private Integer state;
	//是否上架
	private Integer shelves;
	//销量
	private Integer sales;
	
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", detail=" + detail + ", keyword=" + keyword + ", state="
				+ state + ", shelves=" + shelves + ", sales=" + sales + "]";
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getShelves() {
		return shelves;
	}
	public void setShelves(Integer shelves) {
		this.shelves = shelves;
	}

  	
   

}