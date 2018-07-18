<%@page import="com.legendary.entity.Goods"%>
<%@page import="com.legendary.entity.Catalogs"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8">
		<title>商品管理</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="/css/bootstrap.css" />
		<link rel="stylesheet" href="/admin/css/index.css" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">   
		
		<script src="/admin/js/jquery-3.3.1.js"></script>
		<script src="/admin/js/bootstrap-select.js"></script>
		<script src="/admin/js/bootstrap.js"></script>
		<script src="/admin/js/i18n/defaults-zh_CN.js"></script>
		<link href="/admin/css/bootstrap-select.min.css" rel="stylesheet" />
		<link href="/admin/css/bootstrap.min.css" rel="stylesheet" />
		
		<body>
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">
                          	修改商品 <small>商品信息修改</small>
                     </h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<!-- 商品列表--bootstrap高级表格使用 -->
						<div class="panel panel-default">
							<div class="panel-heading">
								输入需要修改的信息
							</div>
							<div class="panel-body">
								<form action="/GoodsServlet" method="get">
										<input type="hidden" name="method" value="edit"/>
										<input type="hidden" name="gid" value="${goods.gid }"/>
										<input type="hidden" name="sales" value="${goods.sales }"/>
									<div class="form-group">
										<label for="txtGoodname">商品名称</label>
										<input type="text" class="form-control" value="${goods.gname }" name="gname" id="txtGoodname" placeholder="Goodname">
									</div>
									<div class="form-group">
									<%
										int cnt = 0;
										Map<String,List<String>> spec = (Map<String,List<String>>) request.getAttribute("catalogs");
										Goods good = (Goods)request.getAttribute("goods");
										String selectedCatalogs = good.getKeyword();
										for (String key : spec.keySet()) {
											if(cnt % 4 == 0) {
												out.write("<div class=\"row\">");
											}
											out.write("<div class=\"col-md-3\">");
											out.write("<div class=\"form-group\">");
											out.write("<label for=\"txtspecdetail\">"+key+"</label><br/>");
											out.write("<select class=\"selectpicker test\" name=\""+ key +"\" multiple data-selected-text-format=\"count > 3\">");
									  		List<String> values = spec.get(key);
									  		for(int i = 0; i < values.size(); i++) {
									  			if(i % 2 == 0) {
									  				out.write("<optgroup label="+values.get(i)+" >");
									  			}
									  			else {
									  				String[] subcatas = values.get(i).split(",");
									  				for(String subcata : subcatas) {
									  					if(selectedCatalogs.contains(subcata))
												  			out.write("<option selected=\"ture\" value=\""+values.get(i-1)+","+subcata+"\">"+subcata+"</option>");
									  					else
									  						out.write("<option value=\""+values.get(i-1)+","+subcata+"\">"+subcata+"</option>");
										  				
									  				}
											  		out.write("</optgroup>");
									  			}
									  		}
											out.write("</select>");
											out.write("</div>");
											out.write("</div>");
											cnt++;
											if(cnt % 4 == 0)
												out.write("</div>");
									  	}
									%>
									</div>
									<div class="form-group">
										<label for="txtDetail">商品详情</label>
										<input type="text" class="form-control" value="${goods.detail }" name="detail" id="txtDetail" placeholder="detail">
									</div>
									<div class="form-group">
										<label for="txtState">商品状态</label>
										<input type="text" class="form-control" value="${goods.state }" name="state" id="txtsellPrice" placeholder="state">
									</div>
									<div class="form-group">
										<label for="txtshelves">是否上架</label>
										<input type="text" class="form-control" value="${goods.shelves }" name="shelves" id="txtshelves" placeholder="shelves">
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