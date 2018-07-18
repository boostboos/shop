package com.legendary.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.legendary.common.CommonUtils;
import com.legendary.entity.Admins;
import com.legendary.entity.PageBean;
import com.legendary.service.AdminService;

@WebServlet("/AdminServlet")
public class AdminServlet extends BaseServlet {
 	private AdminService adminService = new AdminService();	
 	
 	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		Admins admin = CommonUtils.toBean(request.getParameterMap(), Admins.class);
		adminService.addAdmin(admin);
		request.setAttribute("msg", "添加成功");
		logger.addLogs(1, "用户", userinfo.getAid());
		return "r:/AdminServlet?method=query";
	}
 	public String preEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		int aid = Integer.parseInt(request.getParameter("aid"));
 		Admins admin = adminService.load(aid);
 		request.setAttribute("admin", admin);
 		return "f:/admin/admin/editAdmin.jsp";
 	}
 	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		Admins admin = CommonUtils.toBean(request.getParameterMap(), Admins.class);
 		System.out.println(admin);
 		adminService.edit(admin);
 		request.setAttribute("msg", "修改成功");
 		return "r:/AdminServlet?method=query";
 	}
 	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		int aid = Integer.parseInt(request.getParameter("aid"));
 		adminService.delete(aid);
 		String pc = request.getParameter("pc");
 		return "f:/AdminServlet?method=query&pc="+pc;
 	}
 	
 	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins admin = CommonUtils.toBean(request.getParameterMap(), Admins.class);
 		System.out.println(admin);
 		admin = adminService.login(admin);
 		String verfiyCode = request.getParameter("verfiyCode");
 		String vCode = (String) request.getSession().getAttribute("vCode");
 		System.out.println(verfiyCode);
 		System.out.println(vCode);
 		if(admin != null && vCode.equalsIgnoreCase(verfiyCode)) {
 			request.getSession().setAttribute("session_user", admin);
 			return "f:/admin/index.jsp";
 		}else {
 			return "r:/index.jsp";
 		}
 	}
 	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		int pc = getpc(request);
 		int ps = 6;
 		Admins criteria = CommonUtils.toBean(request.getParameterMap(), Admins.class);
 		System.out.println(getUrl(request));
 		PageBean<Admins> pb = adminService.query(criteria,pc,ps);
 		pb.setUrl(getUrl(request));
 		request.setAttribute("pb", pb);
 		return "f:/admin/admin/adminList.jsp";
 	}
}
