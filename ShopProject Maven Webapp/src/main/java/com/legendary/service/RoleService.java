package com.legendary.service;

import com.legendary.dao.RolesDaoI;
import com.legendary.dao.DaoFactory;
import com.legendary.entity.Roles;
import com.legendary.entity.PageBean;

public class RoleService {
	RolesDaoI rdi = (RolesDaoI) DaoFactory.getDao("RolesDaoI");
	public void addRole(Roles role) {
		rdi.addRoles(role);
	}
	public Roles load(int id) {
		return rdi.load(id);
	}
	public void edit(Roles role) {
		rdi.editRoles(role);
	}
	public void delete(int aid) {
		rdi.deleteRoles(aid);
	}
	public PageBean<Roles> query(int pc, int ps) {
		return rdi.findAll(pc,ps);
	}
	
}
