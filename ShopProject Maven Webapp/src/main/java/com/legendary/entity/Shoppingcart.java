package com.legendary.entity;

public class Shoppingcart {
	//商品数量
	private Integer number;
	//是购物车还是收藏夹
	private Integer types;
	//会员id
	private Integer meid;
	//商品详情id
	private Integer gdid;
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getTypes() {
		return types;
	}
	public void setTypes(Integer types) {
		this.types = types;
	}
	public Integer getMeid() {
		return meid;
	}
	public void setMeid(Integer meid) {
		this.meid = meid;
	}
	public Integer getGdid() {
		return gdid;
	}
	public void setGdid(Integer gdid) {
		this.gdid = gdid;
	}
	@Override
	public String toString() {
		return "Shoppingcart [number=" + number + ", types=" + types + ", meid=" + meid + ", gdid=" + gdid + "]";
	}

}