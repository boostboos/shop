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
		<link href="/admin/goodsDetail/css/bootstrap.min.css" rel="stylesheet">
        <link href="/admin/goodsDetail/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
        <script src="/admin/goodsDetail/js/fileinput.js" type="text/javascript"></script>
		<%
			String gid = request.getParameter("gid");
			System.out.println(gid);
		%>
		<body>
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">
                          	添加商品 <small>添加商品信息</small>
                     	</h1>
					</div>
				</div>
				<div class="row">
					<div class="panel panel-default">
						<div class="panel-heading">
							输入需要添加的信息
						</div>
						<div class="panel-body">
							<form action="/GoodsDetailServlet" enctype="multipart/form-data" method="post">
								<input type="hidden" id="gid" name="gid" value="<%=gid %>">
								<input id="method" type="hidden" name="method" value="add"/>
								<input type="hidden" name="btnSubmit" value="btnSubmit"/>
							
								<div class="col-md-6">						
									<div class="form-group">
									<label for="txtspecdetail">规格详情</label><br/>
									<select id="specdetail" name="value" class="selectpicker" multiple>
										<%
											Map<String,List<String>> spec = (Map<String,List<String>>) request.getAttribute("spec");
											
											for (String key : spec.keySet()) {
												out.write("<optgroup label="+key+" data-max-options=\"1\">");
										  		for (String value : spec.get(key)) {
										  			out.write("<option>"+value+"</option>");
										  		}
										  		out.write("</optgroup>");
											}
										%>
									</select>
									</div>
									<div class="form-group">
										<label for="txtPurchprice">进价</label>
										<input id="purchprice" type="text" class="form-control" name="purchprice" id="txtPurchprice" placeholder="Purchprice">
									</div>
									<div class="form-group">
										<label for="txtSellprice">售价</label>
										<input id="sellprice" type="text" class="form-control" name="sellprice" id="txtSellprice" placeholder="Sellprice">
									</div>
									<div class="form-group">
										<label for="txtMarketprice">市场价</label>
										<input id="marketprice" type="text" class="form-control" name="marketprice" id="txtMarketprice" placeholder="Marketprice">
									</div>
									<div class="form-group">
										<label for="txtNumber">库存</label>
										<input id="number" type="text" class="form-control" name="number" id="txtNumber" placeholder="number">
									</div>
									</div>
									<div class="col-md-6">
									<div class="container kv-main row" style="height:260px">
										<div class="col-md-4">
				                			<div class="form-group">
				                    			<input id="file-1" type="file" name="picinfo" class="file" data-overwrite-initial="false" >
				                			</div>
	        							</div>
									</div>
									</div>
								<div class="col-md-12" id="pic">
									<input id="submitbtn" type="submit" class="btn btn-success" value="提交修改"/>
								</div>
								</form>
							</div>
						</div>
				</div>
			</div>
		</body>
	<script>
	$('#submitbtn').click(function(){
		$('#file-1').fileinput("upload")
	})
    $("#file-1").fileinput({
        uploadUrl: '/GoodsDetailServlet?method=add', // you must set a valid URL here else you will get an error
        allowedFileExtensions : ['jpg', 'png','gif'],
        overwriteInitial: false,
        showUpload: false,
        maxFileSize: 1000,
        maxFilesNum: 10,
        layoutTemplates :{
            actionUpload:'',
            actionZoom:''
        },
        slugCallback: function(filename) {
            return filename.replace('(', '_').replace(']', '_');
        },
	    uploadExtraData: function(previewId, index){
	    	var data = {
	    		specdetail : $("#specdetail").val(),
	    		purchprice : $("#purchprice").val(),
	    		sellprice : $("#sellprice").val(),
	    		marketprice : $("#marketprice").val(),
	    		number : $("#number").val(),
	    		gid : $("#gid").val()
            };
            return data;
	    }
	});
	</script>
</html>