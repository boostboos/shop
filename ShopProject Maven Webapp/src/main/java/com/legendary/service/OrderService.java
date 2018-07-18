package com.legendary.service;

import java.util.List;

import com.legendary.dao.DaoFactory;
import com.legendary.dao.OrdersDaoI;
import com.legendary.dao.OrdersDaoImpl;
import com.legendary.entity.OrderHelper;
import com.legendary.entity.Orders;
import com.legendary.entity.PageBean;
import com.legendary.entity.StatisticsHelper;

public class OrderService {
	OrdersDaoI gdi = new OrdersDaoImpl();
	public void addOrders(Orders order) {
		gdi.addOrder(order);
	}
	public Orders load(String oid) {
		return gdi.load(oid);
	}
	public void edit(Orders order) {
		gdi.editOrder(order);
	}
	public void delete(String oid) {
		gdi.deleteOrder(oid);
	}
	public PageBean<Orders> query(Orders criteria, int pc, int ps) {
		return gdi.query(criteria,pc,ps);
	}
	public List<OrderHelper> findAll(Integer meid) {
		return gdi.findAll(meid);
	}
	public PageBean<Orders> queryAll(Orders criteria, int pc, int ps) {
		return gdi.queryAll(criteria,pc,ps);
	}
	public List<Orders> findAll() {
		return gdi.findAll();
	}
	public List<StatisticsHelper> getStat() {
		return gdi.getStat();
	}
}
