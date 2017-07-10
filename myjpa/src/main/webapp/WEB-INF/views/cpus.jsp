<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hardInfo</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resource/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(
			
			//处理ajax循环
			$("#start").click(function(event) {
				setInterval(getData(),1000)}),
			
		//处理ajax请求
		function getData() {
			$.ajax({
				type : "GET",
				url : "http://localhost:8765/myjpa/hard/cpus",
				datatype : "json",
				success : function(data) {
					 for(var i in data){
					        var total=data[i].total;
					      //拿到CPU运行状态的
					        alert(total);
					        //追加图表元素
					        $("#start").append("<div id="+"main"+(i+1)+ "style='width: 600px; height: 400px;'">+"</div>")
					        //追加数据元素，填充数据
					        .append("<input type='text'" + "id='data'+"+(i+1)+"value='"+total+"'");
					         }
				},
				error : function(jqXHR) {
					alert("error:" + jqXHR.status);
				}
			});
		}
		//生成图表的方法
		//循环生成图表
	);
</script>
</head>
<body>
	<div id="body">
		<input type="button" id="start" value="click">
		<h1>this is the hard page</h1>
		<h2 id="ajax"></h2>
		<div id="main1" style="width: 600px; height: 400px;"></div>
		<input type="text" id="data1" value="">
		
	</div>
</body>
</html>