package com.legendary.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.legendary.common.CommonUtils;
import com.legendary.entity.Admins;
import com.legendary.entity.PageBean;
import com.legendary.entity.SubCatalogs;
import com.legendary.service.SubCatalogsService;

@WebServlet("/SubCatalogsServlet")
public class SubCatalogsServlet extends BaseServlet {
	private SubCatalogsService subCatalogsService = new SubCatalogsService();
	
	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
		if(userinfo == null) {
			return "r:/admin/index.jsp";
		}
		int pc = getpc(request);
 		int ps = 6;
 		SubCatalogs criteria = CommonUtils.toBean(request.getParameterMap(), SubCatalogs.class);
 		PageBean<SubCatalogs> pb = subCatalogsService.query(criteria,pc,ps);
 		pb.setUrl(getUrl(request));
 		request.setAttribute("pb", pb);
 		request.setAttribute("cid",request.getParameter("cid"));
		logger.addLogs(4, "子类", userinfo.getAid());
		
 		return "f:/admin/subCatalogs/subCatalogsList.jsp";
 	}

	public String preEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
		if(userinfo == null) {
			return "r:/admin/index.jsp";
		}
		int scid = Integer.parseInt(request.getParameter("scid"));
 		SubCatalogs subCatalogs = subCatalogsService.load(scid);
 		request.setAttribute("subCatalogs", subCatalogs);
 		return "f:/admin/subCatalogs/editSubCatalogs.jsp";
 	}

	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
		if(userinfo == null) {
			return "r:/admin/index.jsp";
		}
		SubCatalogs subCatalogs = CommonUtils.toBean(request.getParameterMap(), SubCatalogs.class);
 		System.out.println("admin"+subCatalogs);
 		subCatalogsService.edit(subCatalogs);
 		request.setAttribute("msg", "修改成功");
		logger.addLogs(3, "子类", userinfo.getAid());
		
 		return "r:/SubCatalogsServlet?method=query&cid="+subCatalogs.getCid();
		
 	}

	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
		if(userinfo == null) {
			return "r:/admin/index.jsp";
		}
		int scid = Integer.parseInt(request.getParameter("scid"));
 		int cid = Integer.parseInt(request.getParameter("cid"));
 		subCatalogsService.delete(scid);
		logger.addLogs(2, "子类", userinfo.getAid());
		
 		return "f:/SubCatalogsServlet?method=query&cid="+cid;
 	}
	
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
		if(userinfo == null) {
			return "r:/admin/index.jsp";
		}
		SubCatalogs subCatalogs = CommonUtils.toBean(request.getParameterMap(), SubCatalogs.class);
		subCatalogsService.add(subCatalogs);
		String cid = request.getParameter("cid");
		System.out.println(subCatalogs);
		request.setAttribute("msg", "添加成功");
		logger.addLogs(1, "子类", userinfo.getAid());
		return "r:/SubCatalogsServlet?method=query&cid="+cid;
	}
	

}
