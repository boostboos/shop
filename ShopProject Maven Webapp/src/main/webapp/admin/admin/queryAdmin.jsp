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
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">   
		
		<body>
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">
                          	用户管理 <small>用户查询</small>
                     </h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<!-- 用户列表--bootstrap高级表格使用 -->
						<div class="panel panel-default">
							<div class="panel-heading">
								输入条件查询用户
							</div>
							<div class="panel-body">
								<form action="/AdminServlet" method="get">
									<input type="hidden" name="method" value="query"/>
									<div class="form-group">
										<label for="txtUsername">用户名</label>
										<input type="text" class="form-control" name="username" id="txtUsername" placeholder="username">
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
									<button type="submit" class="btn btn-success">查询</button>
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