package com.legendary.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.legendary.common.TxQueryRunner;
import com.legendary.entity.GoodsDetail;
import com.legendary.entity.PageBean;
import com.legendary.entity.ShopCartItem;
import com.legendary.entity.Shoppingcart;

public class ShoppingcartDaoImpl implements ShoppingcartDaoI {

	@Override
	public boolean addShoppingcart(Shoppingcart shoppingcart) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "Insert into shoppingcart"
				+ "(meid,gdid,number,types) "
				+ "Values(?,?,?,?)";
		Object[] params = {
				shoppingcart.getMeid(),
				shoppingcart.getGdid(),
				shoppingcart.getNumber(),
				shoppingcart.getTypes()};
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
	public boolean editShoppingcart(Shoppingcart shoppingcart) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql ="UPDATE shoppingcart SET number=?,types=? WHERE meid=? AND gdid=?";
		Object[] params = {
				shoppingcart.getNumber(),
				shoppingcart.getTypes(),
				shoppingcart.getMeid(),
				shoppingcart.getGdid(),
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
	public boolean deleteShoppingcart(int meid,int gdid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM shoppingcart WHERE meid = ? and gdid = ?";
		Object[] params = {meid,gdid};
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
	public List<Shoppingcart> findAll() {
		QueryRunner queryRunner = new TxQueryRunner();
		try{
			String sql = "SELECT * FROM shoppingcart";
			List<Shoppingcart> beanList = queryRunner.query(sql, 
					 new BeanListHandler<Shoppingcart>(Shoppingcart.class));
			return beanList;
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

	@Override
	public PageBean<ShopCartItem> query(ShopCartItem criteria, int pc, int ps) {
		PageBean<ShopCartItem> pb = new PageBean<ShopCartItem>();
		pb.setPageCode(pc);
		pb.setPageSize(ps);
		StringBuilder cntSql = new StringBuilder("select count(*) FROM shoppingcart s,goods g,goodsdetail gd,picinfos p ");
		StringBuilder whereSql = new StringBuilder("WHERE gd.pid=p.pid AND s.gdid = gd.gdid AND gd.gid = g.gid ");
		Integer meid = criteria.getMeid();
		List<Object> params = new ArrayList<Object>();
		if(null!=meid) {
			whereSql.append("and meid = ? ");
			params.add(""+meid);
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
		StringBuilder sql = new StringBuilder("SELECT g.shelves,g.gname,gd.specdetail,gd.sellPrice,gd.marketPrice,p.picinfo,s.meid,s.number,gd.gdid FROM shoppingcart s,goods g,goodsdetail gd,picinfos p ");
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		params.add((pc-1)*ps);
		params.add(ps);
		System.out.println(params);
		try {
			List<ShopCartItem> beanList = queryRunner.query(sql.append(whereSql).append(limitSql).toString(),
					new BeanListHandler<ShopCartItem>(ShopCartItem.class),params.toArray());
			pb.setBeanList(beanList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return pb;
	}
	

	@Override
	public Shoppingcart load(int meid,int gdid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM shoppingcart WHERE meid=? AND gdid=?";
		Object[] paras = {meid,gdid};
		try {
			return queryRunner.query(sql, new BeanHandler<Shoppingcart>(Shoppingcart.class),paras);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
