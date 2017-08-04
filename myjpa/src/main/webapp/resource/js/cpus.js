$(document)
		.ready(
				function() {
					$("#cpus")
							.click(
									function() {
										function getdata() {
											$
													.ajax({
														type : "get", // 请求方式
														url : "hard/cpus", // 地址，就是action请求路径
														async : false,
														dataType : "json",
														success : function(msg) {
															for (var i = 0; i < msg.length; i++) {

																var rate = (msg[i].total * 100)
																		.toFixed(2);
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
																			name : '线程'
																					+ (i + 1)
																					+ '的使用率'
																		} ]
																	} ]
																};
																var res = document
																		.getElementById("cpus"
																				+ i);
																if (!res) {
																	$("#cpus")
																			.after(
																					"<div id=cpus"
																							+ i
																							+ " style=width:600px;height:400px;"
																							+ ">"
																							+ "</div>");
																}
																var myChart = echarts
																		.init(document
																				.getElementById('cpus'
																						+ i));
																myChart
																		.setOption(options);
															}
														},
														error : function(jqXHR) {
															alert("error:"
																	+ jqXHR.status);
														}
													})
										}
										;
										setInterval(getdata, 1000);
									})
				})