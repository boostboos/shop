<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>购物车页面</title>
	<link href="/front/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
	<link href="/front/basic/css/demo.css" rel="stylesheet" type="text/css" />
	<link href="/front/css/cartstyle.css" rel="stylesheet" type="text/css" />
	<link href="/front/css/optstyle.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="/front/js/jquery.js"></script>
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
	<div class="concent">
		<div id="cartTable">
			<div class="cart-table-th">
				<div class="wp">
					<div class="th th-chk">
						<div id="J_SelectAll1" class="select-all J_SelectAll">

						</div>
					</div>
					<div class="th th-item">
						<div class="td-inner">商品信息</div>
					</div>
					<div class="th th-price">
						<div class="td-inner">单价</div>
					</div>
					<div class="th th-amount">
						<div class="td-inner">数量</div>
					</div>
					<div class="th th-sum">
						<div class="td-inner">金额</div>
					</div>
					<div class="th th-op">
						<div class="td-inner">操作</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<c:forEach items="${pb.beanList }" var="item">
				<tr class="item-list">
					<div class="bundle  bundle-last ">
						<div class="clear"></div>
						<div class="bundle-main">
							<ul class="item-content clearfix" gdid="${item.gdid }">
								<li class="td td-chk">
									<div class="cart-checkbox ">
										<input class="check" value="" type="checkbox">
										<label ></label>
									</div>
								</li>
								<li class="td td-item">
									<div class="item-pic">
										<a href="#" target="_blank" data-title="picinfo" class="J_MakePoint" data-point="tbcart.8.12">
											<img src="${item.picinfo }" style="	width:100%; height:100%;" class="itempic J_ItemImg"></a>
									</div>
									<div class="item-info">
										<div class="item-basic-info">
											<a href="#" target="_blank" title="gname" class="item-title J_MakePoint" data-point="tbcart.8.11">${item.gname }</a>
										</div>
									</div>
								</li>
								<li class="td td-info">
									<div class="item-props item-props-can">
										<span class="sku-line">${item.specdetail }</span>
										<i class="theme-login am-icon-sort-desc"></i>
									</div>
								</li>
								<li id="prli" class="td td-price">
									<div class="item-price price-promo-promo">
										<div class="price-content">
											<div class="price-line">
												<em class="price-original">${item.marketprice }</em>
											</div>
											<div class="price-line">
												<em id="nowPirce" class="J_Price price-now" tabindex="0">${item.sellprice }</em>
											</div>
										</div>
									</div>
								</li>
								<li class="td td-amount">
									<div class="amount-wrapper ">
										<div class="item-amount ">
											<div class="sl">
												<input class="min am-btn" name="" type="button" value="-" />
												<input class="text_box" name="" type="text" value="${item.number }" style="width:30px;" />
												<input class="add am-btn" name="" type="button" value="+" />
											</div>
										</div>
									</div>
								</li>
								<li id="tpli" class="td td-sum">
									<div class="td-inner">
										<em id="totalprice" tabindex="0" class="J_ItemSum number">${item.number * item.sellprice }</em>
									</div>
								</li>
								<li class="td td-op">
									<div class="td-inner">
										<a title="移入收藏夹" class="btn-fav" href="#">
	                移入收藏夹</a>
										<a href="javascript:;" data-point-url="#" class="delete">
	                删除</a>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</tr>
			</c:forEach>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>

		<div class="float-bar-wrapper">
			<div id="J_SelectAll2" class="select-all J_SelectAll">
				<div class="cart-checkbox">
					<input class="check-all" id="J_SelectAllCbx2" name="select-all" value="true" type="checkbox">
					<label for="J_SelectAllCbx2"></label>
				</div>
				<span>全选</span>
			</div>
			<div class="operations">
				<a href="#" hidefocus="true" class="deleteAll">删除</a>
				<a href="#" hidefocus="true" class="J_BatchFav">移入收藏夹</a>
			</div>
			<div class="float-bar-right">
				<div class="amount-sum">
					<span class="txt">已选商品</span>
					<em id="J_SelectedItemsCount">0</em><span class="txt">件</span>
					<div class="arrow-box">
						<span class="selected-items-arrow"></span>
						<span class="arrow"></span>
					</div>
				</div>
				<div class="price-sum">
					<span class="txt">合计:</span>
					<strong class="price">¥<em id="J_Total">0.00</em></strong>
				</div>
				<div class="btn-area">
					<a href="/FrontOrderServlet?method=preAdd" id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
						<span>结&nbsp;算</span></a>
				</div>
			</div>

		</div>

	</div>

	<script>
	
	function computeTotalPrice() {
		var prices = $(".J_ItemSum").toArray()
		result = 0;
		for(var i = 0; i < prices.length; i++) {
			var p = $(prices[i]).parent().parent().parent();
			if(p.attr("isSelect")=='true') {
				result += parseFloat(prices[i].textContent);
			}
		}
		$("#J_Total").text(result)
	}
	function computeTotalNum() {
		var nums = $(".text_box").toArray()
		var result = 0;
		for(var i = 0; i < nums.length; i++) {
			var p = $(nums[i]).parent().parent().parent().parent().parent();
			if(p.attr("isSelect")=='true')
				result += parseInt(nums[i].value);
		}
		$("#J_SelectedItemsCount").text(result)
	}
	function changeLinkInfo(){
		var nums = $(".text_box").toArray()
		var result = 0;
		var link="/FrontOrderServlet?method=preAdd&meid=${session_memb.meid }&info="
		var temp = "";
		for(var i = 0; i < nums.length; i++) {
			var p = $(nums[i]).parent().parent().parent().parent().parent();
			if(p.attr("isSelect") == "true") {
				//货物详情id
				temp+=p.attr("gdid")+",";
				//货物数量
				temp+=p.find(".text_box").val()+";";
			}
		}
		link+=temp;
		$("#J_Go").attr("href",link);
	}
	
	$(function(){
		$(".check").click(function(){
			var p = $(this).parent().parent().parent();
			if($(this).prop("checked")) {
				p.attr("isSelect",true);
			}else {
				p.attr("isSelect",false);
			}
			computeTotalPrice();
			computeTotalNum();
			changeLinkInfo();
		})
		
		$(".check-all").click(function(){
			if($(this).prop("checked")) {
				$(".item-content").attr("isSelect",true);
				$(".check").prop("checked",true)
			}else {
				$(".item-content").attr("isSelect",false);
				$(".check").prop("checked",false)
			}
			computeTotalPrice();
			computeTotalNum();
			changeLinkInfo();
		})
		
		$(".add").click(function(){
			var p = $(this).parent()
			var t=p.find('input[class*=text_box]');
			t.val(parseInt(t.val())+1)
			p = p.parent().parent().parent()
			var d = p.siblings("#prli").find("#nowPirce").text()
			var result = t.val() * d
			var s = p.siblings("#tpli").find("#totalprice").text(result)
			computeTotalPrice();
			computeTotalNum();
			changeLinkInfo();
		})
		$(".min").click(function(){
			var p = $(this).parent()
		  	var t=p.find('input[class*=text_box]');
		  	t.val(parseInt(t.val())-1)
			if(parseInt(t.val())<0){
				t.val(0);
			}
			p = p.parent().parent().parent()
		    var d = p.siblings("#prli").find("#nowPirce").text()
		    var result = t.val() * d
		    var s = p.siblings("#tpli").find("#totalprice").text(result)
		    computeTotalPrice();
			computeTotalNum();
			changeLinkInfo();
		})
	}) 
	

	computeTotalNum();
	computeTotalPrice();
	</script>
	</body>
</html>