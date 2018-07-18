package com.legendary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.legendary.common.TxQueryRunner;
import com.legendary.entity.Goods;
import com.legendary.entity.PageBean;

public class GoodsDaoImpl implements GoodsDaoI {

	@Override
	public List<Goods> findAll() {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM goods";
		try {
			return queryRunner.query(sql, new BeanListHandler<Goods>(Goods.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addGoods(Goods goods) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "INSERT INTO goods"
				+ "(gname,detail,keyword,state,shelves,sales) "
				+ "Values(?,?,?,?,?,0)";
		Object[] params = {goods.getGname(),goods.getDetail(),
						goods.getKeyword(),goods.getState(),
						goods.getShelves()};
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
	public boolean editGoods(Goods goods) {
		QueryRunner queryRunner = new TxQueryRunner();
		System.out.println("goods edit:"+goods);
		String sql ="UPDATE goods SET gname=?,detail=?,keyword=?,state=?,shelves=?,sales=? WHERE gid=?";
		Object[] params = {goods.getGname(),goods.getDetail(),
						   goods.getKeyword(),goods.getState(),
						   goods.getShelves(),goods.getSales(),goods.getGid()};
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
	public boolean deleteGoods(int goods) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM goods WHERE gid = ?";
		Object[] params = {goods};
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
	public PageBean<Goods> findAll(int pc, int ps) {
		PageBean<Goods> pb = new PageBean<Goods>();
		pb.setPageCode(pc);
		pb.setPageSize(ps);
		
		String sql = "SELECT COUNT(*) FROM goods";
		QueryRunner queryRunner = new TxQueryRunner();
		try {
			 Number number = (Number) queryRunner.query(sql, new ScalarHandler());
			 int tr = number.intValue();
			 pb.setTotalRecord(tr);
			 
			 sql = "SELECT * FROM goods limit ?,?";
			 
			List<Goods> beanList = queryRunner.query(sql, 
					 new BeanListHandler<Goods>(Goods.class),
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
	public Goods load(int id) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM goods WHERE gid=?";
		try {
			return queryRunner.query(sql, new BeanHandler<Goods>(Goods.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageBean<Goods> query(Goods criteria, int pc, int ps) {
		PageBean<Goods> pb = new PageBean<Goods>();
		pb.setPageCode(pc);
		pb.setPageSize(ps);
		StringBuilder cntSql = new StringBuilder("select count(*) from goods ");
		StringBuilder whereSql = new StringBuilder("where 1=1 ");
		String gname = criteria.getGname();
		List<Object> params = new ArrayList<Object>();
		if(null!=gname && !gname.trim().isEmpty()) {
			whereSql.append("and gname like ? ");
			params.add("%"+gname+"%");
		}
		String keyword = criteria.getKeyword();
		if(null!=keyword && !keyword.trim().isEmpty()) {
			whereSql.append("and keyword like ?");
			params.add("%"+keyword+"%");
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
		
		StringBuilder sql = new StringBuilder("select * from goods ");
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		params.add((pc-1)*ps);
		params.add(ps);
		try {
			List<Goods> beanList = queryRunner.query(sql.append(whereSql).append(limitSql).toString(),
					new BeanListHandler<Goods>(Goods.class),params.toArray());
			pb.setBeanList(beanList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return pb;
	}

}
