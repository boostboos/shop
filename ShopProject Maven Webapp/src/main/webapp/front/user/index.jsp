<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>个人中心</title>

		<link href="/front/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="/front/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">
		<link href="/front/css/personal.css" rel="stylesheet" type="text/css">
		<link href="/front/css/systyle.css" rel="stylesheet" type="text/css">

	</head>

	<body>
		<!--头 -->
		<header>
			<article>
				<div class="mt-logo">
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
				</div>
			</article>
		</header>
            <div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="/front/home/home.jsp">首页</a></li>
							</ul>
						</div>	
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">
					<div class="wrap-left">
						<div class="wrap-list">
							<div class="m-user">
								<!--个人信息 -->
								<div class="m-bg"></div>
								<div class="m-userinfo">
									<div class="m-baseinfo">
										<a href="information.html">
											<img src="/front/images/getAvatar.do.jpg">
										</a>
										<em class="s-name">${session_memb.username }<span class="vip1"></em>
										<div class="s-prestige am-btn am-round">
											</span>会员福利</div>
									</div>
									<div class="m-right">
										<div class="m-new">
											<a href="news.html"><i class="am-icon-bell-o"></i>消息</a>
										</div>
										<div class="m-address">
											<a href="/AddressServlet?method=query&meid=${session_memb.meid}" class="i-trigger">我的收货地址</a>
										</div>
									</div>
								</div>

							</div>
							<div class="box-container-bottom"></div>

							<!--订单 -->
							<div class="m-order">
								<div class="s-bar">
									<i class="s-icon"></i>我的订单
									<a class="i-load-more-item-shadow" href="order.html">全部订单</a>
								</div>
								<ul>
									<li><a href="order.html"><i><img src="/front/images/pay.png"/></i><span>待付款</span></a></li>
									<li><a href="order.html"><i><img src="/front/images/send.png"/></i><span>待发货<em class="m-num">1</em></span></a></li>
									<li><a href="order.html"><i><img src="/front/images/receive.png"/></i><span>待收货</span></a></li>
									<li><a href="order.html"><i><img src="/front/images/comment.png"/></i><span>待评价<em class="m-num">3</em></span></a></li>
									<li><a href="change.html"><i><img src="/front/images/refund.png"/></i><span>退换货</span></a></li>
								</ul>
							</div>

						</div>
					</div>
					<div class="wrap-right">

						<!-- 日历-->
						<div class="day-list">
							<div class="s-bar">
								<a class="i-history-trigger s-icon" href="#"></a>我的日历
								<a class="i-setting-trigger s-icon" href="#"></a>
							</div>
							<div class="s-care s-care-noweather">
								<div class="s-date">
									<em>21</em>
									<span>星期一</span>
									<span>2015.12</span>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

			<aside class="menu">
			<ul>
				<li class="person active"><a href="index.html">个人中心</a></li>
				<li class="person"><a href="#"><strong>个人资料</strong></a>
					<ul>
						<li><a href="/MemberServlet?method=preEdit&meid=${session_memb.meid}" >个人信息</a> </li>
						<li><a href="/AddressServlet?method=query&meid=${session_memb.meid}">收货地址</a></li>
					</ul>
				</li>
				<li class="person"><a href="#">我的交易</a>
					<ul>
						<li><a href="/FrontOrderServlet?method=query&meid=${session_memb.meid}">订单管理</a></li>
						<li><a href="/FrontOrderServlet?method=returnQuery&meid=${session_memb.meid}">退款售后</a></li>
					</ul>
				</li>
			</ul>
		</aside>
		</div>
		<!--引导 -->
		<div class="navCir">
			<li class="index"><a href="/front/home/home.jsp">首页</a></li>
		</div>
	</body>

</html>