package com.legendary.dao;

import java.util.List;

import com.legendary.entity.Admins;
import com.legendary.entity.Catalogs;
import com.legendary.entity.PageBean;

public interface CatalogsDaoI {
	public boolean addCata(Catalogs catalogs);
	public boolean editCata(Catalogs catalogs);
	public boolean deleteCata(int id);
	public List<Catalogs> findAll();
	public Catalogs load(int id);
	public PageBean<Catalogs> query(Catalogs criteria, int pc, int ps);

}
