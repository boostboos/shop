package com.legendary.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.legendary.common.CommonUtils;
import com.legendary.entity.Address;
import com.legendary.entity.Admins;
import com.legendary.entity.Members;
import com.legendary.entity.PageBean;
import com.legendary.service.AddressService;

@WebServlet("/AddressServlet")
public class AddressServlet extends BaseServlet {
	private AddressService addressService = new AddressService();	
	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		System.out.println("添加前");
		Address address = CommonUtils.toBean(request.getParameterMap(), Address.class);
		addressService.addAddress(address);
		request.setAttribute("msg", "添加成功");
		Integer meid=address.getMeid();
		return "r:/AddressServlet?method=query&meid="+meid;
	}
	


	
	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		Address criteria = CommonUtils.toBean(request.getParameterMap(), Address.class);
 		List<Address> addressList = addressService.query(criteria.getMeid());
 		System.out.println(criteria+"123");
 		System.out.println(addressList);
 		request.setAttribute("addressList", addressList);
 		return "f:/front/person/address.jsp";
 		
 		
 	}
	
	public String preEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		int aid = Integer.parseInt(request.getParameter("aid"));
 		int meid = Integer.parseInt(request.getParameter("meid"));
 		Address address = addressService.load(aid);
 		request.setAttribute("address", address);
 		return "f:/front/person/editAddress.jsp";
 	}
	
	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		Address address = CommonUtils.toBean(request.getParameterMap(), Address.class);
 		System.out.println(address);
 		System.out.println(address.getAid());
 		System.out.println(address.getMeid());
 		System.out.println(address.getAddressinfo());
 		System.out.println(address.getReceivername());
 		System.out.println(address.getReceivername());
 		System.out.println(address.getDefaddress());
 		addressService.edit(address);
 		request.setAttribute("msg", "修改成功");
 		return "r:/AddressServlet?method=query&meid="+address.getMeid();
 	}
	
	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Members userinfo =(Members)request.getSession().getAttribute("session_memb");
		if(userinfo == null) {
			return "r:/front/user/login.jsp";
		}
		int aid = Integer.parseInt(request.getParameter("aid"));
 		addressService.delete(aid);
 		String pc = request.getParameter("pc");
 		return "f:/AddressServlet?method=query";
 	}
	
}
