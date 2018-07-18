<%@page import="com.legendary.entity.Address"%>
<%@page import="com.legendary.service.AddressService"%>
<%@page import="com.legendary.entity.Goods"%>
<%@page import="com.legendary.service.GoodsService"%>
<%@page import="com.legendary.entity.Picinfos"%>
<%@page import="com.legendary.service.PictureService"%>
<%@page import="com.legendary.entity.GoodsDetail"%>
<%@page import="com.legendary.service.GoodsDetailService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
  <head>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>结算页面</title>
	<link href="/front/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
	<link href="/front/basic/css/demo.css" rel="stylesheet" type="text/css" />
	<link href="/front/css/cartstyle.css" rel="stylesheet" type="text/css" />
	<link href="/front/css/jsstyle.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="/front/js/address.js"></script>
  </head>
  
  <body>
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
			<div class="concent">
				<!--地址 -->
				<div class="paycont">
					<div class="address">
						<h3>确认收货地址 </h3>
						<div class="control">
							<div class="tc-btn createAddr theme-login am-btn am-btn-danger">使用新地址</div>
						</div>
						<div class="clear"></div>
						<ul>
						<c:forEach items="${addressList }" var="address">
							<div class="per-border"></div>
							<c:if test="${address.defaddress == 1 }">
								<li class="user-addresslist defaultAddr" aid="${address.aid }">
							</c:if>
							<c:if test="${address.defaddress != 1 }">
								<li class="user-addresslist" aid="${address.aid }">
							</c:if>
								<div class="address-left">
									<div class="user">
										<span class="buy-address-detail">   
                   							<span class="buy-user">${address.receivername } </span>
											<span class="buy-phone">${address.receiverphone }</span>
										</span>
									</div>
									<div class="default-address">
									<span class="buy-line-title buy-line-title-type">收货地址：</span>
									<span class="buy-address-detail">
										<span class="street">${address.addressinfo }</span>
									</span>
									</div>
									<c:if test="${address.defaddress == 1 }">
										<ins class="deftip">默认地址</ins>
									</c:if>
								</div>
								<div class="address-right">
									<a href="/front/person/address.html">
										<span class="am-icon-angle-right am-icon-lg"></span></a>
								</div>
								<div class="clear"></div>
								<div class="new-addr-btn">
									<a href="#" class="hidden">设为默认</a>
									<span class="new-addr-bar hidden">|</span>
									<a href="#">编辑</a>
									<span class="new-addr-bar">|</span>
									<a href="javascript:void(0);" onclick="delClick(this);">删除</a>
								</div>
							</li>
						</c:forEach>
						</ul>
						<div class="clear"></div>
					</div>
					<!--物流 -->
					<div class="logistics">
						<h3>选择物流方式</h3>
						<ul class="op_express_delivery_hot">
							<li data-value="yuantong" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -468px"></i>圆通<span></span></li>
							<li data-value="shentong" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -1008px"></i>申通<span></span></li>
							<li data-value="yunda" class="OP_LOG_BTN  "><i class="c-gap-right" style="background-position:0px -576px"></i>韵达<span></span></li>
							<li data-value="zhongtong" class="OP_LOG_BTN op_express_delivery_hot_last "><i class="c-gap-right" style="background-position:0px -324px"></i>中通<span></span></li>
							<li data-value="shunfeng" class="OP_LOG_BTN  op_express_delivery_hot_bottom"><i class="c-gap-right" style="background-position:0px -180px"></i>顺丰<span></span></li>
						</ul>
					</div>
					<div class="clear"></div>

					<!--支付方式-->
					<div class="logistics">
						<h3>选择支付方式</h3>
						<ul class="pay-list">
							<li class="pay card"><img src="/front/images/wangyin.jpg" />银联<span></span></li>
							<li class="pay qq"><img src="/front/images/weizhifu.jpg" />微信<span></span></li>
							<li class="pay taobao"><img src="/front/images/zhifubao.jpg" />支付宝<span></span></li>
						</ul>
					</div>
					<div class="clear"></div>

					<!--订单 -->
					<div class="concent">
						<div id="payTable">
							<h3>确认订单信息</h3>
							<div class="cart-table-th">
								<div class="wp">

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

								</div>
							</div>
							<div class="clear"></div>
							<%
								String meid = request.getParameter("meid");
								String parainfo = request.getParameter("info");
								String[] infos = parainfo.split(";");
								GoodsDetailService gds = new GoodsDetailService();
								PictureService picService = new PictureService();
								GoodsService gs = new GoodsService();
								Double totalPrice = 0.0;
								for(int i = 0; i < infos.length; i++) {
									String[] tags = infos[i].split(",");
									GoodsDetail gd = gds.load(Integer.parseInt(tags[0]));
									Picinfos pinfo = picService.load(gd.getPid());
									Goods good = gs.load(gd.getGid());
									Integer num = Integer.parseInt(tags[1]);
									out.write("<tr class=\"item-list\">");
									out.write("<div class=\"bundle  bundle-last\">");
									out.write("<div class=\"bundle-main\">");
									out.write("<ul class=\"item-content clearfix\">");
									out.write("<div class=\"pay-phone\">");
									out.write("<li class=\"td td-item\">");
									out.write("<div class=\"item-pic\">");
									out.write("<a href=\"#\" class=\"J_MakePoint\">");
									out.write("<img src=\""+pinfo.getPicinfo()+"\" style=\"	width:100%; height:100%;\" class=\"itempic J_ItemImg\"></a>");
									out.write("</div>");
									out.write("<div class=\"item-info\">");
									out.write("<div class=\"item-basic-info\">");
									out.write("<a href=\"#\" class=\"item-title J_MakePoint\" data-point=\"tbcart.8.11\">"+good.getGname()+"</a>");
									out.write("</div></div></li>");
									out.write("<li class=\"td td-info\">");
									out.write("<div class=\"item-props\">");
									out.write("<span class=\"sku-line\">"+gd.getSpecdetail()+"</span>");
									out.write("</div></li>");
									out.write("<li class=\"td td-price\">");
									out.write("<div class=\"item-price price-promo-promo\">");
									out.write("<div class=\"price-content\">");
									out.write("<em class=\"J_Price price-now\">"+gd.getSellprice()+"</em>");
									out.write("</div></div></li>");
									out.write("<li class=\"td td-amount\">");
									out.write("<div class=\"amount-wrapper \">");
									out.write("<div class=\"td-inner\">");
									out.write("<em tabindex=\"0\" class=\"J_ItemAmount number\">"+num+"</em>");
									out.write("</div></div></li>");
									out.write("<li class=\"td td-sum\">");
									out.write("<div class=\"td-inner\">");
									out.write("<em tabindex=\"0\" class=\"J_ItemSum sum\">"+gd.getSellprice().doubleValue()*num+"</em>");
									totalPrice += gd.getSellprice().doubleValue()*num;
									out.write("</div></li></div></ul>");
									out.write("<div class=\"clear\"></div>");
									out.write("</div></tr><div class=\"clear\"></div>");
								}
							%>
							<div class="clear"></div>
							</div>
							</div>
							<div class="clear"></div>
							<div class="pay-total">
						<!--留言-->
							<div class="order-extra">
								<div class="order-user-info">
									<div id="holyshit257" class="memo">
										<label>买家留言：</label>
										<input id=remark type="text" title="选填,对本次交易的说明（建议填写已经和卖家达成一致的说明）" placeholder="选填,建议填写和卖家达成一致的说明" class="memo-input J_MakePoint c2c-text-default memo-close">
										<div class="msg hidden J-msg">
											<p class="error">最多输入500个字符</p>
										</div>
									</div>
								</div>

							</div>
							
							<div class="clear"></div>
							
							<div class="buy-point-discharge ">
								<p class="price g_price ">
									合计 <span>¥</span><em class="pay-sum"><%=totalPrice %></em>
								</p>
							</div>

							<!--信息 -->
							<div class="order-go clearfix">
								<div class="pay-confirm clearfix">
									<div class="box">
										<div tabindex="0" id="holyshit267" class="realPay"><em class="t">实付款：</em>
											<span class="price g_price ">
                                    		<span>¥</span> <em class="style-large-bold-red " id="J_ActualFee"><%=totalPrice %></em>
											</span>
										</div>
										<div id="holyshit268" class="pay-address">
											<p class="buy-footer-address">
												<span class="buy-line-title buy-line-title-type">寄送至：</span>
												<span class="buy--address-detail">
												<span id="street-selected" class="street"></span>
												</span>
											</p>
											<p class="buy-footer-address">
												<span class="buy-line-title">收货人：</span>
												<span class="buy-address-detail">   
                                         			<span id="buy-user-selected" class="buy-user"></span>
												<span id="buy-phone-selected" class="buy-phone"></span>
												</span>
											</p>
										</div>
									</div>

									<div id="holyshit269" class="submitOrder">
										<div class="go-btn-wrap">
											<a id="J_Go" href="/FrontOrderServlet?method=add&meid=<%=meid%>&info=<%=parainfo%>" class="btn-go" tabindex="0" title="点击此按钮，提交订单">提交订单</a>
										</div>
									</div>
									<div class="clear"></div>
								</div>
							</div>
						</div>

						<div class="clear"></div>
					</div>
				</div>
				
			</div>
			<div class="theme-popover-mask"></div>
			<div class="theme-popover">

				<!--标题 -->
				<div class="am-cf am-padding">
					<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add address</small></div>
				</div>
				<hr/>

				<div class="am-u-md-12">
					<form class="am-form am-form-horizontal">

						<div class="am-form-group">
							<label for="user-name" class="am-form-label">收货人</label>
							<div class="am-form-content">
								<input type="text" id="user-name" placeholder="收货人">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-form-label">手机号码</label>
							<div class="am-form-content">
								<input id="user-phone" placeholder="手机号必填" type="email">
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-intro" class="am-form-label">详细地址</label>
							<div class="am-form-content">
								<textarea class="" rows="3" id="user-intro" placeholder="输入详细地址"></textarea>
								<small>100字以内写出你的详细地址...</small>
							</div>
						</div>

						<div class="am-form-group theme-poptit">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<div class="am-btn am-btn-danger">保存</div>
								<div class="am-btn am-btn-danger close">取消</div>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="clear"></div>
		<script>
			var href = "/FrontOrderServlet?method=add&meid=<%=meid%>&info=<%=parainfo%>&price=<%=totalPrice %>";
			
			$(".user-addresslist").click(function(){
				var username = $(this).find(".buy-user").text();
				var userphone = $(this).find(".buy-phone").text();
				var address = $(this).find(".street").text()
				$("#buy-user-selected").text(username);
				$("#street-selected").text(address)
				$("#buy-phone-selected").text(userphone);
				href = href.split("&aid")[0];
				href+="&aid="+$(this).attr("aid");
				href+="&remark="+$("#remark").val();
				$("#J_Go").attr("href",href);
			})
			
			$("#remark").blur(function(){
				href = href.split("&remark")[0];
				href+="&remark="+$("#remark").val();
				$("#J_Go").attr("href",href);
			})
			href+="&aid="+$(".defaultAddr").attr("aid");
			href+="&remark="+$("#remark").val();
			$("#J_Go").attr("href",href);
			var username = $(".defaultAddr").find(".buy-user").text();
			var userphone = $(".defaultAddr").find(".buy-phone").text();
			var address = $(".defaultAddr").find(".street").text()
			$("#buy-user-selected").text(username);
			$("#street-selected").text(address)
			$("#buy-phone-selected").text(userphone);
			
		</script>
	</body>
</html>
