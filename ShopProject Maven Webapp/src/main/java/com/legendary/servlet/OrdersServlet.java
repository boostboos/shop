package com.legendary.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.legendary.common.CommonUtils;
import com.legendary.entity.Address;
import com.legendary.entity.Admins;
import com.legendary.entity.Goods;
import com.legendary.entity.Orders;
import com.legendary.entity.PageBean;
import com.legendary.service.GoodsService;
import com.legendary.service.OrderService;

@WebServlet("/OrdersServlet")
public class OrdersServlet extends BaseServlet{
	private OrderService orderService = new OrderService();
	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
		if(userinfo == null) {
			return "r:/admin/index.jsp";
		}
		int pc = getpc(request);		
 		int ps = 6;
 		
 		Orders criteria = CommonUtils.toBean(request.getParameterMap(), Orders.class);

 		PageBean<Orders> pb = orderService.query(criteria,pc,ps);
 		pb.setUrl(getUrl(request));
 		request.setAttribute("pb", pb);
 		return "f:/admin/order/orderList.jsp"; 		
 	}
	

	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
		if(userinfo == null) {
			return "r:/admin/index.jsp";
		}
		String state = request.getParameter("state");
		String oid = request.getParameter("oid");
 		Orders orders = orderService.load(oid);
 		orders.setState(Integer.parseInt(state));
		orderService.edit(orders);
 		return "f:/OrdersServlet?method=queryAll";
 	}
	
	public String queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
		if(userinfo == null) {
			return "r:/admin/index.jsp";
		}
		int pc = getpc(request);
 		int ps = 6;
 		Orders criteria = CommonUtils.toBean(request.getParameterMap(), Orders.class);
 		PageBean<Orders> pb = orderService.queryAll(criteria,pc,ps);
 		pb.setUrl(getUrl(request));
 		request.setAttribute("pb", pb);
 		return "f:/admin/order/orderList.jsp"; 		
 	}

	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
		if(userinfo == null) {
			return "r:/admin/index.jsp";
		}
		String oid = request.getParameter("oid");
 		orderService.delete(oid);
 		String pc = request.getParameter("pc");
 		return "f:/OrdersServlet?method=queryAll";
 	}
}
