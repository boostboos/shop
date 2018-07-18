package com.legendary.dao;


import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.legendary.common.TxQueryRunner;
import com.legendary.entity.Admins;
import com.legendary.entity.OrderDetail;
import com.legendary.entity.OrderHelper;
import com.legendary.entity.OrderItem;
import com.legendary.entity.Orders;
import com.legendary.entity.PageBean;
import com.legendary.entity.StatisticsHelper;

public class OrdersDaoImpl implements OrdersDaoI {

	
	@Override
	public List<StatisticsHelper> getStat() {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT *, COUNT(*) AS number FROM orders GROUP BY downDate";
		try {
			return queryRunner.query(sql, new BeanListHandler<StatisticsHelper>(StatisticsHelper.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Orders> findAll() {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM orders";
		
		try {
			return queryRunner.query(sql, new BeanListHandler<Orders>(Orders.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addOrder(Orders order) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "Insert into orders"
				+ "(oid,meid,downDate,finishDate,state,remark) "
				+ "Values(?,?,?,?,?,?)";
		Object[] params = {order.getOid(),order.getMeid(),
				order.getDownDate(),order.getFinishDate(),
				order.getState(),order.getRemark(),
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
	public boolean editOrder(Orders order) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql ="UPDATE orders SET meid=?,downDate=?,finishDate=?,state=?,remark=? WHERE oid=?";
		Object[] params = {order.getMeid(),
				order.getDownDate(),order.getFinishDate(),
				order.getState(),order.getRemark(),
				order.getOid()
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
	public boolean deleteOrder(String order) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "DELETE FROM orders WHERE oid = ?";
		Object[] params = {order};
		
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
	public Orders load(String id) {
		QueryRunner queryRunner = new TxQueryRunner();
		String sql = "SELECT * FROM orders WHERE oid=?";
		try {
			return queryRunner.query(sql, new BeanHandler<Orders>(Orders.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PageBean<Orders> query(Orders criteria, int pc, int ps) {
		PageBean<Orders> pb = new PageBean<Orders>();
		pb.setPageCode(pc);
		pb.setPageSize(ps);
		StringBuilder cntSql = new StringBuilder("select count(*) from orders ");
		StringBuilder whereSql = new StringBuilder("where 1=1 AND state=?");

		List<Object> params = new ArrayList<Object>();

		if(null != criteria.getState()) {
			params.add(criteria.getState());
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
		
		StringBuilder sql = new StringBuilder("select * from orders ");
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		params.add((pc-1)*ps);
		params.add(ps);
		try {
			List<Orders> beanList = queryRunner.query(sql.append(whereSql).append(limitSql).toString(),
					new BeanListHandler<Orders>(Orders.class),params.toArray());
			pb.setBeanList(beanList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return pb;
	}

	@Override
	public List<OrderHelper> findAll(Integer meid) {
		QueryRunner queryRunner = new TxQueryRunner();
		String orderSql = "SELECT * FROM orders WHERE meid=?";
		List<OrderHelper> result = null;
		try {
			result = queryRunner.query(orderSql, new BeanListHandler<OrderHelper>(OrderHelper.class),meid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (OrderHelper orderHelper : result) {
			String itemSQl ="SELECT p.picinfo,gd.specdetail,gd.sellPrice,od.number,g.gname FROM orders o, orderdetail od, goods g, goodsdetail gd,picinfos p "
					+ "WHERE o.oid = od.oid AND gd.gdid = od.gid AND gd.gid=g.gid AND p.pid = gd.pid AND o.oid = ?";
			try {
				List<OrderItem> list = queryRunner.query(itemSQl, new BeanListHandler<OrderItem>(OrderItem.class),orderHelper.getOid());
				double totalCost = 0;
				for (OrderItem orderItem : list) {
					totalCost+= orderItem.getSellPrice().doubleValue()*orderItem.getNumber();
				}
				orderHelper.setTotalCost(BigDecimal.valueOf(totalCost));
				orderHelper.setItems(list);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}

	@Override
	public PageBean<Orders> queryAll(Orders criteria, int pc, int ps) {
		PageBean<Orders> pb = new PageBean<Orders>();
		pb.setPageCode(pc);
		pb.setPageSize(ps);
		StringBuilder cntSql = new StringBuilder("select count(*) from orders ");
		StringBuilder whereSql = new StringBuilder("where 1=1 ");

		List<Object> params = new ArrayList<Object>();
		
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
		
		StringBuilder sql = new StringBuilder("select * from orders ");
		StringBuilder limitSql = new StringBuilder(" limit ?,?");
		params.add((pc-1)*ps);
		params.add(ps);
		try {
			List<Orders> beanList = queryRunner.query(sql.append(whereSql).append(limitSql).toString(),
					new BeanListHandler<Orders>(Orders.class),params.toArray());
			pb.setBeanList(beanList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return pb;
	}
	

	
}
