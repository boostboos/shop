package com.legendary.dao;

import java.util.List;

import com.legendary.entity.Admins;
import com.legendary.entity.PageBean;

public interface AdminsDaoI {
	public boolean addAdmin(Admins admin);
	public boolean editAdmin(Admins admin);
	public boolean deleteAdmin(int id);
	public Admins find(String sql);
	public Admins load(int id);
	public PageBean<Admins> query(Admins criteria, int pc, int ps);
}
