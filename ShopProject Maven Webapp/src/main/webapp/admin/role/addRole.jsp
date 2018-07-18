<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8">
		<title>角色管理</title>
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
                          	添加角色 <small>添加角色信息</small>
                     </h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								输入需要添加的信息
							</div>
							<div class="panel-body">
								<form action="/RoleServlet" method="post">		
								<input type="hidden" name="method" value="add"/>
									<div class="form-group">
										<label for="txtRolename">角色名</label>
										<input type="text" class="form-control" name="roleName" id="txtRolename" placeholder="roleName">
									</div>
									<div class="form-group">
										<label for="txtRemark">备注</label>
										<input type="text" class="form-control" name="remark" id="txtRemark" placeholder="remark">
									</div>
									<div class="form-group">
										<label for="txtAuthority">角色权限</label>
										<input type="text" class="form-control" name="authority" id="txtAuthority" placeholder="authority">
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
		</body>

</html>