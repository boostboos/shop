package com.legendary.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.legendary.common.TxQueryRunner;
import com.legendary.entity.Admins;
import com.legendary.entity.PageBean;
import com.legendary.entity.Roles;

public class RolesDaoImpl implements RolesDaoI {

	@Override
	public boolean addRoles(Roles role) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "Insert into roles"
				+ "(rid,roleName,remark,authority) "
				+ "Values(?,?,?,?)";
		Object[] params = {role.getRid(),
				role.getRoleName(),role.getRemark(),
				role.getAuthority()};
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
	public boolean editRoles(Roles role) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql ="UPDATE roles SET roleName=?,remark=?,authority=? WHERE rid=?";
		Object[] params = {
				role.getRoleName(),role.getRemark(),
				role.getAuthority(),role.getRid()};
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
	public boolean deleteRoles(int id) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM roles WHERE rid = ?";
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
	public PageBean<Roles> findAll(int pc, int ps) {
		System.out.println("rolesDaoimpl");
		PageBean<Roles> pb = new PageBean<Roles>();
		pb.setPageCode(pc);
		pb.setPageSize(ps);
		System.out.println("findall...");
		String sql = "SELECT COUNT(*) FROM roles";
		QueryRunner queryRunner = new TxQueryRunner();
		try {
			 Number number = (Number) queryRunner.query(sql, new ScalarHandler());
			 int tr = number.intValue();
			 pb.setTotalRecord(tr);
			 
			 sql = "SELECT * FROM roles limit ?,?";
			 
			List<Roles> beanList = queryRunner.query(sql, 
					 new BeanListHandler<Roles>(Roles.class),
					 (pc-1)*ps,ps);
			pb.setBeanList(beanList);
			return pb;
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Roles load(int id) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM roles WHERE rid=?";
		try {
			return queryRunner.query(sql, new BeanHandler<Roles>(Roles.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
