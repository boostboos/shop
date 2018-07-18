package com.legendary.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.legendary.common.CommonUtils;
import com.legendary.entity.Catalogs;
import com.legendary.entity.Goods;
import com.legendary.entity.Members;
import com.legendary.entity.PageBean;
import com.legendary.entity.SubCatalogs;
import com.legendary.service.CataService;
import com.legendary.service.GoodsService;
import com.legendary.service.SubCatalogsService;

/**
 * Servlet implementation class FrontGoodsServlet
 */
public class FrontGoodsServlet extends BaseServlet {
	private GoodsService searchService = new GoodsService();
	private CataService cs = new CataService();
	private SubCatalogsService scs = new SubCatalogsService();
	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		int pc = getpc(request);
 		int ps = 20;
 		Goods criteria = CommonUtils.toBean(request.getParameterMap(), Goods.class);
 		PageBean<Goods> pb = searchService.query(criteria,pc,ps);
 		System.out.println(pb);
 		request.setAttribute("pb", pb);
 		String cataInfo = "";
 		List<Catalogs> catalist = cs.findAll();
 		for (Catalogs catalog : catalist) {
 			cataInfo += catalog.getCatalogName();
 	 		List<SubCatalogs> subcatalist = scs.findAllByCid(catalog.getCid());
 			for (SubCatalogs subCatalog : subcatalist) {
				cataInfo += "," +subCatalog.getScname();
			}
 			cataInfo+=";";
		}
 		request.setAttribute("cataInfo",cataInfo);
 		return "f:/front/home/search.jsp";
	}

}
