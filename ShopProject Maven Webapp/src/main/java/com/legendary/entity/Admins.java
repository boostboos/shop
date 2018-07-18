
package com.legendary.entity;

import java.io.Serializable;

public class Admins implements Serializable {
	//管理员id
	private Integer aid;
	//用户名
	private String username;
	//密码
	private String passwd;
	//真实姓名
	private String realname;
	//性别
	private String gender;
	//电话号码
	private String phone;
	//电子邮件
	private String email;
	//解释
	public String remark;
	//最后一次登录日期
	public java.util.Date lastDate;
	//账号创建日期
	public java.util.Date createDate;
	//角色id
	public Integer rid;
	
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public java.util.Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(java.util.Date lastDate) {
		this.lastDate = lastDate;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "Admins [aid=" + aid + ", username=" + username + ", passwd=" + passwd + ", realname=" + realname
				+ ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", remark=" + remark + ", lastDate="
				+ lastDate + ", createDate=" + createDate + ", rid=" + rid + "]";
	}

   
   
   

}