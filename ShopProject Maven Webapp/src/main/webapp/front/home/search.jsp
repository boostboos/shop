<%@page import="com.legendary.entity.GoodsDetail"%>
<%@page import="com.legendary.service.GoodsDetailService"%>
<%@page import="com.legendary.entity.Picinfos"%>
<%@page import="com.legendary.service.PictureService"%>
<%@page import="com.legendary.entity.Goods"%>
<%@page import="com.legendary.entity.PageBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8">
		<title>商品管理</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">  
		<title>搜索页面</title>
		<link href="/front/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="/front/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="/front/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="/front/css/seastyle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="/front/basic/js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="/front/js/script.js"></script>
  	</head>
	<body>
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<c:if test="${session_memb == null }">
							<a href="/front/user/login.jsp" target="_top" class="h">亲，请登录</a> 
							<a href="/front/user/login.jsp" target="_top">免费注册</a>
						</c:if>
						<c:if test="${session_memb != null }">
							<a href="#" target="_top" class="h">欢迎您:${session_memb.username }</a>
						</c:if>
					</div>
				</div>
			</ul>
		<ul class="message-r">
			<div class="topMessage home"><div class="menu-hd"><a href="/front/home/home.jsp" target="_top" class="h">商城首页</a></div></div>
			<div class="topMessage my-shangcheng"><div class="menu-hd MyShangcheng"><a href="/front/user/index.jsp" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div></div>
			<div class="topMessage mini-cart"><div class="menu-hd"><a id="mc-menu-hd" href="/GoodsCartServlet?method=query&meid=${session_memb.meid }" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span></a></div></div>
		</ul>
		</div>
		<div class="nav white">
			<div class="logo"><img src="/front/images/logo.png" /></div>
			<div class="logoBig">
				<li><img src="/front/images/logobig.png" /></li>
			</div>
			<div class="search-bar pr">
				<a name="index_none_header_sysc" href="#"></a>
				<form action="/FrontGoodsServlet" method="post" >
					<input type="hidden" name="method" value="query"/>
					<input id="searchInput" name="keyword" type="text" placeholder="搜索" autocomplete="off">
					<input id="ai-topsearch" class="submit am-btn"  value="搜索" index="1" type="submit">
				</form>
			</div>
		</div>
		<div class="clear"></div>
		<b class="line"></b>
          	<div class="search">
			<div class="search-list">
				<div class="nav-table">
					<div class="long-title"><span class="all-goods">全部分类</span></div>
			   		<div class="nav-cont">
						<ul>
							<li class="index"><a href="/front/home/home.jsp">首页</a></li>
						</ul>
					</div>
				</div>
				<div class="am-g am-g-fixed">
					<div class="am-u-sm-12 am-u-md-12">
						<div class="theme-popover">		
							<ul class="select">
								<p class="title font-normal">
									<span class="total fl">搜索到<strong class="num">${pb.totalRecord }</strong>件相关商品</span>
								</p>
								<div class="clear"></div>
								<li class="select-list">
								<%
									String[] infos = request.getAttribute("cataInfo").toString().split(";");
									for(int i = 0; i < infos.length;i++) {
										String[] subinfos = infos[i].split(",");
										out.write("<dl id=\"select"+(i+1)+"\">");
										out.write("<dt class=\"am-badge am-round\">"+subinfos[0]+"</dt>");
										out.write("<div class=\"dd-conent\">");
										
										for(int j = 1; j < subinfos.length;j++) {
											out.write("<dd><a href=\"/FrontGoodsServlet?method=query&keyword="+subinfos[j]+"\">"+subinfos[j]+"</a></dd>");
										}
										out.write("</div></dl>");
									}
								%>
										
								</li>
							</ul>
							<div class="clear"></div>
						</div>
						<div class="search-content">
							<div class="sort">
								<li class="first"><a title="综合">综合排序</a></li>
								<li><a title="销量">销量排序</a></li>
								<li><a title="价格">价格优先</a></li>
								<li class="big"><a title="评价" href="#">评价为主</a></li>
							</div>
							<div class="clear"></div>
							<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
								
								<%
									PageBean<Goods> pb = (PageBean<Goods>)request.getAttribute("pb");
									PictureService pictureService = new PictureService();
									GoodsDetailService gds = new GoodsDetailService();
									List<Goods> goods = pb.getBeanList();
									for(int i = 0; i < goods.size(); i++) {
										Goods good = goods.get(i);
										int gid = good.getGid();
										List<GoodsDetail> gdlist = gds.findAll(gid);
										double price = gdlist.get(0).getSellprice().doubleValue();
										for(GoodsDetail gd : gdlist) {
											if(gd.getSellprice().doubleValue() < price)
												price = gd.getSellprice().doubleValue();
										}
									 	Picinfos picinfo = pictureService.findAllByGid(gid).get(0);
									 	out.write("<li><a href=\"/front/home/introduction.jsp?gid="+gid+"\" >");
									 	out.write("<div class=\"i-pic limit\">");
									 	out.write("<img src=\""+picinfo.getPicinfo()+"\" />");
									 	out.write("<p class=\"title fl\">"+good.getGname()+"</p>");
									 	out.write("<p class=\"price fl\">");
									 	out.write("<b>¥</b>");
									 	out.write("<strong>"+price+"</strong>");
									 	out.write("</p>");
									 	out.write("<p class=\"number fl\">");
									 	out.write("销量<span>"+good.getSales()+"</span>");
									 	out.write("</p>");
									 	out.write("</div></a></li>");
									}
								%>
								
							</ul>
						</div>
						
						<div class="clear"></div>
						<!--分页 -->

					</div>
				</div>
			</div>
		</div>
	</body>
</html>
