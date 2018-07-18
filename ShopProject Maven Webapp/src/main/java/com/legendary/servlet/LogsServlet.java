package com.legendary.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.legendary.common.CommonUtils;
import com.legendary.entity.Goods;
import com.legendary.entity.Logs;
import com.legendary.entity.PageBean;
import com.legendary.service.LogService;

@WebServlet("/LogsServlet")
public class LogsServlet extends BaseServlet {
	LogService logService = new LogService();
	
	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pc = getpc(request);
 		int ps = 6;
 		Logs criteria = CommonUtils.toBean(request.getParameterMap(), Logs.class);
 		System.out.println(getUrl(request));
 		PageBean<Logs> pb = logService.query(criteria,pc,ps);
 		pb.setUrl(getUrl(request));
 		request.setAttribute("pb", pb);
 		return "f:/admin/log/userLogList.jsp";
	}
	
 	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		int id = Integer.parseInt(request.getParameter("id"));
 		logService.delete(id);
 		return "f:/LogsServlet?method=query";
 	}

}
