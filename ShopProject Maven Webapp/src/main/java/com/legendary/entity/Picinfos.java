package com.legendary.entity;

public class Picinfos {
	//图片id
    private String pid;
    //图片路径
    private String picinfo;
    //商品id
    private Integer gid;
	

	@Override
	public String toString() {
		return "Picinfos [pid=" + pid + ", picinfo=" + picinfo + ", gid=" + gid + "]";
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPicinfo() {
		return picinfo;
	}
	public void setPicinfo(String picinfo) {
		this.picinfo = picinfo;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
}