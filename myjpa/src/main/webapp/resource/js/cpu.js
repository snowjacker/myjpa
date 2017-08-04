$(document).ready(function() {
		$("#cpu0").click(function(){
			function getdata() {
				$.ajax({
					type : "get", //请求方式  
					url : "hard/cpu", //地址，就是action请求路径  
					dataType : "text",
					success : function(msg) {
						var rate=(msg*100).toFixed(2);
						//拿到图表输出目标
						var myChart = echarts
						.init(document.getElementById('cpu'));
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
		})