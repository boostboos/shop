package com.legendary.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.legendary.entity.CommentHelper;
import com.legendary.entity.Comments;
import com.legendary.entity.Members;
import com.legendary.entity.OrderDetail;
import com.legendary.entity.Orders;
import com.legendary.service.CommentService;
import com.legendary.service.GoodsDetailService;
import com.legendary.service.OrderDetailService;
import com.legendary.service.OrderService;

@WebServlet("/CommentServlet")
public class CommentServlet extends BaseServlet {
	private CommentService cs = new CommentService();
	OrderService os = new OrderService();
	public String preAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		String oid = request.getParameter("oid");
		List<CommentHelper> commentHelpers = cs.find(oid);
		System.out.println("commentHelpers"+commentHelpers);
		request.setAttribute("comments", commentHelpers);
		request.setAttribute("oid", oid);
		return "f:/front/person/comment.jsp";
	}
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		int size = Integer.parseInt(request.getParameter("size"));
		int meid = Integer.parseInt(request.getParameter("meid"));
		String oid = request.getParameter("oid");
		Orders order = os.load(oid);
		order.setState(8);
		os.edit(order);
		Comments comment = new Comments();
		for (int i = 0; i < size; i++) {
			String op = request.getParameter("op"+i);
			String content = request.getParameter("content"+i);
			comment.setGid(Integer.parseInt(request.getParameter("gid"+i)));
			comment.setInfo(content);
			comment.setMeid(meid);
			comment.setRank(Integer.parseInt(op));
			cs.add(comment);
		}
		return "f:/front/user/index.jsp";
	}
	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "";
	}

}
