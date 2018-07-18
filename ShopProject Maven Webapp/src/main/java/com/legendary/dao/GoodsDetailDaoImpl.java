package com.legendary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.legendary.common.TxQueryRunner;
import com.legendary.entity.Admins;
import com.legendary.entity.GoodsDetail;
import com.legendary.entity.PageBean;

public class GoodsDetailDaoImpl implements GoodsDetailDaoI {

	@Override
	public boolean addGoodDetail(GoodsDetail goodDetail) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "Insert into goodsdetail"
				+ "(specdetail,purchPrice,sellPrice,marketPrice,number,gid,pid) "
				+ "Values(?,?,?,?,?,?,?)";
		Object[] params = {goodDetail.getSpecdetail(), goodDetail.getPurchprice(),
				goodDetail.getSellprice(), goodDetail.getMarketprice(),
				goodDetail.getNumber(),goodDetail.getGid(),goodDetail.getPid()};
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
	public List<GoodsDetail> findAll(int gid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM goodsdetail WHERE gid=?";
		try {
			List<GoodsDetail> beanList = queryRunner.query(sql,new BeanListHandler<GoodsDetail>(GoodsDetail.class),gid);
			return beanList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
		
		
	}

	@Override
	public boolean deleteAllGoodDetail(int gid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM goodsdetail WHERE gid=?";
		boolean result = false;
		try {
			result = queryRunner.update(sql, gid) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public boolean editGoodDetail(GoodsDetail goodDetail) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql ="UPDATE goodsdetail SET specdetail=?,purchPrice=?,sellPrice=?,marketPrice=?,number=?,gid=?,pid=? WHERE gdid=?";
		Object[] params = {goodDetail.getSpecdetail(), goodDetail.getPurchprice(),
				goodDetail.getSellprice(), goodDetail.getMarketprice(),
				goodDetail.getNumber(),goodDetail.getGid(),goodDetail.getPid(),goodDetail.getGdid()};
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
	public boolean deleteGoodDetail(int gdid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM goodsdetail WHERE gdid = ?";
		
		boolean result = false;
		try {
			result = queryRunner.update(sql, gdid) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public GoodsDetail load(int gdid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM goodsDetail WHERE gdid=?";
		try {
			return queryRunner.query(sql, new BeanHandler<GoodsDetail>(GoodsDetail.class),gdid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageBean<GoodsDetail> query(GoodsDetail criteria, int pc, int ps) {
		PageBean<GoodsDetail> pb = new PageBean<GoodsDetail>();
		pb.setPageCode(pc);
		pb.setPageSize(ps);
		StringBuilder cntSql = new StringBuilder("select count(*) from goodsDetail ");
		StringBuilder whereSql = new StringBuilder("where 1=1 ");
		String specdetail = criteria.getSpecdetail();
		List<Object> params = new ArrayList<Object>();
		if(null!=specdetail && !specdetail.trim().isEmpty()) {
			whereSql.append("and gname like ? ");
			params.add("%"+specdetail+"%");
		}
		Integer gid = criteria.getGid();
		if(null!=gid) {
			whereSql.append("and gid = ? ");
			params.add(""+gid);
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
		System.out.println(params);
		StringBuilder sql = new StringBuilder("select * from goodsDetail ");
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		params.add((pc-1)*ps);
		params.add(ps);
		System.out.println(params);
		try {
			List<GoodsDetail> beanList = queryRunner.query(sql.append(whereSql).append(limitSql).toString(),
					new BeanListHandler<GoodsDetail>(GoodsDetail.class),params.toArray());
			pb.setBeanList(beanList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return pb;
	}

}
