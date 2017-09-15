var hardModule = angular.module("hardModule", []);
hardModule.controller("cpu", [ "$http", "$scope", function($http, $scope) {
	$scope.checkCPU = function(){
		$http({
			method : "GET",
			url : 'hard/cpu'
		}).then(function successCallBack(response) {
			$scope.cpus = response.data;
			var rate = ($scope.cpus * 100).toFixed(2);

			var myChart = echarts.init(document.getElementById('cpu'));
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
						value : rate,
						name : 'CPU总体运行情况'
					} ]
				} ]
			};
			myChart.setOption(option);
		}, function errorCallBack(response) {
		});
	}
	setInterval($scope.checkCPU, 1000);
} ]);
hardModule.controller("cpus",["$http","$scope",function($http, $scope) {
		$scope.checkCPUS = function(){
		$http({
			method : "GET",
			url : 'hard/cpus'
		})
		.then(function successCallBack(response) {
			var cpus=new Array();
			 cpus = response.data;
			for (var i = 0; i < cpus.length; i++) {
				var rate = (cpus[i].total * 100)
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
							name : '线程'	+ (i + 1)+ '的使用率'
						} ]
					} ]
					};
					var res = document.getElementById("cpus"+ i);
					if (!res) {
						$("#cpus").after("<div id=cpus"+ i+ " style=width:600px;height:400px;"+ ">"+ "</div>");
					}
					var myChart = echarts.init(document.getElementById('cpus'+ i));
					myChart.setOption(options);
				}
			},
			function errorCallBack(response) {
				alert(response);
			})
	};
	setInterval($scope.checkCPUS, 1000);
} ]);
hardModule.controller("disk", [ "$http", "$scope", function($http, $scope) {
	$scope.checkDisk=function(){
		var diskArray = new Array();
		var center1 = null;
		var center2 = null;
	$http({
		method : "GET",
		url : 'hard/disk'
	}).then(function successCallBack(response) {
		var disks=new Array();
		disks = response.data;
		for (var i = 0; i < disks.length; i++) {
			center1 = 30 * (i + 1) + "%";
			center2 = 33 * (i + 1) + "%";
			var disk = {
				name : disks[i].diskName,
				type : 'pie',
				radius : '50%',
				center : [ center1, center2 ],
				data : [ {
					value : disks[i].usedSize / 1024 / 1024,
					name : '已用空间:G'
				}, {
					value : disks[i].freeSize / 1024 / 1024,
					name : '未用空间:G'
				} ]
			};
			diskArray.push(disk);
		}
		alert(response);
	}, function errorCallBack(response) {
	})
	setInterval($scope.checkDisk, 1000);
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
	};
	
} ]);
hardModule.controller("memory", [ "$http", "$scope", function($http, $scope) {
	$scope.checkMemory=function(){
		var total = "";
		var used = "";
		var free = "";
	$http({
		method : "GET",
		url : 'hard/memory'
	}).then(function successCallBack(response) {
		$scope.memory = response.data;

		$("#total")
				.val(
						(memory[0] / 1024)
								.toFixed(2));
		$("#used")
				.val(
						(used = memory[1] / 1024)
								.toFixed(2));
		$("#free")
				.val(
						(free = memory[2] / 1024)
								.toFixed(2));
		var rate = ((memory[1] / memory[0]) * 100)
				.toFixed(2);

		var myChart = echarts
				.init(document
						.getElementById('memory'));
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
				name : '内存',
				type : 'gauge',
				detail : {
					formatter : '{value}%'
				},
				data : [ {
					value : rate,
					name : '内存使用率'
				} ]
			} ]
		};
		myChart
				.setOption(option);
	
	}, function errorCallBack(response) {
		alert(response);
	});
	setInterval($scope.checkMemory, 1000);
	}
} ]);
hardModule.controller("swap", [ "$http", "$scope", function($http, $scope) {
	$scope.checkSWAP=function(){
	$http({
		method : "GET",
		url : 'hard/swap'
	}).then(function successCallBack(response) {
		$scope.swap = response.data;

		$("#total")
				.val(
						(swap[0] / 1024)
								.toFixed(2));
		$("#used")
				.val(
						(used = swap[1] / 1024)
								.toFixed(2));
		$("#free")
				.val(
						(free = swap[2] / 1024)
								.toFixed(2));
		var rate = ((swap[1] / swap[0]) * 100)
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
	
	}, function errorCallBack(response) {
		alert(response);
	});
	}
	setInterval($scope.checkSWAP, 1000);
} ]);

