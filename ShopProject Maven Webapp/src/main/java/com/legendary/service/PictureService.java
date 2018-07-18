package com.legendary.service;

import java.util.List;

import com.legendary.dao.DaoFactory;
import com.legendary.dao.PicinfosDaoI;
import com.legendary.entity.Picinfos;
import com.legendary.entity.PageBean;

public class PictureService {
	PicinfosDaoI gdi = (PicinfosDaoI) DaoFactory.getDao("PicinfosDaoI");
	public void addPicinfo(Picinfos goods) {
		gdi.addPicinfos(goods);
	}
	public List<Picinfos> findAllByGid(int gid) {
		return gdi.findAllByGid(gid);
	}
	public Picinfos load(String pid) {
		return gdi.load(pid);
	}
	public void edit(Picinfos picinfo) {
		gdi.editPicinfos(picinfo);
	}
	public void delete(String pid) {
		gdi.deletePicinfos(pid);
	}
	public PageBean<Picinfos> query(Picinfos criteria, int pc, int ps) {
		return gdi.query(criteria,pc,ps);
	}
	public void deleteAllByGid(int gid) {
		gdi.deleteAllByGid(gid);
	}
}
