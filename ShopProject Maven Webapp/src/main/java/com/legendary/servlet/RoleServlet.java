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
import com.legendary.entity.Roles;
import com.legendary.service.RoleService;

@WebServlet("/RoleServlet")
public class RoleServlet extends BaseServlet {
	RoleService roleService = new RoleService();
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
		if(userinfo == null) {
			return "r:/admin/index.jsp";
		}
		Roles role = CommonUtils.toBean(request.getParameterMap(), Roles.class);
		roleService.addRole(role);
		request.setAttribute("msg", "添加成功");
		logger.addLogs(1, "角色", userinfo.getAid());
		return "r:/RoleServlet?method=query";
	}
 	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		int pc = getpc(request);
 		int ps = 6;
 		System.out.println(getUrl(request));
 		System.out.println(pc+" :pc  ps: "+ps);
 		PageBean<Roles> pb = roleService.query(pc,ps);
 		System.out.println("...");
 		pb.setUrl(getUrl(request));
 		request.setAttribute("pb", pb);
 		List<Roles> roles = pb.getBeanList();
 		for (Roles ro : roles) {
			System.out.print(ro.toString()+" ");
		}
		logger.addLogs(4, "角色", userinfo.getAid());
 		return "f:/admin/role/roleList.jsp";
 	}
 	public String preEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		int rid = Integer.parseInt(request.getParameter("rid"));
 		Roles role = roleService.load(rid);
 		System.out.println(role);
 		request.setAttribute("role", role);
 		return "f:/admin/role/editRole.jsp";
 	}
 	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		Roles role = CommonUtils.toBean(request.getParameterMap(), Roles.class);
 		System.out.println(role);
 		roleService.edit(role);
 		request.setAttribute("msg", "修改成功");
		logger.addLogs(3, "角色", userinfo.getAid());
 		return "r:/RoleServlet?method=query";
 	}
 	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
 		if(userinfo == null) {
 			return "r:/admin/index.jsp";
 		}
 		int rid = Integer.parseInt(request.getParameter("rid"));
 		roleService.delete(rid);
		logger.addLogs(2, "角色", userinfo.getAid());
 		return "f:/RoleServlet?method=query";
 	}

}
