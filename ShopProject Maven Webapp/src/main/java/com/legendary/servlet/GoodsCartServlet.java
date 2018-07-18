package com.legendary.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.legendary.common.CommonUtils;
import com.legendary.entity.GoodsDetail;
import com.legendary.entity.Logs;
import com.legendary.entity.Members;
import com.legendary.entity.PageBean;
import com.legendary.entity.ShopCartItem;
import com.legendary.entity.Shoppingcart;
import com.legendary.service.ShopCartService;

/**
 * Servlet implementation class GoodsCartServlet
 */
public class GoodsCartServlet extends BaseServlet {
	private ShopCartService scs = new ShopCartService();
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		String meid = request.getParameter("meid");
		System.out.println(request.getQueryString());
		Shoppingcart shopcart = CommonUtils.toBean(request.getParameterMap(), Shoppingcart.class);
		System.out.println("shopcart"+shopcart);
		shopcart.setTypes(1);
		Shoppingcart sc = scs.load(shopcart.getMeid(), shopcart.getGdid());
		System.out.println(sc);
		System.out.println(shopcart);
		if(null == sc)
			scs.add(shopcart);
		else {
			sc.setNumber(sc.getNumber() + shopcart.getNumber());
			scs.edit(sc);
		}
		return "f:/GoodsCartServlet?method=query&meid="+meid;
	}
	
	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		int pc = getpc(request);
 		int ps = 6;
 		ShopCartItem criteria = CommonUtils.toBean(request.getParameterMap(), ShopCartItem.class);
 		System.out.println(getUrl(request));
 		
 		PageBean<ShopCartItem> pb = scs.query(criteria, pc, ps);
 		pb.setUrl(getUrl(request));
 		request.setAttribute("pb", pb);
		return "f:/front/home/shopcart.jsp";
	}
	
	

}
