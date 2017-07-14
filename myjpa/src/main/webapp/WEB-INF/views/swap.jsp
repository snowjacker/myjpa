<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hardInfo</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resource/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resource/echarts.min.js"></script>
</head>
<body>
	<h5>this is the hard page</h5>
	<button id="start">查看SWAP状态</button>
	<div id="main" style="width: 600px; height: 400px;"></div>
	全部：<input id="total" type="text">M<br>
	已用：<input id="used" type="text">M<br>
	可用：<input id="free" type="text">M<br>
	<script>
	$(document).ready(function() {
		function getdata() {
			$.ajax({
				type : "get", //请求方式  
				url : "http://localhost:8765/myjpa/hard/swap", //地址，就是action请求路径  
				dataType : "json",
				success : function(msg) {
					$("#total").val((msg[0]/1024).toFixed(2)); 
					$("#used").val((used=msg[1]/1024).toFixed(2)); 
					$("#free").val((free=msg[2]/1024).toFixed(2));
					var rate=((msg[1]/msg[0])*100).toFixed(2);
					var myChart = echarts.init(document.getElementById('main'));
					// 指定图表的配置项和数据
					var option = {
						tooltip : {
							formatter : "{a} <br/>{b} : {c}%"
						},
						toolbox : {
							feature : {
								restore : {},
								saveAsImage : {}
							}
						},
						series : [ {
							name : 'SWAP',
							type : 'gauge',
							detail : {
								formatter : '{value}%'
							},
							data : [ {
								value : rate,
								name : '交换区使用率'
							} ]
						} ]
					};
					myChart.setOption(option);
				},
				error : function(jqXHR) {
					alert("error:" + jqXHR.status);
				}
			})
		};
		//生成数据,循环调用
		setInterval(getdata,1000);
	})
</script>
</body>
</html>