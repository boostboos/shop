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
				<div class="panel panel-default">
					<div class="panel-heading">
							商品列表
						</div>
						<div class="panel-body">
							<!--table-responsive响应式表格，会自动添加滚动条-->
							<div class="table-responsive">
								<a href="/GoodsDetailServlet?method=preAdd&gid=${gid }">
									<button type="button" class="btn btn-info btn-md">
		  								<span class="glyphicon glyphicon-plus"></span> 添加
									</button>
								</a>
								<table class="table table-striped table-bordered table-hover" id="dataTables-example">
									<thead>
										<tr>
											<th>编号</th>
											<th>规格详情</th>
											<th>进货价格</th>
											<th>销售价格</th>
											<th>市场价格</th>
											<th>库存</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${pb.beanList}" var="goodsDetail">
												<tr class="odd gradeX">
													<td>${goodsDetail.gdid}</td>
													<td>${goodsDetail.specdetail}</td>
													<td>${goodsDetail.purchprice}</td>
													<td>${goodsDetail.sellprice}</td>
													<td>${goodsDetail.marketprice}</td>
													<td>${goodsDetail.number}</td>
													<td> 
														<a title="修改" href="/GoodsDetailServlet?method=preEdit&gdid=${goodsDetail.gdid }" class="t-edit lyphicon glyphicon-pencil"></a>
														<a title="删除" href="/GoodsDetailServlet?method=delete&gdid=${goodsDetail.gdid }&gid=${goodsDetail.gid}" class="t-del glyphicon glyphicon-trash"></a>
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
