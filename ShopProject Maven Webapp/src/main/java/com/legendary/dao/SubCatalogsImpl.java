package com.legendary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.legendary.common.TxQueryRunner;
import com.legendary.entity.PageBean;
import com.legendary.entity.SubCatalogs;

public class SubCatalogsImpl implements SubCatalogsDaoI {

	@Override
	public boolean addSubCatalogs(SubCatalogs subCatalogs) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "Insert into subcatalogs"
				+ "(scname,subcata,cid) "
				+ "Values(?,?,?)";
		Object[] params = {subCatalogs.getScname(),subCatalogs.getSubcata(),subCatalogs.getCid()};
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
	public boolean editSubCatalogs(SubCatalogs subCatalogs) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql ="UPDATE subcatalogs SET scname=?,subcata=?,cid=? WHERE scid=?";
		Object[] params = {subCatalogs.getScname(),subCatalogs.getSubcata(),subCatalogs.getCid(),subCatalogs.getScid()};
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
	public boolean deleteSubCatalogs(int id) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM subcatalogs WHERE scid = ?";
		Object[] params = {id};
		
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
	public List<SubCatalogs> findAllByCid(int id) {
		QueryRunner queryRunner = new TxQueryRunner();
		try {
			String sql = "SELECT * FROM subcatalogs where cid=?";
			 
			List<SubCatalogs> list = queryRunner.query(sql, 
					 new BeanListHandler<SubCatalogs>(SubCatalogs.class),id);
			return list;
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SubCatalogs load(int id) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM subcatalogs WHERE scid=?";
		try {
			return queryRunner.query(sql, new BeanHandler<SubCatalogs>(SubCatalogs.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageBean<SubCatalogs> query(SubCatalogs criteria, int pc, int ps) {
		PageBean<SubCatalogs> pb = new PageBean<SubCatalogs>();
		pb.setPageCode(pc);
		pb.setPageSize(ps);
		StringBuilder cntSql = new StringBuilder("select count(*) from subcatalogs ");
		StringBuilder whereSql = new StringBuilder("where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		Integer cid = criteria.getCid();
		if(null!=cid ) {
			whereSql.append("and cid = ? ");
			params.add(cid);
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
		StringBuilder sql = new StringBuilder("select * from subcatalogs ");
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		params.add((pc-1)*ps);
		params.add(ps);
		try {
			List<SubCatalogs> beanList = queryRunner.query(sql.append(whereSql).append(limitSql).toString(),
					new BeanListHandler<SubCatalogs>(SubCatalogs.class),params.toArray());
			pb.setBeanList(beanList);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return pb;
	}

	@Override
	public boolean deleteAll(int cid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM subcatalogs WHERE cid=?";
		boolean result = false;
		try {
			result = queryRunner.update(sql, cid) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<SubCatalogs> findAll() {
		QueryRunner queryRunner = new TxQueryRunner();
		try {
			String sql = "SELECT * FROM subcatalogs";
			 
			List<SubCatalogs> list = queryRunner.query(sql, 
					 new BeanListHandler<SubCatalogs>(SubCatalogs.class));
			return list;
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
