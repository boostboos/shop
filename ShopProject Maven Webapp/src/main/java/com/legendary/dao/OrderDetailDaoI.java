package com.legendary.dao;

import java.util.List;

import com.legendary.entity.GoodsDetail;
import com.legendary.entity.OrderDetail;
import com.legendary.entity.PageBean;

public interface OrderDetailDaoI {
	public boolean addOrderDetail(OrderDetail orderDetail);
	public boolean editOrderDetail(OrderDetail orderDetail);
	public boolean deleteOrderDetail(int gid,String oid);
	public OrderDetail load(int gid,String oid);
	public List<OrderDetail> findAll(String oid);
	public boolean deleteAll(String oid);
	public List<OrderDetail> findAll();
}
