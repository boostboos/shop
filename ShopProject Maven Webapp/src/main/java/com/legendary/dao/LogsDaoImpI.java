package com.legendary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.legendary.common.TxQueryRunner;
import com.legendary.entity.Logs;
import com.legendary.entity.Orders;
import com.legendary.entity.PageBean;

public class LogsDaoImpI implements LogsDaoI{

	@Override
	public boolean addLog(Logs log) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "Insert into logs"
				+ "(operateType,content,operateDate,uid) "
				+ "Values(?,?,?,?)";
		Object[] params = {
				log.getOperateType(),log.getContent(),
				log.getOperateDate(),log.getUid()};
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
	public PageBean<Logs> query(Logs criteria, int pc, int ps) {
		PageBean<Logs> pb = new PageBean<Logs>();
		pb.setPageCode(pc);
		pb.setPageSize(ps);
		StringBuilder cntSql = new StringBuilder("select count(*) from logs ");
		StringBuilder whereSql = new StringBuilder("where 1=1 ");
		

		List<Object> params = new ArrayList<Object>();

		String content = criteria.getContent();
		if(null!=content && !content.trim().isEmpty()) {
			whereSql.append("and content like ?");
			params.add("%"+content+"%");
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
		
		StringBuilder sql = new StringBuilder("select * from logs ");
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		params.add((pc-1)*ps);
		params.add(ps);
		try {
			List<Logs> beanList = queryRunner.query(sql.append(whereSql).append(limitSql).toString(),
					new BeanListHandler<Logs>(Logs.class),params.toArray());
			pb.setBeanList(beanList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return pb;
	}

	@Override
	public boolean deleteLog(int log) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM logs WHERE id = ?";
		Object[] params = {log};
		
		boolean result = false;
		try {
			result = queryRunner.update(sql, params) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
