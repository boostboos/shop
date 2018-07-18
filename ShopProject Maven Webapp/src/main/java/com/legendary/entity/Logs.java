package com.legendary.entity;

import java.util.Date;

public class Logs {
	private Integer id;
	private Integer operateType;
	private String content;
	private Date operateDate;
	private Integer uid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getOperateType() {
		return operateType;
	}
	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
}
