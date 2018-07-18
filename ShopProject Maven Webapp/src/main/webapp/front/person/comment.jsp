<%@page import="com.legendary.entity.CommentHelper"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">
	<title>发表评论</title>
	<link href="/front/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
	<link href="/front/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">
	<link href="/front/css/personal.css" rel="stylesheet" type="text/css">
	<link href="/front/css/appstyle.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="/front/js/jquery-1.7.2.min.js"></script>
	</head>

	<body>
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
								<li class="index"><a href="#">首页</a></li>
                                <li class="qc"><a href="#">闪购</a></li>
                                <li class="qc"><a href="#">限时抢</a></li>
                                <li class="qc"><a href="#">团购</a></li>
                                <li class="qc last"><a href="#">大包装</a></li>
							</ul>
						    <div class="nav-extra">
						    	<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
						    	<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
						    </div>
						</div>
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="user-comment">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">发表评论</strong> / <small>Make&nbsp;Comments</small></div>
						</div>
						<hr/>

						<div class="comment-main">

						<form action="/CommentServlet" method="post">
						<input type="hidden" name="method" value="add"/>
						<input type="hidden" name="oid" value="${oid }"/>
						<input type="hidden" name="meid" value="${session_memb.meid }"/>
						<c:forEach items="${comments }" var="item" varStatus="status">
							<div class="comment-list">
								<div class="item-pic">
									<a href="#" class="J_MakePoint">
										<img src="${item.picinfo }" class="itempic">
									</a>
								</div>

								<div class="item-title">

									<div class="item-name">
										<a href="#">
											<p class="item-basic-info">${item.gname }</p>
										</a>
									</div>
									<div class="item-info">
										<div class="info-little">
											<span>${item.specdetail }</span>
										</div>
										<div class="item-price">
											价格：<strong>${item.sellPrice }元</strong>
										</div>										
									</div>
								</div>
								<div class="clear"></div>
								<div class="item-comment">
									<textarea name="content${status.index }" placeholder="请写下对宝贝的感受吧，对他人帮助很大哦！"></textarea>
								</div>
								<div class="item-opinion">
									<li><i class="op1 active" select="1"></i>好评</li>
									<li><i class="op2" select="2"></i>中评</li>
									<li><i class="op3" select="3"></i>差评</li>
									<input class="op" type="hidden" name="op${status.index }" value="1" />
									<input type="hidden" name="gid${status.index }" value="${item.gid }"/>
								</div>
							</div>
							</c:forEach>
							<div class="info-btn">
								<input type="hidden" name="size" value="${comments.size() }"/>
								<div class="am-btn am-btn-danger">发表评论</div>
							</div>
						</form>					
					<script type="text/javascript">
						$(document).ready(function() {
							$(".comment-list .item-opinion li").click(function() {	
								$(this).prevAll().children('i').removeClass("active");
								$(this).nextAll().children('i').removeClass("active");
								$(this).children('i').addClass("active");
								var t = $(this).children('i').attr("select");
								$(this).parent().find(".op").val(t)
							});
							
							$(".info-btn").click(function() {
								$("form").submit();
							});
				     	})
					</script>	
						</div>
					</div>

				</div>
				
			</div>

			<aside class="menu">
				<ul>
					<li class="person">
						<a href="index.html">个人中心</a>
					</li>
					<li class="person">
						<a href="#">个人资料</a>
						<ul>
							<li><a href="/MemberServlet?method=preEdit&meid=${session_memb.meid}" >个人信息</a> </li>
							<li><a href="/AddressServlet?method=query&meid=${session_memb.meid}">收货地址</a></li>
						</ul>
					</li>
					<li class="person">
						<a href="#">我的交易</a>
						<ul>
						<li><a href="/FrontOrderServlet?method=query&meid=${session_memb.meid}">订单管理</a></li>
						<li><a href="/FrontOrderServlet?method=returnQuery&meid=${session_memb.meid}">退款售后</a></li>
						</ul>
					</li>
				</ul>

			</aside>
		</div>

	</body>

</html>