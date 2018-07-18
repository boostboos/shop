package com.legendary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.legendary.common.TxQueryRunner;
import com.legendary.entity.Address;
import com.legendary.entity.Admins;
import com.legendary.entity.PageBean;

public class AddressDaoImpl implements AddressDaoI {

	@Override
	public boolean addAddress(Address address) {
		System.out.println("DAO层");
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "Insert into address"
				+ "(meid,addressinfo,receivername,receiverphone,defaddress) "
				+ "Values(?,?,?,?,0)";
		
		System.out.println(address.getAid());
		System.out.println(address.getMeid());
		System.out.println(address.getAddressinfo());
		System.out.println(address.getReceivername());
		System.out.println(address.getReceiverphone());
		
		
		Object[] params = {address.getMeid(),
				address.getAddressinfo(),
				address.getReceivername(),address.getReceiverphone()};
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
	public boolean editAddress(Address address) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql ="UPDATE address SET meid=?,addressinfo=?,receivername=?,receiverphone=? WHERE aid=?";
		Object[] params = {address.getMeid(),address.getAddressinfo(),
				address.getReceivername(),address.getReceiverphone(),
				address.getAid()};
		boolean result = false;
		try {
			result = queryRunner.update(sql, params) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean editAddress1(Address address) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql ="UPDATE address SET defaddress=0 ";
		//Object[] params = {address.getAid()};
		boolean result = false;
		try {
			result = queryRunner.update(sql) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql1 ="UPDATE address SET defaddress=1 WHERE aid=? ";
		Object[] params1 = {address.getAid()};
		boolean result1 = false;
		try {
			result = queryRunner.update(sql1, params1) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteAddress(int address) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM address WHERE aid = ?";
		Object[] params = {address};
		
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
	public PageBean<Address> findAll(int pc, int ps) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address load(int aid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM address WHERE aid=?";
		try {
			return queryRunner.query(sql, new BeanHandler<Address>(Address.class),aid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Address load1(int aid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM address WHERE aid=? ";
		try {
			return queryRunner.query(sql, new BeanHandler<Address>(Address.class),aid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Address> query(int meid) {
		
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = new String("select * from address where meid=?");
		try {
			List<Address> beanList = queryRunner.query(sql,
					new BeanListHandler<Address>(Address.class),meid);
			return beanList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}

}
