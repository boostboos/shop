package com.legendary.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.legendary.common.CommonUtils;
import com.legendary.entity.Admins;
import com.legendary.entity.Catalogs;
import com.legendary.entity.PageBean;
import com.legendary.service.CataService;



@WebServlet("/CatalogsServlet")
public class CatalogsServlet extends BaseServlet {
 	private CataService cataService = new CataService();	
 	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		Catalogs catalogs = CommonUtils.toBean(request.getParameterMap(), Catalogs.class);

 		cataService.addCata(catalogs);
		request.setAttribute("msg", "添加成功");
		return "r:/CatalogsServlet?method=query";
	}
 	
 	public int getpc(HttpServletRequest request) {
 		
		String value = request.getParameter("pc");
		if (null == value || value.trim().isEmpty())
			return 1;
		return Integer.parseInt(value);
	}
 	
 	public String preEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		int cid = Integer.parseInt(request.getParameter("cid"));
 		Catalogs catalogs = cataService.load(cid);
 		request.setAttribute("catalogs", catalogs);
 		return "f:/admin/catalogs/editCatalogs.jsp";
 	}
 	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		Catalogs catalogs = CommonUtils.toBean(request.getParameterMap(), Catalogs.class);
 		System.out.println(catalogs);
 		cataService.edit(catalogs);
 		request.setAttribute("msg", "修改成功");
		logger.addLogs(3, "分类", userinfo.getAid());
 		return "r:/CatalogsServlet?method=query";
 	}
 	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		int cid = Integer.parseInt(request.getParameter("cid"));
 		cataService.delete(cid);
		logger.addLogs(2, "分类", userinfo.getAid());
 		return "f:/CatalogsServlet?method=query";
 	}
 	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		int pc = getpc(request);
 		int ps = 6;
 		Catalogs criteria = CommonUtils.toBean(request.getParameterMap(), Catalogs.class);
 		System.out.println(getUrl(request));
 		
 		PageBean<Catalogs> pb = cataService.query(criteria,pc,ps);
 		System.out.println("111");
 		pb.setUrl(getUrl(request));
 		request.setAttribute("pb", pb);
		logger.addLogs(4, "分类", userinfo.getAid());
 		return "f:/admin/catalogs/catalogsList.jsp";
 	}
 	

}
