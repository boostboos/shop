<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

<title>个人信息</title>

<link href="/front/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css">
<link href="/front/AmazeUI-2.4.2/assets/css/amazeui.css"
	rel="stylesheet" type="text/css">

<link href="/front/css/personal.css" rel="stylesheet" type="text/css">
<link href="/front/css/infstyle.css" rel="stylesheet" type="text/css">
<script src="/front/AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
<script src="/front/AmazeUI-2.4.2/assets/js/amazeui.js" type="text/javascript"></script>
<script src="/front/AmazeUI-2.4.2/assets/js/jquery.js"></script>
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
		<div class="long-title">
			<span class="all-goods">全部分类</span>
		</div>
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

				<div class="user-info">
					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf">
							<strong class="am-text-danger am-text-lg">个人资料</strong> / <small>Personal&nbsp;information</small>
						</div>
					</div>
					<hr />


					<!--个人信息 -->
					<form action="/MemberServlet?method=edit" method="post"
						class="am-form am-form-horizontal">
						<div class="info-main">

							<input type="hidden" name="meid" value="${ member.meid }" />
							<div class="am-form-group">
								<label for="user-name2" class="am-form-label">用户名</label>
								<div class="am-form-content">
									<input type="text" value="${member.username }" name="username"
										id="user-name2" placeholder="username">

								</div>
							</div>

							<div class="am-form-group">
								<label for="user-name" class="am-form-label">更改密码</label>
								<div class="am-form-content">
									<input type="password" value="${member.passwd }" name="passwd"
										id="passwd1" placeholder="输入密码">
								</div>
							</div>

							<div class="am-form-group">
								<label for="user-name" class="am-form-label">确认密码</label>
								<div class="am-form-content">
									<input type="password" value="${member.passwd }" name="passwd"
										id="passwd2" placeholder="确认密码">
								</div>
							</div>

							<div class="am-form-group">
								<label for="user-name" class="am-form-label">真实姓名</label>
								<div class="am-form-content">
									<input type="text" value="${member.realname }" name="realname"
										id="user-name2" placeholder="realname">
								</div>
							</div>

							<div class="am-form-group">
								<label class="am-form-label">性别</label>
								<div class="am-form-content sex">
								<c:if test="${member.gender == '男'  }">
									<label class="am-radio-inline">
										<input type="radio"	name="gender" checked="checked" value="男" data-am-ucheck> 男
									</label> 
									<label class="am-radio-inline"> 
										<input type="radio" name="gender" value="女" data-am-ucheck> 女
									</label>
								</c:if>
								<c:if test="${member.gender == '女'  }">
									<label class="am-radio-inline">
										<input type="radio"	name="gender"  value="男" data-am-ucheck> 男
									</label> 
									<label class="am-radio-inline"> 
										<input type="radio" name="gender" checked="checked" value="女" data-am-ucheck> 女
									</label>
								</c:if>
								</div>
							</div>

							<div class="am-form-group">
								<label for="user-phone" class="am-form-label">生日</label>
								<div class="am-form-content">
									<input value="${member.birthday }" name="birthday"
										id="user-phone" placeholder="2018-1-1" type="tel">

								</div>
							</div>
							<div class="am-form-group">
								<label for="user-phone" class="am-form-label">电话</label>
								<div class="am-form-content">
									<input value="${member.phone }" name="phone" id="user-phone"
										placeholder="" type="tel">
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-email" class="am-form-label">电子邮件</label>
								<div class="am-form-content">
									<input value="${member.email }" name="email" id="user-email"
										placeholder="" type="email">

								</div>
							</div>
							<div class="info-btn">
								<input type="submit" name="" value="修改"
									class="am-btn am-btn-danger">
							</div>


						</div>
					</form>
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

</body>

</html>