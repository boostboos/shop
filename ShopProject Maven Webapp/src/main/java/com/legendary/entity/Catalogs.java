package com.legendary.entity;

public class Catalogs {
	//类别id
    private Integer cid;
    //类别名称
    private String catalogName;
    //类别排序id
    private Integer sortld;
    //类别详情
    public String remark;
    
    
    
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	public Integer getSortld() {
		return sortld;
	}
	public void setSortld(Integer sortld) {
		this.sortld = sortld;
	}
	@Override
	public String toString() {
		return "Catalogs [cid=" + cid + ", catalogName=" + catalogName + ", sortld=" + sortld + ", remark=" + remark
				+ "]";
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
   
   

}