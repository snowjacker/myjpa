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
	src="${pageContext.request.contextPath }/resource/echarts.min.js">
	
</script>
</head>
<body id="divbody">
	<h5>this is the hard page</h5>
	<button id="start">查看CPU状态</button>
	<script type="text/javascript">
		$(document).ready(
				function() {
					function getdata() {
						$.ajax({
							type : "get", //请求方式  
							url : "http://localhost:8765/myjpa/hard/cpus", //地址，就是action请求路径 
							async : false,
							dataType : "json",
							success : function(msg) {
								for (var i = 0; i < msg.length; i++) {
									
									var rate = (msg[i].total*100).toFixed(2);
									var options = {
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
											name : 'CPU',
											type : 'gauge',
											detail : {
												formatter : '{value}%'
											},
											data : [ {
												value : rate,
												name : '线程'+(i+1)+'的使用率'
											} ]
										} ]
									};
									var res = document
											.getElementById("main" +i);
									if (!res) {
										$("#start").after(
												"<div id=main"+i+ " style=width:600px;height:400px;"+">"
														+ "</div>");
									}
									var myChart = echarts.init(document
											.getElementById('main' + i));
									myChart.setOption(options);
								}
							},
							error : function(jqXHR) {
								alert("error:" + jqXHR.status);
							}
						})
					}
					;
					setInterval(getdata, 1000);
				})
	</script>

</body>
</html>