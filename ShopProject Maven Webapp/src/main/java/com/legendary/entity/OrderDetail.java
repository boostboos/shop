
package com.legendary.entity;

public class OrderDetail {
	//货物数量
	private Integer number;
	//货物id
	private Integer gid;
	//用户Id
	private String oid;
	
	
	@Override
	public String toString() {
		return "OrderDetail [number=" + number + ", gid=" + gid + ", oid=" + oid + "]";
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
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}

}