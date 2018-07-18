package com.legendary.entity;

public class Comments {
	//评论id
	private int cid;
	//评论内容
	private String info;
	//商品id
	private Integer gid;
	//评论者id
	private Integer meid;
	//评价
	private Integer rank;
	
	
	
	@Override
	public String toString() {
		return "Comments [cid=" + cid + ", info=" + info + ", gid=" + gid + ", meid=" + meid + ", rank=" + rank + "]";
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public int getCid() {
		return cid;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getMeid() {
		return meid;
	}
	public void setMeid(Integer meid) {
		this.meid = meid;
	}
	
   
}