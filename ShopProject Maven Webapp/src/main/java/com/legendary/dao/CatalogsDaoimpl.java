package com.legendary.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.legendary.common.TxQueryRunner;
import com.legendary.entity.Catalogs;
import com.legendary.entity.PageBean;

public class CatalogsDaoimpl implements CatalogsDaoI {

	private static final Object Catalogs = null;

	@Override
	public boolean addCata(Catalogs catalogs) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "Insert into catalogs"
				+ "(catalogName,sortld,remark) "
				+ "Values(?,?,?)";

		Object[] params = {
				catalogs.getCatalogName(),
				catalogs.getSortld(),
				catalogs.getRemark()
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
	public boolean editCata(Catalogs catalogs) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "UPDATE catalogs SET catalogName=?,sortld=?,remark=? WHERE cid=?";
		Object[] params = {
				catalogs.getCatalogName(),
				catalogs.getSortld(),
				catalogs.getRemark(),
				catalogs.getCid(),
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
	public boolean deleteCata(int catalogs) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM catalogs WHERE cid = ?";
		Object[] params = {catalogs};
		
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
	public List<Catalogs> findAll() {
		QueryRunner queryRunner = new TxQueryRunner();
		try{
			String sql = "SELECT * FROM catalogs";
			List<Catalogs> beanList = queryRunner.query(sql, 
					 new BeanListHandler<Catalogs>(Catalogs.class));
			return beanList;
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Catalogs load(int id) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM catalogs WHERE cid=?";
		try {
			return queryRunner.query(sql, new BeanHandler<Catalogs>(Catalogs.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}




	@Override
	public PageBean<Catalogs> query(Catalogs criteria, int pc, int ps) {
		PageBean<Catalogs> pb = new PageBean<Catalogs>();
		pb.setPageCode(pc);
		pb.setPageSize(ps);
		StringBuilder cntSql = new StringBuilder("select count(*) from catalogs ");
		StringBuilder whereSql = new StringBuilder("where 1=1 ");
		String catalogName = criteria.getCatalogName();
		List<Object> params = new ArrayList<Object>();
		if(null!=catalogName && !catalogName.trim().isEmpty()) {
			whereSql.append("and catalogName like ? ");
			params.add("%"+catalogName+"%");
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
		
		StringBuilder sql = new StringBuilder("select * from catalogs ");
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		params.add((pc-1)*ps);
		params.add(ps);
		try {
			List<Catalogs> beanList = queryRunner.query(sql.append(whereSql).append(limitSql).toString(),
					new BeanListHandler<Catalogs>(Catalogs.class),params.toArray());
			pb.setBeanList(beanList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return pb;
	}

}
