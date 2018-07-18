<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8">
		<title>分类详情管理</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="/css/bootstrap.css" />
		<link rel="stylesheet" href="/admin/css/index.css" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">   
		<%
			String cid = request.getParameter("cid");
			System.out.println(cid);
		%>
		<body>
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">
                          	添加分类详情 <small>添加分类详情信息</small>
                     </h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<!-- 分类详情列表--bootstrap高级表格使用 -->
						<div class="panel panel-default">
							<div class="panel-heading">
								输入需要添加的信息
							</div>
							<div class="panel-body">
								<form action="/SubCatalogsServlet" method="post">
									<input type="hidden" name="method" value="add">	
									<input type="hidden" name="cid" value=<%=cid%>>						
									<div class="form-group">
										<label for="txtscname">分类名称</label>
										<input type="text" class="form-control" name="scname" id="txtscname" placeholder="subcatalogsName">
									</div>
									<div class="form-group">
										<label for="txtsubcatalogsDetail">子类信息</label>
										<input type="text" class="form-control" name="subcata" id="txtsubcatalogsDetail" placeholder="subcatalogsDetail">
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