package com.legendary.entity;
public class Orders {
	//订单id
	private String oid;
	//订单创建日期
	private java.util.Date downDate;
	//订单完成日期
	private java.util.Date finishDate;
	//订单状态
	private Integer state;
	//订单备注
	private String remark;
	//下订单的会员id
	private Integer meid;
	
	
	
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", downDate=" + downDate + ", finishDate=" + finishDate + ", state=" + state
				+ ", remark=" + remark + ", meid=" + meid + "]";
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public java.util.Date getDownDate() {
		return downDate;
	}
	public void setDownDate(java.util.Date downDate) {
		this.downDate = downDate;
	}
	public java.util.Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(java.util.Date finishDate) {
		this.finishDate = finishDate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	public Integer getMeid() {
		return meid;
	}
	public void setMeid(Integer meid) {
		this.meid = meid;
	}
	   

}