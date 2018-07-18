package com.legendary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.legendary.common.TxQueryRunner;
import com.legendary.entity.Members;
import com.legendary.entity.PageBean;

public class MembersDaoImpl implements MembersDaoI {

	private Object member;

	@Override
	public boolean addMember(Members member) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "Insert into members"
				+ "(username,realname,passwd,email,gender,birthday,phone,createDate,lastDate,photoPath,score) "
				+ "Values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {member.getUsername(),member.getRealname(),member.getPasswd(),member.getEmail(),member.getGender(),
				member.getBirthday(),member.getPhone(),member.getCreateDate(),member.getLastDate(),member.getPhotoPath(),member.getScore()};
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
	public boolean editMember(Members member) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql ="UPDATE Members SET username=?,realname=?,passwd=?,email=?,gender=?,birthday=?,phone=?,createDate=?,lastDate=?,photoPath=?,score=? WHERE meid=?";
		Object[] params = {
				member.getUsername(),member.getRealname(),member.getPasswd(),
				member.getEmail(),member.getGender(), member.getBirthday(),
				member.getPhone(),member.getCreateDate(),
				member.getLastDate(),member.getPhotoPath(),
				member.getScore(),member.getMeid()};
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
	public boolean deleteMember(int id) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM members WHERE meid = ?";
		
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
	public Members load(int id) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM members WHERE meid=?";
		try {
			return queryRunner.query(sql, new BeanHandler<Members>(Members.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Members find(String where) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM members WHERE 1=1 AND "+where;
		try {
			return queryRunner.query(sql, new BeanHandler<Members>(Members.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageBean<Members> query(Members criteria, int pc, int ps) {
		PageBean<Members> pb = new PageBean<Members>();
		pb.setPageCode(pc);
		pb.setPageSize(ps);
		StringBuilder cntSql = new StringBuilder("select count(*) from members ");
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
		
		StringBuilder sql = new StringBuilder("select * from members ");
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		params.add((pc-1)*ps);
		params.add(ps);
		try {
			List<Members> beanList = queryRunner.query(sql.append(whereSql).append(limitSql).toString(),
					new BeanListHandler<Members>(Members.class),params.toArray());
			pb.setBeanList(beanList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return pb;
	}

}
