package com.legendary.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.legendary.common.CommonUtils;
import com.legendary.entity.Admins;
import com.legendary.entity.Catalogs;
import com.legendary.entity.Goods;
import com.legendary.entity.Members;
import com.legendary.entity.PageBean;
import com.legendary.entity.SpecificationDetail;
import com.legendary.entity.Specifications;
import com.legendary.entity.SubCatalogs;
import com.legendary.service.CataService;
import com.legendary.service.GoodsDetailService;
import com.legendary.service.GoodsService;
import com.legendary.service.SpecificationDetailService;
import com.legendary.service.SpecificationService;
import com.legendary.service.SubCatalogsService;

@WebServlet("/GoodsServlet")
public class GoodsServlet extends BaseServlet {
	private GoodsService goodsService = new GoodsService();	
 	
	public Map<String, List<String>> getCata() {
 		CataService cs = new CataService();
 		SubCatalogsService scs = new SubCatalogsService();
 		List<Catalogs> catalist = cs.findAll();
 		Map<String, List<String>> cataMap = new HashMap<String, List<String>>();
 		for (Catalogs cata : catalist) {
			int cid = cata.getCid();
			String key = cata.getCatalogName();
	 		List<SubCatalogs> sclist = scs.findAllByCid(cid);
	 		List<String> scInfos = new ArrayList<String>();
			for (SubCatalogs subCatalogs : sclist) {
				scInfos.add(subCatalogs.getScname());
				scInfos.add(subCatalogs.getSubcata());
			}
			cataMap.put(key, scInfos);
		}
 		return cataMap;
 	}
	
	//添加商品
 	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		Goods goods = CommonUtils.toBean(request.getParameterMap(), Goods.class);
		
 		CataService cs = new CataService();
 		SubCatalogsService scs = new SubCatalogsService();
		List<Catalogs> catalist = cs.findAll();
		String catas = "";
		for (Catalogs catalogs : catalist) {
			String cname = catalogs.getCatalogName();
			String [] lists = request.getParameterValues(cname);
			if(lists == null)
				continue;
			for (String string : lists) {
				catas += string+",";
			}
		}
		String[] temp = catas.split(",");
		List<String> ns = Arrays.asList(temp);
		Set<String> set = new HashSet<String>(ns);
		catas = "";
		for (String string : set) {
			catas+=string+",";
		}
		goods.setKeyword(catas+goods.getGname()+","+goods.getDetail());
		goodsService.addGoods(goods);
		request.setAttribute("msg", "添加成功");
		logger.addLogs(1, "货物", userinfo.getAid());
		return "r:/GoodsServlet?method=query";
	}
 	public int getpc(HttpServletRequest request) {
		String value = request.getParameter("pc");
		if (null == value || value.trim().isEmpty())
			return 1;
		return Integer.parseInt(value);
	}
 	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		int pc = getpc(request);
 		int ps = 6;
 		Goods criteria = CommonUtils.toBean(request.getParameterMap(), Goods.class);
 		System.out.println(getUrl(request));
 		PageBean<Goods> pb = goodsService.query(criteria,pc,ps);
 		pb.setUrl(getUrl(request));
 		System.out.println(pb);
 		request.setAttribute("pb", pb);
		logger.addLogs(4, "货物", userinfo.getAid());
 		return "f:/admin/goods/goodsList.jsp";
 		
 	}
 	
 	public String frontQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
 		if(userinfo == null) {
 			return "r:/front/user/login.jsp";
 		}
 		int pc = getpc(request);
 		int ps = 6;
 		Goods criteria = CommonUtils.toBean(request.getParameterMap(), Goods.class);
 		System.out.println(getUrl(request));
 		PageBean<Goods> pb = goodsService.query(criteria,pc,ps);
 		pb.setUrl(getUrl(request));
 		System.out.println(pb);
 		request.setAttribute("pb", pb);
 		return "f:/front/home/search.jsp";
 	}
 	public String preEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		int gid = Integer.parseInt(request.getParameter("gid"));
 		Goods goods = goodsService.load(gid);
 		Map<String, List<String>> list = getCata();
 		request.setAttribute("catalogs",list );
 		request.setAttribute("goods", goods);
 		return "f:/admin/goods/editGoods.jsp";
 	}
 	
 	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		Goods goods = CommonUtils.toBean(request.getParameterMap(), Goods.class);
 		CataService cs = new CataService();
 		SubCatalogsService scs = new SubCatalogsService();
		List<Catalogs> catalist = cs.findAll();
		String catas = "";
		for (Catalogs catalogs : catalist) {
			String cname = catalogs.getCatalogName();
			String [] lists = request.getParameterValues(cname);
			if(lists == null)
				continue;
			for (String string : lists) {
				catas += string+",";
			}
		}
		String[] temp = catas.split(",");
		List<String> ns = Arrays.asList(temp);
		Set<String> set = new HashSet<String>(ns);
		catas = "";
		for (String string : set) {
			catas+=string+",";
		}
		goods.setKeyword(catas);
 		
 		goodsService.edit(goods);
 		request.setAttribute("msg", "修改成功");
		logger.addLogs(3, "货物", userinfo.getAid());
 		return "r:/GoodsServlet?method=query";
 	}

 	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		int gid = Integer.parseInt(request.getParameter("gid"));
 		goodsService.delete(gid);
 		
		logger.addLogs(2, "货物", userinfo.getAid());
 		return "f:/GoodsServlet?method=query";
 	}
 	
 	public String publish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		Map<String, List<String>> catalogs = getCata();
 		request.setAttribute("catalogs",catalogs );
 		return "f:/admin/goods/addGoods.jsp";
 		
 	}
 	

}
