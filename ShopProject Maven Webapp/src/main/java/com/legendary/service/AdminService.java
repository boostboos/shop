package com.legendary.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.legendary.common.TxQueryRunner;
import com.legendary.dao.AdminsDaoI;
import com.legendary.dao.DaoFactory;
import com.legendary.entity.Admins;
import com.legendary.entity.PageBean;

public class AdminService {
	AdminsDaoI adi = (AdminsDaoI) DaoFactory.getDao("AdminsDaoI");
	public void addAdmin(Admins admin) {
		adi.addAdmin(admin);
	}
	
	public Admins login(Admins admin) {
		String sql = "username='"+admin.getUsername()+"' AND "+
	"passwd='"+ admin.getPasswd()+"'";
		System.out.println(sql);
		return adi.find(sql);
	}
	public Admins load(int id) {
		return adi.load(id);
	}
	public void edit(Admins admin) {
		adi.editAdmin(admin);
	}
	public void delete(int aid) {
		adi.deleteAdmin(aid);
	}
	public PageBean<Admins> query(Admins criteria, int pc, int ps) {
		return adi.query(criteria,pc,ps);
	}
	
}
