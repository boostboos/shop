<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!--[if IE 9]><html class="no-js lt-ie10" lang="en"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js" lang="en"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <title>Legendary</title>
        <meta name="description" content="Legendary">
        <meta name="robots" content="noindex, nofollow">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">   
		        
        <link rel="stylesheet" href="/admin/css/bootstrap.min.css">
        <link rel="stylesheet" href="/admin/css/font-awesome.min.css">
        <link rel="stylesheet" href="/admin/css/main.css">
    </head>
    <body>
        <div id="page-wrapper" class="page-loading">
            <div class="preloader">
                <div class="inner">
                    <div class="preloader-spinner themed-background hidden-lt-ie10"></div>
                    <h3 class="text-primary visible-lt-ie10"><strong>Loading..</strong></h3>
                </div>
            </div>
            <div id="page-container" class="header-fixed-top sidebar-visible-lg-full">
                <div id="sidebar">
                    <div id="sidebar-brand" class="themed-background">
                        <a href="#" class="sidebar-title">
                            <i class="icon-cog"></i> 
                            <span class="sidebar-nav-mini-hide">Legendary</span>
                        </a>
                    </div>
                    <div id="sidebar-scroll">
                        <div class="sidebar-content">
                            <ul class="sidebar-nav">
                                <li>
                                    <a href="/StatisticsServlet?method=info" target="main"><i class="icon-home sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide"> 主页</span></a>
                                </li>
								<li>
                                    <a href="#" class="sidebar-nav-menu">
                                    	<i class="icon-chevron-right sidebar-nav-indicator sidebar-nav-mini-hide"></i>
                                   		<i class="icon-gift sidebar-nav-icon"></i>
                                   		<span class="sidebar-nav-mini-hide">订单信息</span></a>
                                    <ul>
                                        <li><a href="/OrdersServlet?method=queryAll" target="main">订单管理</a></li>
                                        <li><a href="/OrdersServlet?method=query&state=1" target="main">待付款订单</a></li>
                                        <li><a href="/OrdersServlet?method=query&state=2" target="main">待发货订单</a></li>
                                        <li><a href="/OrdersServlet?method=query&state=3" target="main">待收货订单</a></li>
                                        <li><a href="/OrdersServlet?method=query&state=4" target="main">待评价订单</a></li>
                                        <li><a href="/OrdersServlet?method=query&state=5" target="main">审查退货订单</a></li>
                                        <li><a href="/OrdersServlet?method=query&state=6" target="main">退货订单</a></li>
                                        <li><a href="/OrdersServlet?method=query&state=7" target="main">退货已发订单</a></li>
                                        <li><a href="/OrdersServlet?method=query&state=8" target="main">已完成订单</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#" class="sidebar-nav-menu">
                                    	<i class="icon-chevron-right sidebar-nav-indicator sidebar-nav-mini-hide"></i>
                                    	<i class="icon-group sidebar-nav-icon"></i>
                                    	<span class="sidebar-nav-mini-hide">商品信息</span></a>
                                    <ul>
                                        <li><a href="/GoodsServlet?method=query" target="main">商品管理</a></li>
                                        <li><a href="/SpecificationServlet?method=query" target="main">规格管理</a></li>
                                        <li><a href="/CatalogsServlet?method=query" target="main">类别管理</a></li>
                                        <li><a href="/GoodsServlet?method=publish" target="main">发布商品</a></li>
                                        <li><a href="/PicinfosServlet?method=query" target="main">图片管理</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#" class="sidebar-nav-menu">
                                    	<i class="icon-chevron-right sidebar-nav-indicator sidebar-nav-mini-hide"></i>
                                    	<i class="icon-gift sidebar-nav-icon"></i>
                                    	<span class="sidebar-nav-mini-hide">用户信息</span></a>
                                    <ul>
                                    	<li><a href="/AdminServlet?method=query" target="main">查询用户</a></li>
                                        <li><a href="/admin/admin/addAdmin.jsp" target="main">添加用户</a></li>
                                        <li><a href="/RoleServlet?method=query" target="main">查询角色</a></li>
                                        <li><a href="/admin/role/addRole.jsp" target="main">添加角色</a></li>
                                    </ul>
                                </li>
                               	<li>
                                    <a href="/MemberServlet?method=query" target="main"><i class="icon-home sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide">会员管理</span></a>
                                </li>

                                <li>
                                    <a href="#" class="sidebar-nav-menu">
                                    	<i class="icon-chevron-right sidebar-nav-indicator sidebar-nav-mini-hide"></i>
                                    	<i class="icon-gift sidebar-nav-icon"></i>
                                    	<span class="sidebar-nav-mini-hide">查看日志</span></a>
                                    <ul>
                                        <li><a href="/LogsServlet?method=query" target="main">用户日志</a></li>
                                        <li><a href="#">会员日志</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="/admin/picture/picture.jsp" target="main"><i class="icon-home sidebar-nav-icon"></i><span class="sidebar-nav-mini-hide"> 退出系统</span></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div id="main-container">
                    <header class="navbar navbar-inverse navbar-fixed-top">
                        <ul class="nav navbar-nav-custom">
                            <li>
                                <a href="javascript:void(0)" onclick="Tool.sidebar('toggle-sidebar');this.blur();">
                                    <i class="icon-reorder animation-fadeInRight" id="sidebar-toggle-mini"></i>
                                    <i class="icon-reorder animation-fadeInRight" id="sidebar-toggle-full"></i>
                                </a>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav-custom pull-right">
                            <li class="dropdown">
                                <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="https://gw.alicdn.com/tps/i3/TB1yeWeIFXXXXX5XFXXuAZJYXXX-210-210.png_60x60.jpg" alt="avatar">
                                    <span>${session_user.username }</span>
                                </a>
                                <ul class="dropdown-menu dropdown-menu-right">
                                    <li>
                                        <a href="#">
                                            <i class="icon-pencil fa-fw pull-right"></i>
                                            个人资料
                                        </a>
                                    </li>
                                    <li>
                                        <a href="login.html">
                                            <i class="icon-off fa-fw pull-right"></i>
                                            退出
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </header>
                    <div id="page-content">
			            <div id="page-wrapper">
							<div id="page-inner">
								<iframe id="external-frame" scrolling="no" onload="setIframeHeight(this)" name="main" width="100%" scrolling="auto" height="100%" src="/StatisticsServlet?method=info" frameborder="0"></iframe>
							</div>
						</div>
                    </div>
                </div>
            

            </div>
        </div>
        <script type="text/javascript">
			function setIframeHeight(iframe) {
				if(iframe) {
					var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
					if(iframeWin.document.body) {
						iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
					}
				}
			};

			window.onload = function() {
				setIframeHeight(document.getElementById('external-frame'));
			};
		</script>
		<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="/js/bootstrap.js"></script>
        <script src="/admin/js/vendor/jquery-2.2.4.min.js"></script>
        <script src="/admin/js/vendor/bootstrap.min.js"></script>
        <script src="/admin/js/plugins.js"></script>
        <script src="/admin/js/tool.js"></script>

    </body>
</html>