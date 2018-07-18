<%@page import="com.legendary.entity.Address"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
  
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	
<title>付款成功页面</title>
<link rel="stylesheet"  type="text/css" href="/front/AmazeUI-2.4.2/assets/css/amazeui.css"/>
<link href="/front/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
<link href="/front/basic/css/demo.css" rel="stylesheet" type="text/css" />

<link href="/front/css/sustyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/front/basic/js/jquery-1.7.min.js"></script>

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

<%
	Address address = (Address)request.getAttribute("address");
	String price = request.getAttribute("price").toString();
	String oid = request.getAttribute("oid").toString();
%>

<div class="take-delivery">
 <div class="status">
   <div class="successInfo">
     <ul>
     	<h2 id="payInfo"></h2>
       <li>付款金额<em><%=price %></em></li>
       <div class="user-info">
         <p>收货人：<%=address.getReceivername() %></p>
         <p>联系电话：<%=address.getReceiverphone() %></p>
         <p>收货地址：<%=address.getAddressinfo() %></p>
       </div>
             请认真核对您的收货信息，如有错误请联系客服
     </ul>
     <div id="unpayOption" class="option">
        <a href="#" id="confirmPay" class="J_MakePoint"><span>确认付款</span></a>
        <a href="/OrderServlet?method=delete&oid=<%=oid%>" class="J_MakePoint"><span>取消订单</span></a>
     </div>
     
     <div id="payOption" class="option">
       <span class="info">您可以</span>
        <a href="/FrontOrderServlet?method=query&meid=${session_memb.meid }" class="J_MakePoint">查看<span>已买到的宝贝</span></a>
     </div>
    </div>
  </div>
</div>


<script type="text/javascript">
	$("#payOption").hide();
	$("#confirmPay").click(function(){
		$("#payOption").toggle()
		$("#unpayOption").toggle()
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("GET","/FrontOrderServlet?method=pay&oid=<%=oid%>",true);
		xmlHttp.send(null);
		xmlHttp.onreadystatechange = function() {
		if(xmlHttp.status == 200 && xmlHttp.readyState == 4) {
			var text = xmlHttp.responseText;
			$("#payInfo").text(text);
		}
	}
	})

</script>

</body>
</html>
