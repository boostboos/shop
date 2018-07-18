<%@page import="com.legendary.entity.Comments"%>
<%@page import="com.legendary.service.CommentService"%>
<%@page import="com.legendary.entity.SpecificationDetail"%>
<%@page import="com.legendary.service.SpecificationService"%>
<%@page import="com.legendary.service.SpecificationDetailService"%>
<%@page import="com.legendary.entity.Specifications"%>

<%@page import="com.legendary.service.GoodsService"%>
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
		<title>商品页面</title>

		<link href="/front/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="/front/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="/front/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link type="text/css" href="/front/css/optstyle.css" rel="stylesheet" />
		<link type="text/css" href="/front/css/style.css" rel="stylesheet" />  	
		
		<script type="text/javascript" src="/front/basic/js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="/front/basic/js/quick_links.js"></script>
		
		<script type="text/javascript" src="/front/js/jquery.imagezoom.min.js"></script>
		<script type="text/javascript" src="/front/AmazeUI-2.4.2/assets/js/amazeui.js"></script>
		<script type="text/javascript" src="/front/js/jquery.flexslider.js"></script>
		<script type="text/javascript" src="/front/js/list.js"></script>
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
		<div class="listMain">
		
		<div class="nav-table">
		   	<div class="long-title"><span class="all-goods">全部分类</span></div>
			<div class="nav-cont">
				<ul>
					<li class="index"><a href="/front/home/home.jsp">首页</a></li>
				</ul>
			</div>
		</div>
		
		<ol class="am-breadcrumb am-breadcrumb-slash">
				<li><a href="#">首页</a></li>
				<li><a href="#">分类</a></li>
				<li class="am-active">内容</li>
		</ol>
		<script type="text/javascript">
			$(function() {});
			$(window).load(function() {
				$('.flexslider').flexslider({
					animation: "slide",
					start: function(slider) {
						$('body').removeClass('loading');
					}
				});
			});
		</script>
		<div class="scoll">
			<section class="slider">
				<div class="flexslider">
					<ul class="slides">
					<%
						Integer gid =Integer.parseInt(request.getParameter("gid"));
						GoodsService gs = new GoodsService();
						
						CommentService cs = new CommentService();
						List<Comments> comments = cs.find(gid);
						System.out.println(comments);
						Goods good = gs.load(gid);
						PictureService picService = new PictureService();
						List<Picinfos> list = picService.findAllByGid(gid);
						int cnt = 0;
						for(Picinfos pic : list) {
							cnt++;
							if(cnt < 5) 
								out.write("<li><img src=\""+pic.getPicinfo()+"\" /></li>");
							else
								break;
						}
					%>
					</ul>
				</div>
			</section>
		</div>
		<div class="item-inform">
			<div class="clearfixLeft" id="clearcontent">
				<div class="box">
					<script type="text/javascript">
						$(document).ready(function() {
							$(".jqzoom").imagezoom();
							$("#thumblist li a").click(function() {
								$(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
								$(".jqzoom").attr('src', $(this).find("img").attr("mid"));
								$(".jqzoom").attr('rel', $(this).find("img").attr("big"));
							});
						});
					</script>
					<%
						Picinfos pinfo = list.get(0);
						String defaultPath = pinfo.getPicinfo();
					%>
					<div class="tb-booth tb-pic tb-s310">
						<a href="#"><img src="<%=defaultPath%>" alt="细节展示放大镜特效" rel="<%=defaultPath%>" class="jqzoom" /></a>
					</div>
					<ul class="tb-thumb" id="thumblist">
						<li class="tb-selected">
							<div class="tb-pic tb-s40">
								<a href="#"><img src="<%=defaultPath%>" mid="<%=defaultPath%>" big="<%=defaultPath%>"></a>
							</div>
						</li>
						<%
							for(int i = 1; i < list.size(); i++) {
								String path = list.get(i).getPicinfo();
								out.write("<li><div class=\"tb-pic tb-s40\">");
								out.write("<a href=\"#\"><img src=\""+path+"\" mid=\""+path+"\" big=\""+path+"\"></a>");
								out.write("</div></li>");
							}
						%>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<div class="clearfixRight">
				<div class="tb-detail-hd">	
					<h1>良品铺子 手剥松子218g 坚果炒货 巴西松子</h1>
				</div>
				<div class="tb-detail-list">
					<!--价格-->
					<div class="tb-detail-price">
						<li class="price iteminfo_price">
							<dt>促销价</dt>
							<dd><em>¥</em><b id="sys_item_price"></b></dd>                                 
						</li>
						<li class="price iteminfo_mktprice">
							<dt>原价</dt>
							<dd><em>¥</em><b id="sys_item_mktprice"></b></dd>									
						</li>
						<div class="clear"></div>
					</div>
					<div class="clear"></div>
					<!--销量-->
					<ul class="tm-ind-panel">
						<li class="tm-ind-item tm-ind-sumCount canClick">
							<div class="tm-indcon"><span class="tm-label">累计销量</span><span class="tm-count"><%=good.getSales() %></span></div>
						</li>
						<li class="tm-ind-item tm-ind-reviewCount canClick tm-line3">
							<div class="tm-indcon"><span class="tm-label">累计评价</span><span class="tm-count"><%=comments.size() %></span></div>
						</li>
					</ul>
					<div class="clear"></div>
					<!--各种规格-->
					<dl class="iteminfo_parameter sys_item_specpara">
						<dt class="theme-login"><div class="cart-title">可选规格<span class="am-icon-angle-right"></span></div></dt>
						<dd>
							<div class="theme-popover-mask"></div>

							<div class="theme-popover">
								<div class="theme-span"></div>
								<div class="theme-poptit">
									<a href="javascript:;" title="关闭" class="close">×</a>
								</div>
								<div class="theme-popbod dform">
									<form class="theme-signin" name="loginform" action="" method="post">

										<div class="theme-signin-left">
											<%
												SpecificationDetailService sds = new SpecificationDetailService();
												SpecificationService ss = new SpecificationService();
												List<Specifications> specList = ss.findAll();
												for(Specifications spec : specList) {
													out.write("<div class=\"theme-options\">");
													out.write("<div class=\"cart-title\">"+spec.getSpecInfo()+"</div>");
													out.write("<ul>");
													for(SpecificationDetail scd: sds.findAll(spec.getSid())) {
														out.write("<li class=\"sku-line\">"+scd.getSdname()+"<i></i></li>");
													}
													out.write("</ul></div>");
												}
											%>
											<div class="theme-options">
												<div class="cart-title number">数量</div>
												<dd>
													<input id="min" class="am-btn am-btn-default" name="" type="button" value="-" />
													<input id="text_box" name="" type="text" value="1" style="width:30px;" />
													<input id="add" class="am-btn am-btn-default" name="" type="button" value="+" />
													<span id="Stock" class="tb-hidden">库存<span id="stockNum">1000</span>件</span>
												</dd>

											</div>
											<div class="clear"></div>

											<div class="btn-op">
												<div class="btn am-btn am-btn-warning">确认</div>
												<div class="btn close am-btn am-btn-warning">取消</div>
											</div>
										</div>
										<div class="theme-signin-right">
											<div class="img-info">
												<img src="/front/images/songzi.jpg" />
											</div>
											<div class="text-info">
												<span class="J_Price price-now">¥0.00</span>
												<span id="Stock" class="tb-hidden">库存<span class="stock">0</span>件</span>
											</div>
										</div>
									</form>
								</div>
							</div>
						</dd>
					</dl>
					<div class="clear"></div>
							<!--活动	-->
							<div class="shopPromotion gold">
								<div class="hot">
									<dt class="tb-metatit">正品认证</dt>
									<div class="gold-list">
										<p>7天无理由退换</p>
									</div>
								</div>
								<div class="clear"></div>
							</div>
				</div>
				<div class="pay">
					<div class="pay-opt">
					<a href="home.html"><span class="am-icon-home am-icon-fw">首页</span></a>
					<a><span class="am-icon-heart am-icon-fw">收藏</span></a>
					
					</div>
					<li>
						<div class="clearfix tb-btn tb-btn-buy theme-login">
							<a id="LikBuy" title="点此按钮到下一步确认购买信息" href="#">立即购买</a>
						</div>
					</li>
					<li>
						<div id="toGoodsCart" class="clearfix tb-btn tb-btn-basket theme-login">
							<a id="LikBasket" title="加入购物车" href="javascript:void(0)"><i></i>加入购物车</a>
						</div>
					</li>
				</div>
				</div>
			
			<div class="clear"></div>
			</div>
			<div class="clear"></div>
			
						
			<!-- introduce-->

			<div class="introduce">
				<div class="introduceMain">
					<div class="am-tabs" data-am-tabs>
						<ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">
							<li class="am-active">
								<a href="#"><span class="index-needs-dt-txt">宝贝详情</span></a>
							</li>
							<li>
								<a href="#"><span class="index-needs-dt-txt">全部评价</span></a>
							</li>
						</ul>

						<div class="am-tabs-bd">

							<div class="am-tab-panel am-fade am-in am-active">
								<div class="J_Brand">

									<div class="attr-list-hd tm-clear">
										<h4>产品参数：</h4></div>
									<div class="clear"></div>
									<ul id="J_AttrUL">
									<%
										GoodsDetailService gds = new GoodsDetailService();
										List<GoodsDetail> goodDetailList = gds.findAll(good.getGid());
										out.write("<li title=\"\">商品类别:&nbsp"+good.getKeyword()+"</li>");
										for(GoodsDetail gd : goodDetailList) {
											out.write("<li title=\"\">规格详情:&nbsp"+gd.getSpecdetail()+"</li>");
										}
										out.write("<li title=\"\">商品详情:&nbsp"+good.getDetail()+"</li>");
									%>
									</ul>
									<div class="clear"></div>
								</div>

								<div class="details">
									<div class="attr-list-hd after-market-hd">
										<h4>商品细节</h4>
									</div>
									<%
										for(int i = 0; i < list.size(); i++) {
											String path = list.get(i).getPicinfo();
											out.write("<div class=\"twlistNews\">");
											out.write("<img src=\""+path+"\" /></div>");
										}
									%>
								</div>
								<div class="clear"></div>

							</div>

							<div class="am-tab-panel am-fade">
								<div class="tb-r-filter-bar">
									<ul class=" tb-taglist am-avg-sm-4">
										<li class="tb-taglist-li tb-taglist-li-current">
											<div class="comment-info">
												<span>全部评价</span>
												<span class="tb-tbcr-num"><%=comments.size() %></span>
											</div>
										</li>

										<li class="tb-taglist-li tb-taglist-li-1">
											<div class="comment-info">
												<span>好评</span>
												<%
													int gc = 0;
													int mc = 0;
													int bc = 0;
													for(Comments c : comments) {
														if(c.getRank() == 1)
															gc++;
														if(c.getRank() == 2)
															mc++;
														if(c.getRank() == 3)
															bc++;
													}
													request.setAttribute("comments", comments);
												%>
												<span class="tb-tbcr-num"><%=gc %></span>
											</div>
										</li>

										<li class="tb-taglist-li tb-taglist-li-0">
											<div class="comment-info">
												<span>中评</span>
												<span class="tb-tbcr-num"><%=mc %></span>
											</div>
										</li>

										<li class="tb-taglist-li tb-taglist-li--1">
											<div class="comment-info">
												<span>差评</span>
												<span class="tb-tbcr-num"><%=bc %></span>
											</div>
										</li>
									</ul>
								</div>
								<div class="clear"></div>

								<ul class="am-comments-list am-comments-list-flip">
									<c:forEach items="${comments }" var="com">
									<li class="am-comment">
										<!-- 评论容器 -->
										<a href="">
											<img class="am-comment-avatar" src="/front/images/hwbn40x40.jpg" />
											<!-- 评论者头像 -->
										</a>

										<div class="am-comment-main">
											<!-- 评论内容容器 -->
											<header class="am-comment-hd">
												<!--<h3 class="am-comment-title">评论标题</h3>-->
												<div class="am-comment-meta">
													<!-- 评论元数据 -->
													<a href="#link-to-user" class="am-comment-author">${com.meid }</a>
												</div>
											</header>
											
											<div class="am-comment-bd">
												<div class="tb-rev-item " data-id="255776406962">
													<div class="J_TbcRate_ReviewContent tb-tbcr-content ">
													${com.info }
													</div>
												</div>

											</div>
										</div>
									</li>
									</c:forEach>
								</ul>

								<div class="clear"></div>

								<!--评论分页 -->
								
								<div class="clear"></div>

								

							</div>

							
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		<script>
			$("#toGoodsCart").attr("goods","F")
			var infos;
			$(".sku-line").click(function() {
				var lis = $(this).siblings();
				for(var i = 0; i < lis.length; i++) {
					lis.removeClass("selected");
				}
				$(this).addClass("selected")
				var selectedItems =	$(".selected");
				var result = "";
				for(var i = 0; i < selectedItems.length; i++) {
					result += selectedItems[i].textContent;
				}
				var selectedItems =	$(".selected");
				if(selectedItems.length == 4) {
					var result = "";
					for(var i = 0; i < selectedItems.length; i++) {
						result += selectedItems[i].textContent+",";
					}
					htmlobj=$.ajax({url:"http://localhost:9090/GoodsForMemberServlet?method=find&gid=<%=good.getGid()%>&para="+result,async:false});
					infos = htmlobj.responseText.split(",");
					$("#sys_item_price").html(infos[0]);
					$("#sys_item_mktprice").html(infos[1]);
					$("#stockNum").html(infos[2]);
					if(infos.length == 4) {
						var href = "/GoodsCartServlet?method=add&meid=${session_memb.meid }&";
						$("#LikBasket").attr("href",href+"gdid="+infos[3])
						$("#toGoodsCart").attr("goods","T");
					}else {
						$("#toGoodsCart").attr("goods","F")
					}
				}
			});
			
			$("#LikBuy").click(function() {
				if(infos.length == 4) {
					var href = "/FrontOrderServlet?method=preAdd&meid=${session_memb.meid }&info="+infos[3];
					href+=","+$("#text_box").val();
					alert(href);
					var flag = $("#LikBuy").attr("goods");
					var num1 = parseInt($("#text_box").val());
					var num2 = parseInt($("#stockNum").text());
					if(num1 > num2) {
						alert("剩余货物不足");
						return;
					}
					if(flag == "F") {
						alert("请选择正确的规格");
						$("#LikBuy").attr("href","javascript:void(0)");
					}else {
						$("#LikBuy").attr("href",href);
					}
				}else {
					$("#LikBuy").attr("goods","F")
				}
			}) 
			
			$("#toGoodsCart").click(function() {
				var flag = $("#toGoodsCart").attr("goods");
				var num1 = parseInt($("#text_box").val());
				var num2 = parseInt($("#stockNum").text());
				if(num1 > num2) {
					alert("剩余货物不足");
					return;
				}
				if(flag == "F") {
					alert("请选择正确的规格");
					$("#LikBasket").attr("href","javascript:void(0)");
				}else {
					var href = $("#LikBasket").attr("href");
					var hrefs = href.split("&number=");
					href = hrefs[0]+"&number="+$("#text_box").val();
					$("#LikBasket").attr("href",href);
				}
			})
		</script>
		
	</body>
</html>
