package com.legendary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.legendary.entity.Admins;
import com.legendary.entity.PageBean;
import com.legendary.common.TxQueryRunner;

public class AdminsDaoImpl implements AdminsDaoI {

	@Override
	public boolean addAdmin(Admins admin) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "Insert into admins"
				+ "(rid,username,passwd,realname,gender,phone,Email,remark,lastDate,createDate) "
				+ "Values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {admin.getRid(),
				admin.getUsername(),admin.getPasswd(),
				admin.getRealname(),admin.getGender(),
				admin.getPhone(),admin.getEmail(),
				admin.getRemark(),admin.getLastDate(),
				admin.getCreateDate()};
		boolean result = false;
		try {
			result = queryRunner.update(sql, params) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public PageBean<Admins> query(Admins criteria, int pc, int ps) {
		PageBean<Admins> pb = new PageBean<Admins>();
		pb.setPageCode(pc);
		pb.setPageSize(ps);
		StringBuilder cntSql = new StringBuilder("select count(*) from admins ");
		StringBuilder whereSql = new StringBuilder("where 1=1 ");
		String username = criteria.getUsername();
		List<Object> params = new ArrayList<Object>();
		if(null!=username && !username.trim().isEmpty()) {
			whereSql.append("and username like ? ");
			params.add("%"+username+"%");
		}
		String gender = criteria.getGender();
		if(null!=gender && !gender.trim().isEmpty()) {
			whereSql.append("and gender=? ");
			params.add(gender);
		}
		String email = criteria.getEmail();
		if(null!=email && !email.trim().isEmpty()) {
			whereSql.append("and email like ? ");
			params.add("%"+email+"%");
		}
		String remark = criteria.getRemark();
		if(null!=remark && !remark.trim().isEmpty()) {
			whereSql.append("and remark like ?");
			params.add("%"+remark+"%");
		}
		QueryRunner queryRunner = new TxQueryRunner();
		Number number;
		try {
			number = (Number)queryRunner.query(cntSql.append(whereSql).toString(), new ScalarHandler(),params.toArray());
			int tr = number.intValue();
			pb.setTotalRecord(tr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringBuilder sql = new StringBuilder("select * from admins ");
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		params.add((pc-1)*ps);
		params.add(ps);
		try {
			List<Admins> beanList = queryRunner.query(sql.append(whereSql).append(limitSql).toString(),
					new BeanListHandler<Admins>(Admins.class),params.toArray());
			pb.setBeanList(beanList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return pb;
	}

	@Override
	public boolean editAdmin(Admins admin) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql ="UPDATE admins SET rid=?,username=?,"
				+ "passwd=?,realname=?,gender=?,"
				+ "phone=?,email=?,remark=? WHERE aid=?";
		Object[] params = {admin.getRid(),
				admin.getUsername(),admin.getPasswd(),
				admin.getRealname(),admin.getGender(),
				admin.getPhone(),admin.getEmail(),
				admin.getRemark(),admin.getAid()};
		boolean result = false;
		try {
			result = queryRunner.update(sql, params) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteAdmin(int id) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM admins WHERE aid = ?";
		
		boolean result = false;
		try {
			result = queryRunner.update(sql, id) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Admins load(int id) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM admins WHERE aid=?";
		try {
			return queryRunner.query(sql, new BeanHandler<Admins>(Admins.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Admins find(String where) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM admins WHERE 1=1 AND "+where;
		try {
			return queryRunner.query(sql, new BeanHandler<Admins>(Admins.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public PageBean<Admins> findAll(int pc,int ps) {
		PageBean<Admins> pb = new PageBean<Admins>();
		pb.setPageCode(pc);
		pb.setPageSize(ps);
		
		String sql = "SELECT COUNT(*) FROM admins";
		QueryRunner queryRunner = new TxQueryRunner();
		try {
			 Number number = (Number) queryRunner.query(sql, new ScalarHandler());
			 int tr = number.intValue();
			 pb.setTotalRecord(tr);
			 
			 sql = "SELECT * FROM admins limit ?,?";
			 
			List<Admins> beanList = queryRunner.query(sql, 
					 new BeanListHandler<Admins>(Admins.class),
					 (pc-1)*ps,ps);
			pb.setBeanList(beanList);
			return pb;
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
