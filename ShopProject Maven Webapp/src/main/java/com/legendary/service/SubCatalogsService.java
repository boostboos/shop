package com.legendary.service;

import java.util.List;

import com.legendary.dao.SubCatalogsImpl;
import com.legendary.entity.PageBean;
import com.legendary.entity.SubCatalogs;

public class SubCatalogsService {
	SubCatalogsImpl scli = new SubCatalogsImpl();

	public void edit(SubCatalogs subCatalogs) {
		scli.editSubCatalogs(subCatalogs);
		
	}

	public PageBean<SubCatalogs> query(SubCatalogs criteria, int pc, int ps) {
		return scli.query(criteria, pc, ps);
	}

	public SubCatalogs load(int sdid) {
		return scli.load(sdid);
	}

	public void delete(int sdid) {
		scli.deleteSubCatalogs(sdid);
		
	}

	public void add(SubCatalogs subCatalogs) {
		scli.addSubCatalogs(subCatalogs);
	}

	public List<SubCatalogs> findAllByCid(int cid) {
		return scli.findAllByCid(cid);
	}
	
	public List<SubCatalogs> findAll() {
		return scli.findAll();
	}
	
}
