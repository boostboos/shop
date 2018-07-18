package com.legendary.dao;

import java.util.List;

import com.legendary.entity.OrderHelper;
import com.legendary.entity.Orders;
import com.legendary.entity.PageBean;
import com.legendary.entity.StatisticsHelper;

public interface OrdersDaoI {
	public boolean addOrder(Orders order);
	public boolean editOrder(Orders order);
	public boolean deleteOrder(String id);
	public Orders load(String id);
	public PageBean<Orders> query(Orders criteria, int pc, int ps);
	public List<OrderHelper> findAll(Integer meid);
	public PageBean<Orders> queryAll(Orders criteria, int pc, int ps);
	public List<Orders> findAll();
	public List<StatisticsHelper> getStat();
}
