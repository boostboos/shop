package com.legendary.dao;

import java.util.List;

import com.legendary.entity.PageBean;
import com.legendary.entity.SubCatalogs;

public interface SubCatalogsDaoI {
	public boolean addSubCatalogs(SubCatalogs subCatalogs);
	public boolean editSubCatalogs(SubCatalogs subCatalogs);
	public boolean deleteSubCatalogs(int id);
	public List<SubCatalogs> findAllByCid(int id);
	public SubCatalogs load(int id);
	public PageBean<SubCatalogs> query(SubCatalogs criteria, int pc, int ps);
	public boolean deleteAll(int cid);
}
