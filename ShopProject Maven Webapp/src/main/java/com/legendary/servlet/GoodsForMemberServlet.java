package com.legendary.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.legendary.common.CommonUtils;
import com.legendary.entity.Admins;
import com.legendary.entity.GoodsDetail;
import com.legendary.entity.Members;
import com.legendary.entity.Shoppingcart;
import com.legendary.service.GoodsDetailService;
import com.legendary.service.ShopCartService;

/**
 * 
 * @作者 屈治宇
 * @类名 GoodsForMemberServlet
 * @描述 商品详情页面获取某规格产品的数量售价
 * @日期 2018年7月6日 上午8:13:27
 */
@WebServlet("/GoodsForMemberServlet")
public class GoodsForMemberServlet extends BaseServlet {

	public String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		GoodsDetailService gds = new GoodsDetailService();
		Integer gid = Integer.parseInt(request.getParameter("gid"));
		List<GoodsDetail> gdList = gds.findAll(gid);
		String[] paras = request.getParameter("para").split(",");
		for (String string : paras) {
			System.out.println(string);
		}
		Arrays.sort(paras);
		String result = "0,0,0";
		for (int i = 0; i < gdList.size(); i++) {
			String[] specs = gdList.get(i).getSpecdetail().split(",");
			Arrays.sort(specs);
			boolean gotTrueGoodsDetail = true;
			for (int j = 0; j < paras.length; j++) {
				if(!paras[j].equals(specs[j])) {
					gotTrueGoodsDetail = false;
					break;
				}
			}
			if(gotTrueGoodsDetail) {
				GoodsDetail goodsDetail = gdList.get(i);
				result = goodsDetail.getMarketprice()+","+
						goodsDetail.getSellprice()+","+
						goodsDetail.getNumber()+","+
						goodsDetail.getGdid();
				break;
			}
		}
		System.out.println(result);
		response.getWriter().print(result);
		return null;
	}

	public String moveToGoodsCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		Shoppingcart shopcart = CommonUtils.toBean(request.getParameterMap(), Shoppingcart.class);
		shopcart.setTypes(1);
		ShopCartService scs = new ShopCartService();
		System.out.println(shopcart);
		scs.add(shopcart);
		return null;
	}

	
}
