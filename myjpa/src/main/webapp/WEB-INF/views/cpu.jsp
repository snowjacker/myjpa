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
<script type="text/javascript">
	$(document).ready(function() {
		 var getting = {
			        url:'cpu',
			        dataType:'json',
			        success:function(res) {
			         console.log(res);
			}
			};
			//关键在这里，Ajax定时访问服务端，不断获取数据 ，这里是1秒请求一次。
			window.setInterval(function(){$.ajax(getting)},1000);

		//以下代码生成图表，但是是静态的
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
				name : 'CPU',
				type : 'gauge',
				detail : {
					formatter : '{value}%'
				},
				data : [ {
					value : 50,
					name : '使用率'
				} ]
			} ]
		};
		setInterval(function() {
			option.series[0].data[0].value = parseInt($('#data').val() * 100);
			myChart.setOption(option, true);
		}, 2000);
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	});
</script>
</head>
<body>


	<h1>this is the hard page</h1>
	<button>查看CPU状态</button>
	<div id="main" style="width: 600px; height: 400px;"></div>
	<input type="text" value=${mav } id="data">

</body>
</html>