<%@page import="com.legendary.entity.Address"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  <%
  	Address address = new Address();
  	List<Address> addList = new ArrayList<Address>();
  	address.setAid(1);
  	addList.add(address);
  	address.setAid(1);
  	addList.add(address);
  	request.setAttribute("addList", addList);
  %>

  <body>
	  <ul class="am-avg-sm-1 am-avg-md-3 am-thumbnails">
		<c:forEach items="${addList}" var="address">
			<c:if test="${address.aid == 0 }">
				<li class="user-addresslist ">
			</c:if>
			<c:if test="${address.aid == 1} ">
				<li class="user-addresslist defaultAddr">
			</c:if>
			<span class="new-option-r"><i class="am-icon-check-circle"></i>默认地址</span>
				<p class="new-tit new-p-re">
					<span class="new-txt">${address.aid}</span> <span
						class="new-txt-rd2">${address.aid}</span>
				</p>
				<div class="new-mu_l2a new-p-re">
					<p class="new-mu_l2cw">
						<span class="title">${address.aid}</span>
					</p>
				</div>
				<div class="new-addr-btn">
					<a href="/AddressServlet?method=preEdit&aid=${address.aid}&meid=${address.aid}" >
					<i class="am-icon-edit"></i>编辑</a> 
					<span class="new-addr-bar">|</span> 
					<a href="/AddressServlet?method=delete&aid=${address.aid }&meid=${address.aid} ">
					<i class="am-icon-trash"></i>删除</a>
				</div>
			</li>
		</c:forEach>
	</ul>
  </body>
</html>
