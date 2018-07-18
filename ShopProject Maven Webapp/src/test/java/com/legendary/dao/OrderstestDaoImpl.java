package com.legendary.dao;
import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.legendary.dao.OrdersDaoI;
import com.legendary.dao.OrdersDaoImpl;
import com.legendary.entity.OrderHelper;
import com.legendary.entity.Orders;
import com.legendary.entity.PageBean;
import com.legendary.entity.Picinfos;

public class OrderstestDaoImpl {
	private static final Orders orders = null;
	OrdersDaoI order=new OrdersDaoImpl();

	@Test
	public void testAddOrder() {
		Random random = new Random();
		Orders ord=new Orders();
		for(int i=0;i<10;i++)
		{
			ord.setMeid(random.nextInt()%100);
			ord.setState(random.nextInt()%100);
			ord.setRemark(random.nextInt()%100+"");
			order.addOrder(ord);
		}
	}

	@Test
	public void testEditOrder() {
		Orders ord=new Orders();
		ord.setMeid(1);
		ord.setState(1);
		ord.setRemark("1");
		order.editOrder(ord);
		}

	@Test
	public void testDeleteOrder() {
	}

	@Test
	public void testLoad() {
		List<OrderHelper> orders = order.findAll(2);
		for (OrderHelper orderHelper : orders) {
			System.out.println(orderHelper);
		}
	}

	@Test
	public void testQuery() {
		Orders ord=new Orders();
		PageBean<Orders> orlist = order.query(ord, 1, 10);
		for(Orders o:orlist.getBeanList())
		{
			System.out.println(o.toString());
		}
	}

}
