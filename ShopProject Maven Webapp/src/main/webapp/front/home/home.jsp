<%@page import="com.legendary.service.PictureService"%>
<%@page import="com.legendary.entity.Picinfos"%>
<%@page import="com.legendary.service.GoodsDetailService"%>
<%@page import="com.legendary.entity.GoodsDetail"%>
<%@page import="com.legendary.entity.Goods"%>
<%@page import="com.legendary.service.GoodsService"%>
<%@page import="com.legendary.entity.SubCatalogs"%>
<%@page import="com.legendary.entity.Catalogs"%>
<%@page import="com.legendary.service.SubCatalogsService"%>
<%@page import="com.legendary.service.CataService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>


<html lang="zh-CN">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<title>首页</title>

		<link href="/front/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="/front/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />

		<link href="/front/basic/css/demo.css" rel="stylesheet" type="text/css" />

		<link href="/front/css/hmstyle.css" rel="stylesheet" type="text/css"/>
		<link href="/front/css/skin.css" rel="stylesheet" type="text/css" />
		<script src="/front/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="/front/AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

	</head>

	<body>
		<div class="hmtop">
			<!--顶部导航条 -->
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

				<!--悬浮搜索框-->

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
			</div>
			<div class="banner">
                      <!--轮播 -->
						<div class="am-slider am-slider-default scoll" data-am-flexslider id="demo-slider-0">
							<ul class="am-slides">
								<li class="banner1"><a><img src="/front/images/ad1.png" /></a></li>
								<li class="banner2"><a><img src="/front/images/ad2.png" /></a></li>
							</ul>
						</div>
						<div class="clear"></div>	
			</div>
			<div class="shopNav">
				<div class="slideall">
					
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
						 <div class="nav-cont">
							<ul>
								<li class="index"><a href="/front/home/home.jsp">首页</a></li>
							</ul>
						</div>			
		        				
						<!--侧边导航 -->
						<div id="nav" class="navfull">
							<div class="area clearfix">
								<div class="category-content" id="guide_2">
									
									<div class="category">
										<ul class="category-list" id="js_climit_li">
										<%
											CataService cs = new CataService();
											SubCatalogsService scs = new SubCatalogsService();
											List<Catalogs> catalist = cs.findAll();
											for(Catalogs cata:catalist) {
												out.print("<li class=\"appliance js_toggle relative\">");
												out.print("<div class=\"category-info\">");
												out.print("<h3 class=\"category-name b-category-name\"><i><img src=\"/front/images/package.png\"></i>");
												out.print("<a class=\"ml-22\" title=\""+cata.getCatalogName()+"\">"+cata.getCatalogName()+"</a></h3>");
												out.print("<em>&gt;</em></div>");
												out.print("<div class=\"menu-item menu-in top\">");
												out.print("<div class=\"area-in\">");
												out.print("<div class=\"area-bg\">");
												out.print("<div class=\"menu-srot\">");
												out.print("<div class=\"sort-side\">");
												List<SubCatalogs> subCatalogs = scs.findAllByCid(cata.getCid());
												for(SubCatalogs subCata:subCatalogs) {
													String[] scds = subCata.getSubcata().split(",");
													out.print("<dl class=\"dl-sort\">");
													out.print("<dt><span title=\""+subCata.getScname()+"\">"+subCata.getScname()+"</span></dt>");
													
													for(String scd:scds) {
													out.print("<dd><a title=\""+scd+"\" href=\"/FrontGoodsServlet?method=query&keyword="+scd+"\"><span>"+scd+"</span></a></dd>");
													}
													out.print("</dl>");
												}
												out.print("</div></div></div></div></div><b class=\"arrow\"></b></li>");
											}
					%>
										</ul>
									</div>
								</div>

							</div>
						</div>
						
						
						<!--轮播-->
						
						<script type="text/javascript">
							(function() {
								$('.am-slider').flexslider();
							});
							$(document).ready(function() {
								$("li").hover(function() {
									$(".category-content .category-list li.first .menu-in").css("display", "none");
									$(".category-content .category-list li.first").removeClass("hover");
									$(this).addClass("hover");
									$(this).children("div.menu-in").css("display", "block")
								}, function() {
									$(this).removeClass("hover")
									$(this).children("div.menu-in").css("display", "none")
								});
							})
						</script>
				</div>
				<script type="text/javascript">
					if ($(window).width() < 640) {
						function autoScroll(obj) {
							$(obj).find("ul").animate({
								marginTop: "-39px"
							}, 500, function() {
								$(this).css({
									marginTop: "0px"
								}).find("li:first").appendTo(this);
							})
						}
						$(function() {
							setInterval('autoScroll(".demo")', 3000);
						})
					}
				</script>
			</div>
			<div class="shopMainbg">
				<div class="shopMain" id="shopmain">
				<%
				int cnt = 0;
				GoodsDetailService gds = new GoodsDetailService();
				GoodsService gs = new GoodsService();
				PictureService ps = new PictureService();
					for(Catalogs cl : catalist) {
						cnt++;
						out.write("<div id=\"f"+cnt+"\">");
						out.write("<div class=\"am-container \">");
						out.write("<div class=\"shopTitle \">");
						out.write("<h4>"+cl.getCatalogName()+"</h4>");
						out.write("<h3>每一本书都有一个故事</h3>");
						out.write("</div></div>");
						out.write("<div class=\"am-g am-g-fixed floodFour\">");
						out.write("<div class=\"am-u-sm-5 am-u-md-4 text-one list \">");
						out.write("<div class=\"word\">");
						List<SubCatalogs> scl = scs.findAllByCid(cl.getCid());
						for(SubCatalogs sc : scl ) {
							out.write("<a class=\"outer\" href=\"/FrontGoodsServlet?method=query&keyword="+sc.getScname()+"\"><span class=\"inner\"><b class=\"text\">"+sc.getScname()+"</b></span></a>");
						}
						out.write("</div>");
						out.write("<a href=\"# \">");
						out.write("<div class=\"outer-con \">");
						out.write("<div class=\"title \">开抢啦</div>");
						out.write("<div class=\"sub-title \">"+cl.getCatalogName()+"类书籍大礼包</div></div>");
						out.write("<img src=\"/front/images/act1.jpg \" /></a>");
						out.write("<div class=\"triangle-topright\"></div></div>");
						
						List<Goods> gl = gs.findAll();
						
						for(Goods g : gl) {
							List<SubCatalogs> sclist = scs.findAllByCid(cl.getCid());
							List<Picinfos> piclist = ps.findAllByGid(g.getGid());
							for(SubCatalogs sc : sclist) {
								if(g.getKeyword().contains(sc.getScname())) {
									out.write("<div class=\"am-u-sm-7 am-u-md-4 text-two\">");
									out.write("<div class=\"outer-con \">");
									out.write("<div class=\"title \">"+g.getGname()+"</div>");
									out.write("<div class=\"sub-title \">"+g.getSales()+"</div>");
									out.write("<i class=\"am-icon-shopping-basket am-icon-md  seprate\"></i></div>");
									out.write("<a href=\"/front/home/introduction.jsp?gid="+g.getGid()+" \"><img src=\""+piclist.get(0).getPicinfo()+"\" /></a></div>");
									break;
								}
							}
						}
						out.write("<div class=\"clear \"></div></div> ");
					}
				%>
				</div>
			</div>
			<div class="clear "></div>
		<script>
			window.jQuery || document.write('<script src="basic/js/jquery.min.js "><\/script>');
		</script>
		<script type="text/javascript " src="/front/basic/js/quick_links.js "></script>
	</body>

</html>