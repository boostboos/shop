<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">
	<title>订单管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
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
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">订单管理</strong> / <small>Order</small></div>
						</div>
						<hr/>

						<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

							<ul class="am-avg-sm-5 am-tabs-nav am-nav am-nav-tabs">
								<li class="am-active"><a href="#tab1">所有订单</a></li>
								<li><a href="#tab2">待付款</a></li>
								<li><a href="#tab3">待发货</a></li>
								<li><a href="#tab4">待收货</a></li>
								<li><a href="#tab5">待评价</a></li>
							</ul>

							<div class="am-tabs-bd">
								<div class="am-tab-panel am-fade am-in am-active" id="tab1">
									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-price">
											<td class="td-inner">单价</td>
										</div>
										<div class="th th-number">
											<td class="td-inner">数量</td>
										</div>
										<div class="th th-operation">
											<td class="td-inner">商品操作</td>
										</div>
										<div class="th th-amount">
											<td class="td-inner">合计</td>
										</div>
										<div class="th th-status">
											<td class="td-inner">交易状态</td>
										</div>
										<div class="th th-change">
											<td class="td-inner">交易操作</td>
										</div>
									</div>

									<div class="order-main">
									<c:forEach items="${orders }" var="order">
										<c:if test="${order.state < 5 || order.state == 8 }">
										<div class="order-list">
											<div class="order">
												<div class="order-title">
													<div class="dd-num">订单编号：<a href="javascript:;">${order.oid }</a></div>
													<span>成交时间：${order.downDate }</span>
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
															<li class="td td-price">
																<div class="item-price">
																${orderDetail.sellPrice }
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span>${orderDetail.number }
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">
																	
																</div>
															</li>
														</ul>
													</c:forEach>
													</div>
													<div class="order-right">
														<li class="td td-amount">
															<div class="item-amount">
																合计：${order.totalCost }
															</div>
														</li>
														<div class="move-right">
															<li class="td td-status">
																<div class="item-status">
																<c:choose>
																<c:when test="${order.state == 1 }">
																	<p class="Mystatus">等待买家付款</p>
																	<p class="order-info"><a href="orderinfo.html">取消订单</a></p>
																</c:when>
																<c:when test="${order.state == 2 }">
																	<p class="Mystatus">买家已付款</p>
																</c:when>
																<c:when test="${order.state == 3 }">
																	<p class="Mystatus">卖家已发货</p>
																</c:when>
																<c:when test="${order.state == 4 }">
																	<p class="Mystatus">交易成功</p>
																</c:when>
																<c:when test="${order.state == 8 }">
																	<p class="Mystatus">订单完成</p>
																</c:when>
																</c:choose>
																</div>
															</li>
															<li class="td td-change">
															
															<c:choose>
																<c:when test="${order.state == 1 }">
																<a href="/FrontOrderServlet?method=edit&meid=${order.meid }&oid=${order.oid }&state=2">
																	<div class="am-btn am-btn-danger anniu">一键支付</div>
																</a>
																</c:when>
																<c:when test="${order.state == 2 }">
																	<div class="am-btn am-btn-danger anniu">提醒发货</div>
																</c:when>
																<c:when test="${order.state == 3 }">
																<a href="/FrontOrderServlet?method=edit&meid=${order.meid }&oid=${order.oid }&state=4">
																	<div class="am-btn am-btn-danger anniu">确认收货</div>
																</a>
																</c:when>
																<c:when test="${order.state == 4 }">
																<a href="/CommentServlet?method=preAdd&oid=${order.oid }">
																<div class="am-btn am-btn-danger anniu">评价商品</div>
																</a>
																<a href="/FrontOrderServlet?method=edit&meid=${order.meid }&oid=${order.oid }&state=5">
																	<div class="am-btn am-btn-danger anniu">申请退货</div>
																</a>
																</c:when>
																<c:when test="${order.state == 8 }">
																<a href="/FrontOrderServlet?method=edit&meid=${order.meid }&oid=${order.oid }&state=5">
																	<div class="am-btn am-btn-danger anniu">申请退货</div>
																</a>
																</c:when>
															</c:choose>
															</li>
														</div>
													</div>
												</div>
											</div>
										</div>
										</c:if>
									</c:forEach>
									</div>
								</div>
								<div class="am-tab-panel am-fade" id="tab2">

									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-price">
											<td class="td-inner">单价</td>
										</div>
										<div class="th th-number">
											<td class="td-inner">数量</td>
										</div>
										<div class="th th-operation">
											<td class="td-inner">商品操作</td>
										</div>
										<div class="th th-amount">
											<td class="td-inner">合计</td>
										</div>
										<div class="th th-status">
											<td class="td-inner">交易状态</td>
										</div>
										<div class="th th-change">
											<td class="td-inner">交易操作</td>
										</div>
									</div>

									<div class="order-main">
									<c:forEach items="${orders }" var="order">
									<c:if test="${order.state == 1 }">
										<div class="order-list">
											<div class="order">
												<div class="order-title">
													<div class="dd-num">订单编号：<a href="javascript:;">${order.oid }</a></div>
													<span>成交时间：${order.downDate }</span>
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
															<li class="td td-price">
																<div class="item-price">
																${orderDetail.sellPrice }
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span>${orderDetail.number }
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">
																	
																</div>
															</li>
														</ul>
													</c:forEach>
													</div>
													<div class="order-right">
														<li class="td td-amount">
															<div class="item-amount">
																合计：${order.totalCost }
															</div>
														</li>
														<div class="move-right">
															<li class="td td-status">
																<div class="item-status">
																<c:choose>
																<c:when test="${order.state == 1 }">
																	<p class="Mystatus">等待买家付款</p>
																	<p class="order-info"><a href="orderinfo.html">取消订单</a></p>
																</c:when>
																<c:when test="${order.state == 2 }">
																	<p class="Mystatus">买家已付款</p>
																</c:when>
																<c:when test="${order.state == 3 }">
																	<p class="Mystatus">卖家已发货</p>
																</c:when>
																<c:when test="${order.state == 4 }">
																	<p class="Mystatus">交易成功</p>
																</c:when>
																</c:choose>
																</div>
															</li>
															<li class="td td-change">
															
															<c:choose>
																<c:when test="${order.state == 1 }">
																<a href="/FrontOrderServlet?method=edit&meid=${order.meid }&oid=${order.oid }&state=2">
																	<div class="am-btn am-btn-danger anniu">一键支付</div>
																</a>
																</c:when>
																<c:when test="${order.state == 2 }">
																<div class="am-btn am-btn-danger anniu">提醒发货</div>
																</c:when>
																<c:when test="${order.state == 3 }">
																<a href="/FrontOrderServlet?method=edit&meid=${order.meid }&oid=${order.oid }&state=4">
																	<div class="am-btn am-btn-danger anniu">确认收货</div>
																</a>
																</c:when>
																<c:when test="${order.state == 4 }">
																<a href="/CommentServlet?method=preAdd&oid=${order.oid }">
																<div class="am-btn am-btn-danger anniu">评价商品</div>
																</a>
																<a href="/FrontOrderServlet?method=edit&meid=${order.meid }&oid=${order.oid }&state=5">
																	<div class="am-btn am-btn-danger anniu">申请退货</div>
																</a>
																</c:when>
																</c:choose>
															</li>
														</div>
													</div>
												</div>
											</div>
										</div>
									</c:if>
									</c:forEach>
									</div>
								</div>
								<div class="am-tab-panel am-fade" id="tab3">
									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-price">
											<td class="td-inner">单价</td>
										</div>
										<div class="th th-number">
											<td class="td-inner">数量</td>
										</div>
										<div class="th th-operation">
											<td class="td-inner">商品操作</td>
										</div>
										<div class="th th-amount">
											<td class="td-inner">合计</td>
										</div>
										<div class="th th-status">
											<td class="td-inner">交易状态</td>
										</div>
										<div class="th th-change">
											<td class="td-inner">交易操作</td>
										</div>
									</div>

									<div class="order-main">
									<c:forEach items="${orders }" var="order">
									<c:if test="${order.state == 2 }">
										<div class="order-list">
											<div class="order">
												<div class="order-title">
													<div class="dd-num">订单编号：<a href="javascript:;">${order.oid }</a></div>
													<span>成交时间：${order.downDate }</span>
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
															<li class="td td-price">
																<div class="item-price">
																${orderDetail.sellPrice }
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span>${orderDetail.number }
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">
																	
																</div>
															</li>
														</ul>
													</c:forEach>
													</div>
													<div class="order-right">
														<li class="td td-amount">
															<div class="item-amount">
																合计：${order.totalCost }
															</div>
														</li>
														<div class="move-right">
															<li class="td td-status">
																<div class="item-status">
																<c:choose>
																<c:when test="${order.state == 1 }">
																	<p class="Mystatus">等待买家付款</p>
																	<p class="order-info"><a href="orderinfo.html">取消订单</a></p>
																</c:when>
																<c:when test="${order.state == 2 }">
																	<p class="Mystatus">买家已付款</p>
																</c:when>
																<c:when test="${order.state == 3 }">
																	<p class="Mystatus">卖家已发货</p>
																</c:when>
																<c:when test="${order.state == 4 }">
																	<p class="Mystatus">交易成功</p>
																</c:when>
																</c:choose>
																</div>
															</li>
															<li class="td td-change">
															
															<c:choose>
																<c:when test="${order.state == 1 }">
																<a href="/FrontOrderServlet?method=edit&meid=${order.meid }&oid=${order.oid }&state=2">
																	<div class="am-btn am-btn-danger anniu">一键支付</div>
																</a>
																</c:when>
																<c:when test="${order.state == 2 }">
																<div class="am-btn am-btn-danger anniu">提醒发货</div>
																</c:when>
																<c:when test="${order.state == 3 }">
																<a href="/FrontOrderServlet?method=edit&meid=${order.meid }&oid=${order.oid }&state=4">
																	<div class="am-btn am-btn-danger anniu">确认收货</div>
																</a>
																</c:when>
																<c:when test="${order.state == 4 }">
																<a href="/CommentServlet?method=preAdd&oid=${order.oid }">
																<div class="am-btn am-btn-danger anniu">评价商品</div>
																</a>
																<a href="/FrontOrderServlet?method=edit&meid=${order.meid }&oid=${order.oid }&state=5">
																	<div class="am-btn am-btn-danger anniu">申请退货</div>
																</a>
																</c:when>
																</c:choose>
															</li>
														</div>
													</div>
												</div>
											</div>
										</div>
									</c:if>
									</c:forEach>
									</div>
								</div>
								<div class="am-tab-panel am-fade" id="tab4">
									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-price">
											<td class="td-inner">单价</td>
										</div>
										<div class="th th-number">
											<td class="td-inner">数量</td>
										</div>
										<div class="th th-operation">
											<td class="td-inner">商品操作</td>
										</div>
										<div class="th th-amount">
											<td class="td-inner">合计</td>
										</div>
										<div class="th th-status">
											<td class="td-inner">交易状态</td>
										</div>
										<div class="th th-change">
											<td class="td-inner">交易操作</td>
										</div>
									</div>

									<div class="order-main">
										<div class="order-list">
										<c:forEach items="${orders }" var="order">
									<c:if test="${order.state == 3 }">
										<div class="order-list">
											<div class="order">
												<div class="order-title">
													<div class="dd-num">订单编号：<a href="javascript:;">${order.oid }</a></div>
													<span>成交时间：${order.downDate }</span>
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
															<li class="td td-price">
																<div class="item-price">
																${orderDetail.sellPrice }
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span>${orderDetail.number }
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">
																	
																</div>
															</li>
														</ul>
													</c:forEach>
													</div>
													<div class="order-right">
														<li class="td td-amount">
															<div class="item-amount">
																合计：${order.totalCost }
															</div>
														</li>
														<div class="move-right">
															<li class="td td-status">
																<div class="item-status">
																<c:choose>
																<c:when test="${order.state == 1 }">
																	<p class="Mystatus">等待买家付款</p>
																	<p class="order-info"><a href="orderinfo.html">取消订单</a></p>
																</c:when>
																<c:when test="${order.state == 2 }">
																	<p class="Mystatus">买家已付款</p>
																</c:when>
																<c:when test="${order.state == 3 }">
																	<p class="Mystatus">卖家已发货</p>
																</c:when>
																<c:when test="${order.state == 4 }">
																	<p class="Mystatus">交易成功</p>
																</c:when>
																</c:choose>
																</div>
															</li>
															<li class="td td-change">
															
															<c:choose>
																<c:when test="${order.state == 1 }">
																<a href="/FrontOrderServlet?method=edit&meid=${order.meid }&oid=${order.oid }&state=2">
																	<div class="am-btn am-btn-danger anniu">一键支付</div>
																</a>
																</c:when>
																<c:when test="${order.state == 2 }">
																<div class="am-btn am-btn-danger anniu">提醒发货</div>
																</c:when>
																<c:when test="${order.state == 3 }">
																<a href="/FrontOrderServlet?method=edit&meid=${order.meid }&oid=${order.oid }&state=4">
																	<div class="am-btn am-btn-danger anniu">确认收货</div>
																</a>
																</c:when>
																<c:when test="${order.state == 4 }">
																<a href="/CommentServlet?method=preAdd&oid=${order.oid }">
																<div class="am-btn am-btn-danger anniu">评价商品</div>
																</a>
																<a href="/FrontOrderServlet?method=edit&meid=${order.meid }&oid=${order.oid }&state=5">
																	<div class="am-btn am-btn-danger anniu">申请退货</div>
																</a>
																</c:when>
																</c:choose>
															</li>
														</div>
													</div>
												</div>
											</div>
										</div>
									</c:if>
									</c:forEach>
										</div>
									</div>
								</div>

								<div class="am-tab-panel am-fade" id="tab5">
									<div class="order-top">
										<div class="th th-item">
											<td class="td-inner">商品</td>
										</div>
										<div class="th th-price">
											<td class="td-inner">单价</td>
										</div>
										<div class="th th-number">
											<td class="td-inner">数量</td>
										</div>
										<div class="th th-operation">
											<td class="td-inner">商品操作</td>
										</div>
										<div class="th th-amount">
											<td class="td-inner">合计</td>
										</div>
										<div class="th th-status">
											<td class="td-inner">交易状态</td>
										</div>
										<div class="th th-change">
											<td class="td-inner">交易操作</td>
										</div>
									</div>

									<div class="order-main">
										<div class="order-list">
										<c:forEach items="${orders }" var="order">
									<c:if test="${order.state == 4 }">
										<div class="order-list">
											<div class="order">
												<div class="order-title">
													<div class="dd-num">订单编号：<a href="javascript:;">${order.oid }</a></div>
													<span>成交时间：${order.downDate }</span>
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
															<li class="td td-price">
																<div class="item-price">
																${orderDetail.sellPrice }
																</div>
															</li>
															<li class="td td-number">
																<div class="item-number">
																	<span>×</span>${orderDetail.number }
																</div>
															</li>
															<li class="td td-operation">
																<div class="item-operation">
																	
																</div>
															</li>
														</ul>
													</c:forEach>
													</div>
													<div class="order-right">
														<li class="td td-amount">
															<div class="item-amount">
																合计：${order.totalCost }
															</div>
														</li>
														<div class="move-right">
															<li class="td td-status">
																<div class="item-status">
																<c:choose>
																<c:when test="${order.state == 1 }">
																	<p class="Mystatus">等待买家付款</p>
																	<p class="order-info"><a href="orderinfo.html">取消订单</a></p>
																</c:when>
																<c:when test="${order.state == 2 }">
																	<p class="Mystatus">买家已付款</p>
																</c:when>
																<c:when test="${order.state == 3 }">
																	<p class="Mystatus">卖家已发货</p>
																</c:when>
																<c:when test="${order.state == 4 }">
																	<p class="Mystatus">交易成功</p>
																</c:when>
																</c:choose>
																</div>
															</li>
															<li class="td td-change">
															
															<c:choose>
																<c:when test="${order.state == 1 }">
																<a href="/FrontOrderServlet?method=edit&meid=${order.meid }&oid=${order.oid }&state=2">
																	<div class="am-btn am-btn-danger anniu">一键支付</div>
																</a>
																</c:when>
																<c:when test="${order.state == 2 }">
																<div class="am-btn am-btn-danger anniu">提醒发货</div>
																</c:when>
																<c:when test="${order.state == 3 }">
																<a href="/FrontOrderServlet?method=edit&meid=${order.meid }&oid=${order.oid }&state=4">
																	<div class="am-btn am-btn-danger anniu">确认收货</div>
																</a>
																</c:when>
																<c:when test="${order.state == 4 }">
																<a href="/CommentServlet?method=preAdd&oid=${order.oid }">
																<div class="am-btn am-btn-danger anniu">评价商品</div>
																</a>
																<a href="/FrontOrderServlet?method=edit&meid=${order.meid }&oid=${order.oid }&state=5">
																	<div class="am-btn am-btn-danger anniu">申请退货</div>
																</a>
																</c:when>
																</c:choose>
															</li>
														</div>
													</div>
												</div>
											</div>
										</div>
									</c:if>
									</c:forEach>
										</div>

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