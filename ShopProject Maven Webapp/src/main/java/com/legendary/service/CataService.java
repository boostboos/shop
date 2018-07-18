package com.legendary.service;

import java.util.List;

import com.legendary.dao.CatalogsDaoI;
import com.legendary.dao.DaoFactory;
import com.legendary.entity.Catalogs;
import com.legendary.entity.PageBean;

public class CataService {
	CatalogsDaoI adi = (CatalogsDaoI) DaoFactory.getDao("CatalogsDaoI");
	public void addCata(Catalogs catalogs) {
		adi.addCata(catalogs);
	}
	public List<Catalogs> findAll() {
		return adi.findAll();
	}
	public Catalogs load(int id) {
		return adi.load(id);
	}
	public void edit(Catalogs catalogs) {
		adi.editCata(catalogs);
	}
	public void delete(int cid) {
		adi.deleteCata(cid);
	}
	public PageBean<Catalogs> query(Catalogs criteria, int pc, int ps) {
		return adi.query(criteria,pc,ps);
	}
	

}

