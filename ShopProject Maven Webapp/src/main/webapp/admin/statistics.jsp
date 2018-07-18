<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.legendary.entity.StatisticsHelper"%>
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
		<script type="text/javascript" src="/admin/js/echarts.simple.min.js"></script>
	</head>
	<body>
	<%
		String[] allCount = request.getAttribute("allCount").toString().split(",");
		for(int i = 0; i < allCount.length;i++) {
			System.out.print(allCount[i]+",");
		}
	%>
	<div class="container" style="margin-top: 10px;">
			<div class="row">
				<div class="col-md-3 col-sm-12 col-xs-12">
					<div class="panel panel-primary text-center no-boder bg-color-green">
						<div class="panel-body">
							<i class="glyphicon glyphicon-shopping-cart fa fa-5x"></i>
							<h3><%=allCount[0] %></h3>
						</div>
						<div class="panel-footer back-footer-green">
							订单数量
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12">
					<div class="panel panel-primary text-center no-boder bg-color-blue">
						<div class="panel-body">
							<i class="glyphicon glyphicon-yen glyphicon fa fa-5x"></i>
							<h3><%=allCount[1] %> </h3>
						</div>
						<div class="panel-footer back-footer-blue">
							成交金额
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12">
					<div class="panel panel-primary text-center no-boder bg-color-red">
						<div class="panel-body">
							<i class="glyphicon glyphicon-retweet fa fa-5x "></i>
							<h3><%=allCount[2] %> </h3>
						</div>
						<div class="panel-footer back-footer-red">
							待处理订单
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12">
					<div class="panel panel-primary text-center no-boder bg-color-brown">
						<div class="panel-body">
							<i class="glyphicon glyphicon-bed fa fa-5x"></i>
							<h3><%=allCount[3] %></h3>
						</div>
						<div class="panel-footer back-footer-brown">
							待发货订单
						</div>
					</div>
				</div>
			</div>

			<!--条图-->
			<div class="row">

				<div class="col-md-6 col-sm-12 col-xs-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							订单统计图
						</div>
						<div class="panel-body">
							<div id="echarts_post1" style="width:500px;height:400px;"></div>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-sm-12 col-xs-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							分类成交量统计图
						</div>
						<div class="panel-body">
							<div id="echarts_post2" style="width:500px;height:400px;"></div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<%
			Map<String,Integer> cata = (Map<String,Integer>)request.getAttribute("cata");
			List<StatisticsHelper> shList = (List<StatisticsHelper>)request.getAttribute("shList");
		%>
		<!--引入js-->
		<script type="text/javascript" src="/admin/js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="/admin/js/bootstrap.js"></script>
		<script type="text/javascript">
		$(function(){
			postChart();
			postCharts();
		});
		//学员职务统计图
		function postChart(){
			var myChart = echarts.init(document.getElementById('echarts_post1')); 
			var option = {
		    xAxis: {
			        type: 'category',
			        <%
			        	out.write("data: [");
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			        	for(int i = 0; i < shList.size();i++){
			        		out.write("'"+df.format(shList.get(i).getDownDate())+"',");
			        	}
			        	out.write("]");
			        %>
			    },
			    yAxis: {
			        type: 'value'
			    },
			    series: [{
			    	<%
				    	out.write("data: [");
			        	for(int i = 0; i < shList.size();i++){
			        		out.write(shList.get(i).getNumber()+",");
			        	}
			        	out.write("],");
		        	%>
			        type: 'line'
			    }]
			};
			
				myChart.setOption(option); 
		}
		
		
		function postCharts() {
			var myChart = echarts.init(document.getElementById('echarts_post2')); 
			var option = {
		    backgroundColor: '#FFF',
		
		    title: {
		        text: 'Customized Pie',
		        left: 'center',
		        top: 20,
		        textStyle: {
		            color: '#ccc'
		        }
		    },
		
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		
		    visualMap: {
		        show: false,
		        min: 80,
		        max: 600,
		        inRange: {
		            colorLightness: [0, 1]
		        }
		    },
		    series : [
		        {
		            name:'分类销量',
		            type:'pie',
		            radius : '55%',
		            center: ['50%', '50%'],
		            data:[
		            	<%
		            		for(String key:cata.keySet()) {
		            			out.write("{value:"+cata.get(key)+", name:'"+key+"'},");
		            		}
		            	%>
		            ].sort(function (a, b) { return a.value - b.value; }),
		            roseType: 'radius',
		            label: {
		                normal: {
		                    textStyle: {
		                        color: 'rgba(0, 0, 0, 1)'
		                    }
		                }
		            },
		            labelLine: {
		                normal: {
		                    lineStyle: {
		                        color: 'rgba(0, 0, 0, 0.3)'
		                    },
		                    smooth: 0.2,
		                    length: 10,
		                    length2: 20
		                }
		            },
		            itemStyle: {
		                normal: {
		                    color: '#c23531',
		                    shadowBlur: 200,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            },
		
		            animationType: 'scale',
		            animationEasing: 'elasticOut',
		            animationDelay: function (idx) {
		                return Math.random() * 200;
		            }
		        }
		    ]
		};
			myChart.setOption(option); 
		}
		
		</script>
	</body>
</html>