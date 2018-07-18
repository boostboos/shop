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
import com.legendary.entity.Picinfos;

public class PicinfosDaoImpl implements PicinfosDaoI {

	@Override
	public List<Picinfos> findAllByGid(int gid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM picinfos WHERE gid=?";
		try {
			return queryRunner.query(sql, new BeanListHandler<Picinfos>(Picinfos.class), gid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addPicinfos(Picinfos picinfos) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "Insert into picinfos"
				+ "(pid,gid,picinfo) "
				+ "Values(?,?,?)";
		Object[] params = {
				picinfos.getPid(),
				picinfos.getGid(),
				picinfos.getPicinfo(),
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
	public boolean editPicinfos(Picinfos picinfos) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql ="UPDATE picinfos SET gid = ?,picinfo = ? WHERE pid=?";
		Object[] params = {
				picinfos.getGid(),
				picinfos.getPicinfo(),
				picinfos.getPid()
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
	public boolean deletePicinfos(String pid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM picinfos WHERE pid = ?";
		
		boolean result = false;
		try {
			result = queryRunner.update(sql, pid) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteAllByGid(int gid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM picinfos WHERE gid=?";
		boolean result = false;
		try {
			result = queryRunner.update(sql,gid) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public Picinfos load(String pid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM picinfos WHERE pid=?";
		try {
			return queryRunner.query(sql, new BeanHandler<Picinfos>(Picinfos.class),pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageBean<Picinfos> query(Picinfos criteria, int pc, int ps) {
		PageBean<Picinfos> pb = new PageBean<Picinfos>();
		pb.setPageCode(pc);
		pb.setPageSize(ps);
		StringBuilder cntSql = new StringBuilder("select count(*) from picinfos ");
		StringBuilder whereSql = new StringBuilder("where 1=1 ");
		String picinfo = criteria.getPicinfo();
		List<Object> params = new ArrayList<Object>();
		if(null!=picinfo && !picinfo.trim().isEmpty()) {
			whereSql.append("and picinfo like ? ");
			params.add("%"+picinfo+"%");
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
		
		StringBuilder sql = new StringBuilder("select * from picinfos ");
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		params.add((pc-1)*ps);
		params.add(ps);
		try {
			List<Picinfos> beanList = queryRunner.query(sql.append(whereSql).append(limitSql).toString(),
					new BeanListHandler<Picinfos>(Picinfos.class),params.toArray());
			pb.setBeanList(beanList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return pb;
	}

}
