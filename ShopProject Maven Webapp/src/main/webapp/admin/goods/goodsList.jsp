<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="UTF-8">
		<title>商品管理</title>
		
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="/css/bootstrap.css" />
		<link rel="stylesheet" href="/admin/css/index.css" />
	</head>

	<body>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<h1 class="page-header">
                          	商品管理 <small>商品列表</small>
                    </h1>
				</div>
			</div>
		<div class="row">
			<div class="col-md-12">
			<div class="col-md-12">
					<!-- 商品列表--bootstrap高级表格使用 -->
					<div class="panel panel-default">
						<div class="panel-heading">
							商品列表
						</div>
						<div class="panel-body">
							<!--table-responsive响应式表格，会自动添加滚动条-->
							<div class="table-responsive">
								<a href="/admin/goods/queryGoods.jsp">
									<button type="button" class="btn btn-primary btn-md">
		  								<span class="glyphicon glyphicon-search"></span> 搜索
									</button>
								</a>
								<table class="table table-striped table-bordered table-hover" id="dataTables-example">
									<thead>
										<tr>
											<th>编号</th>
											<th>名称</th>
											<th>详情</th>
											<th>状态</th>
											<th>是否上架</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${pb.beanList}" var="goods">
												<tr class="odd gradeX">
													<td>${goods.gid}</td>
													<td>${goods.gname}</td>
													<td>${goods.detail}</td>
													<td>${goods.state}</td>
													<td>${goods.shelves}</td>
													<td> 
														<a title="修改" href="/GoodsServlet?method=preEdit&gid=${goods.gid }" class="t-edit lyphicon glyphicon-pencil"></a>
														<a title="添加" href="/GoodsDetailServlet?method=preAdd&gid=${goods.gid }" class="t-edit glyphicon glyphicon-plus"></a>
														<a title="删除" href="/GoodsServlet?method=delete&gid=${goods.gid }" class="t-del glyphicon glyphicon-trash"></a>
														<a title="查看" href="/GoodsDetailServlet?method=query&gid=${goods.gid }" class="t-del glyphicon glyphicon-zoom-in"></a>
												    </td>
												</tr>
										</c:forEach>										
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!--表格结束 -->
				</div>
			</div>
		</div>
		<center>
			<ul class="pagination">
			<li>
			<span >第${pb.pageCode }页/共${pb.totalPage }页</span>
			</li>
			<li><a href="${pb.url }&pc=1">首页</a></li>
			<c:if test="${pb.pageCode > 1 }">
			<li><a href="${pb.url }&pc=${pb.pageCode-1}">上一页</a></li>
			</c:if>
			
			<%-- 计算begin、end --%>
			<c:choose>
				<%-- 如果总页数不足10页，那么把所有的页数都显示出来！ --%>
				<c:when test="${pb.totalPage <= 10 }">
					<c:set var="begin" value="1" />
					<c:set var="end" value="${pb.totalPage }" />
				</c:when>
				<c:otherwise>
					<%-- 当总页数>10时，通过公式计算出begin和end --%>
					<c:set var="begin" value="${pb.pageCode-5 }" />
					<c:set var="end" value="${pb.pageCode+4 }" />	
					<%-- 头溢出 --%>
					<c:if test="${begin < 1 }">
						<c:set var="begin" value="1" />
						<c:set var="end" value="10" />
					</c:if>	
					<%-- 尾溢出 --%>
					<c:if test="${end > pb.totalPage }">
						<c:set var="begin" value="${pb.totalPage - 9 }" />
						<c:set var="end" value="${pb.totalPage }" />
					</c:if>	
				</c:otherwise>
			</c:choose>
			<%-- 循环遍历页码列表 --%>
			<c:forEach var="i" begin="${begin }" end="${end }">
				<c:choose>
					<c:when test="${i eq pb.pageCode }">
						<li><a href="#">${i }</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${pb.url }&pc=${i}">${i }</a></li>	
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${pb.pageCode < pb.totalPage }">
				<li><a href="${pb.url }&pc=${pb.pageCode+1}">下一页</a></li>
			</c:if>
			<li><a href="${pb.url }&pc=${pb.totalPage}">尾页</a></li>
			</ul>
		</center>
	</body>
</html>
