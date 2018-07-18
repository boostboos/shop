package com.legendary.service;

import java.util.List;

import com.legendary.dao.DaoFactory;
import com.legendary.dao.OrderDetailDaoI;
import com.legendary.dao.OrderDetailDaoImpl;
import com.legendary.entity.OrderDetail;
import com.legendary.entity.PageBean;

public class OrderDetailService {
	OrderDetailDaoI oddi = new OrderDetailDaoImpl();
	public void addOrderDetail(OrderDetail orderDetail) {
		oddi.addOrderDetail(orderDetail);
	}
	public OrderDetail load(int gid,String oid) {
		return oddi.load(gid,oid);
	}
	public void edit(OrderDetail goods) {
		oddi.editOrderDetail(goods);
	}
	public void delete(int gid,String oid) {
		oddi.deleteOrderDetail(gid,oid);
	}
	public void deleteAll(String oid) {
		oddi.deleteAll(oid);
	}
	public List<OrderDetail> findAll(){
		return oddi.findAll();
	}
}
