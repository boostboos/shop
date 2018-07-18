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
                          	修改用户 <small>用户信息修改</small>
                     </h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<!-- 用户列表--bootstrap高级表格使用 -->
						<div class="panel panel-default">
							<div class="panel-heading">
								输入需要修改的信息
							</div>
							<div class="panel-body">
								<form action="/AdminServlet" method="get">
										<input type="hidden" name="method" value="edit"/>
										<input type="hidden" name="aid" value="${admin.aid }"/>
									<div class="form-group">
										<label for="txtUsername">用户名</label>
										<input type="text" class="form-control" value="${admin.username }" name="username" id="txtUsername" placeholder="username">
									</div>
									<div class="form-group">
										<label for="txtPasswd">密码</label>
										<input type="text" class="form-control" value="${admin.passwd }" name="passwd" id="txtPasswd" placeholder="passwd">
									</div>
									<div class="form-group">
										<label for="txtrid">角色id</label>
										<input type="text" class="form-control" value="${admin.rid }" name="rid" id="txtrid" placeholder="rid">
									</div>
									<div class="form-group">
										<label for="txtRealname">真实姓名</label>
										<input type="text" class="form-control" value="${admin.realname }" name="realname" id="txtRealname" placeholder="rid">
									</div>
									<div class="form-group">
										<label for="txtGender">性别</label>
										<input type="text" class="form-control" value="${admin.gender }" name="gender" id="txtUserName" placeholder="gender">
									</div>
									<div class="form-group">
										<label for="txtEmail">邮箱</label>
										<input type="text" class="form-control" value="${admin.email }" name="email" id="txtEmail" placeholder="email">
									</div>
									<div class="form-group">
										<label for="txtRemark">备注</label>
										<input type="text" class="form-control" value="${admin.remark }" name="remark" id="txtRemark" placeholder="remark">
									</div>
									<div class="form-group">
										<label for="txtPhone">电话号码</label>
										<input type="text" class="form-control" value="${admin.phone }" name="phone" id="txtPhone" placeholder="phone">
									</div>
									
									<button type="submit" class="btn btn-success">修改</button>
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