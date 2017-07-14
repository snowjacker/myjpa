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
	<button id="start">查看CPU状态</button>
	<div id="main" style="width: 600px; height: 400px;"></div>

	<script type="text/javascript">
		$(document).ready(function() {
	
			function getdata() {
				$.ajax({
					type : "get", //请求方式  
					url : "http://localhost:8765/myjpa/hard/cpu", //地址，就是action请求路径  
					dataType : "text",
					success : function(msg) {
						var rate=(msg*100).toFixed(2);
						//拿到图表输出目标
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
							series : [
								{
									name : 'CPU',
									type : 'gauge',
									detail : {
										formatter : '{value}%'
									},
									data : [ {
										value : rate,
										name : 'CPU总体运行情况'
									} ]
								}
							]
						};
						myChart.setOption(option);
					},
					error : function(jqXHR) {
						alert("error:" + jqXHR.status);
					}
				})
			};
			setInterval(getdata,1000);
		})
	</script>
</body>
</html>