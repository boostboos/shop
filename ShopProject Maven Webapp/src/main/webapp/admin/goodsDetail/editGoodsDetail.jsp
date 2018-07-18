<%@page import="com.legendary.entity.GoodsDetail"%>
<%@page import="java.io.Writer"%>
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
		<body>
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-header">
                          	添加商品 <small>添加商品信息</small>
                     	</h1>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						输入需要添加的信息
					</div>
					<div class="panel-body">
						<form action="/GoodsDetailServlet" enctype="multipart/form-data" method="post">
							<input id="gdid" type="hidden" name="gdid" value="${goodsDetail.gdid}"/>
							<input id="gid" type="hidden" name="gid" value="${goodsDetail.gid}"/>
							<input id="method" type="hidden" name="method" value="edit"/>
							<input type="hidden" name="btnSubmit" value="btnSubmit"/>
								<div class="col-md-6">	
								<div class="form-group">
									<div class="row">
									<div class="col-md-6">	
									<label for="txtspecdetail">规格详情</label><br/>	
										<select id="specdetail" name="specdetail" class="selectpicker" multiple>
											<%
												GoodsDetail goodsDetail = (GoodsDetail)request.getAttribute("goodsDetail");
												String[] selected = goodsDetail.getSpecdetail().split(",");
												Map<String,List<String>> spec = (Map<String,List<String>>) request.getAttribute("spec");
												for (String key : spec.keySet()) {
													out.write("<optgroup label="+key+" data-max-options=\"1\">");
											  		for (String value : spec.get(key)) {
											  			boolean isSelected = true;
											  			for(int i = 0; i < selected.length; i++) {
											  				if(value.equals(selected[i])) {
													  			out.write("<option selected=\"true\">"+value+"</option>");
													  			isSelected = false;
													  			break;
											  				}
											  			}
											  			if(isSelected)
											  				out.write("<option>"+value+"</option>");
											  		}
											  		out.write("</optgroup>");
												}
											%>
										</select>
										</div>
										<div class="col-md-6">
											<label for="txtPictureId">图片id</label>
										<div class="input-group">
						                    <input id="pictureId" type="text" value="${goodsDetail.pid}" name="pid"  placeholder="pictureId" class="form-control">
						                    <span class="input-group-btn">
						                        <button id="picbtn" class="btn btn-default" type="button">更换图片</button>
						                    </span>
						                </div>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="txtPurchprice">进价</label>
									<input id="purchprice" type="text" class="form-control" value="${goodsDetail.purchprice}" name="purchprice" placeholder="Purchprice">
								</div>
								<div class="form-group">
									<label for="txtSellprice">售价</label>
									<input id="sellprice" type="text" class="form-control" value="${goodsDetail.sellprice}" name="sellprice" id="txtSellprice" placeholder="Sellprice">
								</div>
								<div class="form-group">
									<label for="txtMarketprice">市场价</label>
									<input id="marketprice" type="text" class="form-control" value="${goodsDetail.marketprice}" name="marketprice"placeholder="Marketprice">
								</div>
								<div class="form-group">
									<label for="txtNumber">库存</label>
									<input id="number"type="text" class="form-control" value="${goodsDetail.number}" name="number"  placeholder="number">
								</div>
								</div>
								<div class="col-md-6" id="uploadPic">
									<div class="container kv-main row" style="height:260px">
										<div class="col-md-4">
				                			<div class="form-group">
				                    			<input id="file-1" type="file" name="picinfo" class="file" data-overwrite-initial="false" >
				                			</div>
	        							</div>
									</div>
								</div>
								<div class="col-md-6" id="pic">
									<div class="container kv-main row" style="height:260px">
									<div class="col-md-4">
									<img src="${infos }" class="img-rounded" height="260px">
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
		</body>
	<script>
	$('#submitbtn').click(function(){
		$('#file-1').fileinput("upload")
	})
	 $('#picbtn').click(function(){
		 $('#pic').toggle();
		 $('#uploadPic').toggle();
	 })
	 $('#uploadPic').hide();
	 $("#file-1").fileinput({
	        uploadUrl: '/GoodsDetailServlet?method=edit', 
	        allowedFileExtensions : ['jpg', 'png','gif'],
	        overwriteInitial: false,
	        uploadAsync: false,
	        showUpload: false,
	        maxFileSize: 1000,
	        layoutTemplates :{
	            actionUpload:'',
	            actionZoom:''
	        },
	        maxFilesNum: 10,
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
		    		gid : $("#gid").val(),
		    		gdid: $("#gdid").val(),
		    		pid: $("#pictureId").val()
	            };
	            return data;
		    }
		});
	</script>
</html>