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
	<button id="start">查看硬盘使用状态</button>
	<div id="main" style="width: 600px; height: 400px;"></div>
	<script>
		$(document)
				.ready(
						function() {
							var diskArray=new Array();
							function getdata() {
								$
										.ajax({
											type : "get", //请求方式  
											url : "http://localhost:8765/myjpa/hard/disk", //地址，就是action请求路径  
											dataType : "json",
											success : function(msg) {
												for (var i = 0; i < msg.length; i++) { //循环遍历stuList
													var disk={
												            name: msg[i].diskName,
												            type: 'pie',
												            radius : '50%',
												            center: ['30%', '33%'],
												            data:[
												                {value:msg[i].usedSize / 1024 / 1024, name:'已用空间'},
												                {value:msg[i].freeSize / 1024 / 1024, name:'未用空间'}
												            ]
												        };
												        diskArray.push(disk);
												        var myChart=echarts.init(document.getElementById('main'));
														 //一个option就是一块空白区，一块空白区的series表示画多少个图，画什么样的图。
														 //series:[{图1},{图2},……,{图n}]
														 //图的属性可以自定义，圆心 center: [横坐标,纵坐标] 
														option = {
															    title : {
															        text: '硬盘使用统计',
															        subtext: '实时数据',
															        x:'right'
															    },
															    tooltip : {
															        trigger: 'item',
															        formatter: "{a} <br/>{b} : {c} ({d}%)"
															    },
															    legend: {
															        orient: 'vertical',
															        left: 'left',
															        data: ['已用空间','未用空间']
															    },
															    series : diskArray,
															};
														myChart.setOption(option);
												}
											},
											error : function(jqXHR) {
												alert("error:" + jqXHR.status);
											}
										})
							}
							;
							//生成数据,循环调用
							setInterval(getdata, 1000);
							
						})
	</script>
</body>
</html>