package com.legendary.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.legendary.common.CommonUtils;
import com.legendary.entity.Address;
import com.legendary.entity.Goods;
import com.legendary.entity.GoodsDetail;
import com.legendary.entity.Members;
import com.legendary.entity.OrderDetail;
import com.legendary.entity.OrderHelper;
import com.legendary.entity.Orders;
import com.legendary.service.AddressService;
import com.legendary.service.GoodsDetailService;
import com.legendary.service.GoodsService;
import com.legendary.service.OrderDetailService;
import com.legendary.service.OrderService;
import com.legendary.service.ShopCartService;

@WebServlet("/FrontOrderServlet")
public class FrontOrderServlet extends BaseServlet {
	private AddressService as = new AddressService();
	private OrderService os = new OrderService();
	private OrderDetailService ods = new OrderDetailService();
	private ShopCartService scs = new ShopCartService();
	
	public String preAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		Address criteria = CommonUtils.toBean(request.getParameterMap(), Address.class);
 		List<Address> addressList = as.query(criteria.getMeid());
 		request.setAttribute("addressList", addressList);
 		return "f:/front/home/submitOrder.jsp";
	}
	public String pay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		String oid = request.getParameter("oid");
		Orders order = os.load(oid);
		order.setState(2);
		os.edit(order);
		response.getWriter().print("已成功付款");
		return null;
	}
	GoodsDetailService gds = new GoodsDetailService();
	GoodsService gs = new GoodsService();
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		Orders orders = CommonUtils.toBean(request.getParameterMap(), Orders.class);
		System.out.println(orders);
		String aid = request.getParameter("aid");
		orders.setState(1);
		Date date = new Date(new java.util.Date().getTime());
		String time = new java.util.Date().getTime()+"";
		orders.setOid(time);
		orders.setDownDate(date);
		System.out.println("123"+orders);
		os.addOrders(orders);
		String[] infos = request.getParameter("info").split(";");
		for (String info : infos) {
			String[] tags = info.split(",");
			OrderDetail orderDetail = new OrderDetail();
			int gdid = Integer.parseInt(tags[0]);
			int number = Integer.parseInt(tags[1]);
			orderDetail.setGid(gdid);
			GoodsDetail goodsDetail = gds.load(gdid);
			Goods good = gs.load(goodsDetail.getGid());
			goodsDetail.setNumber(goodsDetail.getNumber() - number);
			good.setSales(good.getSales() + number);
			gds.edit(goodsDetail);
			gs.edit(good);
			orderDetail.setNumber(number);
			orderDetail.setOid(time);
			ods.addOrderDetail(orderDetail);
			scs.delete(orders.getMeid(),gdid);
		}
		
		AddressService as = new AddressService();
		Address add = as.load(Integer.parseInt(aid));
		String price = request.getParameter("price");
		request.setAttribute("address", add);
		request.setAttribute("price", price);
		request.setAttribute("oid", time);
		
		return "f:/front/home/pay.jsp";
	}
	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		String oid = request.getParameter("oid");
		os.delete(oid);
		ods.deleteAll(oid);
		return "r:/FrontOrderServlet?method=query&meid="+userinfo.getMeid();
	}
	
	
	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		String meid = request.getParameter("meid");
		String oid = request.getParameter("oid");
		String state = request.getParameter("state");
		Orders order = os.load(oid);
		order.setState(Integer.parseInt(state));
		os.edit(order);
		return "r:/FrontOrderServlet?method=query&meid="+meid;
	}
	
	public String returnEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		String meid = request.getParameter("meid");
		String oid = request.getParameter("oid");
		String state = request.getParameter("state");
		Orders order = os.load(oid);
		order.setState(Integer.parseInt(state));
		os.edit(order);
		return "r:/FrontOrderServlet?method=returnQuery&meid="+meid;
	}
	

	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		Integer meid = Integer.parseInt(request.getParameter("meid"));
		List<OrderHelper> orders = os.findAll(meid);
		request.setAttribute("orders", orders);
		return "f:/front/person/order.jsp";
	}
	
	public String returnQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		Integer meid = Integer.parseInt(request.getParameter("meid"));
		List<OrderHelper> orders = os.findAll(meid);
		request.setAttribute("orders", orders);
		return "f:/front/person/returnGood.jsp";
	}
}
