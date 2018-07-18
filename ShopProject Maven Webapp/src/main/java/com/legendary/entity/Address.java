package com.legendary.entity;

public class Address {
	//主键id
	private Integer aid;
	//地址详情
	private String addressinfo;
	//会员id
	private Integer meid;
	//收货人姓名
	private String receivername;
	//收货人联系电话
	private String receiverphone;
	//是否为默认地址，默认为1，非默认为0
	private Integer defaddress;
	
	
	
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAddressinfo() {
		return addressinfo;
	}
	public void setAddressinfo(String addressinfo) {
		this.addressinfo = addressinfo;
	}
	public Integer getMeid() {
		return meid;
	}
	public void setMeid(Integer meid) {
		this.meid = meid;
	}
	public String getReceivername() {
		return receivername;
	}
	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}
	public String getReceiverphone() {
		return receiverphone;
	}
	public void setReceiverphone(String receiverphone) {
		this.receiverphone = receiverphone;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", addressinfo=" + addressinfo + ", meid=" + meid + ", receivername="
				+ receivername + ", receiverphone=" + receiverphone + ", defaddress=" + defaddress + "]";
	}
	public Integer getDefaddress() {
		return defaddress;
	}
	public void setDefaddress(Integer defaddress) {
		this.defaddress = defaddress;
	}
}