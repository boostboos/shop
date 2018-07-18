package com.legendary.entity;

public class Roles {
	//角色id
	private Integer rid;
	//角色名称
	private String roleName;
	//角色标签
	private String remark;
	//权限
	private Integer authority;
	
	public Integer getRid() {
		return rid;
	}
	@Override
	public String toString() {
		return "Roles [rid=" + rid + ", roleName=" + roleName + ", remark=" + remark + ", authority=" + authority + "]";
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getAuthority() {
		return authority;
	}
	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

}