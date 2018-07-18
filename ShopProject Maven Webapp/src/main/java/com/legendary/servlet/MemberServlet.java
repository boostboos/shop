package com.legendary.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.legendary.common.CommonUtils;
import com.legendary.entity.Admins;
import com.legendary.entity.Members;
import com.legendary.entity.PageBean;
import com.legendary.service.MemberService;

@WebServlet("/MemberServlet")
public class MemberServlet extends BaseServlet {
	private MemberService memberService = new MemberService();
	
 	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members member = CommonUtils.toBean(request.getParameterMap(), Members.class);
		member.setCreateDate(new Date(new Date().getTime()));	
		request.setAttribute("msg", "添加成功");
		if(memberService.addMember(member))
		{
			response.getWriter().write("success");
		}
		else
		{
			response.getWriter().write("fail");
		}
		return null;
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
 		Members criteria = CommonUtils.toBean(request.getParameterMap(),Members.class);
 		System.out.println(getUrl(request));
 		PageBean<Members> pb = memberService.query(criteria,pc,ps);
 		pb.setUrl(getUrl(request));
 		request.setAttribute("pb", pb);
 		return "f:/admin/members/membersList.jsp";
 	}
	public String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Members member = CommonUtils.toBean(request.getParameterMap(),Members.class);
 		System.out.println(member.toString());
 		if(memberService.find(member)!=null)
 		{
 			System.out.println("111");
 			response.getWriter().write("no");
 		}else {
 			response.getWriter().write("yes");
		}
 		return null;
 	}
 	
 	public String preEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
 		if(userinfo == null) {
 			return "r:/front/user/login.jsp";
 		}
 		int meid = Integer.parseInt(request.getParameter("meid"));
 		Members member = memberService.load(meid);
 		request.setAttribute("member", member);
 		return "f:/front/user/information.jsp";
 	}
 	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
 		if(userinfo == null) {
 			return "r:/front/user/login.jsp";
 		}
 		Members member = CommonUtils.toBean(request.getParameterMap(), Members.class);
 		System.out.println(member);
 		memberService.edit(member);
 		request.setAttribute("msg", "修改成功");
 		return "f:/MemberServlet?method=preEdit";
 	}
 	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		int meid = Integer.parseInt(request.getParameter("meid"));
 		memberService.delete(meid);
 		Members userinfo = (Members) request.getSession().getAttribute("session_user");
 		return "f:/MemberServlet?method=query";
 	}
 	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		String userlogin=request.getParameter("login");
 		if("login".equals(userlogin))
 		{
			Members member = CommonUtils.toBean(request.getParameterMap(),Members.class);
 	 		System.out.println(member);
 	 		member = memberService.login(member);
 	 		if(member != null) {
	 			request.getSession().setAttribute("session_memb", member);
	 			response.getWriter().write("success");
 	 		}else {	 			
 	 			response.getWriter().write("fail");
 	 		}
 		}
 		else if("out".equals(userlogin)){		
 	 		HttpSession session=request.getSession();
 			session.invalidate();
 			response.getWriter().write("fail");
 	 	}
 		else{
 			response.getWriter().write("fail");
 		}
 	}


}
