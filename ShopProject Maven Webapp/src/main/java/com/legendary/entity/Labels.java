package com.legendary.entity;

public class Labels {
	//标签id
	private Integer lid;
	//排序id
	private Integer sortId;
	//标签名称
	private java.lang.String labelname;
	//标签备注
	private java.lang.String remark;
	//类别id
	private Integer cid;
	
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public Integer getSortId() {
		return sortId;
	}
	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}
	public java.lang.String getLabelname() {
		return labelname;
	}
	public void setLabelname(java.lang.String labelname) {
		this.labelname = labelname;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
}