<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8">
		<title>电商系统登录</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">   
		<link rel="stylesheet" href="../css/bootstrap.css"/>
		<link rel="stylesheet" href="../css/login.css" />
	</head>
	<body>
		<div class="container">
			<div class="row">
				<header class="col-md-offset-4 col-md-4 col-xs-offset-2 col-xs-8">
					<h1>电商登录系统</h1>
					<span class="glyphicon glyphicon-home"></span>
				</header>
			</div>
			<div class="row">
				<div class="loginbg col-md-offset-4 col-md-4 col-sm-offset-3 col-sm-6 col-xs-offset-3 col-xs-6">
					<div class="login-head">
						<img class="img-circle" alt="" src="../images/test/head_120.png"  />
					</div>
					<form class="login-form" action="/AdminServlet?method=login" method="post">
						<div class="input-group">
							<span class="input-group-addon glyphicon glyphicon-user"></span>
							<input type="text" class="form-control" name="username" placeholder="userName" required="required" autofocus="autofocus" />
						</div>
						<div class="input-group">
							<span class="input-group-addon glyphicon glyphicon-lock"></span>
							<input type="password" class="form-control" name="passwd"  placeholder="password" required="required" />
						</div>
						<div class="row">
						<div class="col-md-8">
						<div class="input-group">
							<span class="input-group-addon glyphicon glyphicon-qrcode"></span>
							<input type="text" class="form-control" name="verfiyCode"  placeholder="verifyCode" required="required"/>
						</div>
						</div>
						<div class="col-md-4">
						<image src="/VerfiyCodeServlet" size="2" />
						</div>
						</div>
						<div class="login-btn">
						<button class="btn btn-lg btn-warning btn-block" type="submit">登录</button>
						</div>
					</form>
				</div> 
			</div>
		</div>
	</body>
</html>
