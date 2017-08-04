$(document).ready(function() {
	$("#disk0").click(function() {
		var diskArray = new Array();
		var center1 = null;
		var center2 = null;
		function getdata() {
			$.ajax({
				type : "get", // 请求方式
				url : "hard/disk", // 地址，就是action请求路径
				dataType : "json",
				success : function(msg) {
					for (var i = 0; i < msg.length; i++) {
						center1 = 30 * (i + 1) + "%";
						center2 = 33 * (i + 1) + "%";
						var disk = {
							name : msg[i].diskName,
							type : 'pie',
							radius : '50%',
							center : [ center1, center2 ],
							data : [ {
								value : msg[i].usedSize / 1024 / 1024,
								name : '已用空间:G'
							}, {
								value : msg[i].freeSize / 1024 / 1024,
								name : '未用空间:G'
							} ]
						};
						diskArray.push(disk);
					}
				},
				error : function(jqXHR) {
					alert("error:" + jqXHR.status);
				}
			})
		}
		;
		setInterval(getdata, 1000);
		var myChart = echarts.init(document.getElementById('disk'));
		option = {
			title : {
				text : '硬盘使用统计',
				subtext : '实时数据',
				x : 'right'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				orient : 'vertical',
				left : 'left',
				data : [ '已用空间', '未用空间' ]
			},
			series : diskArray,
		};
		setInterval(function() {
			myChart.setOption(option);
		}, 1000);
	})
})