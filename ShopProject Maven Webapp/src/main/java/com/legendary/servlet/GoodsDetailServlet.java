package com.legendary.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.legendary.entity.Goods;
import com.legendary.entity.GoodsDetail;
import com.legendary.entity.PageBean;
import com.legendary.entity.Picinfos;
import com.legendary.entity.SpecificationDetail;
import com.legendary.entity.Specifications;
import com.legendary.service.GoodsDetailService;
import com.legendary.service.GoodsService;
import com.legendary.service.PictureService;
import com.legendary.service.SpecificationDetailService;
import com.legendary.service.SpecificationService;
@WebServlet("/GoodsDetailServlet")
@MultipartConfig
public class GoodsDetailServlet extends BaseServlet {
	private GoodsDetailService goodDetailService = new GoodsDetailService();	
	private PictureService pictureService = new PictureService();
		//添加商品
	 	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
			if(userinfo == null) {
				return "r:/admin/index.jsp";
			}
	 		String str = request.getParameter("btnSubmit");
	 		if(null!=str) {
	 			GoodsDetail goodsDetail = CommonUtils.toBean(request.getParameterMap(), GoodsDetail.class);
	 			return "r:/GoodsDetailServlet?method=query&gid="+goodsDetail.getGid();
	 		}
	 		Part part = request.getPart("picinfo");
	 		String headerInfo = part.getHeader("content-disposition");
	 		String fileName = headerInfo.substring(headerInfo.lastIndexOf("=") + 2, headerInfo.length() - 1);
	 		String ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());
	 		long filename=new Date().getTime();
	 		String fileSavingFolder = this.getServletContext().getRealPath("/admin/pictures");
	 		String fileSavingPath = fileSavingFolder + File.separator + filename+ ext ;
	 		File f=new File(fileSavingFolder+File.separator);
	 		if(!f.exists()){
	 			f.mkdirs();
	 		}
	 		part.write(fileSavingPath);
	 		System.out.println("文件上传成功");
	 		
	 		String gid = request.getParameter("gid");
	 		System.out.println("gid"+gid);
	 		GoodsDetail goodsDetail = CommonUtils.toBean(request.getParameterMap(), GoodsDetail.class);
			Picinfos picinfos = new Picinfos();
			goodsDetail.setPid(filename+"");
			picinfos.setPid(filename+"");
			picinfos.setPicinfo("/admin/pictures/"+filename+ ext);
			picinfos.setGid(goodsDetail.getGid());
			System.out.println(picinfos);
			pictureService.addPicinfo(picinfos);
			goodDetailService.addGoods(goodsDetail);
			request.setAttribute("msg", "添加成功");
			logger.addLogs(1, "货物详情", userinfo.getAid());
			return "r:/GoodsDetailServlet?method=query&gid="+goodsDetail.getGid();
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
	 		GoodsDetail criteria = CommonUtils.toBean(request.getParameterMap(), GoodsDetail.class);
	 		PageBean<GoodsDetail> pb = goodDetailService.query(criteria,pc,ps);
	 		pb.setUrl(getUrl(request));
	 		request.setAttribute("pb", pb);
	 		request.setAttribute("gid",request.getParameter("gid"));
			logger.addLogs(4, "货物详情", userinfo.getAid());
	 		return "f:/admin/goodsDetail/goodsDetailList.jsp?";
	 	}

	 	
	 	public String preEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
			if(userinfo == null) {
				return "r:/admin/index.jsp";
			}
	 		int gdid = Integer.parseInt(request.getParameter("gdid"));
	 		GoodsDetail goodsDetail = goodDetailService.load(gdid);
	 		PictureService pictureService = new PictureService();
	 		Picinfos picinfos = pictureService.load(goodsDetail.getPid());
	 		Map<String, List<String>> spec = getSpec();
	 		request.setAttribute("spec", spec);
	 		request.setAttribute("infos", picinfos.getPicinfo());
	 		request.setAttribute("goodsDetail", goodsDetail);
	 		return "f:/admin/goodsDetail/editGoodsDetail.jsp";
	 	}
	 	
	 	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
			if(userinfo == null) {
				return "r:/admin/index.jsp";
			}
	 		boolean hasPic = true;
	 		String ext = "";
	 		String str = request.getParameter("btnSubmit");
	 		if(null!=str) {
	 			GoodsDetail goodsDetail = CommonUtils.toBean(request.getParameterMap(), GoodsDetail.class);
	 			return "r:/GoodsDetailServlet?method=query&gid="+goodsDetail.getGid();
	 		}
	 		long filename=new Date().getTime();
	 		try {
	 			Part part = request.getPart("picinfo");
		 		String headerInfo = part.getHeader("content-disposition");
		 		String fileName = headerInfo.substring(headerInfo.lastIndexOf("=") + 2, headerInfo.length() - 1);
		 		ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		 		
		 		String fileSavingFolder = this.getServletContext().getRealPath("/admin/pictures");
		 		String fileSavingPath = fileSavingFolder + File.separator + filename+ ext ;
		 		File f=new File(fileSavingFolder+File.separator);
		 		if(!f.exists()){
		 			f.mkdirs();
		 		}
		 		part.write(fileSavingPath);
		 		System.out.println("文件上传成功");
	 		} catch (Exception e) {
	 			hasPic = false;
			}
	 		GoodsDetail goodsDetail = CommonUtils.toBean(request.getParameterMap(), GoodsDetail.class);
	 		if(hasPic) {
	 			goodsDetail.setPid(filename+"");
	 			Picinfos picinfos = new Picinfos();
	 			picinfos.setPid(filename+"");
				picinfos.setPicinfo("/admin/pictures/"+filename+ ext);
				picinfos.setGid(goodsDetail.getGid());
		 		pictureService.addPicinfo(picinfos);
	 		}
	 		goodDetailService.edit(goodsDetail);
	 		return "r:/GoodsDetailServlet?method=query&gid="+goodsDetail.getGid();
	 	}
	 	
	 	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
			if(userinfo == null) {
				return "r:/admin/index.jsp";
			}
	 		int gdid = Integer.parseInt(request.getParameter("gdid"));
	 		int gid = Integer.parseInt(request.getParameter("gid"));
	 		
	 		goodDetailService.delete(gdid);
			logger.addLogs(2, "货物详情", userinfo.getAid());
	 		return "f:/GoodsDetailServlet?method=query&gid="+gid;
	 	}
	 	
	 	
	 	
	 	private Map<String, List<String>> getSpec() {
	 		SpecificationDetailService sds = new SpecificationDetailService();
	 		SpecificationService ss = new SpecificationService();
	 		List<Specifications> sslist = ss.findAll();
	 		Map<String, List<String>> specMap = new HashMap<String, List<String>>();
	 		for (Specifications specifications : sslist) {
				int sid = specifications.getSid();
				String key = specifications.getSpecInfo();
		 		List<SpecificationDetail> sdslist = sds.findAll(sid);
		 		List<String> sdInfos = new ArrayList<String>();
				for (SpecificationDetail specificationDetail : sdslist) {
					sdInfos.add(specificationDetail.getSdname());
				}
				specMap.put(key, sdInfos);
			}
	 		return specMap;
	 	}
	 	
	 	public String preAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Admins userinfo = (Admins) request.getSession().getAttribute("session_user");
			if(userinfo == null) {
				return "r:/admin/index.jsp";
			}
	 		Map<String, List<String>> spec = getSpec();
	 		String gid = request.getParameter("gid");
	 		request.setAttribute("spec", spec);
	 		return "f:/admin/goodsDetail/addGoodsDetail.jsp?gid="+gid;
	 	}
}


