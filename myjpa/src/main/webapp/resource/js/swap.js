$(document)
		.ready(
				function() {
					$("#swap0")
							.click(
									function() {
										function getdata() {
											$
													.ajax({
														type : "get", // 请求方式
														url : "http://localhost:8765/myjpa/hard/swap", // 地址，就是action请求路径
														dataType : "json",
														success : function(msg) {
															$("#total")
																	.val(
																			(msg[0] / 1024)
																					.toFixed(2));
															$("#used")
																	.val(
																			(used = msg[1] / 1024)
																					.toFixed(2));
															$("#free")
																	.val(
																			(free = msg[2] / 1024)
																					.toFixed(2));
															var rate = ((msg[1] / msg[0]) * 100)
																	.toFixed(2);
															var myChart = echarts
																	.init(document
																			.getElementById('swap'));
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
															myChart
																	.setOption(option);
														},
														error : function(jqXHR) {
															alert("error:"
																	+ jqXHR.status);
														}
													})
										}
										;
										// 生成数据,循环调用
										setInterval(getdata, 1000);
									});
				})
