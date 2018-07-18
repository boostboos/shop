<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8">
		<title>订单管理</title>
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
                          	订单管理 <small>订单查询</small>
                     </h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<!-- 订单列表--bootstrap高级表格使用 -->
						<div class="panel panel-default">
							<div class="panel-heading">
								输入条件查询订单
							</div>
							<div class="panel-body">
								<form action="/OrdersServlet" method="get">
									<input type="hidden" name="method" value="query"/>
									<div class="form-group">
										<label for="txtMeid">会员姓名</label>
										<input type="text" class="form-control" name="meid" id="txtMeid" placeholder="会员姓名">
									</div>
									<div class="form-group">
										<label for="txtdownDate">下单日期</label>
										<input type="date" class="form-control" name="downDate" id="txtdownDate" value="2018-01-01">
									</div>
									<div class="form-group">
										<label for="txtfinishDate">确认收货日期</label>
										<input type="date" class="form-control" name="finishDate" id="txtfinishDate" value="2018-08-01">
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