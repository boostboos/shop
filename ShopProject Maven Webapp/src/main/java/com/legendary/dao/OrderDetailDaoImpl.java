package com.legendary.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.legendary.common.TxQueryRunner;
import com.legendary.entity.GoodsDetail;
import com.legendary.entity.OrderDetail;
import com.legendary.entity.PageBean;

public class OrderDetailDaoImpl implements OrderDetailDaoI {
	
	@Override
	public List<OrderDetail> findAll() {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM orderdetail";
		try {
			return queryRunner.query(sql, new BeanListHandler<OrderDetail>(OrderDetail.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addOrderDetail(OrderDetail orderDetail) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "Insert into orderDetail"
				+ "(gid,oid,number) "
				+ "Values(?,?,?)";
		Object[] params = {orderDetail.getGid(),
				orderDetail.getOid(),orderDetail.getNumber(),
				};
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
	public boolean deleteAll(String oid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM orderDetail WHERE oid=?";
		boolean result = false;
		try {
			result = queryRunner.update(sql, oid) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean editOrderDetail(OrderDetail orderDetail) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql ="UPDATE orderDetail SET number=? WHERE gid=? AND oid=?";
		Object[] params = {
				orderDetail.getNumber(),orderDetail.getGid(), orderDetail.getOid()
				};
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
	public boolean deleteOrderDetail(int gid,String oid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM orderDetail WHERE gid=? AND oid=?";
		Object[] params = {gid,oid};
		
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
	public OrderDetail load(int gid,String oid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM orderDetail WHERE gid=? And oid=?";
		Object[] params = {gid,oid};
		try {
			return queryRunner.query(sql, new BeanHandler<OrderDetail>(OrderDetail.class),params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderDetail> findAll(String oid) {
		QueryRunner queryRunner = new TxQueryRunner();
		try{
			String sql = "SELECT * FROM orderDetail WHERE oid=?";
			List<OrderDetail> beanList = queryRunner.query(sql, 
					 new BeanListHandler<OrderDetail>(OrderDetail.class),oid);
			return beanList;
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
