package com.legendary.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.legendary.common.CommonUtils;
import com.legendary.entity.Admins;
import com.legendary.entity.GoodsDetail;
import com.legendary.entity.Logs;
import com.legendary.entity.PageBean;
import com.legendary.entity.Picinfos;
import com.legendary.service.PictureService;
import com.mysql.jdbc.PingTarget;

@WebServlet("/PicinfosServlet")
@MultipartConfig
public class PicinfosServlet extends BaseServlet{
	PictureService pictureService = new PictureService();
	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
		if(userinfo == null) {
			return "r:/admin/index.jsp";
		}
		int pc = getpc(request);
 		int ps = 6;
 		Picinfos criteria = CommonUtils.toBean(request.getParameterMap(), Picinfos.class);
 		System.out.println(getUrl(request));
 		PageBean<Picinfos> pb = pictureService.query(criteria,pc,ps);
 		pb.setUrl(getUrl(request));
 		request.setAttribute("pb", pb);
 		return "f:/admin/goodsDetail/picList.jsp";
	}
	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
		if(userinfo == null) {
			return "r:/admin/index.jsp";
		}
		String pid = request.getParameter("pid");
		pictureService.delete(pid);
 		
 		return "f:/PicinfosServlet?method=query";
	}

}
