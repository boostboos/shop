package com.legendary.entity;

import java.util.List;

public class PageBean<T> {
	private int pageCode;
	private int totalPage;
	private int totalRecord;
	private int pageSize;
	private List<T> beanList;
	
	@Override
	public String toString() {
		return "PageBean [pageCode=" + pageCode + ", totalPage=" + totalPage + ", totalRecord=" + totalRecord
				+ ", pageSize=" + pageSize + ", beanList=" + beanList + ", url=" + url + "]";
	}
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	public int getTotalPage() {
		totalPage = totalRecord/pageSize;
		return totalRecord % pageSize == 0 ? totalPage: (totalPage + 1);

	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
}
