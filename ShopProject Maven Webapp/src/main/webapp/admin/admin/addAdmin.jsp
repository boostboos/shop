<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8">
		<title>用户管理</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="/css/bootstrap.css" />
		<link rel="stylesheet" href="/admin/css/index.css" />

	<link href="/admin/css/bootstrap-select.min.css" rel="stylesheet" />
	<link href="/admin/css/bootstrap.min.css" rel="stylesheet" />
	
	<script src="/admin/js/jquery-3.3.1.js"></script>
	<script src="/admin/js/bootstrap-select.js"></script>
	<script src="/admin/js/bootstrap.js"></script>
	<script src="/admin/js/i18n/defaults-zh_CN.js"></script>
		
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">   
		
		<body>
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">
                          	添加用户 <small>添加用户信息</small>
                     </h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<!-- 用户列表--bootstrap高级表格使用 -->
						<div class="panel panel-default">
							<div class="panel-heading">
								输入需要添加的信息
							</div>
							<div class="panel-body">
								<form action="/AdminServlet" method="post">
										<input type="hidden" name="method" value="add"/>								
									<div class="form-group">
										<label for="txtUsername">用户名</label>
										<input type="text" class="form-control" name="username" id="txtUsername" placeholder="username">
									</div>
									<div class="form-group">
										<label for="txtPasswd">密码</label>
										<input type="text" class="form-control" name="passwd" id="txtPasswd" placeholder="passwd">
									</div>
									<div class="form-group">
										<label for="txtRid">角色id</label>
										<input type="text" class="form-control" name="rid" id="txtRid" placeholder="rid">
									</div>
									<div class="form-group">
										<label for="txtRealname">真实姓名</label>
										<input type="text" class="form-control" name="realname" id="txtRealname" placeholder="realname">
									</div>
									<div class="form-group">
										<label for="txtGender">性别</label>
										<input type="text" class="form-control" name="gender" id="txtGender" placeholder="gender">
									</div>
									<div class="form-group">
										<label for="txtEmail">邮箱</label>
										<input type="text" class="form-control" name="email" id="txtEmail" placeholder="email">
									</div>
									<div class="form-group">
										<label for="txtRemark">备注</label>
										<input type="text" class="form-control" name="remark" id="txtRemark" placeholder="remark">
									</div>
									<div class="form-group">
										<label for="txtPhone">电话号码</label>
										<input type="text" class="form-control" name="phone" id="txtPhone" placeholder="phone">
									</div>
									<button type="submit" class="btn btn-success">添加</button>
									<button type="reset" class="btn btn-info">重置</button>
								</form>
							</div>
						</div>
					</div>
					<!--表格结束 -->
				</div>
			</div>
			</div>
		</body>

</html>