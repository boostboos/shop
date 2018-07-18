package com.legendary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.legendary.common.TxQueryRunner;
import com.legendary.entity.Admins;
import com.legendary.entity.CommentHelper;
import com.legendary.entity.Comments;
import com.legendary.entity.PageBean;

public class CommentsDaoImpl implements CommentsDaoI {

	@Override
	public List<CommentHelper> find(String oid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT o.oid,p.picinfo,gd.sellPrice,gd.specdetail,g.gname,g.gid "
				+ "FROM orderdetail od, goodsdetail gd,goods g, orders o,picinfos p "
				+ "WHERE od.gid=gd.gdid AND o.oid=od.oid AND p.pid = gd.pid AND g.gid = gd.gid And o.oid = ?";
		List<CommentHelper> result = null;
		try {
			result = queryRunner.query(sql, new BeanListHandler<CommentHelper>(CommentHelper.class),oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<Comments> find(Integer gid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM comments WHERE gid=?";
		List<Comments> result = null;
		try {
			System.out.println("asdfkjelf"+result);
			result = queryRunner.query(sql, new BeanListHandler<Comments>(Comments.class),gid);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean addComments(Comments comments) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "Insert into comments"
				+ "(meid,gid,info,rank) "
				+ "Values(?,?,?,?)";
		Object[] params = {
				comments.getMeid(),
				comments.getGid(),
				comments.getInfo(),
				comments.getRank()
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
	public boolean editComments(Comments comments) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql ="UPDATE comments SET meid=?,gid=?,info=?,rank=? WHERE cid=?";
		Object[] params = {comments.getMeid(),comments.getGid(),comments.getInfo(),comments.getRank(),
				comments.getCid()
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
	public boolean deleteComments(int id) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM comments WHERE cid = ?";
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
	public PageBean<Comments> findAll(int pc, int ps) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comments load(int id) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM comments WHERE cid=?";
		try {
			return queryRunner.query(sql, new BeanHandler<Comments>(Comments.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageBean<Comments> query(Comments criteria, int pc, int ps) {
		PageBean<Comments> pb = new PageBean<Comments>();
		pb.setPageCode(pc);
		pb.setPageSize(ps);
		StringBuilder cntSql = new StringBuilder("select count(*) from comments ");
		StringBuilder whereSql = new StringBuilder("where 1=1 ");
		String comments = criteria.getInfo();
		List<Object> params = new ArrayList<Object>();
		if(null!=comments && !comments.trim().isEmpty()) {
			whereSql.append("and info like ? ");
			params.add("%"+comments+"%");
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
		
		StringBuilder sql = new StringBuilder("select * from comments ");
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		params.add((pc-1)*ps);
		params.add(ps);
		try {
			List<Comments> beanList = queryRunner.query(sql.append(whereSql).append(limitSql).toString(),
					new BeanListHandler<Comments>(Comments.class),params.toArray());
			pb.setBeanList(beanList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return pb;
	}

}
