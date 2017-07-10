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
	$(document).ready(function() {
		function getdata() {
			$.ajax({
				type : "get", //请求方式  
				url : "http://localhost:8765/myjpa/hard/disk", //地址，就是action请求路径  
				dataType : "text",
				success : function(data) {
					var jsonObj = eval("(" + data + ")");
					$.each(jsonObj, function(i, item) {
						alert(item.diskName + "," + item.totalSize + "," + item.usedSize + "," + item.leftSize);
					});
				},
				error : function(jqXHR) {
					alert("error:" + jqXHR.status);
				}
			})
		}
		;
 
		setInterval(getdata, 1000);
		/* 
		//生成图表
		var myChart = echarts.init(document.getElementById('main'));
		
		// 指定图表的配置项和数据

		option = {
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b}: {c} ({d}%)"
			},
			legend : {
				orient : 'vertical',
				x : 'left',
				data : [ '直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎' ]
			},
			series : [
				{
					name : '访问来源',
					type : 'pie',
					radius : [ '50%', '70%' ],
					avoidLabelOverlap : false,
					label : {
						normal : {
							show : false,
							position : 'center'
						},
						emphasis : {
							show : true,
							textStyle : {
								fontSize : '30',
								fontWeight : 'bold'
							}
						}
					},
					labelLine : {
						normal : {
							show : false
						}
					},
					data : [
						{
							value : 335,
							name : '直接访问'
						},
						{
							value : 310,
							name : '邮件营销'
						},
						{
							value : 234,
							name : '联盟广告'
						},
						{
							value : 135,
							name : '视频广告'
						},
						{
							value : 1548,
							name : '搜索引擎'
						}
					]
				}
			]
		};

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
		*/
	}
	);
</script>
</head>
<body>
	<div id="body">
		<input type="button" id="go" value="click">
		<h1>this is the hard page</h1>
	</div>
</body>
</html>