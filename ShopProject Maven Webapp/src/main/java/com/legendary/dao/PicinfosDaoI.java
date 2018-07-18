package com.legendary.dao;

import java.util.List;

import com.legendary.entity.PageBean;
import com.legendary.entity.Picinfos;

public interface PicinfosDaoI {
	public boolean addPicinfos(Picinfos picinfos);
	public boolean editPicinfos(Picinfos picinfos);
	public boolean deletePicinfos(String pid);
	public Picinfos load(String pid);
	public PageBean<Picinfos> query(Picinfos criteria, int pc, int ps);
	public List<Picinfos> findAllByGid(int gid);
	public boolean deleteAllByGid(int gid);

}
