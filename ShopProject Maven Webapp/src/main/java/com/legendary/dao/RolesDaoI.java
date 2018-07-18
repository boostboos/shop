package com.legendary.dao;

import com.legendary.entity.Admins;
import com.legendary.entity.PageBean;
import com.legendary.entity.Roles;

public interface RolesDaoI {
	public boolean addRoles(Roles role);
	public boolean editRoles(Roles role);
	public boolean deleteRoles(int id);
	public PageBean<Roles> findAll(int pc, int ps);
	public Roles load(int id);
}
