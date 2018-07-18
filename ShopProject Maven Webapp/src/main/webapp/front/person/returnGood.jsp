<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<title>退换货管理</title>
		<link href="/front/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="/front/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="/front/css/personal.css" rel="stylesheet" type="text/css">
		<link href="/front/css/orstyle.css" rel="stylesheet" type="text/css">

		<script src="/front/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
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
							</ul>
						</div>
			</div>
			<b class="line"></b>		
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="user-order">

						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">退换货管理</strong> / <small>Change</small></div>
						</div>
						<hr/>

						<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

							<ul class="am-avg-sm-2 am-tabs-nav am-nav am-nav-tabs">
								<li class="am-active"><a href="#tab1">退款管理</a></li>
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-orderprice th-price">
											<td class="td-inner">交易金额</td>
										</div>
										<div class="th th-changeprice th-price">
											<td class="td-inner">退款金额</td>
										</div>
										<div class="th th-status th-moneystatus">
											<td class="td-inner">交易状态</td>
										</div>
										<div class="th th-change th-changebuttom">
											<td class="td-inner">交易操作</td>
										</div>
									</div>

									<div class="order-main">
									<c:forEach items="${orders }" var="order">
										<div class="order-list">
											<div class="order-title">
												<div class="dd-num">退款编号：<a href="javascript:;">${order.oid }</a></div>
												<span>申请时间：${order.downDate }</span>
											</div>
											<div class="order-content">
												<div class="order-left">
												<c:forEach items="${order.items }" var="orderDetail">
													<ul class="item-list">
														<li class="td td-item">
															<div class="item-pic">
																<a href="#" class="J_MakePoint">
																	<img src="${orderDetail.picinfo }" class="itempic J_ItemImg">
																</a>
															</div>
															<div class="item-info">
																<div class="item-basic-info">
																	<a href="#">
																		<p>${orderDetail.gname }</p>
																		<p class="info-little">
																			${orderDetail.specdetail }
																		</p>
																	</a>
																</div>
															</div>
														</li>

														<ul class="td-changeorder">
															<li class="td td-orderprice">
																<div class="item-orderprice">
																	<span>交易金额：</span>${order.totalCost }
																</div>
															</li>
															<li class="td td-changeprice">
																<div class="item-changeprice">
																	<span>退款金额：</span>${order.totalCost }
																</div>
															</li>
														</ul>
														<div class="clear"></div>
													</ul>
												</c:forEach>
													<div class="change move-right">
														<li class="td td-moneystatus td-status">
															<div class="item-status">
																<c:choose>
																<c:when test="${order.state == 5 }">
																	<p class="Mystatus">等待审批</p>
																</c:when>
																<c:when test="${order.state == 6 }">
																	<p class="Mystatus">同意退货</p>
																</c:when>
																<c:when test="${order.state == 7 }">
																	<p class="Mystatus">等待退款</p>
																</c:when>
																<c:when test="${order.state == 8 }">
																	<p class="Mystatus">退款完成</p>
																</c:when>
																</c:choose>

															</div>
														</li>
													</div>
													<li class="td td-change td-changebutton">
														<c:choose>
															<c:when test="${order.state == 6 }">
															<a href="/FrontOrderServlet?method=returnEdit&meid=${order.meid }&oid=${order.oid }&state=7">
																<div class="am-btn am-btn-danger anniu">寄出货物</div>
															</a>
															</c:when>
														</c:choose>
													</li>

												</div>
											</div>
										</div>
									</c:forEach>
									</div>

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

	</body>

</html>


