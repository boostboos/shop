package com.legendary.entity;

import java.io.Serializable;
import java.util.Date;

public class Members implements Serializable {
	// 会员id
	private Integer meid;
	// 会员名
	private String username;

	// 真实姓名
	private String realname;
	// 密码
	private String passwd;
	// email
	private String email;
	// 性别
	private String gender;
	// 生日
	private java.util.Date birthday;
	// 电话号码
	private String phone;
	// 账号创建日期
	private java.util.Date createDate;
	// 最后登录日期
	private java.util.Date lastDate;
	// 头像路径
	private String photoPath;
	// 会员积分
	private Integer score;

	public Integer getMeid() {
		return meid;
	}

	public void setMeid(Integer meid) {
		this.meid = meid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Members [meid=" + meid + ", username=" + username + ", realname=" + realname + ", passwd=" + passwd
				+ ", email=" + email + ", gender=" + gender + ", birthday=" + birthday + ", phone=" + phone
				+ ", createDate=" + createDate + ", lastDate=" + lastDate + ", photoPath=" + photoPath + ", score="
				+ score + "]";
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public java.util.Date getBirthday() {
		return birthday;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public java.util.Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(java.util.Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}