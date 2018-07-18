package com.legendary.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.legendary.entity.Catalogs;
import com.legendary.entity.Goods;
import com.legendary.entity.GoodsDetail;
import com.legendary.entity.OrderDetail;
import com.legendary.entity.Orders;
import com.legendary.entity.StatisticsHelper;
import com.legendary.entity.SubCatalogs;
import com.legendary.service.CataService;
import com.legendary.service.GoodsDetailService;
import com.legendary.service.GoodsService;
import com.legendary.service.OrderDetailService;
import com.legendary.service.OrderService;
import com.legendary.service.SubCatalogsService;

public class StatisticsServlet extends BaseServlet {
	OrderService os = new OrderService();
	OrderDetailService ods = new OrderDetailService();
	GoodsDetailService gds = new GoodsDetailService();
	GoodsService gs = new GoodsService();
	CataService cs = new CataService();
	SubCatalogsService scs = new SubCatalogsService();
	public String info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Orders> allOrders = os.findAll();
		List<OrderDetail> allOrderDetails = ods.findAll();
		List<Goods> goodList = gs.findAll();
		List<SubCatalogs> subcataList = scs.findAll();
		int allOrderNumber = allOrders.size();
		double money = 0;
		int pendingOrders = 0;
		int undeliverOrders = 0;
		List<Integer> pendingHelper = Arrays.asList(1,4,5,6,7);
		for (Orders order : allOrders) {
			if(pendingHelper.contains(order.getState())) 
				pendingOrders++;
			if(order.getState() == 2)
				undeliverOrders++;
		}
		System.out.println( allOrderNumber+","+money+","+pendingOrders+","+undeliverOrders);
		for (OrderDetail orderDetail : allOrderDetails) {
			GoodsDetail tempDetail  = gds.load(orderDetail.getGid());
			System.out.println(tempDetail);
			money += orderDetail.getNumber() * gds.load(orderDetail.getGid()).getSellprice().doubleValue();
		}
		List<Catalogs> catalist = cs.findAll();
		Map<String,Integer> cata = new HashMap<String, Integer>();
		
		for (SubCatalogs catalog : subcataList) {
			for (Goods good : goodList ) {
				if(good.getKeyword().contains(catalog.getScname())){
					if(cata.containsKey(catalog.getScname())) {
						int num = cata.get(catalog.getScname());
						cata.put(catalog.getScname(),num+good.getSales());
					} else {
						cata.put(catalog.getScname(),good.getSales());
					}
				}
			}
		}
		
		List<StatisticsHelper> shList = os.getStat();
		
		String allCount = allOrderNumber+","+money+","+pendingOrders+","+undeliverOrders;
		request.setAttribute("cata", cata);
		request.setAttribute("allCount", allCount);
		request.setAttribute("shList", shList);
		
		System.out.println(cata);
		System.out.println(allCount);
		System.out.println(shList);
		return "f:/admin/statistics.jsp";
	}
}
