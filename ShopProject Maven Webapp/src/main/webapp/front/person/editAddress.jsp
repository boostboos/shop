<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

<title>地址管理</title>

<link href="/front/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css">
<link href="/front/AmazeUI-2.4.2/assets/css/amazeui.css"
	rel="stylesheet" type="text/css">

<link href="/front/css/personal.css" rel="stylesheet" type="text/css">
<link href="/front/css/addstyle.css" rel="stylesheet" type="text/css">
<script src="/front/AmazeUI-2.4.2/assets/js/jquery.min.js"
	type="text/javascript"></script>
<script src="/front/AmazeUI-2.4.2/assets/js/amazeui.js"></script>

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
					<ul class="message-r">
						<div class="topMessage home"><div class="menu-hd"><a href="/front/home/home.jsp" target="_top" class="h">商城首页</a></div></div>
						<div class="topMessage my-shangcheng"><div class="menu-hd MyShangcheng"><a href="/front/user/index.jsp" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div></div>
						<div class="topMessage mini-cart"><div class="menu-hd"><a id="mc-menu-hd" href="/GoodsCartServlet?method=query&meid=${session_memb.meid }" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span></a></div></div>
					</ul>
				</div>

				<!--悬浮搜索框-->

				<div class="nav white">
					<div class="logoBig">
						<li><img src="../images/logobig.png" /></li>
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
		<div class="long-title">
			<span class="all-goods">全部分类</span>
		</div>
		<div class="nav-cont">
			<ul>
				<li class="index"><a href="#">首页</a></li>
				<li class="qc"><a href="#">闪购</a></li>
				<li class="qc"><a href="#">限时抢</a></li>
				<li class="qc"><a href="#">团购</a></li>
			</ul>
		</div>
	</div>
	<b class="line"></b>
	<div class="center">
		<div class="col-main">
			<div class="main-wrap">
				<div class="user-address">
					<!--例子-->
					<div class="am-modal am-modal-no-btn" id="doc-modal-1">
						<div class="edit-dress" id="edit-dress">	
							<div class="am-u-md-12 am-u-lg-8" style="margin-top: 20px;">
								<form  action="/AddressServlet?meid=${address.meid}" class="am-form am-form-horizontal">
									<input type="hidden" name="method" value="edit" /> 
									<input type="hidden" name="aid" value="${address.aid }" />
									<input type="hidden" name="meid" value="${address.meid }" />
									<div class="am-form-group">
										<label for="user-name" class="am-form-label">收货人</label>
										<div class="am-form-content">
											<input type="text" id="user-name" name="receivername"
												value="${address.receivername}" placeholder="${address.receivername}">
										</div>
									</div>
									<div class="am-form-group">
										<label for="user-phone" class="am-form-label">手机号码</label>
										<div class="am-form-content">
											<input id="user-phone" name="receiverphone"
											value="${address.receiverphone}" placeholder="${address.receiverphone}" type="text">
										</div>
									</div>
									<div class="am-form-group">
										<label for="user-intro" class="am-form-label">详细地址</label>
										<div class="am-form-content">
											<textarea class="" rows="3" id="user-intro"
												name="addressinfo"  placeholder="${address.addressinfo }">${address.addressinfo}</textarea>
											<small>100字以内写出你的详细地址...</small>
										</div>
									</div>

									<div class="am-form-group">
										<div class="am-u-sm-9 am-u-sm-push-3">
											<button type="submit" class="am-btn am-btn-danger">修改</button>
											<a href="javascript: void(0)"
												class="am-close am-btn am-btn-danger" data-am-modal-close>取消</a>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<script type="text/javascript">
					$(document).ready(function() {
						$(".new-option-r").click(function() {
							$(this).parent('.user-addresslist').addClass("defaultAddr").siblings().removeClass("defaultAddr");
						});
				
						var $ww = $(window).width();
						if ($ww > 640) {
							$("#doc-modal-1").removeClass("am-modal am-modal-no-btn")
						}
				
					})
				</script>
				<div class="clear"></div>
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

</body>

</html>
